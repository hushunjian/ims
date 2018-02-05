package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class TopicListed  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.topic_id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.person_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Integer personCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.review_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Integer reviewCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.read_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Integer readCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.price
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.price_RMB
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Double priceRmb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.buy_uid
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Long buyUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.buy_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Date buyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.status
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic_listed.create_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.id
     *
     * @return the value of topic_listed.id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.id
     *
     * @param id the value for topic_listed.id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.topic_id
     *
     * @return the value of topic_listed.topic_id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.topic_id
     *
     * @param topicId the value for topic_listed.topic_id
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.person_count
     *
     * @return the value of topic_listed.person_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Integer getPersonCount() {
        return personCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.person_count
     *
     * @param personCount the value for topic_listed.person_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.review_count
     *
     * @return the value of topic_listed.review_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Integer getReviewCount() {
        return reviewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.review_count
     *
     * @param reviewCount the value for topic_listed.review_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.read_count
     *
     * @return the value of topic_listed.read_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.read_count
     *
     * @param readCount the value for topic_listed.read_count
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.price
     *
     * @return the value of topic_listed.price
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.price
     *
     * @param price the value for topic_listed.price
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.price_RMB
     *
     * @return the value of topic_listed.price_RMB
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Double getPriceRmb() {
        return priceRmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.price_RMB
     *
     * @param priceRmb the value for topic_listed.price_RMB
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setPriceRmb(Double priceRmb) {
        this.priceRmb = priceRmb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.buy_uid
     *
     * @return the value of topic_listed.buy_uid
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Long getBuyUid() {
        return buyUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.buy_uid
     *
     * @param buyUid the value for topic_listed.buy_uid
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setBuyUid(Long buyUid) {
        this.buyUid = buyUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.buy_time
     *
     * @return the value of topic_listed.buy_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Date getBuyTime() {
        return buyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.buy_time
     *
     * @param buyTime the value for topic_listed.buy_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.status
     *
     * @return the value of topic_listed.status
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.status
     *
     * @param status the value for topic_listed.status
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic_listed.create_time
     *
     * @return the value of topic_listed.create_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic_listed.create_time
     *
     * @param createTime the value for topic_listed.create_time
     *
     * @mbggenerated Fri Jun 30 14:33:03 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}