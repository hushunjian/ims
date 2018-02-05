package com.me2me.mgmt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.me2me.cache.service.CacheService;
import com.me2me.common.Constant;
import com.me2me.common.utils.DateUtil;
import com.me2me.mgmt.dao.LocalJdbcDao;
import com.me2me.user.service.UserService;

@Controller
@RequestMapping("/task")
public class TaskConsoleController {

	private static final Logger logger = LoggerFactory.getLogger(TaskConsoleController.class);
	
	@Autowired
	private LocalJdbcDao localJdbcDao;
	@Autowired
	private CacheService cacheService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/ugcCollect")
	@ResponseBody
	public String ugcCollect() {
		logger.info("开始进行UGC编入情绪王国整理");
		long s = System.currentTimeMillis();
		String returnMsg = "执行完成";
		try{
			StringBuilder countSql = new StringBuilder();
			countSql.append("select count(DISTINCT t.uid) as cc from content t where t.type=0");
			countSql.append(" and t.status=0 and t.rights=1 and t.ugc_status=0");
			List<Map<String, Object>> countList = localJdbcDao.queryEvery(countSql.toString());
			int total = 0;
			if(null != countList && countList.size() > 0){
				Map<String, Object> count = countList.get(0);
				total = ((Long)count.get("cc")).intValue();
			}
			logger.info("共["+total+"]个用户的UGC需要整理");
			
			StringBuilder ugcUserSqlBuilder = new StringBuilder();
			ugcUserSqlBuilder.append("select t.uid from content t where t.type=0 and t.status=0 and t.rights=1");
			ugcUserSqlBuilder.append(" and t.ugc_status=0 group by t.uid order by t.uid");
			String ugcUserSql = ugcUserSqlBuilder.toString();
			
			int batch = 200;
			int runCount = 0;
			List<Map<String, Object>> userList = null;
			while(true){
				userList = localJdbcDao.queryEvery(ugcUserSql + " limit " + batch);
				if(null == userList || userList.size() == 0){
					break;
				}
				for(Map<String, Object> u : userList){
					long uid = (Long)u.get("uid");
					this.ugcCollectExce(uid);
				}
				runCount = runCount + userList.size();
				logger.info("本次处理了["+userList.size()+"]个用户，共["+total+"]个用户，还剩["+(total-runCount)+"]个用户");
			}
		}catch(Exception e){
			logger.error("任务执行失败", e);
			returnMsg = "执行失败";
		}
		long e = System.currentTimeMillis();
		logger.info("UGC编入情绪王国整理完成，共耗时["+(e-s)/1000+"]秒");
		
		return returnMsg;
	}
	
