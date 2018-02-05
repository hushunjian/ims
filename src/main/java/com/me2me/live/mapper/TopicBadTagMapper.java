package com.me2me.live.mapper;

import com.me2me.live.model.TopicBadTag;
import com.me2me.live.model.TopicBadTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicBadTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int countByExample(TopicBadTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int deleteByExample(TopicBadTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int insert(TopicBadTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int insertSelective(TopicBadTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    List<TopicBadTag> selectByExample(TopicBadTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    TopicBadTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int updateByExampleSelective(@Param("record") TopicBadTag record, @Param("example") TopicBadTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int updateByExample(@Param("record") TopicBadTag record, @Param("example") TopicBadTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int updateByPrimaryKeySelective(TopicBadTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_bad_tag
     *
     * @mbggenerated Fri Sep 01 18:23:30 CST 2017
     */
    int updateByPrimaryKey(TopicBadTag record);
}