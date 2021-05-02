package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceData {
    private String province;
    private Integer count;
}
