package com.jbb.manager.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName CustomAuthenticationManager
 * @Author 金斌斌
 * @Description 菜单权限添加传递
 * @Date 2018-07-25 10:18
 **/
@Component
public class CustomAuthenticationManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //url所需权限
        Iterator<ConfigAttribute> iterator = collection.iterator();
        boolean flag = false;
        //用户所具有权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        outer:
        for (GrantedAuthority authority : authorities) {
            //用户权限名称
            String roleName = authority.getAuthority();
            while (iterator.hasNext()) {
                ConfigAttribute ca = iterator.next();
                //菜单所需要url
                String needRole = ca.getAttribute();
                if (needRole.equals(roleName)) {
                    flag = true;
                    break outer;
                }
            }
        }
        if (flag) {
            return;
        } else {
            throw new AccessDeniedException("权限不足，请联系管理员");
        }
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
