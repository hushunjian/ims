package com.me2me.ims.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 构造web工具。
 * 
 * @date 2014-10-13
 * @author jiwei.zhang
 *
 */
public class RequestContextBuilder implements HandlerMethodArgumentResolver {
	@Override
	public Object resolveArgument(MethodParameter arg0, ModelAndViewContainer arg1, NativeWebRequest arg2, WebDataBinderFactory arg3) throws Exception {
		HttpServletRequest request = (HttpServletRequest) arg2.getNativeRequest();
		HttpServletResponse resp = (HttpServletResponse) arg2.getNativeResponse();
		RequestContext proxy = new RequestContext(resp, request);
		return proxy;
	}

	@Override
	public boolean supportsParameter(MethodParameter arg0) {
		Class cls = arg0.getParameterType();
		if (cls.equals(RequestContext.class)) {
			return true;
		} else {
			return false;
		}

	}


}