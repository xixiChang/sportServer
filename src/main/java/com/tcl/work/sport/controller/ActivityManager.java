package com.tcl.work.sport.controller;

import com.tcl.work.sport.controller.Filed.FiledActivityDelay;
import com.tcl.work.sport.mapper.ActivityMapper;
import com.tcl.work.sport.model.Activity;
import com.tcl.work.sport.model.ResponseResult;
import com.tcl.work.sport.utils.GetString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tcl.work.sport.constant.Constant.OK;

/**
 * Created by Emcc on 17-9-19.
 */
@RestController
@RequestMapping("/activity")
public class ActivityManager {

    @Autowired
    private ActivityMapper activityMapper;

    @PostMapping(path = "/post")
    public ResponseResult postActivity(@RequestBody @Valid Activity activity,
                                       BindingResult binding) {
        ResponseResult responseResult = new ResponseResult();
        if (binding.hasErrors()) {
            responseResult.setMsg(GetString.errorInfo(binding.getAllErrors()));
            return responseResult;
        }
        if (activityMapper.addActivity(activity) > 0) {
            Map<String, String> map = new HashMap<>();
            map.put("at_server_id", activity.getId());
            map.put("user_id", activity.getUser_id());

            activityMapper.joinActivity(map);
            responseResult.setResult(activity.getId());
            responseResult.setStatus(OK);
        }
        return responseResult;
    }

    @PostMapping(path = "/delay")
    public ResponseResult modifyActivity(@Valid FiledActivityDelay activityDelay,
                                         BindingResult bindingResult) {
        ResponseResult responseResult = new ResponseResult();
        if (bindingResult.hasErrors()) {
            responseResult.setMsg(GetString.errorInfo(bindingResult.getAllErrors()));
            return responseResult;
        }
        if (activityMapper.updateActivityTime(activityDelay) > 0) {
            responseResult.setStatus(OK);
            responseResult.setType("delay");
        }
        return responseResult;
    }

    @PostMapping(path = "/cancel")
    public ResponseResult cancelActivity(@RequestParam(name = "reason") String reason,
                                         @RequestParam(name = "at_server_id") String at_server_id) {
        ResponseResult responseResult = new ResponseResult();

        Map<String, String> map = new HashMap<>();
        map.put("reason", reason);
        map.put("at_server_id", at_server_id);

        if (activityMapper.cancelActivity(map) > 0)
            responseResult.setStatus(OK);
        responseResult.setType("cancel");
        return responseResult;
    }


    @PostMapping(path = "/details")
    public ResponseResult getDetails(@RequestParam(name = "at_server_id") int at_server_id) {
        ResponseResult responseResult = new ResponseResult();
        Activity activity = activityMapper.getDetails(at_server_id);
        List<Integer> joiners = activityMapper.getJoiner(at_server_id);
        if (joiners != null && !joiners.isEmpty())
            activity.setJoiner(joiners.toString());
        responseResult.setResult(activity);
        responseResult.setStatus(OK);
        responseResult.setType("details");
        return responseResult;
    }

    @PostMapping(path = "/getMyActivity")
    public ResponseResult getMyActivity(@RequestParam(name = "user_id") int user_id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(activityMapper.getListForSB(user_id));
        responseResult.setStatus(OK);
        responseResult.setType("getMyActivity");
        return responseResult;
    }

    @PostMapping(path = "/join")
    public ResponseResult joinActivity(@RequestParam(name = "at_server_id") String at_server_id,
                                       @RequestParam(name = "user_id") String user_id) {
        ResponseResult responseResult = new ResponseResult();
        Map<String, String> map = new HashMap<>();
        map.put("at_server_id", at_server_id);
        map.put("user_id", user_id);

        if (activityMapper.joinActivity(map) > 0) {
            responseResult.setType("join");
            responseResult.setStatus(OK);
        }
        return responseResult;
    }

    @PostMapping(path = "/all")
    public ResponseResult getAll() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(activityMapper.getAllActivity());
        responseResult.setStatus(OK);
        return responseResult;
    }

    @PostMapping(path = "/allByPage")
    public ResponseResult getAllByPage(@RequestParam(name = "current_size") int current_size) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(activityMapper.getAllByPage(current_size));
        if (current_size == 0) {
            responseResult.setType("onRefresh");
        } else if (current_size > 0) {
            responseResult.setType("onLoadMore");
        }

        responseResult.setStatus(OK);
        return responseResult;
    }

    @PostMapping(path = "/getJoinerInfo")
    public ResponseResult getJoinerInfo(@RequestBody List<Integer> list) {
        ResponseResult responseResult = new ResponseResult();
        if (list.isEmpty())
            return responseResult;
        responseResult.setResult(activityMapper.getJoinerInfo(list));
        responseResult.setStatus(OK);
        responseResult.setType("getJoinerInfo");
        return responseResult;
    }

}
