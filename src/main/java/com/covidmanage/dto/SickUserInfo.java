package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SickUserInfo {
    private String realName;
    private String phone;
    private String identityId;
    private String sickReason;
    private String whenSick;
    private String ifFavour;
    private double bodyTemperature;
    private String covidTest;
    private String community;
}
