package com.covidmanage.utils;

import lombok.Data;

@Data
public class ResponseTemplate {

    private String code;

    private String msg;

    private Object data;

    public static ResponseTemplate success(String code, String msg){
        return resultData(code, msg, null);
    }

    public static ResponseTemplate success(Object data) {
        return resultData(ResponseCode.SUCCESS.val(), ResponseCode.SUCCESS.msg(), data);
    }

    public static ResponseTemplate success(Object data, String msg) {
        return resultData(ResponseCode.SUCCESS.val(), msg, data);
    }

    public static ResponseTemplate fail(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ResponseTemplate fail(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ResponseTemplate resultData(String code, String msg, Object data) {
        ResponseTemplate resultData = new ResponseTemplate();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

}
