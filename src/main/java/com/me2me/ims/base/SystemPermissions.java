package com.me2me.ims.base;
/**
 * 系统权限列表
 * @author zhangjiwei
 * @date Oct 26, 2017
 */
public enum SystemPermissions {
	//-- 用户管理
	USER_VIEW("查看用户列表"),
	USER_ADD("添加用户"),
	USER_DELETE("删除用户"),
	USER_MODIFY("修改用户"),
	USER_MODIFY_PERMISSION("修改用户权限"),
	USER_MODIFY_PASSWORD("修改用户密码"),
	//-- 角色
	ROLE_VIEW("查看用户角色"),
	ROLE_ADD("添加用户角色"),
	ROLE_DELETE("删除用户角色"),
	ROLE_MODIFY("修改用户角色"),
	ROLE_MODIFY_PERMISSION("修改用户角色权限"),
	
	//-- 功能点
	FEATURE_VIEW("查看功能点"),
	FEATURE_ADD("添加功能点"),
	FEATURE_DELETE("删除功能点"),
	FEATURE_MODIFY("修改功能点");
	
	
	private String desc;

	private SystemPermissions(String desc) {
		this.desc = desc;
	}
	
	
	
}
