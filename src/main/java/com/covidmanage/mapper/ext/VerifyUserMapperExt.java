package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.VerifyUserMapper;
import com.covidmanage.pojo.VerifyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VerifyUserMapperExt extends VerifyUserMapper {
    void addVerifyUser(@Param("name") String name,
                       @Param("address") String address,
                       @Param("nationality") String nationality,
                       @Param("identityId") String identityId,
                       @Param("sex") String sex,
                       @Param("birth") String birth,
                       @Param("issue") String issue,
                       @Param("start_date") String start_date,
                       @Param("end_date") String end_date,
                       @Param("signUrl") String signUrl,
                       @Param("faceUrl") String faceUrl,
                       @Param("backUrl") String backUrl);

    VerifyUser getUserInfo(@Param("identityId") String identityId);
}
