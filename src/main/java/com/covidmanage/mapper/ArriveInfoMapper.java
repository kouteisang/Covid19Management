package com.covidmanage.mapper;

import com.covidmanage.pojo.ArriveInfo;
import com.covidmanage.pojo.ArriveInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArriveInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    long countByExample(ArriveInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int deleteByExample(ArriveInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int insert(ArriveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int insertSelective(ArriveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    List<ArriveInfo> selectByExample(ArriveInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    ArriveInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ArriveInfo record, @Param("example") ArriveInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ArriveInfo record, @Param("example") ArriveInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ArriveInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table arrive_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ArriveInfo record);
}