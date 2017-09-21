package com.tcl.work.sport;

import com.tcl.work.sport.model.AuthCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    public static Map<Integer, String> UserSessions = new HashMap<>();
    public static Map<String, AuthCode> codes = new HashMap<>();//验证码
}
