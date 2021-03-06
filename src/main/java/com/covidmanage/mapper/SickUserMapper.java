package com.covidmanage.mapper;

import com.covidmanage.pojo.SickUser;
import com.covidmanage.pojo.SickUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SickUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    long countByExample(SickUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int deleteByExample(SickUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int insert(SickUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int insertSelective(SickUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    List<SickUser> selectByExample(SickUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    SickUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SickUser record, @Param("example") SickUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SickUser record, @Param("example") SickUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SickUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sick_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SickUser record);
}