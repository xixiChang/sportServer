package com.tcl.work.sport.mapper;

import com.tcl.work.sport.model.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Emcc on 17-9-19.
 */
@Mapper
public interface ActivityMapper {
    int addActivity(Activity activity);
    int updateActivityTime(Activity activity);
    int cancelActivity(Activity activity);
}
