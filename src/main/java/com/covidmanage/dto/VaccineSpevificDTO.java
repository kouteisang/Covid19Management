package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineSpevificDTO {
    private String content;
    private String timestamp;
}
