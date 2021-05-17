package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalInfoDTO {
    private String identityId;
    private String realName;
    private String phone;
    private String emergencyName;
    private String emergencyPhone;
    private String community;
    private String departureLocation;
    private String arriveTime;
    private String state;
}
