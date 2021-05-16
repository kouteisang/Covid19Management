package com.covidmanage.utils;

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
}