	private void ugcCollectExce(long uid){
		String ugcListSql = "select t.id,t.title,t.conver_image,t.content from content t where t.type=0 and t.status=0 and t.rights=1  and t.ugc_status=0 and t.uid="+uid+" order by id";
		List<Map<String, Object>> contentList = localJdbcDao.queryEvery(ugcListSql);
		if(null != contentList && contentList.size() > 0){
			//先判断是否有情绪王国，如果没有则创建
			String userEmotionTopicSql = "select * from topic t where t.sub_type=1 and t.uid="+uid;
			List<Map<String, Object>> topicList = localJdbcDao.queryEvery(userEmotionTopicSql);
			long userEmotionTopicId = 0;
			if(null != topicList && topicList.size() > 0){//有
				Map<String, Object> userEmotionTopic = topicList.get(0);
				userEmotionTopicId = (Long)userEmotionTopic.get("id");
			}else{//没有，则创建
				userEmotionTopicId = this.createUserEmotionTopic(uid);
			}
			if(userEmotionTopicId <= 0){
				logger.info("用户["+uid+"]情绪王国获取失败");
				return;
			}
			
			//获取该用户所有UGC的图片资源
			Map<String, List<String>> imageMap = new HashMap<String, List<String>>();
			StringBuilder ugcImageListSql = new StringBuilder();
			ugcImageListSql.append("select * from content_image i where i.cid in (");
			for(int i=0;i<contentList.size();i++){
				if(i>0){
					ugcImageListSql.append(",");
				}
				ugcImageListSql.append(contentList.get(0).get("id").toString());
			}
			ugcImageListSql.append(")");
			List<Map<String, Object>> ugcImageList = localJdbcDao.queryEvery(ugcImageListSql.toString());
			if(null != ugcImageList && ugcImageList.size() > 0){
				List<String> imageList = null;
				String cidStr = null;
				for(Map<String, Object> m : ugcImageList){
					cidStr = m.get("cid").toString();
					imageList = imageMap.get(cidStr);
					if(null == imageList){
						imageList = new ArrayList<String>();
						imageMap.put(cidStr, imageList);
					}
					imageList.add((String)m.get("image"));
				}
			}
			
			StringBuilder insertUgcSqlBuilder = new StringBuilder();
			insertUgcSqlBuilder.append("insert into topic_fragment(topic_id,uid,fragment_image,fragment,type,content_type,top_id,bottom_id,create_time,at_uid,source,extra,score,status,update_time)");
			insertUgcSqlBuilder.append(" values(").append(userEmotionTopicId).append(",").append(uid).append(",'','#{ugcTitle}#',52,23,0,0,now(),0,0,'#{ugcExtra}#',0,1,now())");
			
			String updateUgcStatus = "update content set ugc_status=1 where id=";
			
			String insertUgcSql = null;
			JSONObject extra = null;
			JSONArray images = null;
			List<String> imgList = null;
			String ugcTitle = null;
			String ugcContent = null;
			for(Map<String, Object> content : contentList){
				ugcTitle = (String)content.get("title");
				if(null == ugcTitle){
					ugcTitle = "";
				}else{
					ugcTitle = ugcTitle.replaceAll("'", "''");//转义
				}
				ugcContent = (String)content.get("content");
				if(null == ugcContent){
					ugcContent = "";
				}else{
					ugcContent = ugcContent.replaceAll("'", "''");
				}
				insertUgcSql = insertUgcSqlBuilder.toString().replace("#{ugcTitle}#", ugcTitle);
				//组装extra
				extra = new JSONObject();
				extra.put("type", "ugc");
				extra.put("only", UUID.randomUUID().toString()+"-"+new Random().nextInt());
				extra.put("content", ugcContent);
		        images = new JSONArray();
		        imgList = imageMap.get(content.get("id").toString());
		        if(null != imgList && imgList.size() > 0){
		        	for(String img : imgList){
		        		images.add(Constant.QINIU_DOMAIN + "/" + img);
		        	}
		        }
		        extra.put("images", images);//图片
		        insertUgcSql = insertUgcSql.replace("#{ugcExtra}#", extra.toJSONString());
		        localJdbcDao.executeSql(insertUgcSql);
		        
		        long cid = (Long)content.get("id");
		        localJdbcDao.executeSql(updateUgcStatus + cid);
			}
			//刷详情缓存
			String totalFragmentSql = "select count(1) as cc from topic_fragment f where f.topic_id="+userEmotionTopicId;
			List<Map<String, Object>> countSearch = localJdbcDao.queryEvery(totalFragmentSql);
			int total = 0;
			if(null != countSearch && countSearch.size() > 0){
				total = ((Long)countSearch.get(0).get("cc")).intValue();
			}
			String lastFragmentIdSql = "select f.id from topic_fragment f where f.status=1 and f.topic_id="+userEmotionTopicId+" order by id desc limit 1";
			List<Map<String, Object>> lastFragmentIdSearch = localJdbcDao.queryEvery(lastFragmentIdSql);
			long fid = 0;
			if(null != lastFragmentIdSearch && lastFragmentIdSearch.size() > 0){
				fid = (Long)lastFragmentIdSearch.get(0).get("id");
			}
            String value = fid + "," + total;
            cacheService.hSet("TOPIC_FRAGMENT_NEWEST", "T_" + userEmotionTopicId, value);
		}
	}
	
