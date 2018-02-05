package com.me2me.ims.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me2me.common.utils.MD5Utils;
import com.me2me.ims.base.ImsResult;
import com.me2me.ims.base.RequestContext;
import com.me2me.ims.base.SystemPermissions;
import com.me2me.ims.exception.ImsError;
import com.me2me.ims.exception.ImsException;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
import com.me2me.ims.model.ImsUser;
import com.me2me.ims.service.ImsUserService;
/**
 * 权限管理。
 * @author zhangjiwei
 * @date Oct 19, 2017
 */
@RestController
@RequestMapping("/ims/user/")
public class ImsUserController {
	@Autowired
	private ImsUserService userService;
	
	@RequestMapping("getAllUsers")
	public ImsResult getAllUsers(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.USER_VIEW);
		List<ImsUser> dbUser = userService.getAllUsers();
		return ImsResult.success(dbUser);
	}
	
	@RequestMapping("getUserById")
	public ImsResult getUserById(RequestContext rc){
		int uid = rc.getInt("userId");
		ImsUser dbUser = userService.getUserById(uid);
		return ImsResult.success(dbUser);
	}
	@RequestMapping("getUserRoles")
	public ImsResult getUserRoles(RequestContext rc){
		int uid = rc.getInt("userId");
		List<ImsRole> dbUser = userService.getUserRoles(uid);
		return ImsResult.success(dbUser);
	}
	@RequestMapping("addUser")
	public ImsResult addUser(RequestContext rc,ImsUser user){
		rc.checkAdminPermission(SystemPermissions.USER_ADD);
		if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getMobile())){
			throw new ImsException(ImsError.ERR_PASSWORD);
		}
		user.setPassword(MD5Utils.getMd5(user.getPassword()));
		userService.addUser(user);
		return ImsResult.success();
	}
	@RequestMapping("addUserFeature")
	public ImsResult addUserFeature(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.USER_ADD);
		int userId= rc.getInt("userId");
		String featureIds= rc.get("featureIds");
		userService.addUserFeature(userId,featureIds);
		return ImsResult.success();
	}
	@RequestMapping("coverUserFeatures")
	public ImsResult coverUserFeatures(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.USER_ADD);
		int userId= rc.getInt("userId");
		String featureIds= rc.get("featureIds");
		userService.coverUserFeatures(userId,featureIds);
		return ImsResult.success();
	}
	@RequestMapping("coverUserRoles")
	public ImsResult coverUserRole(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.USER_ADD);
		int userId= rc.getInt("userId");
		String roleIds= rc.get("roleIds");
		userService.coverUserRoles(userId,roleIds);
		return ImsResult.success();
	}
	@RequestMapping("deleteUser")
	public ImsResult deleteUser(RequestContext rc){
		int userId= rc.getInt("userId");
		rc.checkAdminPermission(SystemPermissions.USER_DELETE);
		userService.deleteImsUser(userId);
		return ImsResult.success();
	}
	@RequestMapping("deleteUserFeature")
	public ImsResult deleteUserFeature(RequestContext rc){
		int userId= rc.getInt("userId");
		int featureId=rc.getInt("featureId");
		rc.checkAdminPermission(SystemPermissions.USER_DELETE);
		userService.deleteUserFeature(userId,featureId);
		return ImsResult.success();
	}
	@RequestMapping("updateUser")
	public ImsResult updateUser(RequestContext rc,ImsUser user){
		rc.checkAdminPermission(SystemPermissions.USER_MODIFY);
		userService.updateImsUser(user);
		return ImsResult.success();
	}
	@RequestMapping("updateUserFeature")
	public ImsResult updateUserFeature(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.USER_MODIFY);
		int uid = rc.getInt("user_id");
		String permissionIds = rc.get("permissionIds");
		userService.updateUserFeature(uid, permissionIds);
		return ImsResult.success();
	}
	@RequestMapping("getUserFeatures")
	public ImsResult getUserFeatures(RequestContext rc){
		int userId= rc.getInt("userId");
		rc.checkAdminPermission(SystemPermissions.USER_VIEW);
		List<ImsFeature> userFeatures = userService.getUserFeatures(userId);
		return ImsResult.success(userFeatures);
	}
	
	
}
