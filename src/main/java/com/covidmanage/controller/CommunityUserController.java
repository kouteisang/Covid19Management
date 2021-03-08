package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CommunityUserController {

    @Autowired
    public CommunityUserService communityUserService;

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
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "identityId") String identityId){
        PageHelper.startPage(page, size);
        List<CommunityUser> commuintUser = communityUserService.findUser(page, size, name, phone, identityId);
        return ResponseTemplate.success(commuintUser);
    }

    /**
     * 添加小区用户
     * @param name
     * @param phone
     * @param province
     * @param city
     * @param district
     * @param community
     * @return
     */
    @PostMapping("/addUser")
    public ResponseTemplate addUser(@RequestParam(value = "identityId") String identityId,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "phone") String phone,
                                    @RequestParam(value = "province") String province,
                                    @RequestParam(value = "city") String city,
                                    @RequestParam(value = "district") String district,
                                    @RequestParam(value = "community") String community,
                                    @RequestParam(value = "emergencyName") String emergencyName,
                                    @RequestParam(value = "energencyPhone") String energencyPhone
                                    ){
        String location = province + "-" + city + "-" + district + "-" + community;
        communityUserService.addUser(identityId, name, phone, location, emergencyName, energencyPhone);
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


}
