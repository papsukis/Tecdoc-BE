package com.adMaroc.Tecdoc.BackOffice.Repository.logs;

import com.adMaroc.Tecdoc.BackOffice.Models.ManufacturerSaveLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ManufacturerSaveLogRepository extends JpaRepository<ManufacturerSaveLog,Long> {
}
