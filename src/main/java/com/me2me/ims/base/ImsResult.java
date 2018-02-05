package com.me2me.ims.base;

import com.me2me.ims.exception.ImsError;

public class ImsResult {
	private int code;
	private String desc;
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ImsResult error(int code, String desc) {
		ImsResult rr = new ImsResult();
		rr.code = code;
		rr.desc = desc;
		return rr;
	}
	public static ImsResult error( String desc) {
		return error(500,desc);
	}
	public static ImsResult success(Object data) {
		ImsResult rr = new ImsResult();
		rr.code = ImsError.SUCCESS.getCode();
		rr.desc = ImsError.SUCCESS.getDesc();
		rr.data = data;
		return rr;
	}

	public static ImsResult success() {
		return success(null);
	}
}
