package com.tcl.work.sport.utils;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Emcc on 17-9-14.
 */
public class GetString {
    public static String errorInfo(List<ObjectError> errors) {
        String rs = "";
        for (ObjectError error : errors) {
            if (!StringUtil.isEmpty(error.getDefaultMessage()))
                rs += error.getDefaultMessage() + "\t";
        }
        return rs;
    }

}
