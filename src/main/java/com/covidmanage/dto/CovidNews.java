package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CovidNews {
    private Integer id;
    private String pubDate;
    private String title;
    private String summary;
    public String infoSource;
    public String sourceUrl;
}
