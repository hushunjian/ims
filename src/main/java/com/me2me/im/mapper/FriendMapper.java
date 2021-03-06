package com.me2me.im.mapper;

import com.me2me.im.model.Friend;
import com.me2me.im.model.FriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int countByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int deleteByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int insert(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int insertSelective(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    List<Friend> selectByExample(FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    Friend selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int updateByPrimaryKeySelective(Friend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friends
     *
     * @mbggenerated Tue Mar 01 14:03:50 CST 2016
     */
    int updateByPrimaryKey(Friend record);
}