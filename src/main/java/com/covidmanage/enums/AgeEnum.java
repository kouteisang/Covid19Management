package com.covidmanage.enums;

public enum AgeEnum {
    /** 成功 */
    child(1, "7 ~ 12 岁", "儿童"),
    teenager(2, "13 ~ 19 岁", "青少年"),
    youth(3, "20 ~ 39 岁", "青年"),
    middle(4, "40 ~ 59 岁", "中年"),
    elderly(5, "> 60 岁", "老年"),
    ;
    private Integer type;
    private String value;
    private String desc;

    AgeEnum(Integer type, String value, String desc) {
        this.type = type;
        this.value = value;
        this.desc = desc;
    }

    public static String getValueByType(Integer type){
        AgeEnum[] ageEnum = AgeEnum.values();
        for (int i = 0; i < ageEnum.length; i ++){
            if(ageEnum[i].getType() == type){
                return ageEnum[i].value;
            }
        }
        return ageEnum[1].value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
