package com.covidmanage.service;

import com.covidmanage.mapper.CommunityUserMapper;
import com.covidmanage.mapper.ext.CommunityUserMapperExt;
import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.pojo.CommunityManagerExample;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.CommunityUserExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangcheng
 * 小区人员管理
 */
@Service
@Slf4j
public class CommunityUserService {

    @Autowired
    private CommunityUserMapperExt communityUserMapperExt;

    /**
     * 根据条件查找小区人员
     * @param page
     * @param size
     * @param name
     * @param phone
     * @param identityId
     * @return
     */
    public List<CommunityUser> findUser(Integer page, Integer size, String name, String phone, String identityId) {
        PageHelper.startPage(page, size);
        log.info("name = {}", name);
        log.info("phone = {}", phone);
        log.info("identityid = {}", identityId);
        List<CommunityUser> communityUsers = communityUserMapperExt.findUser(name, phone, identityId);
        log.info("查找成功");
        return communityUsers;
    }

    /**
     * 添加小区人员
     * @param identityId
     * @param name
     * @param phone
     * @param location
     * @param emergencyName
     * @param energencyPhone
     * @return
     */
    public boolean addUser(String identityId, String name, String phone, String location, String emergencyName, String energencyPhone) {
        CommunityUser cu = communityUserMapperExt.selectByIndentityId(identityId);
        if(cu != null) return false;
        CommunityUser communityUser = CommunityUser.builder().realName(name)
                .identityId(identityId)
                .phone(phone)
                .location(location)
                .emergencyName(emergencyName)
                .emergencyPhone(energencyPhone).build();
        communityUserMapperExt.addUser(communityUser);
        return true;
    }

    /**
     * 根据身份证号删除小区用户
     * @param identityId
     */
    public boolean deleteUserByIdentityId(String identityId){
        CommunityUser communityUser = communityUserMapperExt.selectByIndentityId(identityId);
        if(communityUser == null) return false;
        CommunityUserExample communityUserExample = new CommunityUserExample();
        communityUserExample.createCriteria().andIdentityIdEqualTo(identityId);
        communityUserMapperExt.deleteByExample(communityUserExample);
        return true;
    }


}
