package com.covidmanage.enums;

public enum VaccineStatusEnum {
    ZERO(0, "已预约"),
    ONE(1, "已接种第一针"),
    two(2, "已接种第二针"),
    ;
    private Integer key;
    private String value;



    public static String getValueByKey(Integer key){
        VaccineStatusEnum[] vaccineStatusEnums = VaccineStatusEnum.values();
        for (VaccineStatusEnum vaccine : vaccineStatusEnums){
            if(vaccine.key == key){
                return vaccine.value;
            }
        }
        return vaccineStatusEnums[0].value;
    }

    VaccineStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
