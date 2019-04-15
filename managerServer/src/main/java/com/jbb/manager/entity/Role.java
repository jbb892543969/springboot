package com.jbb.manager.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @ClassName Role
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:02
 **/
@Entity
public class Role {
    private int roleId;
    private String roleName;
    private String roleNameCn;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_name_cn")
    public String getRoleNameCn() {
        return roleNameCn;
    }

    public void setRoleNameCn(String roleNameCn) {
        this.roleNameCn = roleNameCn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleNameCn, role.roleNameCn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, roleName, roleNameCn);
    }
}
