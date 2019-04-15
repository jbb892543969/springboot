package com.jbb.manager.repository.qrepository;

import com.jbb.manager.entity.dto.UserDTO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;


/**
 * @ClassName QUserRepository
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:17
 **/
@Repository
public class QUserRepository extends BaseRepository {
    public QueryResults<UserDTO> getUserRole(String username) {
        JPAQuery<UserDTO> query = factory.select(Projections.bean(UserDTO.class, user.username, user.password, role.roleName, user.userStatus))
                .from(user, userRole, role)
                .where(user.id.eq(userRole.userId)
                        .and(userRole.roleId.eq(role.roleId))
                        .and(user.username.eq(username)));
        return query.fetchResults();
    }

    public JPAQuery userList() {
        JPAQuery<UserDTO> query = factory.select(
                Projections.bean(
                        UserDTO.class, user.username, user.userStatus, user.loginTime, user.realName, user.phone, user.address))
                .from(user);
        return query;
    }
}
