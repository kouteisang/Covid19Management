package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiskAreaDTO {
    private String grade;
    private String province;
    private String city;
    private Integer nowConfirm;
    private String date;
    private Integer confirmAdd;
    private Integer confirm;
    private String sdate;
    private Integer heal;
    private Integer dead;
}
