package com.me2me.ims.exception;
/**
 * 错误信息枚举
 * @author zhangjiwei
 * @date Oct 10, 2017
 */
public enum ImsError {
	SUCCESS(200,"OK"),
	ERR_UNKNOWN(5999,"未知错误"), 
	ERR_SERVICE(5000,"业务错误"),
	ERR_PASSWORD(5001,"密码不正确"),
	ERR_OLD_PASSWORD(5002,"旧密码不正确"),
	ERR_NO_PERMISSION(5003,"没有权限"), 
	ERR_NOT_LOGIN(5004,"未登陆");
	
	private int code;
	private String desc;
	private ImsError(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
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
	
}