	//返回TopicId
	private long createUserEmotionTopic(long uid){
		String userProfileSql = "select u.uid,u.nick_name from user_profile u where u.uid="+uid;
		List<Map<String, Object>> userList = localJdbcDao.queryEvery(userProfileSql);
		String nickName = null;
		if(null != userList && userList.size() > 0){
			Map<String, Object> userProfile = userList.get(0);
			nickName = (String)userProfile.get("nick_name");
		}
		if(StringUtils.isEmpty(nickName)){
			logger.info("用户["+uid+"]不存在");
			return 0;
		}
		if (nickName.matches("用户\\d+.*")) {
			nickName = "我";
		}
		String title = nickName + "的生活记录";
		
		String topicCoverImage = null;
		
		
		String topicCoverSql = "select pic from topic_preset_pic";
		List<Map<String, Object>> topicCoverList = localJdbcDao.queryEvery(topicCoverSql);
		if(null != topicCoverList && topicCoverList.size() > 0){
			int idx = new Random().nextInt(topicCoverList.size());
			Map<String, Object> topicCover = topicCoverList.get(idx);
			topicCoverImage = (String)topicCover.get("pic");
		}
		if(StringUtils.isEmpty(topicCoverImage)){
			logger.info("没有王国封面图片");
			return 0;
		}
		
		String summary = "吃喝玩乐，记录我的日常。";
		long nowTime = System.currentTimeMillis();
		//保存topic表
		StringBuilder insertTopicSql = new StringBuilder();
		insertTopicSql.append("insert into topic(uid,live_image,title,status,create_time,update_time,long_time,qrcode,core_circle,type,ce_audit_type,ac_audit_type,ac_publish_type,rights,summary,sub_type,price,listing_time)");
		insertTopicSql.append(" values(").append(uid).append(",'").append(topicCoverImage).append("','").append(title).append("',0,now(),now(),").append(nowTime);
		insertTopicSql.append(",'','[").append(uid).append("]',0,0,1,0,1,'").append(summary).append("',1,0,null)");
		localJdbcDao.executeSql(insertTopicSql.toString());
		//保存content表
		long topicId = 0;
		String topicIdSql = "select t.id from topic t where t.sub_type=1 and t.uid="+uid;
		List<Map<String, Object>> topicIdSearchList = localJdbcDao.queryEvery(topicIdSql);
		if(null != topicIdSearchList && topicIdSearchList.size() > 0){
			Map<String, Object> topicIdSearch = topicIdSearchList.get(0);
			topicId = (Long)topicIdSearch.get("id");
		}
		if(topicId <= 0){
			logger.info("保存失败了？？？");
			return 0;
		}
		StringBuilder insertContentSql = new StringBuilder();
		insertContentSql.append("insert into content(uid,forward_cid,title,feeling,type,conver_image,forward_title,forward_url,content_type,content,thumbnail,hot_value,person_count,review_count,like_count,favorite_count,read_count,read_count_dummy,is_top,authorization,rights,author,status,create_time,update_time,update_id,ugc_status)");
		insertContentSql.append(" values(").append(uid).append(",").append(topicId).append(",'").append(title).append("','").append(title);
		insertContentSql.append("',3,'").append(topicCoverImage).append("','','',0,'").append(title).append("','',1,0,0,0,0,0,0,0,0,1,0,0,now(),now(),");
		insertContentSql.append(cacheService.incr("UPDATE_ID")).append(",0)");
		localJdbcDao.executeSql(insertContentSql.toString());
		//保存TopicData表
		StringBuilder insertTopicDataSql = new StringBuilder();
		insertTopicDataSql.append("insert into topic_data(topic_id,last_price,last_price_incr,steal_price,update_time,diligently,approve,update_text_length,update_text_count,update_image_count,");
		insertTopicDataSql.append("update_vedio_count,update_vedio_length,update_audio_count,update_audio_length,update_vote_count,update_tease_count,update_day_count,review_text_count,review_text_length)");
		insertTopicDataSql.append(" values(").append(topicId).append(",0,0,0,now(),0,0,0,0,0,0,0,0,0,0,0,0,0,0)");
		localJdbcDao.executeSql(insertTopicDataSql.toString());
		//保存第一次发言（王国简介）
		JSONObject extra = new JSONObject();
		extra.put("type", "textNormal");
		extra.put("only", UUID.randomUUID().toString() + "-" + new Random().nextInt());
		extra.put("hAlign", "center");
		StringBuilder insertTopicFragmentSql = new StringBuilder();
		insertTopicFragmentSql.append("insert into topic_fragment(topic_id,uid,fragment_image,fragment,type,content_type,top_id,bottom_id,create_time,at_uid,source,extra,score,status,update_time)");
		insertTopicFragmentSql.append(" values(").append(topicId).append(",").append(uid).append(",'','").append(summary);
		insertTopicFragmentSql.append("',0,0,0,0,now(),0,0,'").append(extra.toJSONString()).append("',0,0,now())");
		localJdbcDao.executeSql(insertTopicFragmentSql.toString());
		//保存王国详情缓存
		String fidSearchSql = "select * from topic_fragment f where f.topic_id="+topicId+" order by id asc limit 1";
		List<Map<String, Object>> fList = localJdbcDao.queryEvery(fidSearchSql);
		if(null != fList && fList.size() > 0){
			Map<String, Object> fidSearch = fList.get(0);
			long lastFragmentId = (Long)fidSearch.get("id");
			String value = lastFragmentId + ",1";
	        cacheService.hSet("TOPIC_FRAGMENT_NEWEST", "T_" + topicId, value);
		}
		//保存标签
		long tagId = 0;
		String tagSearchSql = "select * from topic_tag where tag='非典型性话痨'";
		List<Map<String, Object>> tagList = localJdbcDao.queryEvery(tagSearchSql);
		if(null != tagList && tagList.size() > 0){
			Map<String, Object> tagSearch = tagList.get(0);
			tagId = (Long)tagSearch.get("id");
		}else{//没有则新建
			StringBuilder insertTopicTagSql = new StringBuilder();
			insertTopicTagSql.append("insert into topic_tag(tag,is_rec,is_sys,status,create_time,user_hobby_ids,pid,order_num)");
			insertTopicTagSql.append(" values('非典型性话痨',0,0,0,now(),null,null,null)");
			localJdbcDao.executeSql(insertTopicTagSql.toString());
			tagList = localJdbcDao.queryEvery(tagSearchSql);
			if(null != tagList && tagList.size() > 0){
				Map<String, Object> tagSearch = tagList.get(0);
				tagId = (Long)tagSearch.get("id");
			}
		}
		if(tagId>0){
			StringBuilder insertTopicTagDetailSql = new StringBuilder();
			insertTopicTagDetailSql.append("insert into topic_tag_detail(topic_id,uid,tag_id,tag,create_time,status,auto_tag)");
			insertTopicTagDetailSql.append(" values(").append(topicId).append(",").append(uid).append(",").append(tagId);
			insertTopicTagDetailSql.append(",'非典型性话痨',now(),0,0)");
			localJdbcDao.executeSql(insertTopicTagDetailSql.toString());
		}
		
		return topicId;
	}
	
