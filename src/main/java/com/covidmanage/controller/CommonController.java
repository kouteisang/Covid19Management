package com.covidmanage.controller;

import com.covidmanage.service.CommonService;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAllProvince")
    public ResponseTemplate getAllProvince(){
        List<String> provinces = commonService.getAllProvince();
        Map<String, Object> map = new HashMap<>();
        map.put("provinces",provinces);
        return ResponseTemplate.success(map);
    }
}
