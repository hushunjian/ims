package com.me2me.ims.exception;
/**
 * 没有权限。
 * @author zhangjiwei
 * @date Oct 23, 2017
 */
public class NoPermissionException extends ImsException{

	public NoPermissionException(ImsError error) {
		super(error);
	}
	
}
