package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.VaccineReservationMapper;
import com.covidmanage.pojo.VaccineReservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VaccineReservationMapperExt extends VaccineReservationMapper {
    void updateReservationStatusByIdentityId(@Param("identityId") String identityId,
                                             @Param("vaccineStatus") Integer vaccineStatus,
                                             @Param("hospitalName") String hospitalName);

    VaccineReservation selectByIdentityId(@Param("identityId") String identityId);

    List<VaccineReservation> getVaccineReservationList(@Param("identityId") String identityId,
                                                       @Param("realName") String realName,
                                                       @Param("phone") String phone);

    void updateReservationStatusFinishByIdentityId(@Param("identityId") String identityId,
                                                   @Param("vaccineStatus") Integer vaccineStatus,
                                                   @Param("picUrl") String picUrl);

    void deleteVaccineReservationByIdentityId(@Param("identityId") String identityId);

    void updateReservationStatusCancelByIdentityId(@Param("identityId") String identityId);
}
