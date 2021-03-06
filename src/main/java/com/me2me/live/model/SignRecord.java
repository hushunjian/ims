package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class SignRecord  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_record.id
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_record.uid
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_record.image
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sign_record.create_time
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_record.id
     *
     * @return the value of sign_record.id
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_record.id
     *
     * @param id the value for sign_record.id
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_record.uid
     *
     * @return the value of sign_record.uid
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_record.uid
     *
     * @param uid the value for sign_record.uid
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_record.image
     *
     * @return the value of sign_record.image
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_record.image
     *
     * @param image the value for sign_record.image
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sign_record.create_time
     *
     * @return the value of sign_record.create_time
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sign_record.create_time
     *
     * @param createTime the value for sign_record.create_time
     *
     * @mbggenerated Thu Jul 20 13:53:53 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}