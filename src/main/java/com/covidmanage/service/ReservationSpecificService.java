package com.covidmanage.service;

import com.covidmanage.dto.VaccineSpevificDTO;
import com.covidmanage.enums.VaccineStatusEnum;
import com.covidmanage.mapper.ext.ReservationSpecificMapperExt;
import com.covidmanage.pojo.ReservationSpecific;
import com.covidmanage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ReservationSpecificService {

    @Autowired
    private ReservationSpecificMapperExt reservationSpecificMapperExt;

    public void insertReservationInfo(String identityId, String realName, String hospitalName, Integer vaccineStatus, int is_deleted) {
        ReservationSpecific reservationSpecific = ReservationSpecific.builder()
                .identityId(identityId)
                .realName(realName)
                .hospitalName(hospitalName)
                .vaccineStatus(vaccineStatus)
                .isDeleted(is_deleted)
                .build();
        reservationSpecificMapperExt.insert(reservationSpecific);
    }


    public void updateDeleteByIdentityId(String identityId) {
        String id = reservationSpecificMapperExt.getLatestUpdateTime(identityId);
        reservationSpecificMapperExt.updateDeleteByIdentityId(identityId,id);
    }

    public List<VaccineSpevificDTO> getVaccineSpecificByIdentityId(String identityId) {
        List<ReservationSpecific> vaccineSpecifics = reservationSpecificMapperExt.getVaccineSpecificByIdentityId(identityId);
        List<VaccineSpevificDTO> list = new ArrayList();
        for(ReservationSpecific reservationSpecific : vaccineSpecifics){
            String content = VaccineStatusEnum.getValueByKey(reservationSpecific.getVaccineStatus());
            if(reservationSpecific.getIsDeleted() == 1){
                content = content + ",然后取消预约。";
            }
            VaccineSpevificDTO vaccineSpevificDTO = VaccineSpevificDTO.builder()
                    .timestamp(DateUtil.dateToString(reservationSpecific.getCreateTime()))
                    .content(content)
                    .build();
            list.add(vaccineSpevificDTO);
        }
        return list;
    }
}
