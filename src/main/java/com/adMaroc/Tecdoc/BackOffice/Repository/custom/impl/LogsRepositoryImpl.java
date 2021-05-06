package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.Models.*;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.LogsRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@Transactional
public class LogsRepositoryImpl implements LogsRepository {
    @PersistenceContext
    private EntityManager em;
    JPAQueryFactory query ;
    QSaveTaskLog saveTaskLog=QSaveTaskLog.saveTaskLog;
    QManufacturerSaveLog manufacturerSaveLog=QManufacturerSaveLog.manufacturerSaveLog;
    QTableSaveLog tableSaveLog=QTableSaveLog.tableSaveLog;

    @Override
    public List<SaveTaskLog> findSaveTaskByStatus(FTP_Status status){
        query = new JPAQueryFactory(em);

        JPAQuery<SaveTaskLog> jpaQuery=query.selectFrom(saveTaskLog).where(saveTaskLog.status.eq(status.label));

        return jpaQuery.fetch();
    }
}
