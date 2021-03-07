package com.adMaroc.Tecdoc.Security.Repository.Impl;

import com.adMaroc.Tecdoc.BackOffice.DTO.FilterDTO;
import com.adMaroc.Tecdoc.Security.Models.*;
import com.adMaroc.Tecdoc.Security.Repository.CustomRoleRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomRoleRepositoryImpl implements CustomRoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> search(List<FilterDTO<Privilege>> filters) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRole role = QRole.role;
        QPrivilege privilege = QPrivilege.privilege;

        BooleanBuilder nameBuilder = new BooleanBuilder();
        BooleanBuilder privilegeBuilder = new BooleanBuilder();
        BooleanBuilder builder = new BooleanBuilder();

        Boolean isTherePrivilege = false;
        for (FilterDTO<Privilege> filter : filters) {
            switch (filter.getTarget()) {
                case "name":
                    nameBuilder.and(role.name.containsIgnoreCase(filter.getValue()));
                    break;
                case "privileges":
                    for (Privilege r : filter.getList()) {
                        isTherePrivilege = true;
                        privilegeBuilder.or(privilege.id.eq(r.getId()));
                    }
                    builder.and(privilegeBuilder);
                    break;
                    }
            }
            JPAQuery<Role> jpaQuery;
            if (isTherePrivilege)
                jpaQuery = query.selectFrom(role).join(role.privileges, privilege).on(builder).where(nameBuilder);
            else
                jpaQuery = query.selectFrom(role).where(nameBuilder);

            return jpaQuery.fetch();

    }
}
