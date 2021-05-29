package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplyNeedDTO {
    private Integer number;
    private String supplyContent;
}
