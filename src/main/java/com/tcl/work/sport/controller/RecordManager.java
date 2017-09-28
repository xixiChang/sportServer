package com.tcl.work.sport.controller;

import com.tcl.work.sport.controller.Filed.FiledRecordQuery;
import com.tcl.work.sport.mapper.RecordMapper;
import com.tcl.work.sport.model.Record;
import com.tcl.work.sport.model.ResponseResult;
import com.tcl.work.sport.utils.GetString;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tcl.work.sport.constant.Constant.OK;

/**
 * Created by Emcc on 17-9-22.
 */
@RestController
@RequestMapping ("/record")
public class RecordManager {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping(path = "/upload")
    public ResponseResult uploadRecord(@RequestBody @Valid Record record,
                                       BindingResult binding){
        ResponseResult responseResult = new ResponseResult();
        if (binding.hasErrors()){
            responseResult.setMsg(GetString.errorInfo(binding.getAllErrors()));
            return responseResult;
        }
        logger.debug(record.toString());
        if (recordMapper.addRecord(record) > 0)
            responseResult.setStatus(OK);
        return responseResult;
    }

    @RequestMapping(path = "/query/{cmd}")
    public ResponseResult queryRecord(@PathVariable String cmd, FiledRecordQuery filed){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMsg(cmd);
        if (filed.getType() != null)
            responseResult.setType(filed.getType());
        switch (cmd){
            case "sum":
                responseResult.setResult(recordMapper.getRecordSUM(filed.getUser_id()));
                responseResult.setStatus(OK);
                break;
            case "month":
                responseResult.setResult(recordMapper.getRecordHistoryMonthly(filed.getUser_id()));
                responseResult.setStatus(OK);
                break;
            case "week":
                responseResult.setResult(recordMapper.getRecordHistoryWeekly(filed.getUser_id()));
                responseResult.setStatus(OK);
                break;
            case "dayall":
                Map<String, Object> map = new HashMap<>();
                map.put("user_id", filed.getUser_id());
                map.put("date", filed.getDate());
                responseResult.setResult(recordMapper.getRecordDayAll(map));
                responseResult.setStatus(OK);
                break;
            case "details":
                responseResult.setResult(recordMapper.getRecordDetails(filed.getId()));
                responseResult.setStatus(OK);
                break;
            case "max":
                Map<String, Object> map_m = new HashMap<>();
                map_m.put("user_id", filed.getUser_id());
                map_m.put("type", filed.getType());
                responseResult.setResult(recordMapper.getRecordMax(map_m));
                responseResult.setStatus(OK);
                break;
            case "maxforday":
                Map<String, Object> map_d = new HashMap<>();
                map_d.put("user_id", filed.getUser_id());
                map_d.put("type", filed.getType());
                responseResult.setResult(recordMapper.getRecordMaxForDay(map_d));
                responseResult.setStatus(OK);
                break;
            default:
                responseResult.setMsg("cmd is undefined");
                break;
        }
        return responseResult;
    }


    @RequestMapping(path = "/rating")
    public ResponseResult rating(@RequestParam("user_id") String user_id){
        List<Integer> friendList = new ArrayList<>();
        friendList.add(28);
        friendList.add(29);
        friendList.add(30);
        friendList.add(31);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setResult(recordMapper.getRating(friendList));
        responseResult.setStatus(OK);

        return responseResult;
    }

}
