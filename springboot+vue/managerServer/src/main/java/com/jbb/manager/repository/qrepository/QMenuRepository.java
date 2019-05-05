package com.jbb.manager.repository.qrepository;

import com.jbb.manager.entity.dto.MenuDTO;
import com.jbb.manager.enumeration.Status;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName QMenuRepository
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-24 11:07
 **/
@Repository
public class QMenuRepository extends BaseRepository {
    public List<MenuDTO> getAllMenu() {
        JPAQuery<MenuDTO> query = factory.select(Projections.bean(MenuDTO.class, menu.url, role.roleName))
                .from(menu, role, roleMenu)
                .where(menu.id.eq(roleMenu.menuId)
                        .and(roleMenu.roleId.eq(role.roleId))
                        .and(menu.status.in(Status.NORMAL.getCode())));
        return query.fetchResults().getResults();

    }

    public List<MenuDTO> getUserMenu(String account) {
        JPAQuery<MenuDTO> query = factory.select(
                Projections.bean(
                        MenuDTO.class, menu.id, menu.pid.as("parentID"), menu.url, menu.name, menu.component, menu.path))
                .from(user, menu, userRole, roleMenu, role)
                .where(user.id.eq(userRole.userId)
                        .and(userRole.roleId.eq(role.roleId))
                        .and(role.roleId.eq(roleMenu.roleId))
                        .and(roleMenu.menuId.eq(menu.id))
                        .and(menu.status.eq(Status.NORMAL.getCode()))
                        .and(user.username.eq(account))
                );
        return query.fetch();
    }
}
