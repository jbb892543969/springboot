package com.jbb.manager.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName UserRole
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:02
 **/
@Entity
@Table(name = "user_role", schema = "manager", catalog = "")
public class UserRole {
    private int id;
    private int userId;
    private int roleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                userId == userRole.userId &&
                roleId == userRole.roleId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, roleId);
    }
}
