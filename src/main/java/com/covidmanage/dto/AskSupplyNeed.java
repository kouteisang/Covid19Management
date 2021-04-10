package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AskSupplyNeed  {
    private String identityId;
    private String realName;
    private String phone;
    private String community;
    private String supplyType;
    private String supplyContent;
    private Integer age;
    private String ageValue;
    private Integer isEmergency;
    private String isEmergencyValue;
    private String createTime;
    private String suggestion;
}
