package com.me2me.user.mapper;

import com.me2me.user.model.UserGag;
import com.me2me.user.model.UserGagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int countByExample(UserGagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int deleteByExample(UserGagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int insert(UserGag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int insertSelective(UserGag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    List<UserGag> selectByExample(UserGagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    UserGag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserGag record, @Param("example") UserGagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int updateByExample(@Param("record") UserGag record, @Param("example") UserGagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int updateByPrimaryKeySelective(UserGag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_gag
     *
     * @mbggenerated Tue Nov 01 17:19:59 CST 2016
     */
    int updateByPrimaryKey(UserGag record);
}