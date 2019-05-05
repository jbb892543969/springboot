package com.jbb.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jbb.manager.entity.MUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName UserDTO
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:37
 **/
public class UserDTO extends MUser implements UserDetails {
    private String roleName;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //加入用户权限信息，可有多个权限信息 例如admin test
        List<GrantedAuthority> authorities = new LinkedList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    //用户是否过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //用户是否被锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return super.getUserStatus() == 1 ? true : false;
    }

    //凭证是否过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //用户是否允许登录
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
