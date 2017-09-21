package com.tcl.work.sport.controller.Filed;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Emcc on 17-9-19.
 */
public class FiledActivityPost {
    private String userId;

    @NotEmpty (message = "url is null")
    private String url;
    @NotEmpty (message = "name is null")
    private String name;
    @NotEmpty (message = "startTime is null")
    private String startTime;
    @NotEmpty (message = "startTime is null")
    private String endTime;
    @NotEmpty (message = "address is null")
    private String address;
    @NotEmpty (message = "goalDis is null")
    private String goalDis;
    @NotEmpty (message = "instruction is null")
    private String instruction;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoalDis() {
        return goalDis;
    }

    public void setGoalDis(String goalDis) {
        this.goalDis = goalDis;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
