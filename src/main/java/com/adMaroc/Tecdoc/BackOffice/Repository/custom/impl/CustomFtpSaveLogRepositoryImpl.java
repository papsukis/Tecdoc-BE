package com.adMaroc.Tecdoc.BackOffice.Repository.custom.impl;

import com.adMaroc.Tecdoc.BackOffice.Models.FtpSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Models.QFtpSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Models.QTableSaveLog;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomFtpSaveLogRepository;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomFtpSaveLogRepositoryImpl implements CustomFtpSaveLogRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public FtpSaveLog findByUserLog(UserLog userLog){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QFtpSaveLog ftpSaveLog=QFtpSaveLog.ftpSaveLog;
        QTableSaveLog tableSaveLog = QTableSaveLog.tableSaveLog;
        JPAQuery<FtpSaveLog> jpaQuery=query.selectFrom(ftpSaveLog).where(ftpSaveLog.userLog.id.eq(userLog.getId()));

        return jpaQuery.fetchOne();
    }

}
