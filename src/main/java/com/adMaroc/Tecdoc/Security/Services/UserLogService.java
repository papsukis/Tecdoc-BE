package com.adMaroc.Tecdoc.Security.Services;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.UserLog;

import java.util.List;

public interface UserLogService {


    List<UserLog> findAll();

    List<UserLog> findByUsername(String username);

    List<UserLog> search(List<FilterDTO> filterDTOS);

    void saveUserLog(UserLog userLog);
}
