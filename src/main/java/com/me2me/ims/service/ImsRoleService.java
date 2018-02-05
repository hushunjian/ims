package com.me2me.ims.service;

import java.util.List;

import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;

/**
 * 权限相关服务
 * 
 * @author zhangjiwei
 * @date Oct 11, 2017
 */
public interface ImsRoleService {
	void updateImsRole(ImsRole user);

	void deleteImsRole(Integer userId);

	void addRole(ImsRole user);

	List<ImsRole> getAllRoles();

	void addRoleFeature(int roleId, String featureIds);
	/**
	 * 清除现有权限设置，添加新的权限设置
	 * @author zhangjiwei
	 * @date Oct 27, 2017
	 * @param roleId
	 * @param featureIds
	 */
	void coverRoleFeatures(int roleId,String featureIds);

	List<ImsFeature> getRoleFeatures(Integer roleId);
}
