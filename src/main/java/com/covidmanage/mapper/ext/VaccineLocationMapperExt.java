package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.VaccineLocationMapper;
import com.covidmanage.pojo.VaccineLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VaccineLocationMapperExt extends VaccineLocationMapper {
    void addVaccineLocation(@Param("hospitalName") String hospitalName,
                       @Param("hospitalLocation") String hospitalLocation,
                       @Param("hospitalTel") String hospitalTel,
                       @Param("type") String type,
                       @Param("picUrl") String picUrl);

    List<VaccineLocation> getVaccineList(@Param("hospitalName") String hospitalName,
                                         @Param("hospitalLocation") String hospitalLocation,
                                         @Param("hostipalTel") String hostipalTel);
}
