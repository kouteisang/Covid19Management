package com.covidmanage.service;

import com.covidmanage.mapper.ext.ArriveInfoMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalService {

    @Autowired
    private ArriveInfoMapperExt arriveInfoMapperExt;

    public void addArrival(String identityId, String departureLocation, String arriveTime) {
        arriveInfoMapperExt.addArrival(identityId, departureLocation, arriveTime);
    }
}
