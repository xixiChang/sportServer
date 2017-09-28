package com.tcl.work.sport.mapper;

import com.tcl.work.sport.controller.Filed.FiledActivityDelay;
import com.tcl.work.sport.model.Activity;
import com.tcl.work.sport.model.ActivityBriefInfo;
import com.tcl.work.sport.model.JoinUser;
import org.apache.ibatis.annotations.Mapper;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Emcc on 17-9-19.
 */

@Mapper
public interface ActivityMapper {
    int addActivity(Activity activity);

    int updateActivityTime(FiledActivityDelay delay);

    int cancelActivity(Map<String, String> map);

    Activity getDetails(int at_server_id);

    List<Integer> getJoiner(int at_server_id);

    List<ActivityBriefInfo> getListForSB(int user_id);

    List<ActivityBriefInfo> getAllActivity();

    int joinActivity(Map<String, String> map);

    List<JoinUser> getJoinerInfo(List<Integer> userList);

    int updateStatusToDone();

}
