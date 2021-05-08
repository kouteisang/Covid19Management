package com.covidmanage.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineReservationDTO {
    private Integer id;
    private String identityId;
    private String realName;
    private String phone;
    private String hospitalName;
    private String vaccineStatus;
    private String vaccineType;
    private String picurl;
    private String createTime;
    private String updateTime;
}
