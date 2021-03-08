package com.covidmanage.service;

import com.covidmanage.mapper.CommunityUserMapper;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.CommunityUserExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CommunityService {

    @Autowired
    private CommunityUserMapper communityUserMapper;

    public List<CommunityUser> findUser(Integer page, Integer size, String name, String phone, String identityId) {
        PageHelper.startPage(page, size);
        CommunityUserExample communityUserExample = new CommunityUserExample();
        communityUserExample.createCriteria().andPhoneEqualTo("17852738980");
        List<CommunityUser> communityUsers = communityUserMapper.selectByExample(communityUserExample);
        return communityUsers;
    }
}
