package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.service.LoginService;
import com.covidmanage.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://192.168.0.9:8080", allowCredentials = "true")
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
        password = EncryptUtil.Base64Encode(password);
        CommunityManager communityManager = loginService.findUserByInfo(identityId, password);
        Map<Object, Object> map = new HashMap<>();
        String[] now = LocalDateTime.now().toString().split("T");
        if(communityManager != null){
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
                                     @RequestParam(value = "picUrl") String picUrl){
        password = EncryptUtil.Base64Encode(password);
        loginService.register(identityId, password, username, picUrl);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
    }

}