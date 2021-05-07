package com.covidmanage.utils;

public enum ResponseCode {
    /** 成功 */
    SUCCESS("200", "成功"),

    /** 操作失败 */
    ERROR("500", "操作失败"),

    /** 小区内无此用户 */
    NO_THIS_PERSON("404","小区内无此住户，请先添加此用户！"),

    /**已经预约过 */
    ALREADY_REASERVE("405","您已经预约过疫苗注射，请先取消后再预约！");

    private ResponseCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;
}
