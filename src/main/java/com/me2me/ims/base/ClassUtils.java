package com.me2me.ims.base;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;



/**
 * 常用的类处理 。
 * 
 * @author Gene.zhang
 * @date 2012-12-28
 */
public class ClassUtils {
	/**
	 * 取得某个类中指定字段的值,调用类的getter方法 。
	 * 
	 * @date 2012-12-28
	 * @param classObject 指定的类
	 * @param fieldName 指定的字段名。
	 * @return 如果取值失败，则抛出异常。
	 */
	public static Object invokeGetter(Object classObject, String fieldName)  {
		String first = fieldName.substring(0, 1);
		String getter = "get" + fieldName.replaceFirst(first, first.toUpperCase());
		Object value = null;
		Class cls =classObject.getClass();
		for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
			try {
				Method method = cls.getMethod(getter, null);
				value = method.invoke(classObject, null);
				break;
			} catch (IllegalAccessException e) {
			} catch (IllegalArgumentException e) {
			} catch (InvocationTargetException e) {
			} catch (NoSuchMethodException e) {
			} catch (SecurityException e) {
			}
			
		}
		return value;
	}

	/**
	 * 递归取属性的getter,如果本类没有getter方法，那么取父类的getter.
	 * @date 2014-5-6
	 * @author jiwei.zhang
	 * @param cls
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static Object invokeGetter(Class cls,Object obj, String fieldName) throws NoSuchMethodException{
		String first = fieldName.substring(0, 1);
		String getter = "get" + fieldName.replaceFirst(first, first.toUpperCase());
		Object value = null;
		Method method;
		for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
			try {
				method = cls.getDeclaredMethod(getter, cls);
				value = method.invoke(obj, null);
				break;
			} catch (IllegalAccessException e) {
			} catch (IllegalArgumentException e) {
			} catch (InvocationTargetException e) {
			}
		}
		return value;
	}

	/**
	 * 调用 setter
	 * @date 2014-5-6
	 * @author jiwei.zhang
	 * @param obj 真正调用 setter的 类。 
	 * @param fieldName 字段名
	 * @param fieldType 字段类型
	 * @param value 字段值。
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void invokeSetter(Object obj, String fieldName,Class<?> fieldType, Object value) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String setter = null;
//		if(boolean.class.isAssignableFrom(value.getClass())||Boolean.class.isAssignableFrom(value.getClass())){
//			setter=fieldName;
//		}else{
			String first = fieldName.substring(0, 1);
			setter="set" + fieldName.replaceFirst(first, first.toUpperCase());
		//}
	
		
		Method method;
		Class cls=obj.getClass();
		for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
			method = cls.getDeclaredMethod(setter, fieldType);
			value = method.invoke(obj, value);
			break;
		}
	}

	/**
	 * 读取某类的某个字段值，侵入式，不调用 getter ,会递归到本类的父类。
	 * 
	 * @param classObject
	 *            待取值的对象。
	 * @param fieldName
	 *            字段名
	 * @return 字段值 ,如果找不到，返回null.
	 */
	public static Object getFieldValue(Object classObject, String fieldName) {
		if (classObject != null) {
			Class<?> cls = classObject.getClass();
			for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
				try {
					Field field = cls.getDeclaredField(fieldName);
					field.setAccessible(true);
					return field.get(classObject);
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	/**
	 * 设置某类的某个字段值，侵入式，不调用 setter
	 * 
	 * @param classObject
	 *            待取值的对象。
	 * @param fieldName
	 *            字段名
	 * @param value
	 *            字段值
	 */
	public static void setFieldValue(Object classObject, String fieldName, Object value){
		if (classObject != null) {
			Class cls = classObject.getClass();
			for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
				try{
					Field field = cls.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(classObject, value);
					field.setAccessible(false);
					return ;
				}catch(Exception e){
				}
			}
		}
	}

	/**
	 * 取某class的所有属性名称，包括父类属性。
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static List<String> getClassFieldNames(Class cls) {
		ArrayList<String> list = new ArrayList<String>();
		for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
			Field[] fields = cls.getDeclaredFields();
			for(Field f:fields){
				if(!list.contains(f.getName())){
					list.add(f.getName());
				}
			}
		}
		return list;
	}
	/**
	 * 取某class的所有属性，包括父类属性。
	 * 
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static List<Field> getClassFields(Class cls) {
		ArrayList<Field> list = new ArrayList<Field>();
		for(;cls!=null && cls!=Object.class ;cls=cls.getSuperclass()){
			Field[] fields = cls.getDeclaredFields();
			for(Field f:fields){
				if(!list.contains(f)){
					list.add(f);
				}
			}
		}
		return list;
	}
	
	public static String getClassFilePath(String className) {
		Class cls = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getClassFilePath(cls);
	}

	/**
	 * 取得一个类的文件路径。
	 * 
	 * @date 2014-3-7
	 * @author jiwei.zhang
	 * @param cls
	 * @return
	 */
	public static String getClassFilePath(Class cls) {
		String className = cls.getName();
		String classNamePath = className.replace(".", "/") + ".class";
		URL is = cls.getClassLoader().getResource(classNamePath);
		String path = is.getFile();
		return path;
	}
	/***
	 * 将bean 转换成map.
	 * 
	 * @date 2013-5-7
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> bean2Map(Object obj) {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		// key值 应该是 Person类中的属性名，利用反射机制
		Class cls = obj.getClass();
		for(;cls!=Object.class;cls=cls.getSuperclass()){
			Field[] fields =cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String key = fields[i].getName();
				if (!Modifier.isStatic(fields[i].getModifiers())) { // 跳过静态属性。
					try {
						map.put(key, ClassUtils.getFieldValue(obj, key));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return map;
	}
	/**
	 * 将值转换为相应的类型
	 * @param type
	 * @param val
	 * @return
	 */
	private static Object convertVal(Class type,Object val){
		if (String.class.isAssignableFrom(type) && val instanceof java.sql.Clob) { // clob
			val = StringUtils.toString((Clob) val);
		}
		if(val instanceof BigInteger && Integer.class.isAssignableFrom(type)){
			val = ((BigInteger) val).intValue();
		}
		return val;
	}
	/**
	 * 将map 转换到 bean 。
	 * @param cls
	 * @param dataMap
	 * @return
	 */
	public static <T> T map2Bean(Class<T> cls, Map<String, Object> dataMap) {
		T obj = null;
		try {
			obj = cls.newInstance();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		for(;cls!=Object.class;cls=(Class<T>) cls.getSuperclass()){
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fname = field.getName();
				Object val = dataMap.get(fname);
				if (val != null) {
					val=convertVal(field.getType(),val);
					try {
						invokeSetter(obj, fname,field.getType(), val);
					} catch (Exception e1) {
						try{
							field.setAccessible(true);
							field.set(obj, val);
							field.setAccessible(false);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return obj;
	}

	/**
	 * 取得某个接口下所有实现这个接口的类
	 */
	public static List<Class> getAllClassByInterface(Class c) {
		List<Class> returnClassList = null;

		if (c.isInterface()) {
			// 获取当前的包名
			String packageName = c.getPackage().getName();
			// 获取当前包下以及子包下所以的类
			List<Class> allClass = getClasses(packageName);
			if (allClass != null) {
				returnClassList = new ArrayList<Class>();
				for (Class classes : allClass) {
					// 判断是否是同一个接口
					if (c.isAssignableFrom(classes)) {
						// 本身不加入进去
						if (!c.equals(classes)) {
							returnClassList.add(classes);
						}
					}
				}
			}
		}

		return returnClassList;
	}

	/*
	 * 取得某一类所在包的所有类名 不含迭代
	 */
	public static String[] getPackageAllClassName(String classLocation, String packageName) {
		// 将packageName分解
		String[] packagePathSplit = packageName.split("[.]");
		String realClassLocation = classLocation;
		int packageLength = packagePathSplit.length;
		for (int i = 0; i < packageLength; i++) {
			realClassLocation = realClassLocation + File.separator + packagePathSplit[i];
		}
		File packeageDir = new File(realClassLocation);
		if (packeageDir.isDirectory()) {
			String[] allClassName = packeageDir.list();
			return allClassName;
		}
		return null;
	}

	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 */
	public static List<Class> getClasses(String packageName) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		return getClasses(packageName, loader);
	}

	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 */
	public static List<Class> getClasses(String packageName, ClassLoader classLoader) {
		List<Class> classes = new ArrayList<Class>();
		boolean recursive = true;
		String packageDirName = packageName.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			dirs = classLoader.getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				String protocol = url.getProtocol();
				if ("file".equals(protocol)) {
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes,classLoader);
				} else if ("jar".equals(protocol)) {
					// 如果是jar包文件
					// 定义一个JarFile
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							if (name.charAt(0) == '/') {
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.endsWith(".class") && name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								if (idx != -1 || recursive) {
									String className = name.replace('/', '.').substring(0, name.length() - 6);
									try {
										classes.add(classLoader.loadClass(className));
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classes;
	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
			final boolean recursive, List<Class> classes,ClassLoader loader) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes,loader);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					classes.add(loader.loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
