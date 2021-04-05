package com.covidmanage.mapper.ext;

import com.covidmanage.dto.SickUserInfo;
import com.covidmanage.mapper.SickUserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface SickUserMapperExt extends SickUserMapper {
    List<SickUserInfo> getSickUserList(@Param("realName")String realName, @Param("identityId") String identityId, @Param("phone") String phone);
}
