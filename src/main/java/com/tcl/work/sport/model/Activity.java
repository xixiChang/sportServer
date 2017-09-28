package com.tcl.work.sport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.omg.PortableInterceptor.INACTIVE;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by Emcc on 17-9-19.
 */
@JsonInclude (JsonInclude.Include.NON_NULL)
public class Activity {

    @JsonIgnore
    private String id;//不发送至客户端

    @NotBlank(message = "user_id is empty")
    private String user_id;

    @NotBlank(message = "image_url is empty")
    private String image_url;//主题图片url

    @NotBlank(message = "publish_user_id is empty")
    private String publish_user_id;//发布者id

    @NotBlank(message = "name is empty")
    private String name;

    @NotBlank(message = "details is empty")
    private String details;

    @NotBlank(message = "start_time is empty")
    private String start_time;

    @NotBlank(message = "end_time is empty")
    private String end_time;

    @NotBlank(message = "address is empty")
    private String address;

    @NotNull(message = "distance is null")
    private int distance;

    @NotNull(message = "join_num_all is null")
    @Min(value = 1, message = "min is 1")
    private int join_num_all;//设置参与总人数


    @NotBlank(message = "notes is empty")
    private String notes;


    private String status;
    private int at_server_id;
    private int join_num;
    private String hot_value;
    private String joiner;
    private Timestamp post_time;
    private int click_count;

    private String reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getPublish_user_id() {
        return publish_user_id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getAddress() {
        return address;
    }

    public int getDistance() {
        return distance;
    }

    public int getJoin_num_all() {
        return join_num_all;
    }

    public String getNotes() {
        return notes;
    }

    public String getStatus() {
        return status;
    }

    public int getAt_server_id() {
        return at_server_id;
    }

    public int getJoin_num() {
        return join_num;
    }

    public String getHot_value() {
        return hot_value;
    }

    public String getJoiner() {
        return joiner;
    }

    public void setJoiner(String joiner) {
        this.joiner = joiner;
    }

    public Timestamp getPost_time() {
        return post_time;
    }

    public String getReason() {
        return reason;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setPublish_user_id(String publish_user_id) {
        this.publish_user_id = publish_user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setJoin_num_all(int join_num_all) {
        this.join_num_all = join_num_all;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAt_server_id(int at_server_id) {
        this.at_server_id = at_server_id;
    }

    public void setJoin_num(int join_num) {
        this.join_num = join_num;
    }

    public void setHot_value(String hot_value) {
        this.hot_value = hot_value;
    }



    public void setPost_time(Timestamp post_time) {
        this.post_time = post_time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getClick_count() {
        return click_count;
    }

    public void setClick_count(int click_count) {
        this.click_count = click_count;
    }
}
