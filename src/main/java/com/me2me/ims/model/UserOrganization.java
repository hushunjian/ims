package com.me2me.ims.model;

public class UserOrganization {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_organization.id
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_organization.organization_name
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    private String organizationName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_organization.id
     *
     * @return the value of user_organization.id
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_organization.id
     *
     * @param id the value for user_organization.id
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_organization.organization_name
     *
     * @return the value of user_organization.organization_name
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_organization.organization_name
     *
     * @param organizationName the value for user_organization.organization_name
     *
     * @mbggenerated Wed Nov 22 09:43:38 CST 2017
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }
}