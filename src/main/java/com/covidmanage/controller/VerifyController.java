package com.covidmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.covidmanage.service.PicScanService;
import com.covidmanage.utils.HttpUtilAli;
import com.covidmanage.utils.PictureToBase64Util;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    private PicScanService picScanService;

    @PostMapping("/verifyInfo")
    public ResponseTemplate verifyInfo(@RequestParam(value = "signUrl") String signUrl,
                                       @RequestParam(value = "faceUrl") String faceUrl,
                                       @RequestParam(value = "backUrl") String backUrl
                           ){
        String prefix = "/Users/huangcheng/Documents/Covid19Management/src/main/resources/static/";
        String signUrlNew = signUrl.split("/")[4];
        String faceUrlNew = faceUrl.split("/")[4];
        String backNew = backUrl.split("/")[4];
        log.info(prefix+signUrlNew);
        log.info(prefix+faceUrlNew);
        log.info(prefix+backNew);
        String name = picScanService.scanShouXie(prefix+signUrlNew);
        Map<Object, Object> face = picScanService.scanIdCardFace(prefix+faceUrlNew);
        Map<Object, Object> back = picScanService.scanIdCardBack(prefix+backNew);
        Map<Object, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("face", face);
        map.put("back", back);
        return ResponseTemplate.success(map);
    }

}
