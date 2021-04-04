package com.covidmanage.service;

import com.covidmanage.mapper.ext.CityInfoMapperExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class CommonService {

    @Autowired
    private CityInfoMapperExt cityInfoMapperExt;

    public List<String> getAllProvince(){
        List<String> provinces = cityInfoMapperExt.getAllProvince();
        return provinces;
    }

}
