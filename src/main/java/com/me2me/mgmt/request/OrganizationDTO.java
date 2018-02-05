package com.me2me.mgmt.request;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class OrganizationDTO {
	@Getter
    @Setter
	private String organizationName;
	
	@Getter
    @Setter
	private List<UserOrganizatoinElement> result = Lists.newArrayList();
	
	@Data
	public static class UserOrganizatoinElement{
		private long id;
		private String organizationName;
	}
}
