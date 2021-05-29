package com.covidmanage.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public static String returnFirstLetter(String province){
        if(province.equals("山东")){
            return "sd";
        }else if(province.equals("北京")){
            return "bj";
        }else if(province.equals("天津")){
            return "tj";
        }else if(province.equals("河北")){
            return "bj";
        }else if(province.equals("山西")){
            return "shanxi";
        }else if(province.equals("辽宁")){
            return "lj";
        }else if(province.equals("上海")){
            return "sh";
        }else if(province.equals("江苏")){
            return "js";
        }else if(province.equals("浙江")){
            return "zj";
        }else if(province.equals("安徽")){
            return "ah";
        }else if(province.equals("福建")){
            return "fj";
        }else if(province.equals("江西")){
            return "jx";
        }else if(province.equals("河南")){
            return "henan";
        }else if(province.equals("湖北")){
            return "hb";
        }else if(province.equals("湖南")){
            return "hn";
        }else if(province.equals("广东")){
            return "gd";
        }else if(province.equals("海南")){
            return "hn";
        }else if(province.equals("四川")){
            return "sc";
        }else if(province.equals("贵州")){
            return "gz";
        }else if(province.equals("云南")){
            return "yn";
        }else if(province.equals("陕西")){
            return "sx";
        }else if(province.equals("甘肃")){
            return "gs";
        }else if(province.equals("台湾")){
            return "tw";
        }else if(province.equals("内蒙古")){
            return "nmg";
        }else if(province.equals("广西")){
            return "gx";
        }else if(province.equals("西藏")){
            return "xz";
        }else if(province.equals("宁夏")){
            return "nx";
        }else if(province.equals("新疆")){
            return "xj";
        }else if(province.equals("重庆")){
            return "cq";
        }else if(province.equals("香港")){
            return "xg";
        }else if(province.equals("澳门")){
            return "am";
        }else if(province.equals("吉林")){
            return "jl";
        }else if(province.equals("黑龙江")){
            return "hlj";
        }
        return "sd";
    }


        public static boolean isIDNumber(String IDNumber) {
            if (IDNumber == null || "".equals(IDNumber)) {
                return false;
            }
            // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
            String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                    "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
            //假设18位身份证号码:41000119910101123X  410001 19910101 123X
            //^开头
            //[1-9] 第一位1-9中的一个      4
            //\\d{5} 五位数字           10001（前六位省市县地区）
            //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
            //\\d{2}                    91（年份）
            //((0[1-9])|(10|11|12))     01（月份）
            //(([0-2][1-9])|10|20|30|31)01（日期）
            //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
            //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
            //$结尾

            //假设15位身份证号码:410001910101123  410001 910101 123
            //^开头
            //[1-9] 第一位1-9中的一个      4
            //\\d{5} 五位数字           10001（前六位省市县地区）
            //\\d{2}                    91（年份）
            //((0[1-9])|(10|11|12))     01（月份）
            //(([0-2][1-9])|10|20|30|31)01（日期）
            //\\d{3} 三位数字            123（第十五位奇数代表男，偶数代表女），15位身份证不含X
            //$结尾


            boolean matches = IDNumber.matches(regularExpression);

            //判断第18位校验值
            if (matches) {

                if (IDNumber.length() == 18) {
                    try {
                        char[] charArray = IDNumber.toCharArray();
                        //前十七位加权因子
                        int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                        //这是除以11后，可能产生的11位余数对应的验证码
                        String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                        int sum = 0;
                        for (int i = 0; i < idCardWi.length; i++) {
                            int current = Integer.parseInt(String.valueOf(charArray[i]));
                            int count = current * idCardWi[i];
                            sum += count;
                        }
                        char idCardLast = charArray[17];
                        int idCardMod = sum % 11;
                        if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }

            }
            return matches;
        }

    public static boolean isPhoneNumber(String phoneNumber){
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9])|(16[6]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNumber);  //registrant_phone  ====  电话号码字段
        boolean isMatch = m.matches();
        if (!isMatch) {
            return false;
        }
        return true;
    }
}
