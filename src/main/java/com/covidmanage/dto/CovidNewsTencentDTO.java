package com.covidmanage.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CovidNewsTencentDTO {
    private String title;
    private String publishTime;
    private String newsUrl;
    private String srcform;
    private String shortcut;
}
