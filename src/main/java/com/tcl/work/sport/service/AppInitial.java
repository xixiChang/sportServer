package com.tcl.work.sport.service;

import com.tcl.work.sport.ApplicationContext;
import com.tcl.work.sport.mapper.UserMapper;
import com.tcl.work.sport.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Calendar;
import java.util.List;


@Service
public class AppInitial {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private UserMapper userMapper;

    @Value("${custom.file.filePath}")
    private String filePath;

    @PostConstruct
    public void AppInitial(){
        DataInitial();
        PathInit();
    }


    private void DataInitial(){
        List<User> users = userMapper.getAllSessions();
        for (User user:users){
            ApplicationContext.UserSessions.put(user.getId(), user.getSession());
        }
        logger.debug(users.size());
    }

    private void PathInit() {
        File activityImageFile = new File(filePath + "activity");
        File headImageFile = new File(filePath + "head");
        if (!activityImageFile.exists()){
            activityImageFile.mkdir();
        }

        if (!headImageFile.exists()){
            headImageFile.mkdir();
        }
    }
}
