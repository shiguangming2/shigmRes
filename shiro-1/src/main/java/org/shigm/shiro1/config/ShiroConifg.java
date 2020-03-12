package org.shigm.shiro1.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.shigm.shiro1.realm.MyRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shigm
 * @date 2019/11/24 15:35
 */
@Configuration
public class ShiroConifg {
    @Bean
    MyRealm myRealm(){
        return  new MyRealm();
    }
    @Bean
    SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        Map<String, String> map =new LinkedHashMap<>();
        map.put("/doLogin","anon");
        map.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return  factoryBean;
    }
}
