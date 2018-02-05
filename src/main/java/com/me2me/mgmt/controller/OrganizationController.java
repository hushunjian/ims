package com.me2me.mgmt.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.kisso.common.encrypt.MD5;
import com.me2me.common.page.PageBean;
import com.me2me.ims.mapper.auto.UserOrganizationInfoMapper;
import com.me2me.ims.mapper.auto.UserOrganizationMapper;
import com.me2me.ims.model.UserOrganization;
import com.me2me.ims.model.UserOrganizationExample;
import com.me2me.ims.model.UserOrganizationInfo;
import com.me2me.ims.model.UserOrganizationInfoExample;
import com.me2me.mgmt.dal.utils.HttpUtils;
import com.me2me.mgmt.dao.LocalJdbcDao;
import com.me2me.mgmt.request.OrganizationDTO;
import com.me2me.mgmt.request.OrganizationInfoDTO;
import com.me2me.mgmt.request.OrganizationInfoDTO.OrganizationInfoElement;
import com.me2me.mgmt.syslog.SystemControllerLog;
import com.me2me.mgmt.vo.DatatablePage;
import com.me2me.user.dto.SearchUserOrganizationDto;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	private LocalJdbcDao localJdbcDao;
	
	@Autowired
	private UserOrganizationInfoMapper userOrganizationInfoMapper;
	
	@Autowired
	private UserOrganizationMapper userOrganizationMapper;

	
	private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	@RequestMapping(value = "/organizationMgr")
	public ModelAndView listOrganization(OrganizationDTO dto){
		ModelAndView view = new ModelAndView("userOrganization/list_organization"); 
		StringBuilder sb = new StringBuilder();
		sb.append("select * from user_organization where 1=1 ");
		if(StringUtils.isNotBlank(dto.getOrganizationName())){
			sb.append("and organization_name like '%").append(dto.getOrganizationName()).append("%' ");
		}
		List<Map<String, Object>> list = localJdbcDao.queryEvery(sb.toString());
		if(null != list && list.size() > 0){
			OrganizationDTO.UserOrganizatoinElement e = null;
			for(Map<String,Object> u :list){
				e = new OrganizationDTO.UserOrganizatoinElement();
				e.setId((Long)u.get("id"));
				e.setOrganizationName((String)u.get("organization_name"));
				dto.getResult().add(e);
			}
		}
		view.addObject("dataObj",dto);
		return view;
	}
	
	
	@RequestMapping(value = "/saveOrganization")
	@ResponseBody
	public String saveOrganization(@RequestParam("organizationName") String organizationName,
								   @RequestParam("id") long id){
		String sq = "select * from user_organization where organization_name ='"+organizationName+"'";
		List<Map<String, Object>> list = localJdbcDao.queryEvery(sq);
		if(list!=null&&list.size()>0){
			return "0";
		}
		if(id != 0){
			//id不为0时为修改操作
			String update = "update user_organization set organization_name = '"+organizationName+"' where id = "+id;
			localJdbcDao.executeSql(update);
			return "1";
		}else{
			//id=0时为新增操作，向user_organization表中添加一条数据
			String insert = "insert into user_organization(organization_name) value('"+organizationName+"')";
			localJdbcDao.executeSql(insert);
			return "1";
		}
	}
	
	@RequestMapping(value = "/remove")
	@ResponseBody
	public String remove(@RequestParam("id") long id){
		String delete = "delete from user_organization where id = "+ id;
		localJdbcDao.executeSql(delete);
		return "1";
	}
	
	@RequestMapping(value="/userOrganizationMgr")
	@ResponseBody
	public ModelAndView queryInfo(OrganizationInfoDTO dto ) throws Exception{
		ModelAndView view = new ModelAndView("userOrganization/list_organization_info");
		
		long meCode = 0;
		if(null != dto.getMeCode() && !"".equals(dto.getMeCode())){
			meCode = Long.valueOf(dto.getMeCode());
		}
		long uid = 0;
		if(null != dto.getUid() && !"".equals(dto.getUid())){
			uid = Long.valueOf(dto.getUid());
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u2.*,u4.me_number,u1.organization_name,u3.nick_name ");
		sb.append("FROM user_organization u1,user_organization_info u2,user_profile u3,user_no u4 ");
		sb.append("WHERE u1.id = u2.organization_id AND u2.uid = u3.uid AND u3.uid = u4.uid ");
		if(uid>0){
			sb.append(" AND u2.uid = ").append(dto.getUid());
		}
		if(StringUtils.isNotBlank(dto.getNickName())){
			sb.append(" AND u3.nick_name LIKE '%").append(dto.getNickName()).append("%' ");
		}
		if(meCode>0){
			sb.append(" AND u4.me_number = ").append(meCode);
		}
		if(StringUtils.isNotBlank(dto.getUserName())){
			sb.append(" AND u2.user_name LIKE '%").append(dto.getUserName()).append("%' ");
		}
		if(StringUtils.isNotBlank(dto.getMobile())){
			sb.append(" AND (u2.mobile1 = '").append(dto.getMobile()).append("' OR u2.mobile2 = '").append(dto.getMobile()).append("') ");
		}
		
		List<Map<String, Object>> list = localJdbcDao.queryEvery(sb.toString());
		if(null!=list&&list.size()>0){
			OrganizationInfoDTO.OrganizationInfoElement e = null;
			for(Map<String,Object> u : list){
				e = new OrganizationInfoDTO.OrganizationInfoElement();
				e.setId((long)u.get("id"));
				e.setUid((long)u.get("uid"));
				e.setMeCode((Long)u.get("me_number"));
				e.setNickName((String)u.get("nick_name"));
				e.setOrganizationName((String)u.get("organization_name"));
				e.setOrganizationNumber((String)u.get("organization_number"));
				e.setUserName((String)u.get("user_name"));
				e.setGender((Integer)u.get("gender"));
				e.setWechatName((String)u.get("wechat_name"));
				e.setWechatNumber((String)u.get("wechat_number"));
				e.setMobile1((String)u.get("mobile1"));
				e.setMobile2((String)u.get("mobile2"));
				e.setBirthday((String)u.get("birthday"));
				e.setAge((Integer)u.get("age"));
				e.setAddress((String)u.get("address"));
				e.setRemark1((String)u.get("remark1"));
				e.setRemark2((String)u.get("remark2"));
				e.setRemark3((String)u.get("remark3"));
				e.setRemark4((String)u.get("remark4"));
				e.setOutRemark1((String)u.get("out_remark1"));
				dto.getResult().add(e);
			}
		}
		view.addObject("dataObj",dto);
		return view;
	}
	
	@RequestMapping(value = "/removeOrganizationInfo")
	@ResponseBody
	public String removeOrganizationInfo(@RequestParam("id") long id){
		String delete = "delete from user_organization_info where id = "+ id;
		localJdbcDao.executeSql(delete);
		return "1";
	}
	
	
	@RequestMapping(value="/edit")
	@ResponseBody
	public OrganizationInfoElement edit(@RequestParam("id") long id){
		String st = "SELECT u2.*,u4.me_number,u1.id as organizationId,u3.nick_name FROM user_organization u1,user_organization_info u2,user_profile u3,user_no u4 WHERE u1.id = u2.organization_id AND u2.uid = u3.uid AND u3.uid = u4.uid and u2.id="+id;
		List<Map<String, Object>> list =localJdbcDao.queryEvery(st);
		if(null!=list&&list.size()>0){
			Map<String, Object> u = list.get(0);
			OrganizationInfoDTO.OrganizationInfoElement e = new OrganizationInfoDTO.OrganizationInfoElement();
			e.setId((long)u.get("id"));
			e.setUid((long)u.get("uid"));
			e.setMeCode((Long)u.get("me_number"));
			e.setNickName((String)u.get("nick_name"));
			e.setOrganizationId((long)u.get("organizationId"));
			e.setOrganizationNumber((String)u.get("organization_number"));
			e.setUserName((String)u.get("user_name"));
			e.setGender((Integer)u.get("gender"));
			e.setWechatName((String)u.get("wechat_name"));
			e.setWechatNumber((String)u.get("wechat_number"));
			e.setMobile1((String)u.get("mobile1"));
			e.setMobile2((String)u.get("mobile2"));
			e.setBirthday((String)u.get("birthday"));
			e.setAge((Integer)u.get("age"));
			e.setAddress((String)u.get("address"));
			e.setRemark1((String)u.get("remark1"));
			e.setRemark2((String)u.get("remark2"));
			e.setRemark3((String)u.get("remark3"));
			e.setRemark4((String)u.get("remark4"));
			e.setOutRemark1((String)u.get("out_remark1"));
			return e;
		}else{
			String st2 = "SELECT u1.uid,u1.nick_name,u2.me_number FROM user_profile u1,user_no u2 WHERE u1.uid = u2.uid and u1.uid = "+id;
			List<Map<String, Object>> list2 =localJdbcDao.queryEvery(st2);
			if(null!=list2&&list2.size()>0){
				Map<String, Object> u = list2.get(0);
				OrganizationInfoDTO.OrganizationInfoElement e = new OrganizationInfoDTO.OrganizationInfoElement();
				e.setUid((long)u.get("uid"));
				e.setMeCode((Long)u.get("me_number"));
				e.setNickName((String)u.get("nick_name"));
				return e;
			}
		}
		return null;
	}
	@RequestMapping(value = "/saveOragnizaionInfo")
	public String saveOragnizaionInof(MultipartHttpServletRequest mrequest) throws Exception {
		try{
			UserOrganizationInfo userOrganizationInfo = new UserOrganizationInfo();
			userOrganizationInfo.setId(StringUtils.isEmpty(mrequest.getParameter("id"))?0:Long.parseLong(mrequest.getParameter("id")));
			userOrganizationInfo.setUid(StringUtils.isEmpty(mrequest.getParameter("uid"))?0:Long.parseLong(mrequest.getParameter("uid")));
			userOrganizationInfo.setAddress(StringUtils.isEmpty(mrequest.getParameter("address"))?null:mrequest.getParameter("address"));
			userOrganizationInfo.setAge(StringUtils.isEmpty(mrequest.getParameter("age"))?0:Integer.valueOf(mrequest.getParameter("age")));
			userOrganizationInfo.setBirthday(StringUtils.isEmpty(mrequest.getParameter("birthday"))?null:mrequest.getParameter("birthday"));
			userOrganizationInfo.setGender(StringUtils.isEmpty(mrequest.getParameter("gender"))?0:Integer.valueOf(mrequest.getParameter("gender")));
			userOrganizationInfo.setMobile1(StringUtils.isEmpty(mrequest.getParameter("mobile1"))?null:mrequest.getParameter("mobile1"));
			userOrganizationInfo.setMobile2(StringUtils.isEmpty(mrequest.getParameter("mobile2"))?null:mrequest.getParameter("mobile2"));
			userOrganizationInfo.setOrganizationId(StringUtils.isEmpty(mrequest.getParameter("organizationId"))?0:Long.parseLong(mrequest.getParameter("organizationId")));
			userOrganizationInfo.setOrganizationNumber(StringUtils.isEmpty(mrequest.getParameter("organizationNumber"))?null:mrequest.getParameter("organizationNumber"));
			userOrganizationInfo.setOutRemark1(StringUtils.isEmpty(mrequest.getParameter("outRemark1"))?null:mrequest.getParameter("outRemark1"));
			userOrganizationInfo.setRemark1(StringUtils.isEmpty(mrequest.getParameter("remark1"))?null:mrequest.getParameter("remark1"));
			userOrganizationInfo.setRemark2(StringUtils.isEmpty(mrequest.getParameter("remark2"))?null:mrequest.getParameter("remark2"));
			userOrganizationInfo.setRemark3(StringUtils.isEmpty(mrequest.getParameter("remark3"))?null:mrequest.getParameter("remark3"));
			userOrganizationInfo.setRemark4(StringUtils.isEmpty(mrequest.getParameter("remark4"))?null:mrequest.getParameter("remark4"));
			userOrganizationInfo.setUserName(StringUtils.isEmpty(mrequest.getParameter("userName"))?null:mrequest.getParameter("userName"));
			userOrganizationInfo.setWechatName(StringUtils.isEmpty(mrequest.getParameter("wechatName"))?null:mrequest.getParameter("wechatName"));
			userOrganizationInfo.setWechatNumber(StringUtils.isEmpty(mrequest.getParameter("wechatNumber"))?null:mrequest.getParameter("wechatNumber"));
			if(userOrganizationInfo.getId()!=0){
				userOrganizationInfoMapper.updateByPrimaryKey(userOrganizationInfo);
			}else{
				userOrganizationInfoMapper.insertSelective(userOrganizationInfo);
			}
			return "redirect:./userOrganizationMgr";
		}catch(Exception e){
			e.printStackTrace();
			logger.error("操作失败！！", e);
			return "redirect:./addOrganizationInfo";
		}
	}
	
	@RequestMapping("/addOrganizationInfo")
	public String addOrganizationInfo(HttpServletRequest request){
		return "userOrganization/addUserOrganization";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxAllOrganizationList")
	public List<UserOrganization> ajaxAllOrganizationList(HttpServletRequest request) throws Exception {
		UserOrganizationExample example = new UserOrganizationExample();
		return userOrganizationMapper.selectByExample(example);
	}
	
	@RequestMapping("/listUsers")
	public String listUsers(HttpServletRequest request){
		return "userOrganization/ajax_list_user";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxLoadUsers")
	@SystemControllerLog(description = "载入系统用户")
	public DatatablePage ajaxLoadUsers(HttpServletRequest request,DatatablePage page) throws Exception {
		Map<String,Object> map = new HashMap<>();
		Enumeration<String> nameeum = request.getParameterNames();
		while(nameeum.hasMoreElements()){
			String name = nameeum.nextElement();
			String val = request.getParameter(name);
			
			if(!name.contains("][") && !StringUtils.isEmpty(val)){
				if(name.equals("nickName")){
					val =HttpUtils.toUTF8(val);
					val = "%"+val+"%";
				}
				
				map.put(name, val);
			}
			
		}
		Map<String,String> colMap = new HashMap<>();
		colMap.put("nickName", "nick_name");
		colMap.put("meCode", "me_number");
		
		// order
		String orderBy =request.getParameter("order[0][column]");
		String order =request.getParameter("order[0][dir]");
		if(orderBy!=null && order!=null){
			String canOrder = request.getParameter("columns["+orderBy+"][orderable]");
			if("true".equals(canOrder)){
				orderBy = request.getParameter("columns["+orderBy+"][data]");
				String orderBy2 = colMap.get(orderBy);
				if(orderBy2!=null){
					orderBy=orderBy2;
				}
				map.put("orderBy", orderBy);
				map.put("order", order);
			}
		}
		PageBean pb = page.toPageBean();
		map.put("skip", (pb.getCurrentPage()-1)*pb.getPageSize());
		map.put("limit", pb.getPageSize());
		String order1 = (String) map.get("order");
		String orderBy1 = (String) map.get("orderBy");
		if(order1!=null && orderBy1!=null){
			map.put("order", orderBy1+" "+order1);
		}
		
		List<SearchUserOrganizationDto> list = userOrganizationMapper.searchUserPage(map);
		int totalRecords=userOrganizationMapper.countSearchUserPage(map);
		page.setData(list);
		page.setRecordsTotal(totalRecords);
		return page;
	}
	
	
	@RequestMapping("/existsOrganizationInfoByUidAndOrganizationId")
	@ResponseBody
	public String existsOrganizationInfoByUidAndOrganizationId (UserOrganizationInfo userOrganizationInfo,HttpServletRequest mrequest){
		Long uid = userOrganizationInfo.getUid();
		Long organizationId = userOrganizationInfo.getOrganizationId();
		UserOrganizationInfoExample example = new UserOrganizationInfoExample();
		UserOrganizationInfoExample.Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		criteria.andOrganizationIdEqualTo(organizationId);
		List<UserOrganizationInfo> list = userOrganizationInfoMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("/MD5")
	@ResponseBody
	public String getMD5(HttpServletRequest request){
		String number = (MD5.toMD5((new Date()).toString())).toUpperCase().substring(0, 16);
		return number;
	}
}
