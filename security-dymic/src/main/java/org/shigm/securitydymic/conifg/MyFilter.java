package org.shigm.securitydymic.conifg;

import org.shigm.securitydymic.bean.Menu;
import org.shigm.securitydymic.bean.Role;
import org.shigm.securitydymic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author shigm
 * @date 2019/11/17 22:45
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher matcher=new AntPathMatcher();
    @Autowired
    MenuService service;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = service.getAllMenus();
        for (Menu menu : menus) {
            if (matcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] roleStr=new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i]=roles.get(i).getName();
                }
                    return SecurityConfig.createList(roleStr);
            }
        }
        return  SecurityConfig.createList("ROLE_login");
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
