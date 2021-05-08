package com.covidmanage.service;

import com.covidmanage.dto.VaccineReservationDTO;
import com.covidmanage.enums.VaccineStatusEnum;
import com.covidmanage.enums.VaccineTypeEnum;
import com.covidmanage.mapper.ext.VaccineLocationMapperExt;
import com.covidmanage.mapper.ext.VaccineReservationMapperExt;
import com.covidmanage.pojo.CommunityUser;
import com.covidmanage.pojo.VaccineLocation;
import com.covidmanage.pojo.VaccineReservation;
import com.covidmanage.pojo.VaccineReservationExample;
import com.covidmanage.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public VaccineReservation selectByIdentityId(String identityId) {
        VaccineReservation vaccineReservation = vaccineReservationMapperExt.selectByIdentityId(identityId);
        return vaccineReservation;
    }

    public void updateReservationStatusByIdentityId(String identityId, Integer vaccineStatus, String hospitalName) {
        vaccineReservationMapperExt.updateReservationStatusByIdentityId(identityId, vaccineStatus, hospitalName);
    }

    public Map<Object, Object> getVaccineReservationList(Integer page, Integer size, String identityId, String realName, String phone) {
        PageHelper.startPage(page, size);
        List<VaccineReservation> vaccineReservationList = vaccineReservationMapperExt.getVaccineReservationList(identityId, realName, phone);
        PageInfo pageInfo = new PageInfo(vaccineReservationList);
        int total = (int) pageInfo.getTotal();
        int totalpage = (total / size) + (total%size == 0 ? 0 : 1);
        log.info("total = {}", total);
        log.info("查找成功");
        List<VaccineReservationDTO> vaccineReservationDTOList = new ArrayList<>();
        for(int i = 0; i < vaccineReservationList.size(); i ++){
            VaccineReservationDTO vaccineReservationDTO = VaccineReservationDTO.builder()
                    .id(vaccineReservationList.get(i).getId())
                    .identityId(vaccineReservationList.get(i).getIdentityId())
                    .realName(vaccineReservationList.get(i).getRealName())
                    .phone(vaccineReservationList.get(i).getPhone())
                    .picurl(vaccineReservationList.get(i).getPicurl())
                    .hospitalName(vaccineReservationList.get(i).getHospitalName())
                    .vaccineStatus(VaccineStatusEnum.getValueByKey(vaccineReservationList.get(i).getVaccineStatus()))
                    .vaccineType(VaccineTypeEnum.getValueByKey(vaccineReservationList.get(i).getVaccineType()))
                    .createTime(DateUtil.dateToString(vaccineReservationList.get(i).getCreateTime()))
                    .updateTime(DateUtil.dateToString(vaccineReservationList.get(i).getUpdateTime()))
                    .build();
            vaccineReservationDTOList.add(vaccineReservationDTO);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("list", vaccineReservationDTOList);
        map.put("total", total);
        map.put("page", page);
        map.put("size", size);
        map.put("totalPage",totalpage);
        return map;
    }

    public void updateReservationStatusFinishByIdentityId(String identityId, Integer vaccineStatus, String picUrl) {
        vaccineReservationMapperExt.updateReservationStatusFinishByIdentityId(identityId, vaccineStatus, picUrl);
    }

    public void deleteVaccineReservationByIdentityId(String identityId) {
        vaccineReservationMapperExt.deleteVaccineReservationByIdentityId(identityId);
    }

    public void updateReservationStatusCancelByIdentityId(String identityId) {
        vaccineReservationMapperExt.updateReservationStatusCancelByIdentityId(identityId);
    }

}
