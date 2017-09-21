package com.tcl.work.sport.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

public class Base64 {

    /**
     *
     * @param para
     * @return Base64 encode String
     */
    public static String base64encode(String para){
        String result = null;
        if (StringUtils.isEmpty(para))
            return result;
        byte[] temp;
        try {
            temp = Base64Utils.encode(para.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            temp = new byte[]{};
        }
        return new String(temp);
    }
}
