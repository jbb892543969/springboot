package com.jbb.manager.config.security;

import com.jbb.manager.entity.dto.MenuDTO;
import com.jbb.manager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName CustomSecurityMetadataSource
 * @Author 金斌斌
 * @Description 鉴权
 * @Date 2018-07-24 10:35
 **/
@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //请求url
        String url = ((FilterInvocation) o).getRequestUrl();
        //菜单及所拥有权限
        List<MenuDTO> allMenu = menuService.getAllMenu();
        List<ConfigAttribute> attributes = new ArrayList<>();
        for (MenuDTO menu : allMenu) {
            //请求路径与菜单url匹配
            if (antPathMatcher.match(menu.getUrl(), url)) {
                attributes.add(new SecurityConfig(menu.getRoleName()));
            }
        }
        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
