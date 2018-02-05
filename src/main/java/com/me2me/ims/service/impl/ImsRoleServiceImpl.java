package com.me2me.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me2me.ims.base.ValidateUtils;
import com.me2me.ims.mapper.MImsPermissionMapper;
import com.me2me.ims.mapper.auto.ImsRoleMapper;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
import com.me2me.ims.model.ImsRoleExample;
import com.me2me.ims.service.ImsRoleService;

@Service
public class ImsRoleServiceImpl implements ImsRoleService {
	@Autowired
	private ImsRoleMapper roleMapper;
	@Autowired
	private MImsPermissionMapper mMapper;

	@Override
	public void updateImsRole(ImsRole user) {
		roleMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteImsRole(Integer id) {
		mMapper.deleteUserRoleMappingByRoleId(id);
		mMapper.deleteRoleFeatureMappingByRoleId(id);
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void addRole(ImsRole role) {
		roleMapper.insertSelective(role);
	}

	@Override
	public List<ImsRole> getAllRoles() {
		ImsRoleExample example = new ImsRoleExample();
		List<ImsRole> ret = roleMapper.selectByExample(example);
		return ret;
	}

	@Override
	public void addRoleFeature(int roleId, String featureIds) {
		for (String x : featureIds.split(",")) {
			if (!ValidateUtils.isEmpty(x)) {
				mMapper.addRoleFeature(roleId, Integer.parseInt(x));
			}
		}
	}

	@Override
	public List<ImsFeature> getRoleFeatures(Integer roleId) {
		return mMapper.getRoleFeatures(roleId);
	}

	@Override
	public void coverRoleFeatures(int roleId, String featureIds) {
		mMapper.clearRoleFeatures(roleId);
		addRoleFeature(roleId,featureIds);
	}

}
