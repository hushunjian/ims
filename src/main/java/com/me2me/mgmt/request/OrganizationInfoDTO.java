package com.me2me.mgmt.request;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class OrganizationInfoDTO {
	@Setter
	@Getter
	private String uid;
	@Setter
	@Getter
	private String nickName;
	@Setter
	@Getter
	private String meCode;
	@Setter
	@Getter
	private String userName;
	@Setter
	@Getter
	private String mobile;
	@Setter
	@Getter
	private List<OrganizationInfoElement> result = Lists.newArrayList();
	
	@Data
	public static class OrganizationInfoElement{
		private long id;
		private long uid;
		private long meCode;
		private String nickName;
		private long organizationId;
		private String organizationName;
		private String organizationNumber;
		private String userName;
		private int gender;
		private String wechatName;
		private String wechatNumber;
		private String mobile1;
		private String mobile2;
		private String birthday;
		private int age;
		private String address;
		private String remark1;
		private String remark2;
		private String remark3;
		private String remark4;
		private String outRemark1;
	}
}
