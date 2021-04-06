package com.covidmanage.service;

import com.covidmanage.mapper.ext.NewsInfoMapperExt;
import com.covidmanage.pojo.NewsInfo;
import com.covidmanage.pojo.NewsInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {

    @Autowired
    private NewsInfoMapperExt newsInfoMapperExt;

    /**
     * 添加公告
     * @param title
     * @param content
     * @return
     */
    public int addNews(String title, String content) {

        NewsInfo newsInfo = NewsInfo.builder().
                newsTitle(title).
                newsContent(content).build();
        int i = newsInfoMapperExt.insert(newsInfo);
        return i;
    }

    /**
     * 得到公告列表
     * @param page
     * @param size
     * @return
     */
    public Map<Object, Object> getNewsList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<NewsInfo> newsList = newsInfoMapperExt.getNewsList();
        PageInfo pageInfo = new PageInfo(newsList);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        Map<Object, Object> map = new HashMap<>();
        map.put("list", newsList);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    /**
     * 根据id得到newsInfo信息
     * @param id
     * @return
     */
    public NewsInfo getNewsInfoById(Integer id) {
        NewsInfo newsInfo = newsInfoMapperExt.getNewsInfoById(id);
        return newsInfo;
    }

    /**
     * 根据id修改newsInfo信息
     * @param id
     * @param newsTitle
     * @param newsContent
     */
    public void updateNewsInfoById(Integer id, String newsTitle, String newsContent) {
        newsInfoMapperExt.updateNewsInfoById(id, newsTitle, newsContent);
    }
}
