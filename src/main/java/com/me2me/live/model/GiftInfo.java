package com.me2me.live.model;

import java.util.Date;

import com.me2me.common.web.BaseEntity;

public class GiftInfo  implements BaseEntity{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.id
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.name
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.add_price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer addPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.image_width
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer imageWidth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.image_height
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer imageHeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.gif_image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private String gifImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.play_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer playTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.sort_number
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer sortNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.status
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gift_info.create_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.id
     *
     * @return the value of gift_info.id
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.id
     *
     * @param id the value for gift_info.id
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.name
     *
     * @return the value of gift_info.name
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.name
     *
     * @param name the value for gift_info.name
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.image
     *
     * @return the value of gift_info.image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.image
     *
     * @param image the value for gift_info.image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.price
     *
     * @return the value of gift_info.price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.price
     *
     * @param price the value for gift_info.price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.add_price
     *
     * @return the value of gift_info.add_price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getAddPrice() {
        return addPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.add_price
     *
     * @param addPrice the value for gift_info.add_price
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setAddPrice(Integer addPrice) {
        this.addPrice = addPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.image_width
     *
     * @return the value of gift_info.image_width
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getImageWidth() {
        return imageWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.image_width
     *
     * @param imageWidth the value for gift_info.image_width
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.image_height
     *
     * @return the value of gift_info.image_height
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getImageHeight() {
        return imageHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.image_height
     *
     * @param imageHeight the value for gift_info.image_height
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.gif_image
     *
     * @return the value of gift_info.gif_image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public String getGifImage() {
        return gifImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.gif_image
     *
     * @param gifImage the value for gift_info.gif_image
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setGifImage(String gifImage) {
        this.gifImage = gifImage == null ? null : gifImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.play_time
     *
     * @return the value of gift_info.play_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getPlayTime() {
        return playTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.play_time
     *
     * @param playTime the value for gift_info.play_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.sort_number
     *
     * @return the value of gift_info.sort_number
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getSortNumber() {
        return sortNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.sort_number
     *
     * @param sortNumber the value for gift_info.sort_number
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.status
     *
     * @return the value of gift_info.status
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.status
     *
     * @param status the value for gift_info.status
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gift_info.create_time
     *
     * @return the value of gift_info.create_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gift_info.create_time
     *
     * @param createTime the value for gift_info.create_time
     *
     * @mbggenerated Wed Sep 06 19:12:13 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}