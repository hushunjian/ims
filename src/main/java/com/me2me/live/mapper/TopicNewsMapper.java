package com.me2me.live.mapper;

import com.me2me.live.model.TopicNews;
import com.me2me.live.model.TopicNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicNewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int countByExample(TopicNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int deleteByExample(TopicNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int insert(TopicNews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int insertSelective(TopicNews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    List<TopicNews> selectByExample(TopicNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    TopicNews selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int updateByExampleSelective(@Param("record") TopicNews record, @Param("example") TopicNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int updateByExample(@Param("record") TopicNews record, @Param("example") TopicNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int updateByPrimaryKeySelective(TopicNews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic_news
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    int updateByPrimaryKey(TopicNews record);
}