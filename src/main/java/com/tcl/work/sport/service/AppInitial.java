package com.tcl.work.sport.service;

import com.tcl.work.sport.ApplicationContext;
import com.tcl.work.sport.mapper.UserMapper;
import com.tcl.work.sport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AppInitial {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void DataInitial(){
        List<User> users = userMapper.getAllSessions();
        for (User user:users){
            ApplicationContext.UserSessions.put(user.getId(), user.getSession());
        }
        logger.log(Level.INFO, ApplicationContext.UserSessions.size() + "");
    }
}
