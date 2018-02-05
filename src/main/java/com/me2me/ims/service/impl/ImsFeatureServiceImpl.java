package com.me2me.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me2me.ims.mapper.MImsPermissionMapper;
import com.me2me.ims.mapper.auto.ImsFeatureMapper;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsFeatureExample;
import com.me2me.ims.service.ImsFeatureService;
@Service
public class ImsFeatureServiceImpl implements ImsFeatureService {
	@Autowired
	private ImsFeatureMapper featureMapper;
	@Autowired
	private MImsPermissionMapper mMapper;
	
	@Override
	public List<ImsFeature> getAllFeatures() {
		ImsFeatureExample example=new ImsFeatureExample();
		List<ImsFeature> ret =featureMapper.selectByExample(example);
		return ret;
	}

	@Override
	public void deleteFeature(Integer featureId) {
		mMapper.deleteUserFeatureMappingByFeatureId(featureId);
		mMapper.deleteRoleFeatureMappingByFeatureId(featureId);
		featureMapper.deleteByPrimaryKey(featureId);
	}


	@Override
	public ImsFeature getFeatureById(int id) {
		
		return featureMapper.selectByPrimaryKey(id);
	}

	@Override
	public void modifyFeature(ImsFeature ft) {
		featureMapper.updateByPrimaryKeySelective(ft);
	}

	@Override
	public void addFeature(ImsFeature ft) {
		featureMapper.insertSelective(ft);
	}

}
