package com.jbb.manager.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName RoleMenu
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:02
 **/
@Entity
@Table(name = "role_menu", schema = "manager", catalog = "")
public class RoleMenu {
    private int id;
    private int roleId;
    private int menuId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "menu_id")
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return id == roleMenu.id &&
                roleId == roleMenu.roleId &&
                menuId == roleMenu.menuId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleId, menuId);
    }
}
