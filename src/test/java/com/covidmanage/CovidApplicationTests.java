package com.covidmanage;

import com.covidmanage.controller.NewsController;
import com.covidmanage.controller.SickUserController;
import com.covidmanage.dto.SickUserInfo;
import com.covidmanage.mapper.ext.CityInfoMapperExt;
import com.covidmanage.mapper.ext.CommunityUserMapperExt;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

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
    void testGet(){
        String s = HttpUtil.doGet("https://lab.isaaclin.cn/nCoV/api/area", "UTF-8");
        System.out.println(s);
    }
}
