package com.adMaroc.Tecdoc.Security.Services;

import com.adMaroc.Tecdoc.Security.Models.UserLog;

import java.util.List;

public interface UserLogService {


    List<UserLog> findAll();

    List<UserLog> findByUsername(String username);

    void saveUserLog(UserLog userLog);
}
