package com.adMaroc.Tecdoc.Security.Repository.Impl;

import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Models.QConfig;
import com.adMaroc.Tecdoc.Security.Repository.CustomConfigRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class CustomConfigRepositoryImpl implements CustomConfigRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Config getConfig(String name){
        JPAQueryFactory query = new JPAQueryFactory(em);

        QConfig config = QConfig.config;

        JPAQuery<Config> jpaQuery = query.selectFrom(config).where(config.name.like(name));

        return jpaQuery.fetchOne();
    }
}
