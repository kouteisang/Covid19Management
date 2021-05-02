package com.covidmanage.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.dto.CityCovidData;
import com.covidmanage.dto.ProvinceData;
import com.covidmanage.service.CommonService;
import com.covidmanage.utils.DateUtil;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import com.sun.deploy.config.JCPConfig;
import jdk.nashorn.internal.scripts.JO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.relaxng.datatype.helpers.ParameterlessDatatypeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080")
@RestController
@RequestMapping("/covidApi")
public class CovidDataApiController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * getOverAll
     * @return
     */
    @GetMapping("/getOverAll")
    public ResponseTemplate getOverAll(){
        Map<String, Object> map = new HashMap<>();
        String url = "https://lab.isaaclin.cn/nCoV/api/overall";
        String overAllInfo = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(overAllInfo);
        System.out.println(jsonObject);
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject result = results.getJSONObject(0);
        String remark1 = result.getString("remark1");
        String remark2 = result.getString("remark2");
        String remark3 = result.getString("remark3");
        String note1 = result.getString("note1");
        String note2 = result.getString("note2");
        String note3 = result.getString("note3");
        Long updateTime = Long.parseLong(result.getString("updateTime"));
        map.put("remark1", remark1);
        map.put("remark2", remark2);
        map.put("remark3", remark3);
        map.put("note1", note1);
        map.put("note2", note2);
        map.put("note3", note3);
        map.put("updateTime", DateUtil.millisecondToString(updateTime));
        JSONObject globalStatistics = result.getJSONObject("globalStatistics");
        String currentConfirmedCount = globalStatistics.getString("currentConfirmedCount");
        String confirmedCount = globalStatistics.getString("confirmedCount");
        String curedCount = globalStatistics.getString("curedCount");
        String deadCount = globalStatistics.getString("deadCount");
        String confirmedIncr = globalStatistics.getString("confirmedIncr");
        String curedIncr = globalStatistics.getString("curedIncr");
        String deadIncr = globalStatistics.getString("deadIncr");
        String yesterdayConfirmedCountIncr = globalStatistics.getString("yesterdayConfirmedCountIncr");

        map.put("currentConfirmedCount", Long.parseLong(currentConfirmedCount));
        map.put("confirmedCount", Long.parseLong(confirmedCount));
        map.put("curedCount", Long.parseLong(curedCount));
        map.put("deadCount", Long.parseLong(deadCount));
        map.put("confirmedCountYes", Long.parseLong(confirmedCount) - Long.parseLong(confirmedIncr));
        map.put("curedCountYes", Long.parseLong(curedCount)-Long.parseLong(curedIncr));
        map.put("deadCountYes", Long.parseLong(deadCount) - Long.parseLong(deadIncr));
        map.put("now", (LocalDateTime.now().toString().split("T"))[0]);
        map.put("yesterday", (LocalDateTime.now().plusDays(-1).toString().split("T"))[0]);
        return ResponseTemplate.success(map);
    }

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
        Long updateTime = Long.parseLong(countryResult.getString("updateTime")); //1617758105936 这个地方还需要转换一下

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
        map.put("updateTime", DateUtil.millisecondToString(updateTime));
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

    @GetMapping("/getCovidDataByProvince")
    public ResponseTemplate getCovidDataByProvince(@RequestParam(value = "province") String province) throws UnsupportedEncodingException {
        String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode(province, "UTF-8");
        String provinceData = HttpUtil.doGet(url, "UTF-8");
        //得到json类型数据
        JSONObject jsonObject = JSONObject.parseObject(provinceData);
        //得到json中results数组数据
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject provinceResult = results.getJSONObject(0);
        String provinceName = provinceResult.getString("provinceName"); //省的名字
        Integer currentConfirmedCount =  Integer.parseInt(provinceResult.getString("currentConfirmedCount")); //当前确诊人数
        Integer confirmedCount =  Integer.parseInt(provinceResult.getString("confirmedCount")); //总确诊人数
        Integer suspectedCount =  Integer.parseInt(provinceResult.getString("suspectedCount")); //疑似病例
        Integer curedCount =  Integer.parseInt(provinceResult.getString("curedCount")); //治愈人数
        Integer deadCount =  Integer.parseInt(provinceResult.getString("deadCount"));  //死亡人数
        JSONArray cities = provinceResult.getJSONArray("cities");
        List<CityCovidData> list = new ArrayList<>();
        for(int i = 0; i < cities.size(); i ++){
            JSONObject cityData = cities.getJSONObject(i);
            String cityName = cityData.getString("cityName");
            Integer cityCurrentConfirmedCount = Integer.parseInt(cityData.getString("currentConfirmedCount"));
            Integer cityConfirmedCount = Integer.parseInt(cityData.getString("confirmedCount"));
            Integer citySuspectedCount = Integer.parseInt(cityData.getString("suspectedCount"));
            Integer cityCuredCount = Integer.parseInt(cityData.getString("curedCount"));
            Integer cityDeadCount = Integer.parseInt(cityData.getString("deadCount"));
            Integer cityhighDangerCount = Integer.parseInt(cityData.getString("highDangerCount"));
            Integer citymidDangerCount = Integer.parseInt(cityData.getString("midDangerCount"));
            CityCovidData cityDataInfo = CityCovidData.builder().cityName(cityName)
                    .currentConfirmedCount(cityCurrentConfirmedCount)
                    .confirmedCount(cityConfirmedCount)
                    .suspectedCount(citySuspectedCount)
                    .curedCount(cityCuredCount)
                    .deadCount(cityDeadCount)
                    .highDangerCount(cityhighDangerCount)
                    .midDangerCount(citymidDangerCount).build();
            list.add(cityDataInfo);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("provinceName", provinceName);
        map.put("currentConfirmedCount", currentConfirmedCount);
        map.put("confirmedCount", confirmedCount);
        map.put("suspectedCount", suspectedCount);
        map.put("curedCount", curedCount);
        map.put("deadCount", deadCount);
        return ResponseTemplate.success(map);
    }


    @GetMapping("/getAllProvincesCovidData")
    public ResponseTemplate getAllProvincesCovidData() throws UnsupportedEncodingException {
        List<String> provinces = commonService.getAllProvince();
        Map<Object, Object> mapConfirmed = new HashMap<>();
        Map<Object, Object> mapCurrent = new HashMap<>();
        Map<Object, Object> mapCured = new HashMap<>();
        Map<Object, Object> mapDead = new HashMap<>();
        Map<Object, Object> res = new HashMap<>();
        List<ProvinceData> listConfirmed = new ArrayList<>();
        List<ProvinceData> listCurrent = new ArrayList<>();
        List<ProvinceData> listCured = new ArrayList<>();
        List<ProvinceData> listDead = new ArrayList<>();
        if(stringRedisTemplate.opsForValue().get("listConfirmed") != null){
            for(String provinceName : provinces){
                //得到累计确诊
                String all = stringRedisTemplate.opsForValue().get(provinceName+"mapConfirmed");
                mapConfirmed.put(provinceName, Integer.valueOf(all));
                //得到目前确诊
                String now = stringRedisTemplate.opsForValue().get(provinceName+"mapCurrent");
                mapCurrent.put(provinceName, Integer.valueOf(now));
                //得到治愈人数
                String cure = stringRedisTemplate.opsForValue().get(provinceName+"mapCured");
                mapCured.put(provinceName, Integer.valueOf(cure));
                //得到死亡人数
               // log.info("provinceName = {}", provinceName);
                String dead = stringRedisTemplate.opsForValue().get(provinceName+"mapDead");
                mapDead.put(provinceName, Integer.valueOf(dead));
            }
            //得到listConfirmed
            String sConfirmed = stringRedisTemplate.opsForValue().get("listConfirmed");
            listConfirmed = JSONObject.parseArray(sConfirmed, ProvinceData.class);
            //得到listCurrent
            String sCurrent = stringRedisTemplate.opsForValue().get("listCurrent");
            listCurrent = JSONObject.parseArray(sCurrent, ProvinceData.class);
            //得到listCured
            String sCured = stringRedisTemplate.opsForValue().get("listCured");
            listCured = JSONObject.parseArray(sCured, ProvinceData.class);
            //得到listDead
            String sDead = stringRedisTemplate.opsForValue().get("listDead");
            listDead = JSONObject.parseArray(sDead, ProvinceData.class);

            res.put("listConfirmed", listConfirmed);
            res.put("listCurrent", listCurrent);
            res.put("listCured", listCured);
            res.put("listDead", listDead);
            res.put("mapConfirmed", mapConfirmed);
            res.put("mapCurrent", mapCurrent);
            res.put("mapCured", mapCured);
            res.put("mapDead", mapDead);
            return ResponseTemplate.success(res);
        }
        if(stringRedisTemplate.opsForValue().get("listConfirmed") == null){
            for(String province : provinces){
                String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode(province, "UTF-8");
                String provinceData = HttpUtil.doGet(url, "UTF-8");
                //得到json类型数据
                JSONObject jsonObject = JSONObject.parseObject(provinceData);
                //得到json中results数组数据
                JSONArray results = jsonObject.getJSONArray("results");
                JSONObject provinceResult = results.getJSONObject(0);
                String provinceName = provinceResult.getString("provinceName"); //省份名称
                Integer confirmedCount = Integer.parseInt(provinceResult.getString("confirmedCount")); //累计确诊人数
                Integer currentConfirmedCount = Integer.parseInt(provinceResult.getString("currentConfirmedCount")); //当前确诊人数
                Integer curedCount = Integer.parseInt(provinceResult.getString("curedCount")); //累计治愈人数
                Integer deadCount = Integer.parseInt(provinceResult.getString("deadCount")); //累计死亡人数
                mapConfirmed.put(provinceName, confirmedCount);
                mapCurrent.put(provinceName,currentConfirmedCount);
                mapCured.put(provinceName, curedCount);
                mapDead.put(provinceName, deadCount);
                listConfirmed.add(ProvinceData.builder().province(provinceName).count(confirmedCount).build());
                listCurrent.add(ProvinceData.builder().province(provinceName).count(currentConfirmedCount).build());
                listCured.add(ProvinceData.builder().province(provinceName).count(curedCount).build());
                listDead.add(ProvinceData.builder().province(provinceName).count(deadCount).build());
                stringRedisTemplate.opsForValue().set(provinceName+"mapConfirmed", String.valueOf(confirmedCount), 3, TimeUnit.HOURS);
                stringRedisTemplate.opsForValue().set(provinceName+"mapCurrent", String.valueOf(currentConfirmedCount), 3, TimeUnit.HOURS);
                stringRedisTemplate.opsForValue().set(provinceName+"mapCured", String.valueOf(curedCount), 3, TimeUnit.HOURS);
                stringRedisTemplate.opsForValue().set(provinceName+"mapDead", String.valueOf(deadCount), 3, TimeUnit.HOURS);
            }
            stringRedisTemplate.opsForValue().set("listConfirmed", JSON.toJSON(listConfirmed).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listCurrent", JSON.toJSON(listCurrent).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listCured", JSON.toJSON(listCured).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listDead", JSON.toJSON(listDead).toString(),3 ,TimeUnit.HOURS);
            res.put("listConfirmed", listConfirmed);
            res.put("listCurrent", listCurrent);
            res.put("listCured", listCured);
            res.put("listDead", listDead);
            res.put("mapConfirmed", mapConfirmed);
            res.put("mapCurrent", mapCurrent);
            res.put("mapCured", mapCured);
            res.put("mapDead", mapDead);
        }
        return ResponseTemplate.success(res);

    }

}
