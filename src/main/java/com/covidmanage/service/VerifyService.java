package com.covidmanage.service;

import com.covidmanage.mapper.ext.VerifyUserMapperExt;
import com.covidmanage.pojo.VerifyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class VerifyService {
    @Autowired
    private VerifyUserMapperExt verifyUserMapperExt;

    public void addVerifyUser(String name, Map<Object, Object> face, Map<Object, Object> back, String signUrl, String faceUrl, String backUrl) {
        String address = (String)face.get("address");
        String nationality = (String)face.get("nationality");
        String identityId = (String)face.get("identityId");
        String sex = (String)face.get("sex");
        String birth = (String)face.get("birth");
        String issue = (String) back.get("issue");
        String start_date = (String) back.get("start_date");
        String end_date = (String) back.get("end_date");
        verifyUserMapperExt.addVerifyUser(name, address, nationality,
                identityId, sex, birth, issue, start_date, end_date, signUrl, faceUrl, backUrl);

    }

    public VerifyUser getUserInfo(String identityId) {
        VerifyUser userInfo = verifyUserMapperExt.getUserInfo(identityId);
        return userInfo;
    }
}
