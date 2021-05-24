package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.AusSpecificMapper;
import com.covidmanage.pojo.AusSpecific;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AusSpecificMapperExt extends AusSpecificMapper {
    void insertAusSpecific(@Param("username") String username,
                           @Param("identityId") String identityId,
                           @Param("info") String info);

    List<AusSpecific> getAusSpecificList(@Param("identityId") String identityId);
}
