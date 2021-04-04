package com.covidmanage.mapper.ext;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityInfoMapperExt {

    List<String> getAllProvince();

    List<String> getAllCities(@Param("province") String province);

    List<String> getAllDistricts(@Param("city") String city);
}
