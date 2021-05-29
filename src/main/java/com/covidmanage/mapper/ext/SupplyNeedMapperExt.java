package com.covidmanage.mapper.ext;

import com.covidmanage.dto.AskSupplyNeed;
import com.covidmanage.dto.SupplyNeedDTO;
import com.covidmanage.mapper.SupplyNeedMapper;
import com.covidmanage.pojo.SupplyNeed;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface SupplyNeedMapperExt extends SupplyNeedMapper {

    List<AskSupplyNeed> getAskForSupplyList(@Param("supplyType") String supplyType,
                                            @Param("supplyContent") String supplyContent,
                                            @Param("isEmergency") Integer isEmergency);

    String  getSupplyContentByAge(@Param("age") Integer age);

    Integer getSupplyCountByAge(@Param("age") Integer age);

    Integer getSupplyKindCountByDay(@Param("sk") String sk, @Param("day0") String day0);

    List<SupplyNeedDTO> recommendBuySupply(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
}
