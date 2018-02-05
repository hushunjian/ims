package com.me2me.mgmt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.me2me.common.page.PageBean;
import com.me2me.common.security.SecurityUtils;
import com.me2me.common.utils.DateUtil;
import com.me2me.common.web.Response;
import com.me2me.content.dto.SearchAdBannerListDto;
import com.me2me.content.dto.SearchAdInfoListDto;
import com.me2me.content.model.AdBanner;
import com.me2me.content.model.AdInfo;
import com.me2me.content.service.ContentService;
import com.me2me.ims.base.RequestContext;
import com.me2me.io.service.FileTransferService;
import com.me2me.live.model.TopicTag;
import com.me2me.live.service.LiveService;
import com.me2me.mgmt.vo.DatatablePage;
import com.plusnet.sso.api.vo.JsonResult;

@Controller
@RequestMapping("/ad")
public class AdController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdController.class);
	
	@Autowired
    private ContentService contentService;
	
	@Autowired
	private FileTransferService fileTransferService;
	@Autowired
	private LiveService liveService;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@RequestMapping(value = "/adBanner")
	public String adBanner(HttpServletRequest request) throws Exception {
		return "ad/list_adBanner";
	}
	@ResponseBody
	@RequestMapping(value = "/ajaxAdBannerList")
	public DatatablePage ajaxAdBannerList(HttpServletRequest request,DatatablePage page) throws Exception {
		int status = 0;
		SearchAdBannerListDto dto = new SearchAdBannerListDto();
		PageBean pb = page.toPageBean();
		Response resp = contentService.searchAdBannerListPage(status,pb.getCurrentPage(),pb.getPageSize());
		if(null != resp && resp.getCode() == 200 && null != resp.getData()){
			dto = (SearchAdBannerListDto)resp.getData();
		}
		page.setData(dto.getResult());
		page.setRecordsTotal(dto.getTotalRecord());
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxAllAdBannerList")
	public List<AdBanner> ajaxAllAdBannerList(HttpServletRequest request,DatatablePage page) throws Exception {
		return contentService.getAllAdBannerList();
	}
	@RequestMapping(value = "/addAdBanner")
	@ResponseBody
	public String addAdBanner(AdBanner adBanner,HttpServletRequest mrequest) throws Exception {
		try {
		    if(adBanner.getId()==0){
		    	contentService.saveAdBanner(adBanner);
		    }else{
		    	contentService.updateAdBanner(adBanner);
		    }
			return "1";
		} catch (Exception e) {
			logger.error("保存广告位失败", e);
			return "0";
		}
	}
	@RequestMapping(value = "/delAdBanner")
	@ResponseBody
	public String delAdBanner(long id,HttpServletRequest mrequest) throws Exception {
		try {
			AdBanner adBanner = new AdBanner();
			adBanner.setId(id);
			adBanner.setStatus(1);
			contentService.updateAdBanner(adBanner);
			return "1";
		} catch (Exception e) {
			logger.error("删除广告位失败", e);
			return "0";
		}
	}
	@RequestMapping(value = "/getAdBanner")
	@ResponseBody
	public AdBanner getAdBanner(long id,HttpServletRequest mrequest) throws Exception {
		try {
			return contentService.getAdBannerById(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/adInfo")
	public String adInfo(HttpServletRequest request) throws Exception {
		return "ad/list_adInfo";
	}
	@ResponseBody
	@RequestMapping(value = "/ajaxAdInfoList")
	public DatatablePage ajaxAdInfoList(long bannerId,HttpServletRequest request,DatatablePage page) throws Exception {
		int status = 0;
		SearchAdInfoListDto dto = new SearchAdInfoListDto();
		PageBean pb = page.toPageBean();
		Response resp = contentService.searchAdInfoListPage(bannerId,pb.getCurrentPage(),pb.getPageSize());
		if(null != resp && resp.getCode() == 200 && null != resp.getData()){
			dto = (SearchAdInfoListDto)resp.getData();
		}
		page.setData(dto.getResult());
		page.setRecordsTotal(dto.getTotalRecord());
		return page;
	}
	@RequestMapping(value = "/delAdInfo")
	@ResponseBody
	public String delAdInfo(long id,HttpServletRequest mrequest) throws Exception {
		try {
			contentService.delAdInfo(id);
			return "1";
		} catch (Exception e) {
			logger.error("删除失败", e);
			return "0";
		}
	}
	@RequestMapping(value = "/getAdInfo")
	@ResponseBody
	public AdInfo getAdInfo(long id,HttpServletRequest mrequest) throws Exception {
		try {
			return contentService.getAdInfoById(id);
		} catch (Exception e) {
			return null;
		}
	}
	@RequestMapping(value = "/addAdInfo")
	@ResponseBody
	public String addAdInfo(MultipartHttpServletRequest mrequest) throws Exception {
		try{
			AdInfo adInfo = new AdInfo();
			adInfo.setId(StringUtils.isEmpty(mrequest.getParameter("id"))?0:Long.parseLong(mrequest.getParameter("id")));
			adInfo.setAdTitle(StringUtils.isEmpty(mrequest.getParameter("adTitle"))?null:mrequest.getParameter("adTitle"));
			adInfo.setAdCoverWidth(StringUtils.isEmpty(mrequest.getParameter("adCoverWidth"))?null:Integer.parseInt(mrequest.getParameter("adCoverWidth")));
			adInfo.setAdCoverHeight(StringUtils.isEmpty(mrequest.getParameter("adCoverHeight"))?null:Integer.parseInt(mrequest.getParameter("adCoverHeight")));
			adInfo.setEffectiveTime(StringUtils.isEmpty(mrequest.getParameter("effectiveTime"))?null:new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mrequest.getParameter("effectiveTime")));
			adInfo.setDisplayProbability(StringUtils.isEmpty(mrequest.getParameter("displayProbability"))?null:Integer.parseInt(mrequest.getParameter("displayProbability")));
			adInfo.setType(StringUtils.isEmpty(mrequest.getParameter("type"))?null:Integer.parseInt(mrequest.getParameter("type")));
			adInfo.setTopicId(StringUtils.isEmpty(mrequest.getParameter("topicId"))?0:Long.parseLong(mrequest.getParameter("topicId")));
			adInfo.setAdUrl(StringUtils.isEmpty(mrequest.getParameter("adUrl"))?null:mrequest.getParameter("adUrl"));
			adInfo.setBannerId(StringUtils.isEmpty(mrequest.getParameter("bannerId"))?0:Long.parseLong(mrequest.getParameter("bannerId")));
			MultipartFile file = mrequest.getFile("file");
			if(file!=null && !StringUtils.isEmpty(file.getOriginalFilename()) && file.getSize()>0){
				String imgName = SecurityUtils.md5(mrequest.getSession().getId()+System.currentTimeMillis(), "1");
	    		fileTransferService.upload(file.getBytes(), imgName);
	    		adInfo.setAdCover(imgName);
			}
			if(adInfo.getId()!=0){
				contentService.updateAdInfo(adInfo);
			}else{
				contentService.saveAdInfo(adInfo);
			}
			return "1";
		}catch(Exception e){
			e.printStackTrace();
			logger.error("保存广告失败", e);
			return "0";
		}
	}
	@RequestMapping(value = "/getTimeInterval")
	@ResponseBody
	public Map<String,String> getTimeInterval(HttpServletRequest mrequest) throws Exception {
		Map<String,String> dateMap  =new HashMap<String,String>();
		try{
			Date today = new Date();
			Date effectiveTime = DateUtil.addDay(today,1);
			dateMap.put("data", "1");
			dateMap.put("today",DateUtil.date2string(today, "yyyy-MM-dd HH:mm:ss"));
			dateMap.put("effectiveTime",DateUtil.date2string(effectiveTime, "yyyy-MM-dd HH:mm:ss"));
			return dateMap;
		}catch(Exception e){
			dateMap.put("data","0");
			return dateMap;
		}
	}
	@RequestMapping(value = "/listAdTag")
	public String listAdTag(HttpServletRequest mrequest,RequestContext rc) throws Exception {
		int bannerId= rc.getInt("bannerId");
		Map<String,Object> banner= jdbc.queryForMap("select * from ad_banner where id=?",bannerId);
		rc.attr("adBanner",banner);
		List<Map<String,Object>> tags = jdbc.queryForList("select m.*,tag.tag from ad_tag m,topic_tag tag where tag.id=m.tag_id and banner_id=? ",bannerId);
		rc.attr("adBannerTag",tags);
		List<Map<String,Object>> tagList = jdbc.queryForList("select * from topic_tag tag ");
		rc.attr("tagList",tagList);
		return "ad/listAdTag";
	}
	@ResponseBody
	@RequestMapping(value = "/addBannerTagMapping",produces="application/json; charset=UTF-8")
	public JsonResult addBannerTagMapping(HttpServletRequest mrequest,RequestContext rc) throws Exception {
		String tag = rc.get("tag");
		int banner_id=rc.getInt("banner_id");
		int position=rc.getInt("position");
		try{
			TopicTag ttag = liveService.getTopicTagByTag(tag);
			if(jdbc.queryForObject("select count(1) from ad_tag where tag_id=? and banner_id=?", Integer.class,ttag.getId(),banner_id)>0){
				return JsonResult.error("标签已绑定");
			}
			jdbc.update("insert into ad_tag(tag_id,banner_id,position,create_time) values(?,?,?,now())",ttag.getId(),banner_id,position);
		}catch(Exception e){
			return JsonResult.error("标签不存在");
		}
		return JsonResult.success();
	}
	@ResponseBody
	@RequestMapping(value = "/delBannerTagMapping")
	public JsonResult delBannerTagMapping(HttpServletRequest mrequest,RequestContext rc) throws Exception {
		int mapperId= rc.getInt("mapperId");
		jdbc.update("delete from ad_tag where id=?",mapperId);
		return JsonResult.success();
	}
	@ResponseBody
	@RequestMapping(value = "/getBannerTagMapping")
	public JsonResult getBannerTagMapping(HttpServletRequest mrequest,RequestContext rc) throws Exception {
		int mapperId= rc.getInt("mapperId");
		Map<String,Object> data=  jdbc.queryForMap("select * from ad_tag where id=?",mapperId);
		return JsonResult.success(data);
	}
}
