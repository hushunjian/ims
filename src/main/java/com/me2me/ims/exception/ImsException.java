package com.me2me.ims.exception;
/**
 * IMS错误。
 * @author zhangjiwei
 * @date Oct 10, 2017
 */
public class ImsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private ImsError error;
	public ImsException(ImsError error) {
		super(error.getDesc());
		this.error = error;
	}
	public ImsError getError() {
		return error;
	}
	public void setError(ImsError error) {
		this.error = error;
	}
	
}
