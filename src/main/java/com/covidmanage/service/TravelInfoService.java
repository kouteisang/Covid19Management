package com.covidmanage.service;

import com.covidmanage.mapper.TravelInfoMapper;
import com.covidmanage.mapper.ext.TravelInfoMapperExt;
import com.covidmanage.pojo.TravelInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TravelInfoService {

    @Autowired
    private TravelInfoMapperExt travelInfoMapperExt;

    public List<TravelInfo> getAll() {
        List<TravelInfo> all = travelInfoMapperExt.getAll();
        return all;
    }
}
