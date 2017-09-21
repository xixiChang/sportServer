package com.tcl.work.sport.controller.Filed;

import com.tcl.work.sport.utils.SHA1;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class FiledUserRegister {

    @NotEmpty (message = "username is null")
    private String name;

    @NotEmpty (message = "password is null")
    private String password;

    @NotEmpty (message = "phone is null")
    @Pattern(regexp = "^(0|86|17951)?(13[0-9]|15[012356789]|16[6]|17[12345678]|18[0-9]|14[56789]|19[89])[0-9]{8}$", message = "phone num is incorrect")
    private String phone;

    @NotEmpty (message = "code is null")
    @Pattern(regexp = "^[0-9]{4}$", message = "code length is 4")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
