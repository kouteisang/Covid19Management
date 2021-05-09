package com.covidmanage.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpPositionUtil {

    public static String getIp(){
        String ipv4 = "";
        String chinaz = "http://ip.chinaz.com";

        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
            //System.out.println(inputLine.toString());		//输出http://ip.chinaz.com网页详细信息
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ipv4 = ipstr;
            System.out.println("ipstr：："+ipstr);
            System.out.println("ipv4::"+ipv4);
        }
        return ipv4;
    }

    public static String getAddress(){
        String ip = IpPositionUtil.getIp();
        String url = "https://restapi.amap.com/v3/ip?key=643d6b4d35d9b5e57cd7bea1f94f1533&type=4&ip="+ip;
        String address = HttpUtil.doGet(url, "UTF-8");
        JSONObject jsonObject = JSONObject.parseObject(address);
        String province = jsonObject.getString("province");
        String city = jsonObject.getString("city");
        return province+"-"+city;
    }
}
