package com.me2me.mgmt.handler;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.me2me.ims.base.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessSecurityHandler extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	response.setContentType("text/html;charset=UTF-8");
    	String requestUri = request.getRequestURI();
    	if("/ims/login".equals(requestUri)){
    		return true;
    	}
    	RequestContext rc = new RequestContext(response, request);
    	try{
    		rc.getAdmin();
    	}catch(Exception e){
    		rc.write("<script>alert('您还没有登录');location.href='/login.jsp';</script>");
    		return false;
    	}
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
