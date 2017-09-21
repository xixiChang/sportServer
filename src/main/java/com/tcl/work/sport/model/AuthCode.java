package com.tcl.work.sport.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Emcc on 17-9-13.
 */
public class AuthCode {
    private String code;
    private Long time;

    public AuthCode(String code, Long time) {
        this.code = code;
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public boolean isTimeOut() {
        return (new Date().getTime() - time) > ( 5 * 1000 * 60);
    }

    public boolean isRight(String c) {
        return code.equals(c);
    }
}
