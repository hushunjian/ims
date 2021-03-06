package com.me2me.ims.mapper.auto;

import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImsFeatureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int countByExample(ImsFeatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int deleteByExample(ImsFeatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int insert(ImsFeature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int insertSelective(ImsFeature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    List<ImsFeature> selectByExample(ImsFeatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    ImsFeature selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int updateByExampleSelective(@Param("record") ImsFeature record, @Param("example") ImsFeatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int updateByExample(@Param("record") ImsFeature record, @Param("example") ImsFeatureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int updateByPrimaryKeySelective(ImsFeature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ims_feature
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    int updateByPrimaryKey(ImsFeature record);
}