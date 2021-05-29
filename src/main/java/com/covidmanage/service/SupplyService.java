package com.covidmanage.service;

import com.covidmanage.dto.AskSupplyNeed;
import com.covidmanage.dto.SupplyNeedDTO;
import com.covidmanage.enums.AgeEnum;
import com.covidmanage.enums.IsEmergency;
import com.covidmanage.mapper.ext.SupplyNeedMapperExt;
import com.covidmanage.pojo.SupplyNeed;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SupplyService {

    @Autowired
    private SupplyNeedMapperExt supplyNeedMapperExt;


    public int applySupply(String identityId, String supplyType, String supplyContent, Integer age, Integer isEmergency, String suggestion) {
        SupplyNeed supplyNeed = SupplyNeed.builder()
                .identityId(identityId)
                .supplyType(supplyType)
                .supplyContent(supplyContent)
                .age(age)
                .isEmergency(isEmergency)
                .suggestion(suggestion).build();
        int i = supplyNeedMapperExt.insert(supplyNeed);
        return i;
    }

    public Map<Object, Object> getAskForSupplyList(Integer page, Integer size, String supplyType, String supplyContent, Integer isEmergency) {
        PageHelper.startPage(page, size);
        List<AskSupplyNeed> askForSupplyList = supplyNeedMapperExt.getAskForSupplyList(supplyType, supplyContent, isEmergency);
        for (AskSupplyNeed asn : askForSupplyList){
            asn.setIsEmergencyValue(IsEmergency.getValueByKey(asn.getIsEmergency()));
            asn.setAgeValue(AgeEnum.getValueByType(asn.getAge()));
        }
        log.info("askForSupplyList = {}",askForSupplyList.size());
        PageInfo pageInfo = new PageInfo(askForSupplyList);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        Map<Object, Object> map = new HashMap<>();
        map.put("list", askForSupplyList);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    public String getSupplyContentByAge(Integer age) {
        String supplyContentByAge = supplyNeedMapperExt.getSupplyContentByAge(age);
        if(supplyContentByAge == null) return "暂无缺失";
        return supplyContentByAge;
    }

    public Integer getSupplyCountByAge(Integer age) {
        Integer supplyCountByAge = supplyNeedMapperExt.getSupplyCountByAge(age);
        if(supplyCountByAge == null) return 0;
        return supplyCountByAge;
    }

    public Integer getSupplyKindCountByDay(String sk, String day0) {
        Integer supplyKindCountByDay = supplyNeedMapperExt.getSupplyKindCountByDay(sk, day0);
        return supplyKindCountByDay;
    }

    public List<String> recommendBuySupply(String beginTime, String endTime) {
        List<SupplyNeedDTO> supplyNeedDTOS = supplyNeedMapperExt.recommendBuySupply(beginTime, endTime);
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(SupplyNeedDTO supplyNeedDTO : supplyNeedDTOS){
            ts.add(supplyNeedDTO.getNumber());
        }
        Iterator<Integer> iterator = ts.iterator();
        List<Integer> nums = new ArrayList<>();
        while (iterator.hasNext()){
            int number = iterator.next();
            if(nums.size() < 3){
                nums.add(number);
            }else if(nums.size() >= 3){
                break;
            }
        }
        List<String> resSupply = new ArrayList<>();
        for(int i = 0; i < supplyNeedDTOS.size(); i ++){
            if(supplyNeedDTOS.get(i).getNumber() == nums.get(0)
                    || supplyNeedDTOS.get(i).getNumber() == nums.get(Math.min(1, nums.size()))
                    || supplyNeedDTOS.get(i).getNumber() == nums.get(Math.min(2, nums.size()))){
                resSupply.add(supplyNeedDTOS.get(i).getSupplyContent());
            }
        }
        return resSupply;
    }
}
