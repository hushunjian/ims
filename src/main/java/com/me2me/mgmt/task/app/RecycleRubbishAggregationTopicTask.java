package com.me2me.mgmt.task.app;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.me2me.content.service.ContentService;

@Component
public class RecycleRubbishAggregationTopicTask {
	
	private static final Logger logger = LoggerFactory.getLogger(RecycleRubbishAggregationTopicTask.class);
	
	@Autowired
	private ContentService contentService;

	@Scheduled(cron="0 30 2 * * ?")
	public void updateAggregationTopic(){
		logger.info("回收垃圾聚合王国任务开始");
		long s = System.currentTimeMillis();
		try {
			//先查询出创建时间超过七天，且没有收过子王国的所有聚合王国
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT id,type,category_id ");
			sb.append("FROM topic ");
			sb.append("where type=1000 and create_time < DATE_ADD(NOW(),INTERVAL -7 DAY) ");
			sb.append("and id not IN (SELECT DISTINCT topic_id FROM topic_aggregation)");
			List list = contentService.executeSqlForList(sb.toString());
			if(list != null && list.size()>0){
				logger.info("本次共["+list.size()+"]个需要回收的垃圾聚合王国");
				//拼接update语句
				StringBuilder updateSql = new StringBuilder();
				updateSql.append("update topic set type=0 , category_id=1 ");
				updateSql.append("where id in (");
				for(int i=0 ;i<list.size();i++){
					Map  str =  (Map) list.get(i);
					updateSql.append(str.get("id")).append(",");
				}
				updateSql.deleteCharAt(updateSql.length()-1);
				updateSql.append(")");
				contentService.executeSql(updateSql.toString());
			}else{
				logger.info("无垃圾聚合王国需要回收");
			}
		} catch (Exception e) {
			logger.error("回收垃圾聚合王国任务出错",e);
		}
		long e = System.currentTimeMillis();
		logger.info("回收垃圾聚合王国任务完成，共耗时["+(e-s)+"]毫秒");
	}
	

}
