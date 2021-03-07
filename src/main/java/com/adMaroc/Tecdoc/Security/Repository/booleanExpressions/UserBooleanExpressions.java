package com.adMaroc.Tecdoc.Security.Repository.booleanExpressions;

import com.adMaroc.Tecdoc.Security.Models.QRole;
import com.adMaroc.Tecdoc.Security.Models.QUser;
import com.adMaroc.Tecdoc.Security.Models.Role;
import com.querydsl.core.types.dsl.BooleanExpression;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class UserBooleanExpressions {

    public QUser user=QUser.user;
    public QRole role = QRole.role;

    public BooleanExpression isUserNameLike(String username){
        return ofNullable(username).map(user.username::containsIgnoreCase).get();
    }
    public BooleanExpression isRoleEqual(Role r){
        return of(r.getId()).map(role.id::eq).get();
    }
}
