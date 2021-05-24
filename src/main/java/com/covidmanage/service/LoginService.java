package com.covidmanage.service;

import com.covidmanage.dto.AusSpecificDTO;
import com.covidmanage.mapper.ext.AusSpecificMapperExt;
import com.covidmanage.mapper.ext.CommunityManagerMapperExt;
import com.covidmanage.pojo.AusSpecific;
import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author huangcheng
 * 登录相关
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private CommunityManagerMapperExt communityManagerMapperExt;
    @Autowired
    private AusSpecificMapperExt ausSpecificMapperExt;

    public CommunityManager findUserByInfo(String identityId, String password){
        CommunityManager userInfo = communityManagerMapperExt.findUserByInfo(identityId, password);
        return userInfo;
    }

    public void register(String identityId, String password, String username, String picUrl, Integer certificate) {
        Integer user_role = 0;
        if(certificate == 0)  user_role = 1;
        if(certificate == 1) user_role = 0;
        communityManagerMapperExt.register(identityId, password, username, picUrl, certificate, user_role);
    }

    public Integer getAus() {
        return communityManagerMapperExt.getAus();
    }

    public Map<Object, Object> getNeedAusInfo(Integer page, Integer size, String username, String identityId) {
        PageHelper.startPage(page, size);
        log.info("name = {}", username);
        log.info("identityid = {}", identityId);
        List<CommunityManager> communityManagers = communityManagerMapperExt.getNeedAusInfo(username, identityId);
        PageInfo pageInfo = new PageInfo(communityManagers);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        log.info("total = {}", total);
        log.info("查找成功");
        Map<Object, Object> map = new HashMap<>();
        map.put("list", communityManagers);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    public void insertAusSpecific(String username, String identityId, String info) {
        ausSpecificMapperExt.insertAusSpecific(username, identityId, info);
    }

    public void pass(String identityId) {
        communityManagerMapperExt.pass(identityId);
    }

    public List<AusSpecificDTO> getAusSpecificList(String identityId) {
        List<AusSpecific> ausSpecificList = ausSpecificMapperExt.getAusSpecificList(identityId);
        List<AusSpecificDTO> ausSpecificDTOS = new ArrayList<>();
        for(AusSpecific as : ausSpecificList){
            AusSpecificDTO ausSpecificDTO = AusSpecificDTO.builder().info(as.getInfo()).createTime(DateUtil.dateToString(as.getCreateTime())).build();
            ausSpecificDTOS.add(ausSpecificDTO);
        }
        return ausSpecificDTOS;
    }
}
