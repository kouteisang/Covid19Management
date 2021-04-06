package com.covidmanage.mapper.ext;

import com.covidmanage.mapper.NewsInfoMapper;
import com.covidmanage.pojo.NewsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsInfoMapperExt extends NewsInfoMapper {

    List<NewsInfo> getNewsList();

    NewsInfo getNewsInfoById(@Param("id") Integer id);

    void updateNewsInfoById(@Param("id") Integer id, @Param("newsTitle") String newsTitle, @Param("newsContent") String newsContent);
}
