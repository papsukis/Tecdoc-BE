package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.Models.FtpSaveLog;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import org.springframework.stereotype.Component;

@Component
public interface CustomFtpSaveLogRepository {
    FtpSaveLog findByUserLog(UserLog userLog);
}
