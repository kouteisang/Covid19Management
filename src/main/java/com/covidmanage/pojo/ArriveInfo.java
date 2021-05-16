package com.covidmanage.pojo;

import java.io.Serializable;
import java.util.Date;

public class ArriveInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.identity_id
     *
     * @mbg.generated
     */
    private String identityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.departure_location
     *
     * @mbg.generated
     */
    private String departureLocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.arrive_time
     *
     * @mbg.generated
     */
    private String arriveTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column arrive_info.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.id
     *
     * @return the value of arrive_info.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.id
     *
     * @param id the value for arrive_info.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.identity_id
     *
     * @return the value of arrive_info.identity_id
     *
     * @mbg.generated
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.identity_id
     *
     * @param identityId the value for arrive_info.identity_id
     *
     * @mbg.generated
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.departure_location
     *
     * @return the value of arrive_info.departure_location
     *
     * @mbg.generated
     */
    public String getDepartureLocation() {
        return departureLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.departure_location
     *
     * @param departureLocation the value for arrive_info.departure_location
     *
     * @mbg.generated
     */
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation == null ? null : departureLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.arrive_time
     *
     * @return the value of arrive_info.arrive_time
     *
     * @mbg.generated
     */
    public String getArriveTime() {
        return arriveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.arrive_time
     *
     * @param arriveTime the value for arrive_info.arrive_time
     *
     * @mbg.generated
     */
    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime == null ? null : arriveTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.update_time
     *
     * @return the value of arrive_info.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.update_time
     *
     * @param updateTime the value for arrive_info.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column arrive_info.create_time
     *
     * @return the value of arrive_info.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column arrive_info.create_time
     *
     * @param createTime the value for arrive_info.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
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
        sb.append(", departureLocation=").append(departureLocation);
        sb.append(", arriveTime=").append(arriveTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}