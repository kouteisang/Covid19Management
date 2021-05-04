package com.covidmanage.config;

import com.covidmanage.pojo.CommunityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Object o) throws Exception {
//        HttpSession session = httpServletRequest.getSession(false);
//        log.info("session = {}", session);
//        if(session == null) {
//           return false;
//        }
//        CommunityManager communityManager = (CommunityManager) session.getAttribute("COMMUNITY_MANAGER");
//        log.info("communityManager = {}", communityManager);
//        if(communityManager != null){
//            return true;
//        }
//        return false;
        return true;
    }
}