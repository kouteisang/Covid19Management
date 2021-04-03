package com.covidmanage.service;

import com.covidmanage.mapper.CommunityUserMapper;
import com.covidmanage.mapper.ext.CommunityUserMapperExt;
import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.pojo.CommunityManagerExample;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.CommunityUserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Object, Object> findUser(Integer page, Integer size, String name, String phone, String identityId) {
        PageHelper.startPage(page, size);
        log.info("name = {}", name);
        log.info("phone = {}", phone);
        log.info("identityid = {}", identityId);
        List<CommunityUser> communityUsers = communityUserMapperExt.findUser(name, phone, identityId);
        PageInfo pageInfo = new PageInfo(communityUsers);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        log.info("total = {}", total);
        log.info("查找成功");
        Map<Object, Object> map = new HashMap<>();
        map.put("list", communityUsers);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    /**
     * 添加小区人员
     * @param identityId
     * @param realName
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param community
     * @param emergencyName
     * @param energencyPhone
     * @return
     */
    public boolean addUser(String identityId, String realName, String phone, String province, String city, String district, String community, String emergencyName, String energencyPhone) {
        CommunityUser cu = communityUserMapperExt.selectByIndentityId(identityId);
        if(cu != null) return false;
        CommunityUser communityUser = CommunityUser.builder().realName(realName)
                .identityId(identityId)
                .phone(phone)
                .province(province)
                .city(city)
                .district(district)
                .community(community)
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

    /**
     * 查找用户身份信息
     * @param identityId
     */
    public CommunityUser findUserByIndentityId(String identityId) {
        CommunityUser communityUser = communityUserMapperExt.selectByIndentityId(identityId);
        if(communityUser == null) return null;
        else return communityUser;
    }

    /**
     * 根据身份证号修改用户信息
     * @param identityId
     * @param realName
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param community
     * @param emergencyName
     * @param emergencyPhone
     */
    public void editInfoByIdentityId(String identityId, String realName, String phone, String province, String city,
                                     String district, String community, String emergencyName, String emergencyPhone) {
        CommunityUserExample communityUserExample = new CommunityUserExample();
        CommunityUser communityUser = CommunityUser.builder().realName(realName)
                .identityId(identityId)
                .phone(phone)
                .province(province)
                .city(city)
                .district(district)
                .community(community)
                .emergencyName(emergencyName)
                .emergencyPhone(emergencyPhone).build();
        communityUserMapperExt.editInfoByIdentityId(communityUser);
    }
}
