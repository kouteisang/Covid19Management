package com.covidmanage.utils;

public enum ResponseCode {
    /** 成功 */
    SUCCESS("200", "成功"),

    /** 操作失败 */
    ERROR("500", "操作失败");

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
