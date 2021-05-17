package com.covidmanage.service;

import com.covidmanage.dto.ArrivalInfoDTO;
import com.covidmanage.mapper.ext.ArriveInfoMapperExt;
import com.covidmanage.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class ArrivalService {

    @Autowired
    private ArriveInfoMapperExt arriveInfoMapperExt;

    public void addArrival(String identityId, String departureLocation, String arriveTime) {
        arriveInfoMapperExt.addArrival(identityId, departureLocation, arriveTime);
    }


    public Map<Object, Object> getArrivalList(Integer page, Integer size, String identityId, String realName, String phone) throws ParseException {
        PageHelper.startPage(page, size);
        List<ArrivalInfoDTO> arrivalList = arriveInfoMapperExt.getArrivalList(identityId, realName, phone);
        for(ArrivalInfoDTO arrivalInfoDTO : arrivalList){
            String arriveTime = arrivalInfoDTO.getArriveTime();
            Date date = DateUtil.StringToDate(arriveTime);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.add(Calendar.DATE,14);
            Date d = ca.getTime();
            String s = DateUtil.dateToString1(d);
            Calendar caNow = Calendar.getInstance();
            String nowString = DateUtil.dateToString1(caNow.getTime());
            if(nowString.compareTo(s) > 0){
                arrivalInfoDTO.setState("居家隔离已满14天");
            }else {
                arrivalInfoDTO.setState("居家隔离未满14天");
            }
        }
        PageInfo pageInfo = new PageInfo(arrivalList);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        log.info("total = {}", total);
        log.info("查找成功");
        Map<Object, Object> map = new HashMap<>();
        map.put("list", arrivalList);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }
}
