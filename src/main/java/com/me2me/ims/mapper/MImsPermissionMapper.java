package com.me2me.ims.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsRole;
/**
 * 权限管理相关。
 * @author zhangjiwei
 * @date Oct 12, 2017
 */

public interface MImsPermissionMapper {
	
	/**
	 * 取用户的权限。
	 * @author zhangjiwei
	 * @date Oct 12, 2017
	 * @param uid
	 * @return
	 */
	List<ImsFeature> getUserPermissons(@Param("userId") int uid);
	
	
	@Delete("delete from ims_user_feature where uid=#{0}")
	void delUserPermission(int uid);

	@Insert("insert into ims_user_feature(user_id,feature_id) values(#{0},#{1})")
	void addUserPermission(int uid, int parseInt);
	
	@Insert("insert into ims_role_feature(role_id,feature_id) values(#{0},#{1})")
	void addRoleFeature(int roleId,int featureId);

	@Insert("insert into ims_user_feature(user_id,feature_id) values(#{0},#{1})")
	void addUserFeature(int uid, int parseInt);

	@Delete("delete from ims_user_feature where user_id=#{0} and feature_id=#{1}")
	void deleteUserFeature(Integer userId, Integer featureId);

	@Select("select * from ims_feature f ,ims_role_feature rf where rf.role_id=#{0} and f.id= rf.feature_id")
	List<ImsFeature> getRoleFeatures(Integer roleId);

	@Select("select * from ims_feature f ,ims_user_feature uf where uf.user_id=#{0} and f.id= uf.feature_id")
	List<ImsFeature> getUserFeatures(int uid);

	@Delete("delete from ims_role_feature where role_id=#{0}")
	void clearRoleFeatures(int roleId);

	@Select("select * from ims_role r,ims_user_role ur where ur.user_id=#{0} and r.id= ur.role_id")
	List<ImsRole> getUserRoles(int userId);

	@Delete("delete from ims_user_feature where user_id=#{0}")
	void clearUserFeature(int userId);

	@Delete("delete from ims_user_role where user_id=#{0}")
	void clearUserRole(int userId);

	@Insert("insert into ims_user_role(user_id,role_id) values(#{0},#{1})")
	void addUserRole(int userId, int roleId);

	@Delete("delete from ims_user_role where role_id=#{0}")
	void deleteUserRoleMappingByRoleId(Integer id);
	
	@Delete("delete from ims_user_role where user_id=#{0}")
	void deleteUserRoleMappingByUserId(Integer userId);
	
	@Delete("delete from ims_role_feature where role_id=#{0}")
	void deleteRoleFeatureMappingByRoleId(Integer id);
	
	@Delete("delete from ims_role_feature where feature_id=#{0}")
	void deleteRoleFeatureMappingByFeatureId(Integer featureId);
	

	@Delete("delete from ims_user_feature where user_id=#{0}")
	void deleteUserFeatureMappingByUserId(Integer userId);
	
	@Delete("delete from ims_user_feature where feature_id=#{0}")
	void deleteUserFeatureMappingByFeatureId(Integer featureId);
}

