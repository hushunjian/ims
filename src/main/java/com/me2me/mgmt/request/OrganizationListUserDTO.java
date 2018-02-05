package com.me2me.mgmt.request;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class OrganizationListUserDTO {
	@Getter
	@Setter
	private String nickName;
	@Getter
	@Setter
	private String meCode;
	
	@Getter
	@Setter
	List<OrganizationListUserElement> result = Lists.newArrayList();
	
	@Data
	public static class OrganizationListUserElement {
		private long uid;
		private String nickName;
		private long meCode;
	}
}
