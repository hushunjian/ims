package com.me2me.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me2me.ims.base.ImsResult;
import com.me2me.ims.base.RequestContext;
import com.me2me.ims.base.SystemPermissions;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.service.ImsFeatureService;
/**
 * 权限管理。
 * @author zhangjiwei
 * @date Oct 19, 2017
 */
@RestController
@RequestMapping("/ims/feature/")
public class ImsFeatureController {
	@Autowired
	private ImsFeatureService featureService;
	
	@RequestMapping("getAllFeatures")
	public ImsResult getAllFeature(RequestContext rc) throws Exception{
		rc.checkAdminLogin();
		List<ImsFeature> permissions =featureService.getAllFeatures();
		return ImsResult.success(permissions);
	}
	@RequestMapping("deleteFeature")
	public ImsResult deleteFeature(RequestContext rc,Integer featureId){
		rc.checkAdminPermission(SystemPermissions.FEATURE_DELETE);
		featureService.deleteFeature(featureId);
		return ImsResult.success();
	}
	@RequestMapping("getFeatureById")
	public ImsResult getFeatureById(RequestContext rc) throws Exception{
		rc.checkAdminPermission(SystemPermissions.FEATURE_VIEW);
		int id= rc.getInt("id");
		ImsFeature permissions =featureService.getFeatureById(id);
		return ImsResult.success(permissions);
	}
	@RequestMapping("modifyFeature")
	public ImsResult modifyFeature(RequestContext rc,ImsFeature ft) throws Exception{
		rc.checkAdminPermission(SystemPermissions.FEATURE_MODIFY);
		featureService.modifyFeature(ft);
		return ImsResult.success();
	}
	@RequestMapping("addFeature")
	public ImsResult addFeature(RequestContext rc,ImsFeature ft) throws Exception{
		rc.checkAdminPermission(SystemPermissions.FEATURE_ADD);
		featureService.addFeature(ft);
		return ImsResult.success();
	}
}

