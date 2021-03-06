package com.me2me.activity.mapper;

import com.me2me.activity.model.UserActivity;
import com.me2me.activity.model.UserActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int countByExample(UserActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int deleteByExample(UserActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int insert(UserActivity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int insertSelective(UserActivity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    List<UserActivity> selectByExample(UserActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    UserActivity selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserActivity record, @Param("example") UserActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int updateByExample(@Param("record") UserActivity record, @Param("example") UserActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int updateByPrimaryKeySelective(UserActivity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_activity
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    int updateByPrimaryKey(UserActivity record);
}