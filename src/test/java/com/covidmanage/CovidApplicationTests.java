package com.covidmanage;

import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class CovidApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private CommunityService communityService;
    @Test
    void contextLoads() {
       // jdbcTemplate.queryForObject("select * from community_user");
        Long ans = jdbcTemplate.queryForObject("select count(1) from community_user", Long.class);
        log.info("ans:{}", ans);

        log.info("数据源类型{}", dataSource.getClass());
    }
    @Test
    void findUserTest(){
        log.info("communityService{}", communityService);
        List<CommunityUser> list = communityService.findUser(1, 10, "黄程", "17852738980", "372929199801166317");
        log.info("list:{}", list.size());
        for(CommunityUser cu : list){
            System.out.println(cu.toString());
        }
    }

}
