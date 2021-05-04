package com.covidmanage.controller;

import com.covidmanage.pojo.CommunityManager;
import com.covidmanage.service.LoginService;
import com.covidmanage.utils.EncryptUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseTemplate login(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password,
                                  HttpServletRequest httpServletRequest){
        password = EncryptUtil.Base64Encode(password);
        CommunityManager communityManager = loginService.findUserByInfo(username, password);
        Map<Object, Object> map = new HashMap<>();
        if(communityManager != null){
            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("COMMUNITY_MANAGER", communityManager);
            map.put("COMMUNITY_MANAGER", communityManager);
            map.put("role","MANAGER");
            map.put("status", 200);
        }
        else {
            map.put("status", 400);
        }
        return ResponseTemplate.success(map);
    }

}
