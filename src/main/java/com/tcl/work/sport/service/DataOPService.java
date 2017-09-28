package com.tcl.work.sport.service;

import com.tcl.work.sport.mapper.ActivityMapper;
import com.tcl.work.sport.mapper.UserMapper;
import com.tcl.work.sport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DataOPService {

    @Autowired
    private ActivityMapper activityMapper;

    /**
     * 每天凌晨１点更改活动状态至过期
     */
    @Scheduled(cron = "0 0 1 * * *")
    public void modifyActicitySatus(){
        activityMapper.updateStatusToDone();
    }
}
