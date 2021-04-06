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

    SickUserInfo selectSickUserByIdentityId(@Param("identityId") String identityId);

    void editSickUserInfoidentityId(@Param("identityId") String identityId, @Param("sickReason") String sickReason,
                               @Param("ifFavour") String ifFavour, @Param("bodyTemperature") Double bodyTemperature,
                               @Param("covidTest") String covidTest);

     SickUserInfo getSickUserInfoByIdentityId(@Param("identityId") String identityId);
}
