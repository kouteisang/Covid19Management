package com.covidmanage.mapper.ext;

import com.covidmanage.dto.AskSupplyNeed;
import com.covidmanage.mapper.SupplyNeedMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplyNeedMapperExt extends SupplyNeedMapper {

    List<AskSupplyNeed> getAskForSupplyList(@Param("supplyType") String supplyType,
                                            @Param("supplyContent") String supplyContent,
                                            @Param("isEmergency") Integer isEmergency);

}
