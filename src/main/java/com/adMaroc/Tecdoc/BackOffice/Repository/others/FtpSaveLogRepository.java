package com.adMaroc.Tecdoc.BackOffice.Repository.others;

import com.adMaroc.Tecdoc.BackOffice.Models.FtpSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomFtpSaveLogRepository;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface FtpSaveLogRepository extends JpaRepository<FtpSaveLog,Long>, CustomFtpSaveLogRepository {

//    OrderByEndTimeDesc
}