	@RequestMapping(value = "/refreshHarvest")
	@ResponseBody
	public String refreshHarvest(@RequestParam("tid")long topicId) {
		String topicSql = "select * from topic t where t.id="+topicId;
		List<Map<String, Object>> list = localJdbcDao.queryEvery(topicSql);
		if(null == list || list.size() == 0){
			return "王国不存在";
		}
		Map<String, Object> topic = list.get(0);
		int price = (Integer)topic.get("price");
		
		int harvestPercent = 30;
		String hp = userService.getAppConfigByKey("HARVEST_PERCENT");
		if(!StringUtils.isEmpty(hp)){
			harvestPercent = Integer.valueOf(hp);
		}
		int canHarvestPrice = price*harvestPercent/100;
		if(canHarvestPrice<0){
			canHarvestPrice = 0;
		}
		
		String updateSql = "update topic_data set harvest_price=? where topic_id=?";
		localJdbcDao.executeSqlWithParams(updateSql, canHarvestPrice, topicId);
		
		cacheService.set("TOPIC_HARVEST:"+topicId, String.valueOf(canHarvestPrice));
		
		return "刷新成功";
	}
	
	@RequestMapping(value = "/transformKingdomInage")
	@ResponseBody
	public String transformKingdomInage(){
		logger.info("UGC和图组的王国图库转换任务开始");
		long s = System.currentTimeMillis();
		try{
			StringBuilder conSql = new StringBuilder();
			conSql.append("from topic_fragment f,topic t where f.topic_id=t.id");
			conSql.append(" and f.status=1 and f.at_uid=0 and f.content_type in (23,25)");
			long totalCount = 0;
			String countSql = "select count(1) cc " + conSql.toString();
			List<Map<String, Object>> countList = localJdbcDao.queryEvery(countSql);
			if(null != countList && countList.size() > 0){
				Map<String, Object> cc = countList.get(0);
				totalCount = (Long)cc.get("cc");
			}
			logger.info("本次共[{}]个UGC和图组类内容需要转换", totalCount);
			
			String querySql = "select f.* " + conSql.toString() + " order by f.id limit 500";
			
			int runCount = 0;
			List<Map<String, Object>> fragmentList = null;
			while(true){
				fragmentList = localJdbcDao.queryEvery(querySql);
				if(null == fragmentList || fragmentList.size() == 0){
					break;
				}
				//开始处理
				for(Map<String, Object> f : fragmentList){
					this.transferTopicImage(f);
				}
				runCount = runCount + fragmentList.size();
				logger.info("本次处理了[{}]个，共[{}]个，还剩[{}]个", fragmentList.size(), totalCount, (totalCount-runCount));
			}
		}catch(Exception e){
			logger.error("王国图库转换任务失败", e);
		}
		long e = System.currentTimeMillis();
		logger.info("王国图库转换任务完成，共耗时[{}]", DateUtil.showTimeBySecond((int)((e-s)/1000)));
		
		return "转换完成";
	}
	
