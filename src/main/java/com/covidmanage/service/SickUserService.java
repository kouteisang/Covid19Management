package com.covidmanage.service;

import com.covidmanage.dto.SickUserInfo;
import com.covidmanage.mapper.SickUserMapper;
import com.covidmanage.mapper.ext.SickUserMapperExt;
import com.covidmanage.pojo.SickUser;
import com.covidmanage.pojo.SickUserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区病情人员管理
 */
@Service
@Slf4j
public class SickUserService {

    @Autowired
    private SickUserMapperExt sickUserMapperExt;
    /**
     * 添加生病人员信息
     * @param identityId
     * @param sickReason
     * @param whenSick
     * @param ifFavour
     * @param bodyTemperature
     */
    public boolean addSickUser(String identityId, String sickReason, String whenSick, String ifFavour, Double bodyTemperature, String covidTest) {

        SickUser sickUser = SickUser.builder().
                identityId(identityId)
                .sickReason(sickReason)
                .whenSick(whenSick)
                .ifFavour(ifFavour)
                .bodyTemperature(bodyTemperature)
                .covidTest(covidTest)
                .build();
        int flag = sickUserMapperExt.insert(sickUser);
        if(flag > 0)
            return true;
        return false;
    }

    /**
     * 得到生病人员列表
     * @param page
     * @param size
     * @param realName
     * @param identityId
     * @param phone
     */
    public Map<Object, Object> getSickUserList(Integer page, Integer size, String realName, String identityId, String phone) {
        PageHelper.startPage(page, size);
        List<SickUserInfo> sickUserInfo = sickUserMapperExt.getSickUserList(realName, identityId, phone);
        PageInfo pageInfo = new PageInfo(sickUserInfo);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        Map<Object, Object> map = new HashMap<>();
        map.put("list", sickUserInfo);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage", totalpage);
        return map;
    }

    /**
     * 根据身份证号删除生病人员信息
     * @param identityId
     * @return
     */
    public boolean deleteSickUserByIdentityId(String identityId){
        SickUserInfo sickUser = sickUserMapperExt.selectSickUserByIdentityId(identityId);
        if(sickUser == null) return false;
        SickUserExample sickUserExample = new SickUserExample();
        sickUserExample.createCriteria().andIdentityIdEqualTo(identityId);
        sickUserMapperExt.deleteByExample(sickUserExample);
        return true;
    }


    /**
     * 根据身份证号修改生病人员病况
     * @param identityId
     * @param sickReason
     * @param ifFavour
     * @param bodyTemperature
     * @param covidTest
     */
    public void editSickUserInfoidentityId(String identityId, String sickReason, String ifFavour, Double bodyTemperature, String covidTest) {
        sickUserMapperExt.editSickUserInfoidentityId(identityId, sickReason, ifFavour, bodyTemperature, covidTest);
    }

    public SickUserInfo getSickUserInfoByIdentityId(String identityId) {
        SickUserInfo sickUserInfo = sickUserMapperExt.getSickUserInfoByIdentityId(identityId);
        return sickUserInfo;
    }
}
