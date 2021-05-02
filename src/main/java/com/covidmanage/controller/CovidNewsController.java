package com.covidmanage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.covidmanage.dto.CovidNews;
import com.covidmanage.utils.DateUtil;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080")
@RestController
@RequestMapping("/covidnews")
public class CovidNewsController {

    @GetMapping("/getCovidNews")
    public ResponseTemplate getCovidNews(@RequestParam(value = "page") Integer page){
        String url = "https://lab.isaaclin.cn/nCoV/api/news?page=" + page;
        String countryData = HttpUtil.doGet(url, "UTF-8");
        //得到json类型数据
        JSONObject jsonObject = JSONObject.parseObject(countryData);
        //得到json中results数组数据
        JSONArray results = jsonObject.getJSONArray("results");
        //得到results[0]的数据也就是具体某个country的数据
        List<CovidNews> list = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            JSONObject result = results.getJSONObject(i);
            String pubDate = DateUtil.millisecondToString(Long.parseLong(result.get("pubDate").toString()));
            String title = result.get("title").toString();
            String summary = result.get("summary").toString();
            String infoSource = result.get("infoSource").toString();
            String sourceUrl = result.get("sourceUrl").toString();
            CovidNews covidNews = CovidNews.builder().id(i).
                    pubDate(pubDate).title(title).
                    summary(summary).infoSource(infoSource).
                    sourceUrl(sourceUrl).build();
            list.add(covidNews);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return ResponseTemplate.success(map);
    }
}
