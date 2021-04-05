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

    /**
     * 得到所有省份
     * @return
     */
    public List<String> getAllProvince(){
        List<String> provinces = cityInfoMapperExt.getAllProvince();
        return provinces;
    }

    /**
     * 得到所有城市
     * @param province
     * @return
     */
    public List<String> getAllCities(String province){
        List<String> cities = cityInfoMapperExt.getAllCities(province);
        return cities;
    }

    /**
     * 得到所有区域
     * @param city
     * @return
     */
    public List<String> getAllDistricts(String city){
        List<String> districts = cityInfoMapperExt.getAllDistricts(city);
        return districts;
    }

}
