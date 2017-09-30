package com.tcl.work.sport.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoinUser {
    int id;
    String image_url;
    String name;
    String im_uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIm_uid() {
        return im_uid;
    }

    public void setIm_uid(String im_uid) {
        this.im_uid = im_uid;
    }
}
