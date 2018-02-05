package com.me2me.activity.model;

import com.me2me.common.web.BaseEntity;

import java.util.Date;

public class UserActivity implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.uid
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.activity_id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    private Long activityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_activity.create_time
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.id
     *
     * @return the value of user_activity.id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.id
     *
     * @param id the value for user_activity.id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.uid
     *
     * @return the value of user_activity.uid
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.uid
     *
     * @param uid the value for user_activity.uid
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.activity_id
     *
     * @return the value of user_activity.activity_id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.activity_id
     *
     * @param activityId the value for user_activity.activity_id
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_activity.create_time
     *
     * @return the value of user_activity.create_time
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_activity.create_time
     *
     * @param createTime the value for user_activity.create_time
     *
     * @mbggenerated Thu May 05 11:25:15 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}