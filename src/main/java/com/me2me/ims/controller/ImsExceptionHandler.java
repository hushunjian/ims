package com.me2me.ims.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.me2me.ims.base.ImsResult;
import com.me2me.ims.exception.ImsError;
import com.me2me.ims.exception.ImsException;
import com.me2me.ims.exception.ServiceException;


@Controller
public class ImsExceptionHandler  implements HandlerExceptionResolver{
	private Logger logger= LoggerFactory.getLogger(ImsExceptionHandler.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		ImsError error;
		ModelAndView mv = new ModelAndView();  
		if(ex instanceof ImsException){
			error = ((ImsException) ex).getError();
		}else if(ex instanceof ServiceException){
			logger.error("业务处理异常",ex);
			error= ImsError.ERR_SERVICE;
		}else{
			logger.error("未知错误：",ex);
			error=ImsError.ERR_UNKNOWN;
		}
		response.setContentType("application/json;charset=UTF-8");
		ImsResult result = new ImsResult();
		result.setCode(error.getCode());
		result.setDesc(error.getDesc());
		String str = JSON.toJSONString(result,true);
		try {
			Writer writer =response.getWriter();
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mv;
	}

}
