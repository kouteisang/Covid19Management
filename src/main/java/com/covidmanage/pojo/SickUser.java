package com.covidmanage.pojo;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class SickUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.identity_id
     *
     * @mbg.generated
     */
    private String identityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.sick_reason
     *
     * @mbg.generated
     */
    private String sickReason;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.when_sick
     *
     * @mbg.generated
     */
    private String whenSick;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.if_favour
     *
     * @mbg.generated
     */
    private String ifFavour;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.body_temperature
     *
     * @mbg.generated
     */
    private Double bodyTemperature;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sick_user.covid_test
     *
     * @mbg.generated
     */
    private String covidTest;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.id
     *
     * @return the value of sick_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.id
     *
     * @param id the value for sick_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.identity_id
     *
     * @return the value of sick_user.identity_id
     *
     * @mbg.generated
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.identity_id
     *
     * @param identityId the value for sick_user.identity_id
     *
     * @mbg.generated
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.sick_reason
     *
     * @return the value of sick_user.sick_reason
     *
     * @mbg.generated
     */
    public String getSickReason() {
        return sickReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.sick_reason
     *
     * @param sickReason the value for sick_user.sick_reason
     *
     * @mbg.generated
     */
    public void setSickReason(String sickReason) {
        this.sickReason = sickReason == null ? null : sickReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.when_sick
     *
     * @return the value of sick_user.when_sick
     *
     * @mbg.generated
     */
    public String getWhenSick() {
        return whenSick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.when_sick
     *
     * @param whenSick the value for sick_user.when_sick
     *
     * @mbg.generated
     */
    public void setWhenSick(String whenSick) {
        this.whenSick = whenSick == null ? null : whenSick.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.if_favour
     *
     * @return the value of sick_user.if_favour
     *
     * @mbg.generated
     */
    public String getIfFavour() {
        return ifFavour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.if_favour
     *
     * @param ifFavour the value for sick_user.if_favour
     *
     * @mbg.generated
     */
    public void setIfFavour(String ifFavour) {
        this.ifFavour = ifFavour == null ? null : ifFavour.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.body_temperature
     *
     * @return the value of sick_user.body_temperature
     *
     * @mbg.generated
     */
    public Double getBodyTemperature() {
        return bodyTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.body_temperature
     *
     * @param bodyTemperature the value for sick_user.body_temperature
     *
     * @mbg.generated
     */
    public void setBodyTemperature(Double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.update_time
     *
     * @return the value of sick_user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.update_time
     *
     * @param updateTime the value for sick_user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.create_time
     *
     * @return the value of sick_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.create_time
     *
     * @param createTime the value for sick_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sick_user.covid_test
     *
     * @return the value of sick_user.covid_test
     *
     * @mbg.generated
     */
    public String getCovidTest() {
        return covidTest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sick_user.covid_test
     *
     * @param covidTest the value for sick_user.covid_test
     *
     * @mbg.generated
     */
    public void setCovidTest(String covidTest) {
        this.covidTest = covidTest == null ? null : covidTest.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
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
        sb.append(", sickReason=").append(sickReason);
        sb.append(", whenSick=").append(whenSick);
        sb.append(", ifFavour=").append(ifFavour);
        sb.append(", bodyTemperature=").append(bodyTemperature);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", covidTest=").append(covidTest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}