package com.covidmanage.mapper.ext;

import com.covidmanage.dto.ArrivalInfoDTO;
import com.covidmanage.mapper.ArriveInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArriveInfoMapperExt extends ArriveInfoMapper {

    void addArrival(@Param("identityId") String identityId,
                    @Param("departureLocation") String departureLocation,
                    @Param("arriveTime") String arriveTime);

    List<ArrivalInfoDTO> getArrivalList(@Param("identityId") String identityId,
                                        @Param("realName") String realName,
                                        @Param("phone") String phone);
}
