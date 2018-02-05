package com.me2me.ims.vo;

import java.util.HashSet;
import java.util.Set;

import com.me2me.ims.model.ImsUser;

public class LoginResultVo {
	private ImsUser user;
	private Set<String> permissions = new HashSet<>();

	public ImsUser getUser() {
		return user;
	}

	public void setUser(ImsUser user) {
		this.user = user;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
}
