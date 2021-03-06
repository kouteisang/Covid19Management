package com.covidmanage.mapper;

import com.covidmanage.pojo.VaccineReservation;
import com.covidmanage.pojo.VaccineReservationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VaccineReservationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    long countByExample(VaccineReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int deleteByExample(VaccineReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int insert(VaccineReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int insertSelective(VaccineReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    List<VaccineReservation> selectByExample(VaccineReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    VaccineReservation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VaccineReservation record, @Param("example") VaccineReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VaccineReservation record, @Param("example") VaccineReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VaccineReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vaccine_reservation
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VaccineReservation record);
}