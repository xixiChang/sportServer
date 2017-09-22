package com.tcl.work.sport.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private int id;
    private int user_id;

    /**
     * (yyyy-MM-dd)
     */
    @NotEmpty(message = "date is null")
    private Date date;

    /**
     * (HH:mm:ss)
     */
    @NotEmpty(message = "time is null")
    private String time;


    /**
     * 0:步行, 1:跑步, 3:骑行
     */
    @Pattern(regexp = "^(0|1|2)$", message = "type = 0|1|2")


    private String type;
    private int step;
    private int distance; //单位：ｍ
    private int calorie; //单位：c
    private float mean_speed; //单位：m/s
    private int spent_time; //s

    @NotEmpty(message = "start_time is null")
    private Time start_time; //HH:mm:ss
    @NotEmpty(message = "end_time is null")
    private Time end_time; //HH:mm:ss

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return simpleDateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public float getMean_speed() {
        return mean_speed;
    }

    public void setMean_speed(float mean_speed) {
        this.mean_speed = mean_speed;
    }

    public int getSpent_time() {
        return spent_time;
    }

    public void setSpent_time(int spent_time) {
        this.spent_time = spent_time;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }
}