package com.covidmanage.pojo;

import java.io.Serializable;
import java.util.Date;

public class CommunityUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.identity_id
     *
     * @mbg.generated
     */
    private String identityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.location
     *
     * @mbg.generated
     */
    private String location;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.emergency_name
     *
     * @mbg.generated
     */
    private String emergencyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.emergency_phone
     *
     * @mbg.generated
     */
    private String emergencyPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column community_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.id
     *
     * @return the value of community_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.id
     *
     * @param id the value for community_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.identity_id
     *
     * @return the value of community_user.identity_id
     *
     * @mbg.generated
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.identity_id
     *
     * @param identityId the value for community_user.identity_id
     *
     * @mbg.generated
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.name
     *
     * @return the value of community_user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.name
     *
     * @param name the value for community_user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.phone
     *
     * @return the value of community_user.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.phone
     *
     * @param phone the value for community_user.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.location
     *
     * @return the value of community_user.location
     *
     * @mbg.generated
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.location
     *
     * @param location the value for community_user.location
     *
     * @mbg.generated
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.emergency_name
     *
     * @return the value of community_user.emergency_name
     *
     * @mbg.generated
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.emergency_name
     *
     * @param emergencyName the value for community_user.emergency_name
     *
     * @mbg.generated
     */
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName == null ? null : emergencyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.emergency_phone
     *
     * @return the value of community_user.emergency_phone
     *
     * @mbg.generated
     */
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.emergency_phone
     *
     * @param emergencyPhone the value for community_user.emergency_phone
     *
     * @mbg.generated
     */
    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone == null ? null : emergencyPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.update_time
     *
     * @return the value of community_user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.update_time
     *
     * @param updateTime the value for community_user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column community_user.create_time
     *
     * @return the value of community_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column community_user.create_time
     *
     * @param createTime the value for community_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community_user
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
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", location=").append(location);
        sb.append(", emergencyName=").append(emergencyName);
        sb.append(", emergencyPhone=").append(emergencyPhone);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}