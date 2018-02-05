package com.me2me.ims.service;

import java.util.List;

import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
import com.me2me.ims.model.ImsUser;

/**
 * 权限相关服务
 * 
 * @author zhangjiwei
 * @date Oct 11, 2017
 */
public interface ImsUserService {

	List<ImsFeature> getUserFeatures(int uid);

	/**
	 * 修改用户资料
	 * 
	 * @author zhangjiwei
	 * @date Oct 11, 2017
	 * @param user
	 */
	void updateUser(ImsUser user);

	/**
	 * 更新用户的权限
	 * 
	 * @author zhangjiwei
	 * @date Oct 11, 2017
	 * @param uid
	 * @param permissions
	 */
	void updateUserFeature(int uid, String permissionIds);

	List<ImsUser> getAllUsers();

	void deleteImsUser(Integer userId);

	void addUser(ImsUser user);

	void updateImsUser(ImsUser user);

	void addUserFeature(int roleId, String featureIds);

	void deleteUserFeature(Integer userId, Integer featureId);

	ImsUser getUserById(int uid);

	List<ImsRole> getUserRoles(int uid);

	void coverUserFeatures(int userId, String featureIds);
	
	void coverUserRoles(int userId, String roleIds);
}
