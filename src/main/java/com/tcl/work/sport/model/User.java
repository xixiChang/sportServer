package com.tcl.work.sport.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tcl.work.sport.utils.TimeTranslator;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private int id;
    private String name;
    private String password;
    private Date join_time;
    private Date update_time;
    private String session;
    private String phone;
    private String image_url;
    private String retain;
    private String im_uid;

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
    }

    public String getIm_uid() {
        return im_uid;
    }

    public void setIm_uid(String im_uid) {
        this.im_uid = im_uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoin_time() {
        return join_time;
    }

    public void setJoin_time(String join_time) {
        this.join_time = TimeTranslator.stringToDateTime(join_time);
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRetain() {
        return retain;
    }

    public void setRetain(String retain) {
        this.retain = retain;
    }
}
