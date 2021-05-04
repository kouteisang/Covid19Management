package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.VaccineLocationMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VaccineLocationMapperExt extends VaccineLocationMapper {
    void addVaccineLocation(@Param("hospitalName") String hospitalName,
                       @Param("hospitalLocation") String hospitalLocation,
                       @Param("hospitalTel") String hospitalTel,
                       @Param("type") String type,
                       @Param("picUrl") String picUrl);
}
