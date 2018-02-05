package com.me2me.ims.base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.me2me.ims.exception.ImsError;
import com.me2me.ims.exception.ImsException;
import com.me2me.ims.exception.NoPermissionException;
import com.me2me.ims.model.ImsUser;



/**
 * http请求包装类。                     
 * 
 * @date 2014-8-21
 * @author jiwei.zhang
 * 
 */
public class RequestContext{
	private HttpServletResponse response;
	private HttpSession session;
	private Date requestDate;
	private Logger logger = LoggerFactory.getLogger(RequestContext.class);
	private HttpServletRequest request;
	private Queue<String> debugInfo;
	private static final String SESSION_DEBUG_KEY="__debug";
	private String SESSION_ADMIN_USER_KEY="admin_user";
	private String SESSION_ADMIN_USER_PERMISSION="admin_user_permission";
	
	public RequestContext(HttpServletResponse response, HttpServletRequest request) {
		super();
		this.response = response;
		this.request= request;
		this.session = request.getSession(true);
		// 获取持续的debug消息列表 
		this.debugInfo= (Queue<String>) session(SESSION_DEBUG_KEY);
		if(this.debugInfo==null){
			debugInfo=new LinkedBlockingQueue<String>();
			this.session(SESSION_DEBUG_KEY, debugInfo);
		}
		while(debugInfo.size()>50){		//避免缓存太多。
			debugInfo.poll();
		}
		this.requestDate = new Date();
		//Log.info("\n\n\n=======Page url:"+request.getRequestURL().toString()+"?"+request.getQueryString()+"=======\n");
		
	}
	/**
	 * 下载文件时指定下载名
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param filePath
	 *            文件全路径
	 * @param fileName
	 *            指定客户端下载时显示的文件名
	 * @throws IOException
	 */
	public static void downloadFile(HttpServletRequest request,
			HttpServletResponse response, String filePath, String fileName)
			throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(response.getOutputStream());

		long fileLength = new File(filePath).length();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		/*
		 * 解决各浏览器的中文乱码问题
		 */
		String userAgent = request.getHeader("User-Agent");
		byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes()
				: fileName.getBytes("UTF-8"); // fileName.getBytes("UTF-8")处理safari的乱码问题
		fileName = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
		response.setHeader("Content-disposition",
				String.format("attachment; filename=\"%s\"", fileName));

