package com.covidmanage.service;

import com.covidmanage.mapper.ext.CommunityManagerMapperExt;
import com.covidmanage.pojo.CommunityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author huangcheng
 * 登录相关
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private CommunityManagerMapperExt communityManagerMapperExt;

    public CommunityManager findUserByInfo(String identityId, String password){
        CommunityManager userInfo = communityManagerMapperExt.findUserByInfo(identityId, password);
        return userInfo;
    }

    public void register(String identityId, String password, String username, String picUrl) {
        communityManagerMapperExt.register(identityId, password, username, picUrl);
    }
}
