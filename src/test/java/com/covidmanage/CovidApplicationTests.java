package com.covidmanage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.controller.*;
import com.covidmanage.dto.*;
import com.covidmanage.mapper.ext.CityInfoMapperExt;
import com.covidmanage.mapper.ext.CommunityUserMapperExt;
import com.covidmanage.mapper.ext.VaccineLocationMapperExt;
import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VaccineReservation;
import com.covidmanage.service.*;
import com.covidmanage.utils.*;
import jdk.nashorn.internal.scripts.JO;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.ls.LSOutput;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@SpringBootTest
class CovidApplicationTests {

    @Autowired
    private LoginService loginService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private CommunityUserService communityUserService;
    @Autowired
    private CommunityUserMapperExt communityUserMapperExt;
    @Autowired
    private CityInfoMapperExt cityInfoMapperExt;
    @Autowired
    private SickUserController sickUserController;
    @Autowired
    private NewsController newsController;
    @Autowired
    private CommonController commonController;
    @Autowired
    private SupplyController supplyController;
    @Autowired
    private SupplyService supplyService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private VaccineLocationMapperExt vaccineLocationMapperExt;
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private VacinneController vacinneController;
    @Autowired
    private ReservationSpecificService reservationSpecificService;

    @Test
    void testRedis(){
        System.out.println(redisTemplate);
        System.out.println(stringRedisTemplate);
    }

    @Test
    void contextLoads() {
       // jdbcTemplate.queryForObject("select * from community_user");
        Long ans = jdbcTemplate.queryForObject("select count(1) from community_user", Long.class);
        log.info("ans:{}", ans);

        log.info("数据源类型{}", dataSource.getClass());
    }
    @Test
    void findUserTest(){
        log.info("communityService{}", communityUserService);
        Map<Object, Object> list = communityUserService.findUser(1, 10, "黄", "17852738980", "");
        log.info("list:{}", list.size());

    }

    @Test
    void addUser(){
        communityUserService.addUser("30","黄先亮0403","13475910553","山东省","济南市",
                "历城区","万科幸福里二期8号楼1单元102","黄程","13276445572");
    }

    @Test
    void deleteUser(){
        communityUserService.deleteUserByIdentityId("372929197208016351");
        log.info("删除成功");
    }

    @Test
    void finduserByCondition(){
        CommunityUser communityUser = communityUserMapperExt.selectByIndentityId("372929199801166317");
        log.info("ans = {}", communityUser.getRealName());
    }

    @Test
    void findUserByIdentiryId(){
        CommunityUser communityUser = communityUserService.findUserByIndentityId("372929199801166317");
        System.out.println(communityUser.toString());
    }

    @Test
    void editInfoByIdentityId(){
        communityUserService.editInfoByIdentityId("6","huangXL","1",
                "1","1","1","1","1","1");
    }

    @Test
    void getAllProvince(){
        List<String> provinces = cityInfoMapperExt.getAllProvince();
        for(String province : provinces){
            System.out.println(province);
        }
    }

    @Test
    void getAllCities(){
        List<String> provinces = cityInfoMapperExt.getAllDistricts("济南市");
        for(String province : provinces){
            System.out.println(province);
        }
    }

    @Test
    void addSickUser(){
        sickUserController.addSickUser("2","感冒","2017-01-01","否",36.5, "是");
    }

    @Test
    void getUserList(){
        ResponseTemplate sickUserList = sickUserController.getSickUserList(1, 10, "", "", "");
        Object data = sickUserList.getData();
        System.out.println(data);
    }

    @Test
    void deleteSickUserByIdentityId(){
        ResponseTemplate rt = sickUserController.deleteSickUserByIdentityId("372929199801166317");
        System.out.println(rt.toString());
    }

    @Test
    void editSickUserInfoidentityId(){
        ResponseTemplate responseTemplate = sickUserController.editSickUserInfo("372929199801166317", "想睡觉", "否", "阴性", 36.6);
        System.out.println(responseTemplate.toString());
    }

    @Test
    void getSickUserInfoByIdentityId(){
        ResponseTemplate info = sickUserController.getSickUserInfoByIdentityId("372929199801166317");
        System.out.println(info.toString());
    }

    @Test
    void getNewsList(){
        ResponseTemplate newsList = newsController.getNewsList(1, 10);
        System.out.println(newsList.toString());
    }


