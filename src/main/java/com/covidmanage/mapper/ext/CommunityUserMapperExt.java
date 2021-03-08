package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.CommunityUserMapper;
import com.covidmanage.pojo.CommunityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface CommunityUserMapperExt extends CommunityUserMapper {

    void addUser(@Param("communityUser") CommunityUser communityUser);

    List<CommunityUser> findUser(@Param("realName") String realName,
                                 @Param("phone") String phone,
                                 @Param("identityId") String identityId);

    CommunityUser selectByIndentityId(@Param("identityId") String identityId);
}