	private void transferTopicImage(Map<String, Object> fragment){
		long fid = (Long)fragment.get("id");
		long topicId = (Long)fragment.get("topic_id");
		String image = (String)fragment.get("fragment_image");
//		int type = (Integer)fragment.get("type");
		int contentType = (Integer)fragment.get("content_type");
		Date createTime = (Date)fragment.get("create_time");
		String extra = (String)fragment.get("extra");
		
		List<TopicImage> insertList = new ArrayList<TopicImage>();
		TopicImage topicImage = null;
		if(contentType == 1 || contentType == 51){//图片
			if(!StringUtils.isEmpty(image)){
				topicImage = new TopicImage();
				topicImage.setImage(image);
				topicImage.setExtra(extra);
				insertList.add(topicImage);
			}
		}else if(contentType == 23 || contentType == 25){//UGC或图组 （两种类型图片方面格式差不多，可以一起解析）
			if(!StringUtils.isEmpty(extra)){
				JSONObject extraJson = null;
				try{
					extraJson = JSONObject.parseObject(extra.replaceAll("\n", "").replaceAll("\\\\", "\\\\\\\\"));
				}catch(Exception e){
					
				}
				if(null != extraJson && null != extraJson.get("images")){
					JSONArray imagesArray = extraJson.getJSONArray("images");
					if(imagesArray.size() > 0){
						JSONArray imageInfoArray = extraJson.getJSONArray("imageInfo");
						if(null == imageInfoArray){
							imageInfoArray = new JSONArray();
						}
						String img = null;
						for (int i = 0; i < imagesArray.size(); i++) {
							topicImage = new TopicImage();
							img = imagesArray.getString(i);
							if(img.startsWith("http")){//extra里面的图片地址是全地址，所以需要将前缀去掉
								img = img.substring(img.lastIndexOf("/")+1);
							}
							topicImage.setImage(img);
							if(imageInfoArray.size() > i){
								topicImage.setExtra(imageInfoArray.getJSONObject(i).toJSONString());
							}
							insertList.add(topicImage);
						}
					}
				}
			}
		}
		
		if(insertList.size() > 0){
			StringBuilder insertSql = new StringBuilder();
			insertSql.append("insert into topic_image(topic_id,fid,image,extra,create_time) values ");
			for(int i=0;i<insertList.size();i++){
				topicImage = insertList.get(i);
				if(i>0){
					insertSql.append(",");
				}
				insertSql.append("(").append(topicId).append(",").append(fid).append(",'").append(topicImage.getImage()).append("',");
				if(null == topicImage.getExtra()){
					insertSql.append("null,");
				}else{
					insertSql.append("'").append(topicImage.getExtra()).append("',");
				}
				insertSql.append("'").append(DateUtil.date2string(createTime, "yyyy-MM-dd HH:mm:ss")).append("')");
			}
			localJdbcDao.executeSql(insertSql.toString());
		}
		
		//更改状态
		String updateSql = "update topic_fragment set at_uid=100 where id=?";
		localJdbcDao.executeSqlWithParams(updateSql, fid);
	}
	
	@Data
	private class TopicImage{
		private String image;
		private String extra;
	}
}
