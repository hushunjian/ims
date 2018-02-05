package com.me2me.ims.service.autorun;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.me2me.ims.base.AnImsFeature;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.service.ImsFeatureService;

/**
 * 功能点注解扫描器
 * 
 * @author Gene.zhang
 * @date 2013-1-7
 */
@Component
public class FeatureAnnotationScanner implements ApplicationListener<ContextRefreshedEvent> {
	private Logger log = LoggerFactory.getLogger(FeatureAnnotationScanner.class);
	@Autowired
	private ImsFeatureService ftService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(Controller.class);
		//this.scanFeatures(beans.values());
	}

	private void scanFeatures(Collection<Object> beans) {
		// 扫描类上面的注释
		for (Object bean : beans) {
			Class cls = bean.getClass();
			if (cls.getName().contains("CustomAuditController")) {
				System.out.println(cls.getName());
			}
			AnImsFeature feature = (AnImsFeature) cls.getAnnotation(AnImsFeature.class);
			// 扫描所有方法上的注解
			for (Method method : cls.getDeclaredMethods()) {
				AnImsFeature mf = method.getAnnotation(AnImsFeature.class);
				if (mf != null) {
					ImsFeature ift = new ImsFeature();
					ift.setName(mf.name());
					ift.setSn(mf.sn());
					//ftService.addFeature(ift);
					log.info("添加方法功能点:" + cls.getName() + "－" + method.getName() + "->" + ift.getName());
				}
			}
		}
	}
}
