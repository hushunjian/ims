package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class RobotQuotationRecord   implements BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column robot_quotation_record.id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column robot_quotation_record.uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column robot_quotation_record.robot_uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    private Long robotUid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column robot_quotation_record.quotation_id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    private Long quotationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column robot_quotation_record.create_time
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column robot_quotation_record.id
     *
     * @return the value of robot_quotation_record.id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column robot_quotation_record.id
     *
     * @param id the value for robot_quotation_record.id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column robot_quotation_record.uid
     *
     * @return the value of robot_quotation_record.uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column robot_quotation_record.uid
     *
     * @param uid the value for robot_quotation_record.uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column robot_quotation_record.robot_uid
     *
     * @return the value of robot_quotation_record.robot_uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public Long getRobotUid() {
        return robotUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column robot_quotation_record.robot_uid
     *
     * @param robotUid the value for robot_quotation_record.robot_uid
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public void setRobotUid(Long robotUid) {
        this.robotUid = robotUid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column robot_quotation_record.quotation_id
     *
     * @return the value of robot_quotation_record.quotation_id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public Long getQuotationId() {
        return quotationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column robot_quotation_record.quotation_id
     *
     * @param quotationId the value for robot_quotation_record.quotation_id
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column robot_quotation_record.create_time
     *
     * @return the value of robot_quotation_record.create_time
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column robot_quotation_record.create_time
     *
     * @param createTime the value for robot_quotation_record.create_time
     *
     * @mbggenerated Tue Jul 25 19:33:38 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}