package com.me2me.ims.service;

import java.util.List;

import com.me2me.ims.exception.UserNotFoundException;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsUser;

/**
 * 权限相关服务
 * 
 * @author zhangjiwei
 * @date Oct 11, 2017
 */
public interface ImsLoginService {
	ImsUser login(String userName, String pwd) throws UserNotFoundException;

	/**
	 * 获取用户所有的权限。包括独立指定和所属角色的权限。
	 * 
	 * @author zhangjiwei
	 * @date Oct 24, 2017
	 * @param uid
	 * @return
	 */
	List<ImsFeature> getUserPermissions(int uid);
}
