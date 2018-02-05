package com.me2me.content.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class AdInfo  implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.ad_title
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private String adTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.ad_cover
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private String adCover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.ad_cover_width
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Integer adCoverWidth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.ad_cover_height
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Integer adCoverHeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.effective_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Date effectiveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.create_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.display_probability
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Integer displayProbability;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.type
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.topic_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.ad_url
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private String adUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.banner_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Long bannerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_info.status
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.id
     *
     * @return the value of ad_info.id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.id
     *
     * @param id the value for ad_info.id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.ad_title
     *
     * @return the value of ad_info.ad_title
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public String getAdTitle() {
        return adTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.ad_title
     *
     * @param adTitle the value for ad_info.ad_title
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.ad_cover
     *
     * @return the value of ad_info.ad_cover
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public String getAdCover() {
        return adCover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.ad_cover
     *
     * @param adCover the value for ad_info.ad_cover
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setAdCover(String adCover) {
        this.adCover = adCover == null ? null : adCover.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.ad_cover_width
     *
     * @return the value of ad_info.ad_cover_width
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Integer getAdCoverWidth() {
        return adCoverWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.ad_cover_width
     *
     * @param adCoverWidth the value for ad_info.ad_cover_width
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setAdCoverWidth(Integer adCoverWidth) {
        this.adCoverWidth = adCoverWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.ad_cover_height
     *
     * @return the value of ad_info.ad_cover_height
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Integer getAdCoverHeight() {
        return adCoverHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.ad_cover_height
     *
     * @param adCoverHeight the value for ad_info.ad_cover_height
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setAdCoverHeight(Integer adCoverHeight) {
        this.adCoverHeight = adCoverHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.effective_time
     *
     * @return the value of ad_info.effective_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.effective_time
     *
     * @param effectiveTime the value for ad_info.effective_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.create_time
     *
     * @return the value of ad_info.create_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.create_time
     *
     * @param createTime the value for ad_info.create_time
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.display_probability
     *
     * @return the value of ad_info.display_probability
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Integer getDisplayProbability() {
        return displayProbability;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.display_probability
     *
     * @param displayProbability the value for ad_info.display_probability
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setDisplayProbability(Integer displayProbability) {
        this.displayProbability = displayProbability;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.type
     *
     * @return the value of ad_info.type
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.type
     *
     * @param type the value for ad_info.type
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.topic_id
     *
     * @return the value of ad_info.topic_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.topic_id
     *
     * @param topicId the value for ad_info.topic_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.ad_url
     *
     * @return the value of ad_info.ad_url
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public String getAdUrl() {
        return adUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.ad_url
     *
     * @param adUrl the value for ad_info.ad_url
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.banner_id
     *
     * @return the value of ad_info.banner_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Long getBannerId() {
        return bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.banner_id
     *
     * @param bannerId the value for ad_info.banner_id
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_info.status
     *
     * @return the value of ad_info.status
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_info.status
     *
     * @param status the value for ad_info.status
     *
     * @mbggenerated Tue Sep 19 15:49:41 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}