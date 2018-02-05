package com.me2me.live.mapper;

import com.me2me.live.model.TopicTag;
import com.me2me.live.model.TopicTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int countByExample(TopicTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int deleteByExample(TopicTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int insert(TopicTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int insertSelective(TopicTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    List<TopicTag> selectByExample(TopicTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    TopicTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int updateByExampleSelective(@Param("record") TopicTag record, @Param("example") TopicTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int updateByExample(@Param("record") TopicTag record, @Param("example") TopicTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int updateByPrimaryKeySelective(TopicTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_tag
     *
     * @mbggenerated Mon Sep 11 09:42:32 CST 2017
     */
    int updateByPrimaryKey(TopicTag record);
}