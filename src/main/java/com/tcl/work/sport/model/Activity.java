package com.tcl.work.sport.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


/**
 * Created by Emcc on 17-9-19.
 */
@JsonInclude (JsonInclude.Include.NON_NULL)
public class Activity {
    private int id;
    private String publish_user_id;//发布者id
    private String topic;//活动名称
    private Date time;//活动开始时间
    private Date end_time;//活动结束时间
    private Date publish_time;//发布时间
    private String address;//活动地址
    private int count;//活动人数
    private String content;//活动内容及介绍
    private int status;//活动状态
    private String image_url;//活动主题图片地址
    private String lltude;
    private String goal_dis;//目标距离
    private String reason;//活动取消/推迟原因
    private String retain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoal_dis() {
        return goal_dis;
    }

    public void setGoal_dis(String goal_dis) {
        this.goal_dis = goal_dis;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPublish_user_id() {
        return publish_user_id;
    }

    public void setPublish_user_id(String publish_user_id) {
        this.publish_user_id = publish_user_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLltude() {
        return lltude;
    }

    public void setLltude(String lltude) {
        this.lltude = lltude;
    }

    public String getRetain() {
        return retain;
    }

    public void setRetain(String retain) {
        this.retain = retain;
    }
}
