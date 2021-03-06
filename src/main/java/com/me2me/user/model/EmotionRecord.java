package com.me2me.user.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class EmotionRecord  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.id
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.uid
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.emotionId
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Long emotionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.happyValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Integer happyvalue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.freeValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Integer freevalue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emotion_record.create_time
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.id
     *
     * @return the value of emotion_record.id
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.id
     *
     * @param id the value for emotion_record.id
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.uid
     *
     * @return the value of emotion_record.uid
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.uid
     *
     * @param uid the value for emotion_record.uid
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.emotionId
     *
     * @return the value of emotion_record.emotionId
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Long getEmotionid() {
        return emotionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.emotionId
     *
     * @param emotionid the value for emotion_record.emotionId
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setEmotionid(Long emotionid) {
        this.emotionid = emotionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.happyValue
     *
     * @return the value of emotion_record.happyValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Integer getHappyvalue() {
        return happyvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.happyValue
     *
     * @param happyvalue the value for emotion_record.happyValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setHappyvalue(Integer happyvalue) {
        this.happyvalue = happyvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.freeValue
     *
     * @return the value of emotion_record.freeValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Integer getFreevalue() {
        return freevalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.freeValue
     *
     * @param freevalue the value for emotion_record.freeValue
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setFreevalue(Integer freevalue) {
        this.freevalue = freevalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emotion_record.create_time
     *
     * @return the value of emotion_record.create_time
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emotion_record.create_time
     *
     * @param createTime the value for emotion_record.create_time
     *
     * @mbggenerated Tue May 23 14:16:14 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}