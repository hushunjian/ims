package com.me2me.content.mapper;

import com.me2me.content.model.AdInfo;
import com.me2me.content.model.AdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int countByExample(AdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int deleteByExample(AdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int insert(AdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int insertSelective(AdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    List<AdInfo> selectByExample(AdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    AdInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") AdInfo record, @Param("example") AdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int updateByExample(@Param("record") AdInfo record, @Param("example") AdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int updateByPrimaryKeySelective(AdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_info
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    int updateByPrimaryKey(AdInfo record);
}