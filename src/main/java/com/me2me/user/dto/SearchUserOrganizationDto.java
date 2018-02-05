package com.me2me.user.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class SearchUserOrganizationDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private long uid;
	private String nickName;
	private long meCode;
}
