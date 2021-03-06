package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class TopicNews  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_news.id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_news.topic_id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_news.content
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_news.type
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_news.create_time
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_news.id
     *
     * @return the value of topic_news.id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_news.id
     *
     * @param id the value for topic_news.id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_news.topic_id
     *
     * @return the value of topic_news.topic_id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_news.topic_id
     *
     * @param topicId the value for topic_news.topic_id
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_news.content
     *
     * @return the value of topic_news.content
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_news.content
     *
     * @param content the value for topic_news.content
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_news.type
     *
     * @return the value of topic_news.type
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_news.type
     *
     * @param type the value for topic_news.type
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_news.create_time
     *
     * @return the value of topic_news.create_time
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_news.create_time
     *
     * @param createTime the value for topic_news.create_time
     *
     * @mbggenerated Wed Jun 07 18:12:17 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}