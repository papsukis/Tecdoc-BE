package com.adMaroc.Tecdoc.Security.Repository.Impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.QRole;
import com.adMaroc.Tecdoc.Security.Models.QUser;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Repository.CustomUserRepository;
import com.adMaroc.Tecdoc.Security.Repository.booleanExpressions.UserBooleanExpressions;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class CustomUserRepositoryImpl extends UserBooleanExpressions implements CustomUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> search(List<FilterDTO<Role>> filters){
        JPAQueryFactory query = new JPAQueryFactory(em);

//        JPAQuery<User> jpaQuery=query.selectFrom(user).where(isUserNameLike())
        BooleanBuilder userBuilder = new BooleanBuilder();
        BooleanBuilder roleBuilder = new BooleanBuilder();
        Boolean isThereRole = false;
        String username="";
        BooleanBuilder builder = new BooleanBuilder();
        for(FilterDTO<Role> filter :filters ){
            switch (filter.getTarget()){
                case "username":
                    username=filter.getValue();
                    userBuilder.and(user.username.containsIgnoreCase(username));
                    break;
                case "roles"   :
                    for(Role r: filter.getList())
                    {
                        isThereRole=true;
                        roleBuilder.or(role.id.eq(r.getId()));
                    }
                    builder.and(roleBuilder);
                    break;
        }}
        JPAQuery<User> jpaQuery;
        if(isThereRole)
            jpaQuery= query.selectFrom(user).join(user.roles,role).on(builder).where(userBuilder);
        else
            jpaQuery= query.selectFrom(user).where(userBuilder);

        return jpaQuery.fetch();
    }




}
