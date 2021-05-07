package com.covidmanage.service;

import com.covidmanage.mapper.ext.VaccineLocationMapperExt;
import com.covidmanage.mapper.ext.VaccineReservationMapperExt;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VaccineLocation;
import com.covidmanage.pojo.VaccineReservation;
import com.covidmanage.pojo.VaccineReservationExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class VaccineService {

    @Autowired
    private VaccineLocationMapperExt vaccineLocationMapperExt;
    @Autowired
    private VaccineReservationMapperExt vaccineReservationMapperExt;

    public void addVaccineLocation(String hospitalName, String hospitalLocation, String hospitalTel, String type, String picUrl){
        vaccineLocationMapperExt.addVaccineLocation(hospitalName, hospitalLocation, hospitalTel, type, picUrl);
    }


    public Map<Object, Object> getVaccineList(Integer page, Integer size, String hospitalName, String hospitalLocation, String hospitalTel) {
        PageHelper.startPage(page, size);
        log.info("hospitalName = {}", hospitalName);
        log.info("hospitalLocation = {}", hospitalLocation);
        log.info("hospitalTel = {}", hospitalTel);
        List<VaccineLocation> vaccineLocationList = vaccineLocationMapperExt.getVaccineList(hospitalName, hospitalLocation, hospitalTel);
        PageInfo pageInfo = new PageInfo(vaccineLocationList);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        log.info("total = {}", total);
        log.info("查找成功");
        Map<Object, Object> map = new HashMap<>();
        map.put("list", vaccineLocationList);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    public void reserveVaccine(String identityId, String realName, String phone, String hospitalName, Integer vaccineStatus, Integer vaccineType, String picUrl) {
        VaccineReservation vaccineReservation = VaccineReservation.builder()
                .identityId(identityId)
                .realName(realName)
                .phone(phone)
                .hospitalName(hospitalName)
                .vaccineStatus(vaccineStatus)
                .vaccineType(vaccineType)
                .picurl("")
                .build();
        vaccineReservationMapperExt.insert(vaccineReservation);
    }

    public boolean selectByIdentityId(String identityId) {
        VaccineReservationExample vaccineReservationExample = new VaccineReservationExample();
        VaccineReservationExample.Criteria criteria = vaccineReservationExample.createCriteria().andIdentityIdEqualTo(identityId);
        List<VaccineReservation> vaccineReservation = vaccineReservationMapperExt.selectByExample(vaccineReservationExample);
        if(vaccineReservation == null || vaccineReservation.size() == 0){
            return true;
        }
        return false;
    }
}
