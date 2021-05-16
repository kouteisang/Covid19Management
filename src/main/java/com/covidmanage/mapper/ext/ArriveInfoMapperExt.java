package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.ArriveInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArriveInfoMapperExt extends ArriveInfoMapper {

    void addArrival(@Param("identityId") String identityId,
                    @Param("departureLocation") String departureLocation,
                    @Param("arriveTime") String arriveTime);
}