		response.setHeader("Content-Length", String.valueOf(fileLength));
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();

	}

	/**
	 * 下载文件时不指定下载文件名称
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param filePath
	 *            文件全路径
	 * @throws IOException
	 */
	public static void downloadFile(HttpServletRequest request,
			HttpServletResponse response, String filePath) throws IOException {
		File file = new File(filePath);
		downloadFile(request, response, filePath, file.getName());
	}
	public Logger getLogger() {
		return logger;
	}
	/**
	 * 向客户端中写入文本
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param content
	 */
	public void write(String content) {
		try {
			write(content.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public void write(int num){
		write(num+"");
	}
	public void write(float num){
		write(num+"");
	}
	/**
	 * 向客户端写入字节流
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param content
	 */
	public void write(byte[] content) {
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(content);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 从Request中获取一个bean对象，form表单提交的字段名称必须和bean中的名称一致。<br/>
	 * form表单中提交的字符串值，会自动转换为bean的字段类型。
	 * 
	 * @date 2014-8-29
	 * @author jiwei.zhang
	 * @param c
	 * @return
	 */
	public <T> T get(Class<T> c) {
		try {
			Map<String,String> ret = copyRequestParamsToMap();
			return params2bean(ret, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 public static <T> T params2bean(Map<String,String> map,Class<T> c){
	    	Field[] fields = c.getDeclaredFields();
			T obj = null;
			try {
				obj = c.newInstance();
				int n =0;
				for (Field f : fields) {
					String key = f.getName();
					//log.info("装配{}属性{}",c.getName(),key);
					String firstChar = key.substring(0, 1);
					String keyUpper = key.replaceFirst(firstChar, firstChar.toUpperCase());
					Method setMethod;
					Object newVal =null;
					try {
						setMethod = obj.getClass().getDeclaredMethod("set" + keyUpper, f.getType());// 根据
						// field得到对应的get方法
						Class fieldType = f.getType();
						try {
							String val = map.get(key);
							
							if(int.class.isAssignableFrom(fieldType)){
								newVal=Integer.parseInt(val);
							}else if(long.class.isAssignableFrom(fieldType)){
									newVal=Long.parseLong(val);
							}else if (float.class.isAssignableFrom(fieldType)) {
								newVal= Float.parseFloat(val);
							}else if (double.class.isAssignableFrom(fieldType)) {
								newVal= Double.parseDouble(val);
							}else if (boolean.class.isAssignableFrom(fieldType)) {
								newVal= Double.parseDouble(val);
							}else if (String.class.isAssignableFrom(fieldType)) {
								newVal= val;
							} else if (Number.class.isAssignableFrom(fieldType)) {
								if(ValidateUtils.isNumeric(val)){
									if (fieldType.equals(java.lang.Integer.class)) {
										newVal= (int) Float.parseFloat(val);
									} else if (fieldType.equals(java.lang.Float.class)) {
										newVal= Float.parseFloat(val);
									} else if (fieldType.equals(java.lang.Double.class)) {
										newVal= Double.parseDouble(val);
									} else if (fieldType.equals(java.lang.Long.class)) {
										newVal= Long.parseLong(val);
									}
								}
							} else if (java.sql.Timestamp.class.isAssignableFrom(fieldType)) {
								if (val!=null && val.length() > 10) {
									newVal= new Timestamp(DateTimeUtils.parserDateTime(val, "yyyy-MM-dd HH:mm:ss").getTime());
								} else {
									newVal= new Timestamp(DateTimeUtils.parserDateTime(val, "yyyy-MM-dd").getTime());
								}
							} else if (java.util.Date.class.isAssignableFrom(fieldType)) {
								if(val!=null){
									newVal= DateTimeUtils.parserDateTime(val, "yyyy-MM-dd");
								}
							}else if(java.util.Collection.class.isAssignableFrom(fieldType)){
							
							}else{		// 自定义对象
								// 将对象new出来 ，如product.name
								Map<String,String> newValMap = new HashMap<String, String>();
								for(String name:map.keySet()){
									String value = map.get(name);
									if(name.startsWith(key+".")){
										newValMap.put(name.replaceAll("^\\w+\\.", ""), value);
									}
								}
								if(newValMap.size()>0){
									Object subClass = params2bean(newValMap, fieldType);
									newVal= subClass;
								}
							}
						} catch (Exception e) {
							throw e;
						}
						if(newVal!=null) n++;
						setMethod.invoke(obj, newVal);
					} catch (Exception e) {
						
					}
				}
				if(n>0) return obj;		// 如果对象没有注入任何属性，则返回 null.
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	    }
	/**
	 * 从request中取得参数
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 */
	public String get(String key) {
		String v = request.getParameter(key);
		if(v!=null) v=v.trim();
		return v;
	}
	/**
	 * 从request中取得参数，如果参数为null，返回空字符串。
	 * @date 2014-9-9
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public String get(String key,String defaultValue) {
		String v = request.getParameter(key);
		if(ValidateUtils.isEmpty(v)){
			v= defaultValue;
		}
		if(v!=null) v=v.trim();
		return v;
	}
	public Date getDate(String key){
		String val = this.get(key);
		if(StringUtils.isEmpty(val)){
			return null;
		}
		try{
			return DateTimeUtils.parserDateTime(val);
		}catch(Exception e){
			return DateTimeUtils.parserDateTime(val,"yyyy-MM-dd");
		}
	}
	public Date getDate(String key,String defaultValue){
		String val = this.get(key, defaultValue);
		if(ValidateUtils.isDateTime(val)){
			return DateTimeUtils.parserDateTime(val);
		}
		return null;
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Integer getInt(String key) {
		try {
			return Integer.parseInt(request.getParameter(key));
		} catch (NumberFormatException e) {
			return null;
		}
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Integer getInt(String key,Integer defaultValue) {
		try {
			return Integer.parseInt(request.getParameter(key));
		} catch (NumberFormatException e) {
			logger.debug("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
			return defaultValue;
		}
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Float getFloat(String key,Float defaultValue) {
		try {
			return Float.parseFloat(request.getParameter(key));
		} catch (Exception e) {
			logger.debug("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
			return defaultValue;
		}
	}
	/**
	 * 从request中取一个int变量。如果没有值，则会抛出运行时异常
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Float getFloat(String key) {
		try {
			return Float.parseFloat(request.getParameter(key));
		} catch (Exception e) {
			throw new RuntimeException("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
		}
	}
	/**
	 * 取一个时间戳
	 * @date 2014-8-29
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Timestamp getTimestamp(String key){
		try {
			return new Timestamp(DateTimeUtils.parserDateTime(request.getParameter(key)).getTime());
		} catch (NumberFormatException e) {
			throw new RuntimeException("parameter:" + key+"的值"+request.getParameter(key)+"不合法", e);
		}
	}

	

	/**
	 * 从request中取得该key对应的所有参数值。
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public String[] getValues(String key) {
		return request.getParameterValues(key);
	}

	/**
	 * 向请求中插入数据。
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @param value
	 */
	public void attr(String key, Object value) {
		request.setAttribute(key, value);
	}

	public Object attr(String key) {
		return request.getAttribute(key);
	}
	public Integer attrInt(String key){
		return Integer.parseInt(attr(key)+"");
	}
	/**
	 * 从session中取值
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @return
	 */
	public Object session(String key) {
		return session.getAttribute(key);
	}

	/**
	 * 向session中插入值。
	 * 
	 * @date 2014-8-21
	 * @author jiwei.zhang
	 * @param key
	 * @param value
	 */
	public void session(String key, Object value) {
		session.setAttribute(key, value);
	}
	/**
	 * 测试用时
	 * @date 2014-9-9
	 * @author jiwei.zhang
	 * @return
	 */
	public String debugTimeUsed(){
		Date now = new Date();
		String str = request.getRequestURI()+" used time:"+(now.getTime()-requestDate.getTime())+"ms.";
		System.out.println(str);
		return str;
	}
	/**
	 * 向客户端发送错误消息 。
	 * @date 2014-9-9
	 * @author jiwei.zhang
	 * @param msg
	 */
	public void err(String msg){
		msg="<br><div class='container'><div class='alert alert-danger' role='alert'>"+msg+"</div></div>";
		this.attr("action_msg", msg);
	}

	

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * 跳转
	 * @date 2014-9-26
	 * @author jiwei.zhang
	 * @param string
	 */
	public void redirect(String string) {
		try {
			response.sendRedirect(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 取文件绝对地址
	 * @date 2014-10-15
	 * @author jiwei.zhang
	 * @param path 文件相对于web根目录的位置。
	 * @return 
	 */
	public File getWebResource(String path){
		return new File(this.session.getServletContext().getRealPath(path));
	}

	/**
	 * 取得request对象中的所有参数，支持GET方式提交的中文参数，前提是WEB容器URL编码必须是ISO-8859-1编码。
	 * 
	 * @date 2012-6-14
	 * @param request
	 * @return map(String,String)，键是请求的参数名，相同键的多个值如
	 *         ?name=1&name=2，将被转换为逗号分隔的值，如?name=1,2。如果没有参数，返回空map；
	 */
	public  Map<String, String> copyRequestParamsToMap() {
		Map<String, String> params = new HashMap<String, String>();
		Enumeration<String> it = request.getParameterNames();
		boolean get = request.getMethod().toLowerCase().equals("get");
		while (it.hasMoreElements()) { // 遍历所有的参数，并放入map中。
			String key = it.nextElement();
			String[] values = request.getParameterValues(key);
			String value = null;
			if (values.length <= 1) {
				value = get(key);
			} else {
				value = StringUtils.join(request.getParameterValues(key)); // 多个值转换为以逗号分隔的字符串。
			}
			if(get){
				try {
					params.put(key, new String(value.getBytes("ISO-8859-1"),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				params.put(key,value);
			}
		}
		return params;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * 输出 request请求值 
	 */
	public void debugRequestParams(){
		System.out.println(request.getRequestURL().toString()+"?"+request.getQueryString());
		Enumeration<String> names=request.getParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			String[] values =request.getParameterValues(name);
			System.out.println(name+"="+StringUtils.join(values));
		}
	}
	
	/**
	 * 取debug信息，
	 * @return
	 */
	public Queue<String> getDebugInfo() {
		return debugInfo;
	}
	public String getUTF8Parameter(String name) {
		String str = request.getParameter(name);
		if(str!=null){
			try {
				return new String(str.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 初始化管理员SESSION
	 * @author zhangjiwei
	 * @date Oct 26, 2017
	 * @param user
	 * @param permissions
	 */
	public void initAdminSession(ImsUser user, Set<String> permissions){
		session(SESSION_ADMIN_USER_KEY, user);
		session(SESSION_ADMIN_USER_PERMISSION, permissions);
	}
	/**
	 * 检查用户权限，如果有就放过，如果没有就抛出Permission异常
	 * @author zhangjiwei
	 * @date Oct 23, 2017
	 * @param feature
	 */
	public void checkAdminPermission(SystemPermissions feature){
		ImsUser user = (ImsUser) session(SESSION_ADMIN_USER_KEY);
		Set<String> permissions = (Set<String>)session(SESSION_ADMIN_USER_PERMISSION);
		if(user==null || permissions==null){
			throw new NoPermissionException(ImsError.ERR_NO_PERMISSION);
		}else{
			if(feature==null){
				throw new ImsException(ImsError.ERR_NO_PERMISSION);
			}
			String key = feature.toString();
			if(!permissions.contains(key)){
				throw new ImsException(ImsError.ERR_NO_PERMISSION);
			}
		}
	}
	/**
	 * 检查用户权限，如果有就放过，如果没有就抛出Permission异常
	 * @author zhangjiwei
	 * @date Oct 26, 2017
	 */
	public void checkAdminLogin(){
		getAdmin();
	}
	public ImsUser getAdmin(){
		ImsUser user= (ImsUser) session(SESSION_ADMIN_USER_KEY);
		if(user==null){
			throw new ImsException(ImsError.ERR_NOT_LOGIN);
		}
		return user;
	}
}
