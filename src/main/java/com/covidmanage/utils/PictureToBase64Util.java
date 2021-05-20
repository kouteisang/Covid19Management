package com.covidmanage.utils;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureToBase64Util {

    public static String picTobase64(String picurl){
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(picurl);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        //System.out.println(encoder.encode(data));
         return encoder.encode(data);
    }
}
