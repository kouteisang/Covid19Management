package com.covidmanage.pojo;

import java.io.Serializable;

public class CommunityManager implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.identity_id
     *
     * @mbg.generated
     */
    private String identityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.user_role
     *
     * @mbg.generated
     */
    private Integer userRole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_manager.picUrl
     *
     * @mbg.generated
     */
    private String picurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community_manager
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.id
     *
     * @return the value of community_manager.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.id
     *
     * @param id the value for community_manager.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.identity_id
     *
     * @return the value of community_manager.identity_id
     *
     * @mbg.generated
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.identity_id
     *
     * @param identityId the value for community_manager.identity_id
     *
     * @mbg.generated
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.username
     *
     * @return the value of community_manager.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.username
     *
     * @param username the value for community_manager.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.password
     *
     * @return the value of community_manager.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.password
     *
     * @param password the value for community_manager.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.user_role
     *
     * @return the value of community_manager.user_role
     *
     * @mbg.generated
     */
    public Integer getUserRole() {
        return userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.user_role
     *
     * @param userRole the value for community_manager.user_role
     *
     * @mbg.generated
     */
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_manager.picUrl
     *
     * @return the value of community_manager.picUrl
     *
     * @mbg.generated
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_manager.picUrl
     *
     * @param picurl the value for community_manager.picUrl
     *
     * @mbg.generated
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_manager
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identityId=").append(identityId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", userRole=").append(userRole);
        sb.append(", picurl=").append(picurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}