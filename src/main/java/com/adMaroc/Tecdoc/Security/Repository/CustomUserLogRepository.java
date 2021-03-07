package com.adMaroc.Tecdoc.Security.Repository;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.UserLog;

import java.util.List;

public interface CustomUserLogRepository {
    List<UserLog> search(List<FilterDTO> filters);
}
