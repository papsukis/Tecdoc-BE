package com.adMaroc.Tecdoc.Security.Repository.Impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.*;
import com.adMaroc.Tecdoc.Security.Repository.CustomUserLogRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomUserLogRepositoryImpl implements CustomUserLogRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserLog> search(List<FilterDTO> filters) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QUserLog userLog = QUserLog.userLog;
        QPrivilege privilege = QPrivilege.privilege;

       BooleanBuilder builder = new BooleanBuilder();
        for (FilterDTO<Privilege> filter : filters) {
            switch (filter.getTarget()) {
                case "username":
                    builder.and(userLog.username.containsIgnoreCase(filter.getValue()));
                    break;
                case "ipaddress":
                    builder.and(userLog.ipAddress.containsIgnoreCase(filter.getValue()));
                    break;
                case "action" :
                    builder.and(userLog.action.containsIgnoreCase(filter.getValue()));
                    break;
//                case: "before" :
//                    builder.and(userLog.logTime.before(filter.getValue()))

            }
        }
        JPAQuery<UserLog> jpaQuery;
            jpaQuery = query.selectFrom(userLog).where(builder);

        return jpaQuery.fetch();

    }
}
