package com.tcl.work.sport.controller.Filed;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class FiledUpdateUser {
    @NotNull(message = "user_id is null")
    private int user_id;

    @NotBlank(message = "image_url is blank")
    private String image_url;

    private String retain;

    @NotBlank(message = "name is blank")
    private String name;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
