package com.tcl.work.sport.controller.Filed;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Emcc on 17-9-19.
 */
public class FiledActivityDelay {

    @NotBlank(message = "user_id is empty")
    private String user_id;

    @NotBlank(message = "at_server_id is empty")
    private String at_server_id;

    @NotBlank(message = "reason is empty")
    private String reason;

    @NotBlank(message = "start_time is empty")
    private String start_time;

    @NotBlank(message = "end_time is empty")
    private String end_time;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAt_server_id() {
        return at_server_id;
    }

    public void setAt_server_id(String at_server_id) {
        this.at_server_id = at_server_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
