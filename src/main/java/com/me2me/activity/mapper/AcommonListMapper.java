package com.me2me.activity.mapper;

import com.me2me.activity.model.AcommonList;
import com.me2me.activity.model.AcommonListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcommonListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int countByExample(AcommonListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int deleteByExample(AcommonListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int insert(AcommonList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int insertSelective(AcommonList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    List<AcommonList> selectByExample(AcommonListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    AcommonList selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int updateByExampleSelective(@Param("record") AcommonList record, @Param("example") AcommonListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int updateByExample(@Param("record") AcommonList record, @Param("example") AcommonListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int updateByPrimaryKeySelective(AcommonList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table a_common_list
     *
     * @mbggenerated Wed Apr 19 20:32:21 CST 2017
     */
    int updateByPrimaryKey(AcommonList record);
}