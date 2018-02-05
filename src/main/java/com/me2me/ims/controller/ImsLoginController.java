package com.me2me.ims.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.me2me.common.utils.MD5Utils;
import com.me2me.ims.base.ImsResult;
import com.me2me.ims.base.RequestContext;
import com.me2me.ims.exception.ImsError;
import com.me2me.ims.exception.ImsException;
import com.me2me.ims.exception.UserNotFoundException;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsUser;
import com.me2me.ims.service.ImsLoginService;
import com.me2me.ims.service.ImsUserService;
import com.me2me.ims.vo.LoginResultVo;

/**
 * 权限管理。
 * 
 * @author zhangjiwei
 * @date Oct 19, 2017
 */
@Controller
@RequestMapping("/ims/")
public class ImsLoginController {
	@Autowired
	private ImsLoginService loginService;

	@Autowired
	private ImsUserService userService;
	@ResponseBody
	@RequestMapping(value="modifyPassword",produces="application/json; charset=UTF-8")
	public ImsResult modifyPassword(RequestContext rc) {
		rc.checkAdminLogin();
		ImsUser user = (ImsUser) rc.session("admin_user");
		String oldPwd = rc.get("password");
		String newPwd = rc.get("newPassword");

		if (user.getPassword().equals(MD5Utils.getMd5(oldPwd))) {
			user.setPassword(MD5Utils.getMd5(newPwd));
			userService.updateUser(user);
		} else {
			throw new ImsException(ImsError.ERR_OLD_PASSWORD);
		}
		return ImsResult.success();
	}
	@ResponseBody
	@RequestMapping(value="login",produces=MediaType.APPLICATION_JSON_VALUE)
	public ImsResult login(RequestContext rc, ImsUser user) {
		String pwd = MD5Utils.getMd5(user.getPassword());
		try {
			ImsUser dbUser = loginService.login(user.getUserName(), pwd);
			List<ImsFeature> permissions = loginService.getUserPermissions(dbUser.getId());
			
			LoginResultVo  vo = new LoginResultVo();
			vo.setUser(dbUser);
			Set<String> keys = new LinkedHashSet();
			permissions.forEach(feature->keys.add(feature.getSn()));
			vo.setPermissions(keys);
			rc.initAdminSession(dbUser,keys);
			return ImsResult.success(vo);
		} catch (UserNotFoundException e) {
			throw new ImsException(ImsError.ERR_PASSWORD);
		}
	}
	@RequestMapping(value="exit")
	public String exit(RequestContext rc, ImsUser user) {
		rc.getSession().invalidate();
		return "redirect:/login.jsp";
	}
}
