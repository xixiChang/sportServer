package com.tcl.work.sport.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.tcl.work.sport.constant.Constant.FAULT;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult {
    private String status = FAULT;
    private String msg = "";
    private Object result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
