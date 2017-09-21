package com.tcl.work.sport.mapper;

import com.tcl.work.sport.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int addUser(User user);
    List<User> getAllSessions();

    User checkUser(User user);
    int checkPhone(String phone);
}
