package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceWithPicDTO {
    private String province;
    private String picurl;
}
