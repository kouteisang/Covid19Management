package com.covidmanage.controller;

import com.covidmanage.pojo.NewsInfo;
import com.covidmanage.pojo.VerifyUser;
import com.covidmanage.service.NewsService;
import com.covidmanage.service.VerifyService;
import com.covidmanage.utils.ResponseCode;
import com.covidmanage.utils.ResponseTemplate;
import com.github.pagehelper.PageHelper;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/manager/news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private VerifyService verifyService;
    /**
     * 添加公告信息
     * @param newsTitle
     * @param newsContent
     * @return
     */
    @PostMapping("/addNews")
    public ResponseTemplate addNews(@RequestParam(value = "newsTitle", required = true) String newsTitle,
                                    @RequestParam(value = "newsContent", required = true) String newsContent,
                                    @RequestParam(value = "operator") String opeartor){
        newsTitle = newsTitle.trim();
        newsContent = newsContent.trim();
        VerifyUser userInfo = verifyService.getUserInfo(opeartor);
        if(userInfo == null){
            return ResponseTemplate.fail(ResponseCode.NO_VERIFY.val(), ResponseCode.NO_VERIFY.msg());
        }
        if(newsTitle.length() < 5 || newsTitle.equals("") || newsContent.equals("")) return ResponseTemplate.fail(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
        int i = newsService.addNews(newsTitle, newsContent);
        if(i > 0)
            return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg());
        else return ResponseTemplate.fail(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
    }

    /**
     * 得到公告列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/getNewsList")
    public ResponseTemplate getNewsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        PageHelper.startPage(page, size);
        Map<Object, Object> map = newsService.getNewsList(page, size);
        return ResponseTemplate.success(map);
    }


    /**
     * 根据id得到公告信息
     * @param id
     * @return
     */
    @GetMapping("/getNewsInfoById")
    public ResponseTemplate getNewsInfoById(@RequestParam(value = "id") Integer id){
        NewsInfo newsInfo = newsService.getNewsInfoById(id);
        return ResponseTemplate.success(newsInfo);
    }

    @PostMapping("/updateNewsInfoById")
    public ResponseTemplate updateNewsInfoById(@RequestParam(value = "id") Integer id,
                                               @RequestParam(value = "newsTitle") String newsTitle,
                                               @RequestParam(value = "newsContent") String newsContent){
        newsTitle = newsTitle.trim();
        newsContent = newsContent.trim();
        if(newsTitle.equals("") || newsContent.equals("")) return ResponseTemplate.fail(ResponseCode.ERROR.val(), ResponseCode.ERROR.msg());
        newsService.updateNewsInfoById(id, newsTitle, newsContent);
        return ResponseTemplate.success(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.val());
    }
}
