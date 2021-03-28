package com.adMaroc.Tecdoc.BackOffice.Repository.others;

import com.adMaroc.Tecdoc.BackOffice.Models.TableSaveLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TableSaveLogRepository extends JpaRepository<TableSaveLog,Long> {
}
