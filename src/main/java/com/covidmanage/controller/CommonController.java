package com.covidmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.service.CommonService;
import com.covidmanage.service.SupplyService;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
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

    /**
     * 处理疫苗类型
     */
    @GetMapping("/dealWithVaccinetype")
    public ResponseTemplate dealWithVaccinetype(@RequestParam(value = "vaccineType") String vaccineType){
        String[] vaccineTypes = vaccineType.split(",");
        Map<Object, Object> types = new HashMap<>();
        types.put("types", vaccineTypes);
        return ResponseTemplate.success(types);
    }

    @GetMapping("/getWeatherInfo")
    public ResponseTemplate getWeatherInfo(){

        String url = "https://restapi.amap.com/v3/weather/weatherInfo?key=643d6b4d35d9b5e57cd7bea1f94f1533&city=370300&extensions=all";
        String s = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray forecasts = jsonObject.getJSONArray("forecasts");
        JSONArray casts = forecasts.getJSONObject(0).getJSONArray("casts");
        List<String> dateList = new ArrayList<>();
        List<String> dayweatherList = new ArrayList<>();
        List<String> nightweatherList = new ArrayList<>();
        List<Integer> daytempList = new ArrayList<>();
        List<Integer> nighttempList = new ArrayList<>();
        for(int i = 0; i < casts.size(); i ++){
            JSONObject object = casts.getJSONObject(i);
            String date = object.getString("date");
            dateList.add(date);
            String dayweather = object.getString("dayweather");
            dayweatherList.add(dayweather);
            String nightweather = object.getString("nightweather");
            nightweatherList.add(nightweather);
            String daytemp = object.getString("daytemp");
            daytempList.add(Integer.parseInt(daytemp));
            String nighttemp = object.getString("nighttemp");
            nighttempList.add(Integer.parseInt(nighttemp));
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("dateList",dateList);
        map.put("dayweatherList", dayweatherList);
        map.put("nightweatherList", nightweatherList);
        map.put("daytempList", daytempList);
        map.put("nighttempList", nighttempList);
        return ResponseTemplate.success(map);
    }



}
