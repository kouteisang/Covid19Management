package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelInfoDTO {
    private String province;
    private String picUrl;
    private int score;
    private String info;
}
