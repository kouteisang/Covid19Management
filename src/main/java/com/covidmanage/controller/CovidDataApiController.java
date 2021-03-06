package com.covidmanage.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.dto.*;
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
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
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

        map.put("currentConfirmedCountPercent", String.format("%.1f",100.0*(Long.parseLong(confirmedCount)*1.0)/( Long.parseLong(confirmedCount) + Long.parseLong(curedCount) +Long.parseLong(deadCount))));
        map.put("curedCountPercent", String.format("%.1f",100.0*(Long.parseLong(curedCount)*1.0)/(Long.parseLong(confirmedCount) + Long.parseLong(curedCount) +Long.parseLong(deadCount))));
        map.put("deadCountPercent", String.format("%.1f",100.0*(Long.parseLong(deadCount)*1.0)/(Long.parseLong(confirmedCount) + Long.parseLong(curedCount) +Long.parseLong(deadCount))));

        return ResponseTemplate.success(map);
    }

    /**
     * ???????????????????????????????????????
     * @param country
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/getCovidDataByCountry")
    public ResponseTemplate getCovidDataByCountry(@RequestParam(value = "country") String country) throws UnsupportedEncodingException {
        String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode(country, "UTF-8");
        String countryData = HttpUtil.doGet(url, "UTF-8");
        //??????json????????????
        JSONObject jsonObject = JSONObject.parseObject(countryData);
        //??????json???results????????????
        JSONArray results = jsonObject.getJSONArray("results");
        //??????results[0]??????????????????????????????country?????????
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
        Long updateTime = Long.parseLong(countryResult.getString("updateTime")); //1617758105936 ?????????????????????????????????

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
            if(cities.get(i).equals("?????????") || cities.get(i).equals("?????????") ||
                    cities.get(i).equals("?????????") || cities.get(i).equals("?????????") || cities.get(i).equals("?????????????????????") ||
                    cities.get(i).equals("?????????") ||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")
                    ||cities.get(i).equals("?????????") ||cities.get(i).equals("?????????")|| cities.get(i).equals("?????????")
                    ||cities.get(i).equals("????????????")||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")
                    ||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")
                    ||cities.get(i).equals("???????????????") ||cities.get(i).equals("?????????")|| cities.get(i).equals("?????????")
                    ||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")
                    ||cities.get(i).equals("?????????")||cities.get(i).equals("?????????")||cities.get(i).equals("?????????????????????"))
                continue;
            supportCities.add((String) cities.get(i));
        }
        return ResponseTemplate.success(supportCities);
    }

    @GetMapping("/getAllSupportCitiesTencent")
    public ResponseTemplate getAllSupportCitiesTencent(){

        String allCities = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=FAutoCountryConfirmAdd", "UTF-8");
        List<String> supportCities = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(allCities);
        JSONObject data = jsonObject.getJSONObject("data");
        String fAutoCountryConfirmAdd = data.getJSONObject("FAutoCountryConfirmAdd").toString();
        String all = fAutoCountryConfirmAdd.replace("{", "").replace("}", "");
        String[] allCountry = all.split(",");
        for(int i = 0; i < allCountry.length ; i++){
            String[] split = allCountry[i].split(":");
            String country = split[0].replace("\"", "");
            supportCities.add(country);
        }
        return ResponseTemplate.success(supportCities);
    }



    @GetMapping("/getCovidDataByProvince")
    public ResponseTemplate getCovidDataByProvince(@RequestParam(value = "province") String province) throws UnsupportedEncodingException {
        if(province.equals("??????") || province.equals("??????") || province.equals("??????")){
            province += '???';
        }else if (province.equals("??????")){
            province = "????????????????????????";
        } else if(province.equals("??????")){
            province = "?????????????????????";
        }else if(province.equals("??????")){
            province = "???????????????";
        }else if(province.equals("??????")){
            province = "?????????????????????";
        }else {
            province+='???';
        }
        List<String> cityNames = new ArrayList<>();
        List<Integer> confirmedCountList = new ArrayList<>();
        List<Integer> curedCountList = new ArrayList<>();
        List<Integer> deadCountList = new ArrayList<>();
        String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode(province, "UTF-8");
        String provinceData = HttpUtil.doGet(url, "UTF-8");
        //??????json????????????
        JSONObject jsonObject = JSONObject.parseObject(provinceData);
        //??????json???results????????????
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject provinceResult = results.getJSONObject(0);
        String provinceName = provinceResult.getString("provinceName"); //????????????
        Integer currentConfirmedCount =  Integer.parseInt(provinceResult.getString("currentConfirmedCount")); //??????????????????
        Integer confirmedCount =  Integer.parseInt(provinceResult.getString("confirmedCount")); //???????????????
        Integer suspectedCount =  Integer.parseInt(provinceResult.getString("suspectedCount")); //????????????
        Integer curedCount =  Integer.parseInt(provinceResult.getString("curedCount")); //????????????
        Integer deadCount =  Integer.parseInt(provinceResult.getString("deadCount"));  //????????????
        JSONArray cities = provinceResult.getJSONArray("cities");
        List<CityCovidData> list = new ArrayList<>();
        for(int i = 0; i < cities.size(); i ++){
            JSONObject cityData = cities.getJSONObject(i);
            String cityName = cityData.getString("cityName");
            if(cityName.equals("???????????????")) continue;
            cityNames.add(cityName);
            Integer cityCurrentConfirmedCount = Integer.parseInt(cityData.getString("currentConfirmedCount"));
            Integer cityConfirmedCount = Integer.parseInt(cityData.getString("confirmedCount"));
            Integer citySuspectedCount = Integer.parseInt(cityData.getString("suspectedCount"));
            Integer cityCuredCount = Integer.parseInt(cityData.getString("curedCount"));
            Integer cityDeadCount = Integer.parseInt(cityData.getString("deadCount"));
            Integer cityhighDangerCount = Integer.parseInt(cityData.getString("highDangerCount"));
            Integer citymidDangerCount = Integer.parseInt(cityData.getString("midDangerCount"));
            confirmedCountList.add(cityConfirmedCount);
            curedCountList.add(cityCuredCount);
            deadCountList.add(cityDeadCount);
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
        map.put("cityNames", cityNames);
        map.put("confirmedCountList", confirmedCountList);
        map.put("curedCountList", curedCountList);
        map.put("deadCountList", deadCountList);
        return ResponseTemplate.success(map);
    }


    @GetMapping("/getAllProvincesCovidData")
    public ResponseTemplate getAllProvincesCovidData() throws UnsupportedEncodingException {
        List<ProvinceWithPicDTO> provinces = commonService.getProvinceWithPic();
        Map<Object, Object> mapConfirmed = new HashMap<>();
        Map<Object, Object> mapCurrent = new HashMap<>();
        Map<Object, Object> mapCured = new HashMap<>();
        Map<Object, Object> mapDead = new HashMap<>();
        Map<Object, Object> res = new HashMap<>();
        List<ProvinceData> listConfirmed = new ArrayList<>();
        List<ProvinceData> listCurrent = new ArrayList<>();
        List<ProvinceData> listCured = new ArrayList<>();
        List<ProvinceData> listDead = new ArrayList<>();
        List<ProviceCovidDataDTO> listProviceCovidDataDTO = new ArrayList<>();
        if(stringRedisTemplate.opsForValue().get("listProviceCovidDataDTO") != null){
            for(ProvinceWithPicDTO province : provinces){
                String provinceName = province.getProvince();
                //??????????????????
                String all = stringRedisTemplate.opsForValue().get(provinceName+"mapConfirmed");
                mapConfirmed.put(provinceName, Integer.valueOf(all));
                //??????????????????
                String now = stringRedisTemplate.opsForValue().get(provinceName+"mapCurrent");
                mapCurrent.put(provinceName, Integer.valueOf(now));
                //??????????????????
                String cure = stringRedisTemplate.opsForValue().get(provinceName+"mapCured");
                mapCured.put(provinceName, Integer.valueOf(cure));
                //??????????????????
               // log.info("provinceName = {}", provinceName);
                String dead = stringRedisTemplate.opsForValue().get(provinceName+"mapDead");
                mapDead.put(provinceName, Integer.valueOf(dead));
            }
            //??????listConfirmed
            String sConfirmed = stringRedisTemplate.opsForValue().get("listConfirmed");
            listConfirmed = JSONObject.parseArray(sConfirmed, ProvinceData.class);
            //??????listCurrent
            String sCurrent = stringRedisTemplate.opsForValue().get("listCurrent");
            listCurrent = JSONObject.parseArray(sCurrent, ProvinceData.class);
            //??????listCured
            String sCured = stringRedisTemplate.opsForValue().get("listCured");
            listCured = JSONObject.parseArray(sCured, ProvinceData.class);
            //??????listDead
            String sDead = stringRedisTemplate.opsForValue().get("listDead");
            listDead = JSONObject.parseArray(sDead, ProvinceData.class);
            //??????listProviceCovidDataDTO
            String slistProviceCovidDataDTO = stringRedisTemplate.opsForValue().get("listProviceCovidDataDTO");
            listProviceCovidDataDTO = JSONObject.parseArray(slistProviceCovidDataDTO, ProviceCovidDataDTO.class);

            res.put("listConfirmed", listConfirmed);
            res.put("listCurrent", listCurrent);
            res.put("listCured", listCured);
            res.put("listDead", listDead);
            res.put("mapConfirmed", mapConfirmed);
            res.put("mapCurrent", mapCurrent);
            res.put("mapCured", mapCured);
            res.put("mapDead", mapDead);
            res.put("listProviceCovidDataDTO", listProviceCovidDataDTO);
            return ResponseTemplate.success(res);
        }
        if(stringRedisTemplate.opsForValue().get("listProviceCovidDataDTO") == null){
            for(ProvinceWithPicDTO province : provinces){
                String url = "https://api.inews.qq.com/newsqa/v1/query/pubished/daily/list?province=" + URLEncoder.encode(province.getProvince(), "UTF-8");
                String provinceData = HttpUtil.doGet(url, "UTF-8");
                //??????json????????????
                JSONObject jsonObject = JSONObject.parseObject(provinceData);
                //??????json???results????????????
                JSONArray results = jsonObject.getJSONArray("data");


                JSONObject provinceResult = results.getJSONObject(results.size()-1);
                    String provinceName = provinceResult.getString("province"); //????????????
                    Integer confirmedCount = Integer.parseInt(provinceResult.getString("confirm")); //??????????????????
                    Integer curedCount = Integer.parseInt(provinceResult.getString("heal")); //??????????????????
                    Integer deadCount = Integer.parseInt(provinceResult.getString("dead")); //??????????????????
                    Integer currentConfirmedCount = confirmedCount - curedCount - deadCount; //??????????????????
                    listProviceCovidDataDTO.add(ProviceCovidDataDTO.builder()
                            .province(province.getProvince())
                            .picUrl(province.getPicurl())
                            .curedCount(curedCount)
                            .deadCount(deadCount)
                            .currentConfirmedCount(currentConfirmedCount)
                            .suspectedCount(0)
                            .confirmedCount(confirmedCount).build());
                    mapConfirmed.put(provinceName, confirmedCount);
                    mapCurrent.put(provinceName, currentConfirmedCount);
                    mapCured.put(provinceName, curedCount);
                    mapDead.put(provinceName, deadCount);
                    listConfirmed.add(ProvinceData.builder().province(provinceName).count(confirmedCount).build());
                    listCurrent.add(ProvinceData.builder().province(provinceName).count(currentConfirmedCount).build());
                    listCured.add(ProvinceData.builder().province(provinceName).count(curedCount).build());
                    listDead.add(ProvinceData.builder().province(provinceName).count(deadCount).build());
                    stringRedisTemplate.opsForValue().set(provinceName + "mapConfirmed", String.valueOf(confirmedCount), 3, TimeUnit.HOURS);
                    stringRedisTemplate.opsForValue().set(provinceName + "mapCurrent", String.valueOf(currentConfirmedCount), 3, TimeUnit.HOURS);
                    stringRedisTemplate.opsForValue().set(provinceName + "mapCured", String.valueOf(curedCount), 3, TimeUnit.HOURS);
                    stringRedisTemplate.opsForValue().set(provinceName + "mapDead", String.valueOf(deadCount), 3, TimeUnit.HOURS);
            }
            stringRedisTemplate.opsForValue().set("listConfirmed", JSON.toJSON(listConfirmed).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listCurrent", JSON.toJSON(listCurrent).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listCured", JSON.toJSON(listCured).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listDead", JSON.toJSON(listDead).toString(),3 ,TimeUnit.HOURS);
            stringRedisTemplate.opsForValue().set("listProviceCovidDataDTO", JSON.toJSON(listProviceCovidDataDTO).toString(),3 ,TimeUnit.HOURS);

            res.put("listConfirmed", listConfirmed);
            res.put("listCurrent", listCurrent);
            res.put("listCured", listCured);
            res.put("listDead", listDead);
            res.put("mapConfirmed", mapConfirmed);
            res.put("mapCurrent", mapCurrent);
            res.put("mapCured", mapCured);
            res.put("mapDead", mapDead);
            res.put("listProviceCovidDataDTO", listProviceCovidDataDTO);
        }
        return ResponseTemplate.success(res);

    }

    @GetMapping("/getCovidRumors")
    public ResponseTemplate getCovidRumors(@RequestParam(value = "page") Integer page){
        List<RumorDTO> rumors = new ArrayList<>();
        String url = "https://lab.isaaclin.cn/nCoV/api/rumors?page=" + page;
        String rumorString = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(rumorString);
        JSONArray results = jsonObject.getJSONArray("results");
        for(int i = 0; i < 10; i ++){
            JSONObject result = results.getJSONObject(i);
            String mainSummary = result.getString("mainSummary");
            String title = result.getString("title");
            String body = result.getString("body");
            RumorDTO rumor = RumorDTO.builder()
                    .mainSummary(mainSummary)
                    .title(title)
                    .body(body).build();
            rumors.add(rumor);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("rumors", rumors);
        return ResponseTemplate.success(map);
    }

    /**
     * ???????????????????????????????????????
     * @param country
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/getCovidDataByCountryTencent")
    public ResponseTemplate getCovidDataByCountryTencent(@RequestParam(value = "country") String country) throws UnsupportedEncodingException {
        String allCountryData = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/foreign/country/ranklist", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(allCountryData);
        JSONArray data = jsonObject.getJSONArray("data");
        Map<Object, Object> map = new HashMap<>();
        for(int i = 0; i < data.size(); i ++){
            JSONObject object = data.getJSONObject(i);
            if(object.getString("name").equals(country)){
                map.put("confirmedCount", object.getInteger("confirm"));
                map.put("suspectedCount", object.getInteger("suspect"));
                map.put("deadCount", object.getInteger("dead"));
                map.put("curedCount", object.getInteger("heal"));
                map.put("currentConfirmedCount", object.getInteger("nowConfirm"));
                map.put("updateTime", object.getString("y")+"."+object.getString("date"));
                map.put("confirmedCountYes", object.getInteger("confirm") - object.getInteger("confirmAdd"));
                map.put("curedCountYes", object.getInteger("heal") - object.getInteger("healCompare"));
                map.put("deadCountYes", object.getInteger("dead") - object.getInteger("deadCompare"));
                break;
            }
        }
        return ResponseTemplate.success(map);
    }


    @GetMapping("/getRiskArea")
    public ResponseTemplate getRiskArea(){
        String s = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=statisGradeCityDetail", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray statisGradeCityDetail = data.getJSONArray("statisGradeCityDetail");
        List<RiskAreaDTO> list = new ArrayList<>();
        for(int i = 0; i < statisGradeCityDetail.size(); i ++){
            JSONObject object = statisGradeCityDetail.getJSONObject(i);
            String province = object.getString("province");
            String city = object.getString("city");
            Integer nowConfirm = object.getInteger("nowConfirm");
            Integer confirmAdd = object.getInteger("confirmAdd");
            Integer confirm = object.getInteger("confirm");
            String grade = object.getString("grade");
            String sdate = object.getString("sdate");
            String date = object.getString("date");
            Integer heal = object.getInteger("heal");
            Integer dead = object.getInteger("dead");
            RiskAreaDTO riskArea = RiskAreaDTO.builder()
                    .province(province)
                    .city(city)
                    .nowConfirm(nowConfirm)
                    .confirmAdd(confirmAdd)
                    .confirm(confirm)
                    .grade(grade)
                    .sdate(sdate)
                    .date(date)
                    .heal(heal)
                    .dead(dead)
                    .build();
            list.add(riskArea);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("list", list);
        return ResponseTemplate.success(map);
    }

    @GetMapping("/getRiskSpecificInfo")
    public ResponseTemplate getRiskSpecificInfo(@RequestParam(value = "city") String city) {
        String s = HttpUtil.doGet("https://eyesight.news.qq.com/sars/riskarea", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        List<String> listArea = new ArrayList<>();
        JSONArray data = jsonObject.getJSONArray("data");
        for(int i = 0; i < data.size(); i ++){
            JSONObject riskArea = data.getJSONObject(i);
            String area = riskArea.getString("area");
            if(area.contains(city)){
                listArea.add(area);
            }
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("listArea", listArea);
        return ResponseTemplate.success(map);
    }
}
