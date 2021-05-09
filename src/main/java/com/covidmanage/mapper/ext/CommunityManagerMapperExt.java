package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.CommunityManagerMapper;
import com.covidmanage.pojo.CommunityManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommunityManagerMapperExt extends CommunityManagerMapper {

    CommunityManager findUserByInfo(@Param("identityId") String identityId, @Param("password") String password);

    void register(@Param("identityId") String identityId,
                  @Param("password") String password,
                  @Param("username") String username,
                  @Param("picUrl") String picUrl);
}
