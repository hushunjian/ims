package com.me2me.ims.service;

import java.util.List;

import com.me2me.ims.model.ImsFeature;

/**
 * 权限相关服务
 * 
 * @author zhangjiwei
 * @date Oct 11, 2017
 */
public interface ImsFeatureService {
	/**
	 * 返回所有权限
	 * 
	 * @author zhangjiwei
	 * @date Oct 11, 2017
	 */
	List<ImsFeature> getAllFeatures();

	void deleteFeature(Integer featureId);

	ImsFeature getFeatureById(int id);

	void modifyFeature(ImsFeature ft);

	void addFeature(ImsFeature ft);
}
