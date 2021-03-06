package com.me2me.activity.mapper;

import com.me2me.activity.model.LuckCount;
import com.me2me.activity.model.LuckCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuckCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int countByExample(LuckCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int deleteByExample(LuckCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int insert(LuckCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int insertSelective(LuckCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    List<LuckCount> selectByExample(LuckCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    LuckCount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int updateByExampleSelective(@Param("record") LuckCount record, @Param("example") LuckCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int updateByExample(@Param("record") LuckCount record, @Param("example") LuckCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int updateByPrimaryKeySelective(LuckCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table luck_count
     *
     * @mbggenerated Wed Oct 19 16:27:34 CST 2016
     */
    int updateByPrimaryKey(LuckCount record);
}