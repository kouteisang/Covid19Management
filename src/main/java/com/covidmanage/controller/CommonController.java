package com.covidmanage.controller;

import com.covidmanage.service.CommonService;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://10.151.60.110:8080", maxAge = 3600)
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 得到所有省份
     * @return
     */
    @GetMapping("/getAllProvince")
    public ResponseTemplate getAllProvince(){
        List<String> provinces = commonService.getAllProvince();
        Map<String, Object> map = new HashMap<>();
        map.put("provinces",provinces);
        return ResponseTemplate.success(map);
    }

    /**
     * 得到所有城市
     * @param province
     * @return
     */
    @GetMapping("/getAllCities")
    public ResponseTemplate getAllCities(@RequestParam(value = "province", required = false, defaultValue = "") String province) throws UnsupportedEncodingException {
        province = URLDecoder.decode(province,"utf-8");
        log.info("province = {}", province);
        List<String> cities = commonService.getAllCities(province);
        Map<String, Object> map = new HashMap<>();
        map.put("cities",cities);
        return ResponseTemplate.success(map);
    }

    /**
     * 得到所有区域
     * @param city
     * @return
     */
    @GetMapping("/getAllDistricts")
    public ResponseTemplate getAllDistricts(@RequestParam(value = "city", required = false, defaultValue = "") String city){
        List<String> districts = commonService.getAllDistricts(city);
        Map<String, Object> map = new HashMap<>();
        map.put("districts", districts);
        return ResponseTemplate.success(map);
    }


    /**
     * 得到所有物资类型
     */
    @GetMapping("/getAllSupplyKind")
    public ResponseTemplate getAllSupplyKind(){
        List<String> supplyKind = commonService.getAllSupplyKind();
        return ResponseTemplate.success(supplyKind);
    }

    /**
     * 得到对应物资下的内容
     */
    @GetMapping("/getSupplyContentByKind")
    public ResponseTemplate getSupplyContentByKind(@RequestParam(value = "supplyKind") String supplyKind){
        List<String> supplyContent = commonService.getSupplyContentByKind(supplyKind);
        return ResponseTemplate.success(supplyContent);
    }


}