    @Test
    void testGet() throws UnsupportedEncodingException {
        String s = HttpUtil.doGet("https://lab.isaaclin.cn/nCoV/api/area?latest=1&province="+ URLEncoder.encode("中国", "UTF-8"), "UTF-8");
       // log.info("data = {}", s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject jsonObject1 = results.getJSONObject(0);
        String curedCount = jsonObject1.getString("curedCount");
        log.info("curedCount = {}",curedCount);
       // System.out.println(jsonObject);
    }

    @Test
    void mmTotime(long time){
        //1617758105936
        String s = DateUtil.millisecondToString(1617758105936l);
        System.out.println(s);
    }

    @Test
    void getAllSupportCities(){
        String allCities = HttpUtil.doGet("https://lab.isaaclin.cn/nCoV/api/provinceName?lang=zh", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(allCities);
        JSONArray cities = jsonObject.getJSONArray("results");
        List<String> supportCities = new ArrayList<>();
        for(int i = 0; i < cities.size(); i ++){
            supportCities.add((String) cities.get(i));
        }
        System.out.println((String) cities.get(0));
    }

    @Test
    void getAllSupplyKind(){
        ResponseTemplate allSupplyKind = commonController.getAllSupplyKind();
        System.out.println(allSupplyKind);
    }

    @Test
    void getAllSupplyContent(){
        ResponseTemplate contents = commonController.getSupplyContentByKind("医疗应急物资");
        System.out.println(contents);
    }

    @Test
    void applySupply(){
        supplyController.applySupply("372929199801166317","医疗应急物资","医用防护服",1,1,"");
    }

    @Test
    void getAskForSupplyList(){
        ResponseTemplate askForSupplyList = supplyController.getAskForSupplyList(1, 10, "", "", 1);
        System.out.println(askForSupplyList);
    }

    @Test
    void getSupplyContentByAge(){
        Integer supplyContentByAge = supplyService.getSupplyCountByAge(2);
        System.out.println(supplyContentByAge);
    }

    @Test
    void getTime(){
        String day = LocalDateTime.now().plusDays(-1).toString();
        String[] ts = day.split("T");
        System.out.println(ts[0]);
    }

    @Test
    void getOverAll(){
        String url = "https://lab.isaaclin.cn/nCoV/api/overall";
        String overAllInfo = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(overAllInfo);
        System.out.println(jsonObject);
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject result = results.getJSONObject(0);
        String note = result.getString("remark1");
        JSONObject globalStatistics = result.getJSONObject("globalStatistics");
        System.out.println(globalStatistics);
        //System.out.println("globalStatistics = ", globalStatistics);
        String currentConfirmedCount = globalStatistics.getString("currentConfirmedCount");
        System.out.println(currentConfirmedCount);
    }

    @Test
    void getCovidNews(){
        String url = "https://lab.isaaclin.cn/nCoV/api/news?page=1&num=10";
        String countryData = HttpUtil.doGet(url, "UTF-8");
        //得到json类型数据
        JSONObject jsonObject = JSONObject.parseObject(countryData);
        //得到json中results数组数据
        JSONArray results = jsonObject.getJSONArray("results");
        //得到results[0]的数据也就是具体某个country的数据
        List<CovidNews> list = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            JSONObject result = results.getJSONObject(i);
            String pubDate = DateUtil.millisecondToString(Long.parseLong(result.get("pubDate").toString()));
            String title = result.get("title").toString();
            String summary = result.get("summary").toString();
            String infoSource = result.get("infoSource").toString();
            String sourceUrl = result.get("sourceUrl").toString();
            CovidNews covidNews = CovidNews.builder().id(i).
                                    pubDate(pubDate).title(title).
                                    summary(summary).infoSource(infoSource).
                                    sourceUrl(sourceUrl).build();
            list.add(covidNews);
        }
        for(CovidNews covidNew : list){
            System.out.println(covidNew.getPubDate());
        }
    }

    @Test
    void getCovidDataByProvince() throws UnsupportedEncodingException {
        String url = "https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=" + URLEncoder.encode("山东省", "UTF-8");
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
        System.out.println(cities);
       // cities.getJSONObject()
    }

