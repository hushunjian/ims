package com.me2me.live.mapper;

import com.me2me.live.model.GiftHistory;
import com.me2me.live.model.GiftHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int countByExample(GiftHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int deleteByExample(GiftHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int insert(GiftHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int insertSelective(GiftHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    List<GiftHistory> selectByExample(GiftHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    GiftHistory selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int updateByExampleSelective(@Param("record") GiftHistory record, @Param("example") GiftHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int updateByExample(@Param("record") GiftHistory record, @Param("example") GiftHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int updateByPrimaryKeySelective(GiftHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_history
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    int updateByPrimaryKey(GiftHistory record);
}