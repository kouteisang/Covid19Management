package com.covidmanage.service;

import com.alibaba.fastjson.JSONObject;
import com.covidmanage.utils.HttpUtilAli;
import com.covidmanage.utils.PictureToBase64Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PicScanService {

    public String scanShouXie(String picUrl){
        String host = "https://ocrapi-shouxie.taobao.com";
        String path = "/ocrservice/shouxie";
        String method = "POST";
        String appcode = "3d62d8deea3e43a2af9bc646a83b0dfa";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String img = PictureToBase64Util.picTobase64(picUrl);
        JSONObject params = new JSONObject();
        params.put("img", img);
        params.put("prob", false);
        params.put("charInfo", false);
        params.put("rotate", false);
        params.put("table", false);
        params.put("sortPage", false);
        String bodys = params.toString();
        String content = "";
        try {
            HttpResponse response = HttpUtilAli.doPost(host, path, method, headers, querys, bodys);
            String res = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSONObject.parseObject(res);
            content = jsonObject.getString("content");
            log.info("content = {}", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public Map<Object, Object> scanIdCardFace(String picUrl){
        String host = "http://dm-51.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String appcode = "3d62d8deea3e43a2af9bc646a83b0dfa";
        String imgFile = picUrl;
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");

        Map<String, String> querys = new HashMap<String, String>();
        // 对图像进行base64编码
        String imgBase64 = PictureToBase64Util.picTobase64(imgFile);

        //configure配置
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");

        String config_str = configObj.toString();

        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        requestObj.put("image", imgBase64);
        if(configObj.size() > 0) {
            requestObj.put("configure", config_str);
        }
        String bodys = requestObj.toString();
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpResponse response = HttpUtilAli.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                return map;
            }
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSONObject.parseObject(res);
            map.put("address", res_obj.getString("address"));
            map.put("nationality", res_obj.getString("nationality"));
            map.put("identityId", res_obj.getString("num"));
            map.put("sex", res_obj.getString("sex"));
            map.put("name", res_obj.getString("name"));
            map.put("birth", res_obj.getString("birth"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<Object, Object> scanIdCardBack(String picUrl){
        String host = "http://dm-51.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String appcode = "3d62d8deea3e43a2af9bc646a83b0dfa";
        String imgFile = picUrl;
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");

        Map<String, String> querys = new HashMap<String, String>();
        // 对图像进行base64编码
        String imgBase64 = PictureToBase64Util.picTobase64(imgFile);

        //configure配置
        JSONObject configObj = new JSONObject();
        configObj.put("side", "back");

        String config_str = configObj.toString();

        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        requestObj.put("image", imgBase64);
        if(configObj.size() > 0) {
            requestObj.put("configure", config_str);
        }
        String bodys = requestObj.toString();
        Map<Object, Object> map = new HashMap<>();
        try {
            HttpResponse response = HttpUtilAli.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return map;
            }
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSONObject.parseObject(res);
            map.put("issue", res_obj.getString("issue"));
            map.put("start_date", res_obj.getString("start_date"));
            map.put("end_date", res_obj.getString("end_date"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }





}
