package com.tcl.work.sport.mapper;

import com.tcl.work.sport.model.RateItem;
import com.tcl.work.sport.model.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Emcc on 17-9-22.
 */
@Mapper
public interface RecordMapper {

    int addRecord(Record record);

    Map<String, String> getRecordMaxForDay(Map<String, Object> map);

    Map<String, String> getRecordMax(Map<String, Object> map);

    Record getRecordDetails(int id);

    List<Record> getRecordDayAll(Map<String, Object> map);

    List<Map<String, String>> getRecordHistoryWeekly(int user_id);

    List<Map<String, String>> getRecordHistoryMonthly(int user_id);

    Map<String, String> getRecordSUM(int user_id);

    List<RateItem> getRating(List<Integer> user_id);

}
