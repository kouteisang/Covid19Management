package com.covidmanage.controller;

import com.covidmanage.dto.AusSpecificDTO;
import com.covidmanage.pojo.AusSpecific;
import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.service.CommunityUserService;
import com.covidmanage.service.LoginService;
import com.covidmanage.utils.*;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/manager")
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 登录相关
     * @param identityId
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseTemplate login(@RequestParam(value = "identityId") String identityId,
                                  @RequestParam(value = "password") String password,
                                  HttpServletRequest httpServletRequest){
        log.info("this is test.");
        password = EncryptUtil.Base64Encode(password);
        CommunityManager communityManager = loginService.findUserByInfo(identityId, password);
        Map<Object, Object> map = new HashMap<>();
        String[] now = LocalDateTime.now().toString().split("T");
        if(communityManager != null && communityManager.getCertificate() == 1){
            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("COMMUNITY_MANAGER", communityManager);
            map.put("communityUserInfo", communityManager);
            map.put("address", IpPositionUtil.getAddress());
            if(communityManager.getUserRole() == 1){
                map.put("role","MANAGER");
            }else if(communityManager.getUserRole() == 0){
                map.put("role", "user");
            }
            map.put("nowTime", now[0] + " "+ now[1]);
            map.put("status", 200);
        }
        else {
            map.put("status", 400);
        }
        return ResponseTemplate.success(map);
    }

    @PostMapping("/register")
    public ResponseTemplate register(@RequestParam(value = "identityId") String identityId,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "username") String username,
                                     @RequestParam(value = "picUrl") String picUrl,
                                     @RequestParam(value = "role") Integer role){
        password = EncryptUtil.Base64Encode(password);
        Map<Object, Object> map = new HashMap<>();
        if(role == 0){
            loginService.register(identityId, password, username, picUrl, 1);
            map.put("res", "普通用户角色,注册成功!");
            return ResponseTemplate.success(map);
        }else if(role == 1){
            loginService.register(identityId, password, username, picUrl, 0);
            String info = username + "发起了注册管理员权限申请。";
            loginService.insertAusSpecific(username, identityId, info);
            map.put("res", "管理员角色,注册成功，需审核后才能使用!");
            return ResponseTemplate.success(map);
        }
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

    @GetMapping("/getAus")
    public ResponseTemplate getAus(){
        Integer aus = loginService.getAus();
        Map<Object, Object> map = new HashMap<>();
        map.put("aus", aus);
        return ResponseTemplate.success(map);
    }

    @GetMapping("/getNeedAusInfo")
    public ResponseTemplate getNeedAusInfo(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "size") Integer size,
                                           @RequestParam(value = "username") String username,
                                           @RequestParam(value = "identityId") String identityId){
        PageHelper.startPage(page, size);
        Map<Object, Object> needAusInfo = loginService.getNeedAusInfo(page, size, username, identityId);

        return ResponseTemplate.success(needAusInfo);
    }

    @PostMapping("/pass")
    public ResponseTemplate pass(@RequestParam(value = "operator") String operator,
                                 @RequestParam(value = "identityId") String identityId){
        String info = operator + "审核通过";
        loginService.insertAusSpecific(operator,identityId, info);
        loginService.pass(identityId);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

    @GetMapping("/getAusSpecificList")
    public ResponseTemplate getAusSpecificList(@RequestParam(value = "identityId") String identityId){
        List<AusSpecificDTO> ausSpecificList = loginService.getAusSpecificList(identityId);
        Map<Object, Object> map = new HashMap<>();
        map.put("ausSpecificList", ausSpecificList);
        return ResponseTemplate.success(map);
    }
}