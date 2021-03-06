package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VerifyUser;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.VerifyService;
import com.covidmanage.utils.CommonUtil;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/user")
public class CommunityUserController {

    @Autowired
    private CommunityUserService communityUserService;
    @Autowired
    private VerifyService verifyService;

    /**
     * 查找小区用户
     * @param page
     * @param size
     * @param name
     * @param phone
     * @param identityId
     * @return
     */
    @GetMapping("/findUser")
    public ResponseTemplate findUser(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                     @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                     @RequestParam(value = "phone", required = false, defaultValue = "") String phone,
                                     @RequestParam(value = "identityId", required = false, defaultValue = "") String identityId){
        PageHelper.startPage(page, size);
        Map<Object, Object> commuintUser = communityUserService.findUser(page, size, name, phone, identityId);
        return ResponseTemplate.success(commuintUser);
    }

    /**
     * 添加小区用户
     * @param realName
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param community
     * @return
     */
    @PostMapping("/addUser")
    public ResponseTemplate addUser(@RequestParam(value = "identityId") String identityId,
                                    @RequestParam(value = "realName") String realName,
                                    @RequestParam(value = "phone") String phone,
                                    @RequestParam(value = "province") String province,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "district") String district,
                                    @RequestParam(value = "community") String community,
                                    @RequestParam(value = "emergencyName") String emergencyName,
                                    @RequestParam(value = "emergencyPhone") String emergencyPhone,
                                    @RequestParam(value = "operator") String operator){
        log.info("identityId = {}", identityId);
        log.info("realName = {}", realName);
        log.info("phone = {}", phone);
        log.info("province = {}", province);
        log.info("city = {}", city);
        log.info("district = {}", district);
        log.info("community = {}", community);
        log.info("operator = {}", operator);
        VerifyUser userInfo = verifyService.getUserInfo(operator);
        if(userInfo == null){
            return ResponseTemplate.fail(ResponseCode.NO_VERIFY.val(), ResponseCode.NO_VERIFY.msg());
        }
        if(!CommonUtil.isIDNumber(identityId) || !CommonUtil.isPhoneNumber(phone) || !CommonUtil.isPhoneNumber(emergencyPhone)){
            return ResponseTemplate.fail(ResponseCode.ERROR.val(),ResponseCode.ERROR.msg());
        }
        communityUserService.addUser(identityId, realName, phone, province, city, district, community, emergencyName, emergencyPhone);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val());
    }

    /**
     * 删除小区用户
     * @param identityId
     * @return
     */
    @PostMapping("/deleteUser")
    public ResponseTemplate deleteUserByIdentityId(@RequestParam(value = "identityId") String identityId){
        boolean flag = communityUserService.deleteUserByIdentityId(identityId);
        if(flag)
            return ResponseTemplate.success(ResponseCode.SUCCESS.val());
        else return ResponseTemplate.fail(ResponseCode.ERROR.val(), null);
    }

    /**
     * 根据身份证号查找用户信息
     * @param identityId
     * @return
     */
    @GetMapping("/findUserByIndentityId")
    public ResponseTemplate findUserByIndentityId(@RequestParam(value = "identityId") String identityId){
        CommunityUser communityUserInfo = communityUserService.findUserByIndentityId(identityId);
        return ResponseTemplate.success(communityUserInfo);

    }


    /**
     * 根据身份证号修改小区住户信息
     * @param identityId
     * @param realName
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param community
     * @param emergencyName
     * @param emergencyPhone
     * @return
     */
    @PostMapping("/editInfoByIdentityId")
    public ResponseTemplate editInfoByIdentityId(@RequestParam(value = "identityId") String identityId,
                                                  @RequestParam(value = "realName") String realName,
                                                  @RequestParam(value = "phone") String phone,
                                                  @RequestParam(value = "province") String province,
                                                  @RequestParam(value = "city") String city,
                                                  @RequestParam(value = "district") String district,
                                                  @RequestParam(value = "community") String community,
                                                  @RequestParam(value = "emergencyName") String emergencyName,
                                                  @RequestParam(value = "emergencyPhone") String emergencyPhone){
        communityUserService.editInfoByIdentityId(identityId, realName, phone, province, city, district, community,emergencyName, emergencyPhone);
        return ResponseTemplate.success("更新成功");
    }

}
