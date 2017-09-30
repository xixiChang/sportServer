package com.tcl.work.sport.mapper;

import com.tcl.work.sport.controller.Filed.FiledUpdateUser;
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

    User getInfo(int user_id);

    int updateUser(FiledUpdateUser user);

    @Deprecated
    User getUserAll(int user_id);
}
