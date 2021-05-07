package com.covidmanage.enums;

public enum VaccineTypeEnum {
    BEIJINGSHENGWU(1, "北京生物"),
    BEIJINGKEXING(2, "北京科兴"),
    WUHANSHENGWU(3, "武汉生物"),
            ;
    private Integer key;
    private String value;



    public static String getValueByKey(Integer key){
        VaccineTypeEnum[] vaccinetypeEnums = VaccineTypeEnum.values();
        for (VaccineTypeEnum vaccine : vaccinetypeEnums){
            if(vaccine.key == key){
                return vaccine.value;
            }
        }
        return vaccinetypeEnums[0].value;
    }

    VaccineTypeEnum(Integer key, String value) {
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
