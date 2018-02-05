package com.me2me.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me2me.ims.base.ValidateUtils;
import com.me2me.ims.mapper.MImsPermissionMapper;
import com.me2me.ims.mapper.auto.ImsUserMapper;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
import com.me2me.ims.model.ImsUser;
import com.me2me.ims.model.ImsUserExample;
import com.me2me.ims.service.ImsUserService;

@Service
public class ImsUserServiceImpl implements ImsUserService {
	@Autowired
	private ImsUserMapper userMapper;
	@Autowired
	private MImsPermissionMapper mMapper;

	@Override
	public void updateUser(ImsUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void updateUserFeature(int uid, String permissionIds) {
		mMapper.delUserPermission(uid);

		for (String pid : permissionIds.split(",")) {
			mMapper.addUserPermission(uid, Integer.parseInt(pid));
		}
	}

	@Override
	public List<ImsUser> getAllUsers() {
		ImsUserExample example = new ImsUserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public void addUser(ImsUser user) {
		userMapper.insertSelective(user);

	}

	@Override
	public void deleteImsUser(Integer userId) {
		mMapper.deleteUserRoleMappingByUserId(userId);
		mMapper.deleteUserFeatureMappingByUserId(userId);
		userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public void updateImsUser(ImsUser user) {
		userMapper.updateByPrimaryKeySelective(user);

	}

	@Override
	public void addUserFeature(int uid, String featureIds) {
		for (String x : featureIds.split(",")) {
			if (!ValidateUtils.isEmpty(x)) {
				mMapper.addUserFeature(uid, Integer.parseInt(x));
			}
		}

	}

	@Override
	public void deleteUserFeature(Integer userId, Integer featureId) {
		
		mMapper.deleteUserFeature(userId, featureId);
	}

	@Override
	public List<ImsFeature> getUserFeatures(int uid) {
		return mMapper.getUserFeatures(uid);
	}

	@Override
	public ImsUser getUserById(int uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<ImsRole> getUserRoles(int uid) {
		return mMapper.getUserRoles(uid);
	}

	@Override
	public void coverUserFeatures(int userId, String featureIds) {
		mMapper.clearUserFeature(userId);
		this.addUserFeature(userId, featureIds);
	}

	@Override
	public void coverUserRoles(int userId, String roleIds) {
		mMapper.clearUserRole(userId);
		for (String x : roleIds.split(",")) {
			if (!ValidateUtils.isEmpty(x)) {
				mMapper.addUserRole(userId, Integer.parseInt(x));
			}
		}
	}

}
