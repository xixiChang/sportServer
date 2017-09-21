package com.tcl.work.sport.controller;

import com.tcl.work.sport.controller.Filed.FiledActivityPost;
import com.tcl.work.sport.mapper.ActivityMapper;
import com.tcl.work.sport.model.Activity;
import com.tcl.work.sport.model.ResponseResult;
import com.tcl.work.sport.utils.GetString;
import com.tcl.work.sport.utils.TimeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.tcl.work.sport.constant.Constant.OK;

/**
 * Created by Emcc on 17-9-19.
 */
@RestController(value = "/activity")
public class ActivityManager {

    @Autowired
    private ActivityMapper activityMapper;

    @PostMapping(value = "/post")
    public ResponseResult postActivity(@Valid FiledActivityPost activityFiled,
                                       BindingResult binding){
        ResponseResult responseResult = new ResponseResult();
        if (binding.hasErrors()){
            responseResult.setMsg(GetString.errorInfo(binding.getAllErrors()));
            return responseResult;
        }
        if( activityMapper.addActivity(getActivity(activityFiled)) > 0){
            responseResult.setStatus(OK);
        }
        return responseResult;
    }

    private Activity getActivity(FiledActivityPost activityFiled) {
        Activity activity = new Activity();
        activity.setPublish_user_id(activityFiled.getUserId());
        activity.setImage_url(activityFiled.getUrl());
        activity.setTopic(activityFiled.getName());
        activity.setTime(TimeTranslator.stringToDateTime(activityFiled.getStartTime()));
        activity.setEnd_time(TimeTranslator.stringToDateTime(activityFiled.getEndTime()));
        activity.setAddress(activityFiled.getAddress());
        activity.setGoal_dis(activityFiled.getGoalDis());
        activity.setContent(activityFiled.getStartTime());
        activity.setCount(activityFiled.getCount());
        return activity;
    }

}
