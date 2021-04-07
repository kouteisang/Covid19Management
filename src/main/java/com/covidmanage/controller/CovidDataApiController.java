package com.covidmanage.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://10.151.60.110:8080", maxAge = 3600)
@RestController
@RequestMapping("/covidApi")
public class CovidDataApiController {

    /**
     * 根据国家名得到具体疫情实况
     * @param country
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/getCovidDataByCountry")
    public ResponseTemplate getCovidDataByCountry(@RequestParam(value = "country") String country) throws UnsupportedEncodingException {
        String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode(country, "UTF-8");
        String countryData = HttpUtil.doGet(url, "UTF-8");
        //得到json类型数据
        JSONObject jsonObject = JSONObject.parseObject(countryData);
        //得到json中results数组数据
        JSONArray results = jsonObject.getJSONArray("results");
        //得到results[0]的数据也就是具体某个country的数据
        JSONObject countryResult = results.getJSONObject(0);
        String locationId = countryResult.getString("locationId");
        String continentName = countryResult.getString("continentName");
        String continentEnglishName = countryResult.getString("continentEnglishName");
        String countryName = countryResult.getString("countryName");
        String countryEnglishName = countryResult.getString("countryEnglishName");
        String currentConfirmedCount = countryResult.getString("currentConfirmedCount");
        String confirmedCount = countryResult.getString("confirmedCount");
        String suspectedCount = countryResult.getString("suspectedCount");
        String curedCount = countryResult.getString("curedCount");
        String deadCount = countryResult.getString("deadCount");
        String updateTime = countryResult.getString("updateTime"); //1617758105936 这个地方还需要转换一下

        Map<String, String> map = new HashMap<>();
        map.put("locationId", locationId);
        map.put("continentName", continentName);
        map.put("continentEnglishName", continentEnglishName);
        map.put("countryName", countryName);
        map.put("countryEnglishName", countryEnglishName);
        map.put("currentConfirmedCount", currentConfirmedCount);
        map.put("confirmedCount", confirmedCount);
        map.put("suspectedCount", suspectedCount);
        map.put("curedCount", curedCount);
        map.put("deadCount", deadCount);
        map.put("updateTime", updateTime);
        return ResponseTemplate.success(map);
    }


    @GetMapping("/getAllSupportCities")
    public ResponseTemplate getAllSupportCities(){
        String allCities = HttpUtil.doGet("https://lab.isaaclin.cn/nCoV/api/provinceName?lang=zh", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(allCities);
        JSONArray cities = jsonObject.getJSONArray("results");
        List<String> supportCities = new ArrayList<>();
        for(int i = 0; i < cities.size(); i ++){
            if(cities.get(i).equals("上海市") || cities.get(i).equals("云南省") ||
                    cities.get(i).equals("北京市") || cities.get(i).equals("四川省") || cities.get(i).equals("宁夏回族自治区") ||
                    cities.get(i).equals("山东省") ||cities.get(i).equals("江苏省")||cities.get(i).equals("江西省")
                    ||cities.get(i).equals("河北省") ||cities.get(i).equals("河南省")|| cities.get(i).equals("浙江省")
                    ||cities.get(i).equals("黑龙江省")||cities.get(i).equals("青海省")||cities.get(i).equals("陕西省")||cities.get(i).equals("重庆市")
                    ||cities.get(i).equals("辽宁省")||cities.get(i).equals("贵州省")
                    ||cities.get(i).equals("西藏自治区") ||cities.get(i).equals("福建省")|| cities.get(i).equals("湖南省")
                    ||cities.get(i).equals("湖北省")||cities.get(i).equals("海南省")||cities.get(i).equals("山西省")
                    ||cities.get(i).equals("天津市")||cities.get(i).equals("安徽省")||cities.get(i).equals("广西壮族自治区"))
                continue;
            supportCities.add((String) cities.get(i));
        }
        return ResponseTemplate.success(supportCities);
    }
}
