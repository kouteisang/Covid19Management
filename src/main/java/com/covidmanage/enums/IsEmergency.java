package com.covidmanage.enums;

public enum IsEmergency {
    TRUE_EMERGENCY(1, "是"),
    FALSE_EMERGENCY(2, "否");
    private Integer key;
    private String value;



    public static String getValueByKey(Integer key){
        IsEmergency[] isEmergencies = IsEmergency.values();
        for (IsEmergency isEmergency : isEmergencies){
            if(isEmergency.key == key){
                return isEmergency.value;
            }
        }
        return isEmergencies[0].value;
    }

    IsEmergency(Integer key, String value) {
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
