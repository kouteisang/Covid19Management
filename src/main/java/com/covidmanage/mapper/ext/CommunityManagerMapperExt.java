package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.CommunityManagerMapper;
import com.covidmanage.pojo.CommunityManager;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityManagerMapperExt extends CommunityManagerMapper {

    CommunityManager findUserByInfo(@Param("identityId") String identityId, @Param("password") String password);

    void register(@Param("identityId") String identityId,
                  @Param("password") String password,
                  @Param("username") String username,
                  @Param("picUrl") String picUrl,
                  @Param("certificate") Integer certificate,
                  @Param("userRole") Integer userRole);

    Integer getAus();

    List<CommunityManager> getNeedAusInfo(@Param("username") String username,
                                          @Param("identityId") String identityId);

    void pass(@Param("identityId") String identityId);
}
