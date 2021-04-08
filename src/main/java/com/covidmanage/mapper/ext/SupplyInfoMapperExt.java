package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.SupplyInfoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplyInfoMapperExt extends SupplyInfoMapper {

    List<String> getAllSupplyKind();

    List<String> getSupplyContentByKind(@Param("supplyKind") String supplyKind);
}
