package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.CommunityManagerMapper;
import com.covidmanage.pojo.CommunityManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommunityManagerMapperExt extends CommunityManagerMapper {

    CommunityManager findUserByInfo(@Param("username") String username, @Param("password") String password);
}
