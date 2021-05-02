package com.covidmanage.mapper.ext;

import com.covidmanage.dto.ProvinceWithPicDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityInfoMapperExt {

    List<String> getAllProvince();

    List<String> getAllCities(@Param("province") String province);

    List<String> getAllDistricts(@Param("city") String city);

    List<ProvinceWithPicDTO> getProvinceWithPic();
}
