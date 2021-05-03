package com.covidmanage.controller;


import com.covidmanage.dto.SickUserInfo;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.SickUserService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/manager/sick")
public class SickUserController {

    @Autowired
    private CommunityUserService communityUserService;
    @Autowired
    private SickUserService sickUserService;


    /**
     * 添加生病人员信息
     * @param identityId
     * @param sickReason
     * @param whenSick
     * @param ifFavour
     * @param bodyTemperature
     * @return
     */
    @PostMapping("/addSickUser")
    public ResponseTemplate addSickUser(@RequestParam(value = "identityId") String identityId,
                                        @RequestParam(value = "sickReason") String sickReason,
                                        @RequestParam(value = "whenSick") String whenSick,
                                        @RequestParam(value = "ifFavour") String ifFavour,
                                        @RequestParam(value = "bodyTemperature") Double bodyTemperature,
                                        @RequestParam(value = "covidTest") String covidTest){
        log.info("whenSick = {}", whenSick);
        CommunityUser communityUser = communityUserService.findUserByIndentityId(identityId);
        if(communityUser == null) return ResponseTemplate.fail(ResponseCode.NO_THIS_PERSON.val(),ResponseCode.NO_THIS_PERSON.msg());
        boolean flag = sickUserService.addSickUser(identityId, sickReason, whenSick, ifFavour, bodyTemperature, covidTest);
        if(flag) return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
        else return ResponseTemplate.success(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
    }

    /**
     * 得到生病人员列表
     * @param page
     * @param size
     * @param realName
     * @param identityId
     * @param phone
     * @return
     */
    @GetMapping("/getSickUserList")
    public ResponseTemplate getSickUserList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                            @RequestParam(value = "realName", required = false) String realName,
                                            @RequestParam(value = "identityId", required = false) String identityId,
                                            @RequestParam(value = "phone", required = false) String phone){
        PageHelper.startPage(page, size);
        Map<Object, Object> sickUserList = sickUserService.getSickUserList(page, size, realName, identityId, phone);
        return ResponseTemplate.success(sickUserList);

    }

    /**
     * 通过身份证id删除生病人员信息/人员康复
     * @param identityId
     * @return
     */
    @PostMapping("/deleteSickUserByIdentityId")
    public ResponseTemplate deleteSickUserByIdentityId(@RequestParam(value = "identityId") String identityId){
        boolean deleteSuccess = sickUserService.deleteSickUserByIdentityId(identityId);
        if(deleteSuccess)
            return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
        else return ResponseTemplate.success(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
    }

    @PostMapping("/editSickUserInfoByidentityId")
    public ResponseTemplate editSickUserInfo(@RequestParam(value = "identityId") String identityId,
                                             @RequestParam(value = "sickReason") String sickReason,
                                             @RequestParam(value = "ifFavour") String ifFavour,
                                             @RequestParam(value = "covidTest") String covidTest,
                                             @RequestParam(value = "bodyTemperature") Double bodyTemperature){
        sickUserService.editSickUserInfoidentityId(identityId, sickReason,ifFavour, bodyTemperature,covidTest);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

    @GetMapping("/getSickUserInfoByIdentityId")
    public ResponseTemplate getSickUserInfoByIdentityId(@RequestParam(value = "identityId") String identityId){
        SickUserInfo sickUserInfo = sickUserService.getSickUserInfoByIdentityId(identityId);
        Map<String, Object> map = new HashMap<>();
        map.put("sickUserInfo", sickUserInfo);
        return ResponseTemplate.success(sickUserInfo, "查找病情人员信息成功");
    }
}


