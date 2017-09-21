package com.tcl.work.sport.service;

import com.tcl.work.sport.mapper.UserMapper;
import com.tcl.work.sport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataOPService {

    @Autowired
    private UserMapper userMapper;

    public boolean addNewUser(User user){
        return userMapper.addUser(user) > 0;
    }
}
