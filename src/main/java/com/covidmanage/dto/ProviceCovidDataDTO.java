package com.covidmanage.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviceCovidDataDTO {
    private String province; //得到省份信息
    private String picUrl; //得到图片路径
    private Integer deadCount; //得到死亡人数
    private Integer curedCount; //治愈人数
    private Integer currentConfirmedCount; //得到当前确诊人数
    private Integer suspectedCount; //疑似感染人数
    private Integer confirmedCount; //得到累计确诊人数
}
