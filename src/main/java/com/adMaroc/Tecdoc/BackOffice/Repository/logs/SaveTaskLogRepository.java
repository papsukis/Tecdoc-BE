package com.adMaroc.Tecdoc.BackOffice.Repository.logs;

import com.adMaroc.Tecdoc.BackOffice.Models.SaveTaskLog;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.LogsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface SaveTaskLogRepository extends JpaRepository<SaveTaskLog, Long>, LogsRepository {
}
