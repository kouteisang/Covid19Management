package com.covidmanage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.controller.CommonController;
import com.covidmanage.controller.NewsController;
import com.covidmanage.controller.SickUserController;
import com.covidmanage.controller.SupplyController;
import com.covidmanage.dto.CityCovidData;
import com.covidmanage.dto.CovidNews;
import com.covidmanage.dto.SickUserInfo;
import com.covidmanage.mapper.ext.CityInfoMapperExt;
import com.covidmanage.mapper.ext.CommunityUserMapperExt;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommonService;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.SupplyService;
import com.covidmanage.utils.DateUtil;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@SpringBootTest
class CovidApplicationTests {

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
}
