package com.adMaroc.Tecdoc.BackOffice.Repository.custom;

import com.adMaroc.Tecdoc.BackOffice.Models.FTP_Status;
import com.adMaroc.Tecdoc.BackOffice.Models.SaveTaskLog;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public interface LogsRepository {
    List<SaveTaskLog> findSaveTaskByStatus(FTP_Status status);
}
