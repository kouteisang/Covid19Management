package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.TravelInfoMapper;
import com.covidmanage.pojo.TravelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelInfoMapperExt extends TravelInfoMapper {
    List<TravelInfo> getAll();
}
