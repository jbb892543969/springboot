package com.jbb.manager.repository.qrepository;

import com.jbb.manager.entity.querydsl.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BaseRepository
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-24 11:07
 **/
@Repository
public class BaseRepository {
    @Autowired
    public JPAQueryFactory factory;
    public QMUser user = QMUser.mUser;
    public QUserRole userRole = QUserRole.userRole;
    public QRole role = QRole.role;
    public QRoleMenu roleMenu = QRoleMenu.roleMenu;
    public QMenu menu = QMenu.menu;
}
