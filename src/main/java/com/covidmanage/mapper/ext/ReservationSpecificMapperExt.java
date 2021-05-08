package com.covidmanage.mapper.ext;

import com.covidmanage.dto.VaccineSpevificDTO;
import com.covidmanage.mapper.ReservationSpecificMapper;
import com.covidmanage.pojo.ReservationSpecific;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ReservationSpecificMapperExt extends ReservationSpecificMapper {
    String getLatestUpdateTime(@Param("identityId") String identityId);

    void updateDeleteByIdentityId(@Param("identityId") String identityId,
                                  @Param("id") String id);
    List<ReservationSpecific> getVaccineSpecificByIdentityId(@Param("identityId") String identityId);
}
