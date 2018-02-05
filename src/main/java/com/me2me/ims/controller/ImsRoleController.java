package com.me2me.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me2me.ims.base.ImsResult;
import com.me2me.ims.base.RequestContext;
import com.me2me.ims.base.SystemPermissions;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
import com.me2me.ims.service.ImsRoleService;
/**
 * 权限管理。
 * @author zhangjiwei
 * @date Oct 19, 2017
 */
@RestController
@RequestMapping("/ims/role/")
public class ImsRoleController {
	@Autowired
	private ImsRoleService roleService;
	

	
	
	@RequestMapping("getAllRoles")
	public ImsResult getAllRoles(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.ROLE_VIEW);
		List<ImsRole> dbRole = roleService.getAllRoles();
		return ImsResult.success(dbRole);
	}
	@RequestMapping("addRole")
	public ImsResult addRole(RequestContext rc,ImsRole user){
		rc.checkAdminPermission(SystemPermissions.ROLE_ADD);
		roleService.addRole(user);
		return ImsResult.success();
	}
	@RequestMapping("deleteRole")
	public ImsResult deleteRole(RequestContext rc){
		int roleId= rc.getInt("roleId");
		rc.checkAdminPermission(SystemPermissions.ROLE_DELETE);
		roleService.deleteImsRole(roleId);
		return ImsResult.success();
	}
	@RequestMapping("updateRole")
	public ImsResult updateRole(RequestContext rc,ImsRole user){
		rc.checkAdminPermission(SystemPermissions.ROLE_MODIFY);
		roleService.updateImsRole(user);
		return ImsResult.success();
	}
	@RequestMapping("addRoleFeature")
	public ImsResult addRoleFeature(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.ROLE_MODIFY_PERMISSION);
		int roleId= rc.getInt("roleId");
		String featureIds= rc.get("featureIds");
		roleService.addRoleFeature(roleId,featureIds);
		return ImsResult.success();
	}
	@RequestMapping("coverRoleFeatures")
	public ImsResult coverRoleFeatures(RequestContext rc){
		rc.checkAdminPermission(SystemPermissions.ROLE_MODIFY_PERMISSION);
		int roleId= rc.getInt("roleId");
		String featureIds= rc.get("featureIds");
		roleService.coverRoleFeatures(roleId,featureIds);
		return ImsResult.success();
	}
	
	@RequestMapping("getRoleFeatures")
	public ImsResult getRoleFeatures(RequestContext rc){
		int roleId= rc.getInt("roleId");
		rc.checkAdminPermission(SystemPermissions.ROLE_VIEW);
		List<ImsFeature> userFeatures = roleService.getRoleFeatures(roleId);
		return ImsResult.success(userFeatures);
	}
	
}
