package com.tcl.work.sport.controller;

import com.tcl.work.sport.constant.Constant;
import com.tcl.work.sport.controller.Filed.FiledUpdateUser;
import com.tcl.work.sport.controller.Filed.FiledUserRegister;
import com.tcl.work.sport.mapper.UserMapper;
import com.tcl.work.sport.model.AuthCode;
import com.tcl.work.sport.model.ResponseResult;
import com.tcl.work.sport.model.User;
import com.tcl.work.sport.service.SendSMSCode;
import com.tcl.work.sport.thirdparty.IMRegister;
import com.tcl.work.sport.utils.Base64;
import com.tcl.work.sport.utils.GetString;
import com.tcl.work.sport.utils.SHA1;
import com.tcl.work.sport.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

import static com.tcl.work.sport.ApplicationContext.UserSessions;
import static com.tcl.work.sport.ApplicationContext.codes;
import static com.tcl.work.sport.constant.Constant.OK;

@RestController
@RequestMapping("/user")
public class ManagerUser {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private UserMapper userMapper;


    private IMRegister imRegister = new IMRegister();

    private SendSMSCode sendSMSCode = new SendSMSCode();

    @RequestMapping(path = "/login")
    public ResponseResult userLogin(User user) {
        ResponseResult result = new ResponseResult();
        if (user.getPhone() == null || user.getPassword() == null) {
            result.setMsg("手机号或密码为空");
            return result;
        }

        user.setPassword(Base64.base64encode(user.getPassword()));

        User checkUser = userMapper.checkUser(user);
        if (checkUser != null && checkUser.getId() > 0) {
            result.setStatus("ok");
            result.setResult(checkUser);
            UserSessions.put(checkUser.getId(), checkUser.getSession());
        } else {
            result.setMsg("手机号或密码错误");
        }

        return result;
    }

    @RequestMapping(path = "/register")
    public ResponseResult userRegister(@Valid FiledUserRegister info, BindingResult binding) {
        ResponseResult result = new ResponseResult();
        if (binding.hasErrors()) {
            result.setMsg(GetString.errorInfo(binding.getAllErrors()));
            return result;
        }

        AuthCode authCode = codes.get(info.getPhone());
        if (authCode == null) {
            result.setMsg("手机号不正确");
            return result;
        }
        if (authCode.isTimeOut()) {
            result.setMsg("验证码已超时,请重新获取");
            return result;
        }

        if (!authCode.isRight(info.getCode())) {
            result.setMsg("验证码错误");
            return result;
        }

        if (userMapper.checkPhone(info.getPhone()) > 0) {
            result.setMsg("phone has been registered");
            return result;
        }
        String uid = String.valueOf(new Date().getTime());

        User user = new User();
        user.setName(info.getName());
        user.setPassword(Base64.base64encode(info.getPassword()));
        user.setJoin_time(new Date());
        user.setIm_uid(uid);
        user.setSession(SHA1.encode(info.getPassword()));
        user.setPhone(info.getPhone());
        user.setImage_url(Constant.USER_DEFAULT_IMAGE_URL);

        imRegister.imUserRegister(user);

        if (userMapper.addUser(user) > 0)
            result.setStatus(OK);
        return result;
    }

    @RequestMapping(path = "/getauthcode")
    public ResponseResult userGetAuthCode(String phone) {
        ResponseResult result = new ResponseResult();
        if (StringUtil.isEmpty(phone)) {
            result.setMsg("phone is null");
            return result;
        }

        if (!phone.matches("^(0|86|17951)?(13[0-9]|15[012356789]|16[6]|17[12345678]|18[0-9]|14[56789]|19[89])[0-9]{8}$")) {
            result.setMsg("phone is incorrect");
            return result;
        }

        if (userMapper.checkPhone(phone) > 0) {
            result.setMsg("phone has been registered");
            return result;
        }
        int tempNum = (int) (Math.random() * 9999);
        String randomNum = String.valueOf(tempNum < 1000 ? tempNum + 1000 : tempNum);
        sendSMSCode.sendSms(phone, randomNum);
        codes.put(phone, new AuthCode(randomNum, new Date().getTime()));

        result.setStatus(OK);
        return result;
    }

    @RequestMapping(path = "/getuserinfo")
    public ResponseResult getUserInfo(@RequestParam("user_id") String user_id) {
        ResponseResult responseResult = new ResponseResult();
        User user = userMapper.getInfo(Integer.parseInt(user_id));
        if (user.getId() != 0) {
            responseResult.setResult(user);
            responseResult.setStatus(OK);
            responseResult.setType("getuserinfo");
        } else {
            responseResult.setMsg("not found user");
        }
        return responseResult;
    }

    @RequestMapping(path = "/modifyInfo")
    public ResponseResult updateUser(@RequestBody @Valid FiledUpdateUser user,
                                     BindingResult binding) {
        ResponseResult responseResult = new ResponseResult();
        if (binding.hasErrors()) {
            responseResult.setMsg(GetString.errorInfo(binding.getAllErrors()));
            return responseResult;
        }
        if (userMapper.updateUser(user) > 0) {
            responseResult.setStatus(OK);
            imUpdate(user);
            return responseResult;
        } else {
            responseResult.setMsg("更新失败,请重试");
        }
        return responseResult;
    }


    private void imUpdate(FiledUpdateUser user) {
        User localUser = userMapper.getInfo(user.getUser_id());
        imRegister.imUserUpdate(localUser);
    }
}
