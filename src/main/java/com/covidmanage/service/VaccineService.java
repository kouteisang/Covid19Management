package com.covidmanage.service;

import com.covidmanage.mapper.ext.VaccineLocationMapperExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VaccineService {

    @Autowired
    private VaccineLocationMapperExt vaccineLocationMapperExt;

    public void addVaccineLocation(String hospitalName, String hospitalLocation, String hospitalTel, String type, String picUrl){
        vaccineLocationMapperExt.addVaccineLocation(hospitalName, hospitalLocation, hospitalTel, type, picUrl);
    }


}