    @Test
    void getPronviceData() throws UnsupportedEncodingException {
        List<String> provinces = commonService.getAllProvince();
        Map<Object, Object> map = new HashMap<>();
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
            log.info("province = {}", province);
            map.put(provinceName, confirmedCount);
        }
    }

    @Test
    void getProvinceWithPic(){
        List<ProvinceWithPicDTO> list = cityInfoMapperExt.getProvinceWithPic();
        for(ProvinceWithPicDTO provinceWithPicDTO: list){
            System.out.println(provinceWithPicDTO.toString());
        }
    }

    @Test
    void getRumors(){
        List<RumorDTO> rumors = new ArrayList<>();
        String url = "https://lab.isaaclin.cn/nCoV/api/rumors?page=" + 1;
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
    }

    @Test
    void getEncrypyUtil(){
        String code = EncryptUtil.Base64Encode("cshchcsh19981999");
        System.out.println(code);
        System.out.println(EncryptUtil.Base64Decode("Y3NoY2hjc2gxOTk4MTk5OQ=="));
    }

    @Test
    void findUserBuInfo(){
        CommunityManager huangcheng = loginService.findUserByInfo("huangcheng", "Y3NoY2hjc2gxOTk4MTk5OQ==");
        System.out.println(huangcheng);
    }

    @Test
    void getDate(){
        LocalDateTime now = LocalDateTime.now();
        String s = now.toLocalDate().toString();
        System.out.println(s);
        String ss = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=ChinaVaccineTrendData", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(ss);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray chinaVaccineTrendData = data.getJSONArray("ChinaVaccineTrendData");
        List<Integer> totalVaccinationsList = new ArrayList<>();
        List<Double> totalVaccinationsPerHundredList = new ArrayList<>();
        int len = chinaVaccineTrendData.size();
        for(int i = len-1; i >= len - 30; i --){
            JSONObject coviddata = chinaVaccineTrendData.getJSONObject(i);
            String date = coviddata.getString("date");
            Integer totalVaccinations = coviddata.getInteger("total_vaccinations");
            Double totalVaccinationsPerHundred = coviddata.getDouble("total_vaccinations_per_hundred");
            totalVaccinationsList.add(totalVaccinations);
            totalVaccinationsPerHundredList.add(totalVaccinationsPerHundred);
        }
    }

    @Test
    void insertVaccineLocation(){
        vaccineLocationMapperExt.addVaccineLocation("1","2","3","4","5");
    }

    @Test
    void getVaccineList(){
        Map<Object, Object> vaccineList = vaccineService.getVaccineList(1, 10, "", "", "");
        System.out.println(vaccineList);
    }

    @Test
    void ReservationVaccine(){
        VaccineReservation b = vaccineService.selectByIdentityId("372929199801166317");
        System.out.println(b);
    }

    @Test
    void LocalDateTime(){
        String[] now = LocalDateTime.now().toString().split("T");
        System.out.println(now[0] + " " + now[1]);
    }

//    @Test
//    void getVaccineSpecificByIdentityId(){
//        reservationSpecificService.getVaccineSpecificByIdentityId("")
//    }

    @Test
    void getLatestUpdateTime() throws UnknownHostException {

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
    }


    @Test
    void Test1(){
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
    }


    @Test
    void Test2(){
        String allCountryData = HttpUtil.doGet("https://api.inews.qq.com/newsqa/v1/automation/foreign/country/ranklist", "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(allCountryData);
        JSONArray data = jsonObject.getJSONArray("data");
        for(int i = 0; i < data.size(); i ++){
            JSONObject object = data.getJSONObject(i);
            if(object.getString("name").equals("美国")){
                System.out.println(object);
            }
           // System.out.println(object.getString("name"));
        }
    }


    @Test
    void Test3() throws UnsupportedEncodingException {
        String url1 = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=provinceCompare";
        String s = HttpUtil.doGet(url1, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.getJSONObject("data").getJSONObject("provinceCompare").getJSONObject("台湾").getInteger("nowConfirm"));
        //Integer integer = jsonObject.getJSONObject("data").getJSONObject("provinceCompare").getJSONObject("辽宁").getInteger("nowConfirm");
       // System.out.println(integer);
    }
    @Test
    void Test4() throws UnsupportedEncodingException {
        String url = "https://api.dreamreader.qq.com/news/v1/province/news/list?province_code="+"sd"+"&page_size=10";
        String s = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONObject data = jsonObject.getJSONObject("data");
        System.out.println(data);
        JSONArray items = data.getJSONArray("items");
        for(int i = 0; i < items.size() ; i ++){
            System.out.println(items.getJSONObject(i));
        }
    }

    @Test
    void Test5() throws ParseException {
        String arriveTime = "2021-05-17";
        Date date = DateUtil.StringToDate(arriveTime);
        Calendar ca = Calendar.getInstance();
        Date d = ca.getTime();
        String s = DateUtil.dateToString1(d);
        Calendar caNow = Calendar.getInstance();
        String nowString = DateUtil.dateToString1(caNow.getTime());
        System.out.println(nowString);
    }

}
