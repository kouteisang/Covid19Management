package com.covidmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.covidmanage.dto.TravelInfoDTO;
import com.covidmanage.pojo.TravelInfo;
import com.covidmanage.service.TravelInfoService;
import com.covidmanage.utils.HttpUtil;
import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelInfoService travelInfoService;

    @GetMapping("/getTravelProvinceInfo")
    public ResponseTemplate getTravelProvinceInfo(){
        List<TravelInfoDTO> travelInfoDTOS = new ArrayList<>();
        List<TravelInfo> allInfos = travelInfoService.getAll();
        String url1 = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=provinceCompare";
        String s = HttpUtil.doGet(url1, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(s);
        for (TravelInfo info : allInfos){
            String province = info.getProvince();
            Integer zero = jsonObject.getJSONObject("data")
                    .getJSONObject("provinceCompare")
                    .getJSONObject(province)
                    .getInteger("zero");
            Integer confirmAdd = jsonObject.getJSONObject("data")
                    .getJSONObject("provinceCompare")
                    .getJSONObject(province)
                    .getInteger("confirmAdd");

            int score = zero * 4 + 3 * info.getA5Num() + 3 * info.getTravelScore();
            if(confirmAdd <= 5 && confirmAdd >= 0){
                score += (5-confirmAdd)*20;
            }
            TravelInfoDTO build = TravelInfoDTO.builder()
                    .score(score)
                    .info(info.getInfo())
                    .picUrl(info.getPicurl())
                    .province(province)
                    .build();
            travelInfoDTOS.add(build);
        }
        Collections.sort(travelInfoDTOS, new Comparator<TravelInfoDTO>() {
            @Override
            public int compare(TravelInfoDTO o1, TravelInfoDTO o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        List<TravelInfoDTO> top10 = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            top10.add(travelInfoDTOS.get(i));
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("top10", top10);
        return ResponseTemplate.success(map);
    }
}
