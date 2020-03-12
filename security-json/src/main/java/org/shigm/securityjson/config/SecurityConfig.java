package org.shigm.securityjson.config;

import org.shigm.securityjson.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author shigm
 * @date 2019/11/24 18:01
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    MyFilter myFilter() {
        MyFilter myFilter = new MyFilter();
        try {
            myFilter.setAuthenticationManager(authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myFilter;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
               .and().formLogin().permitAll()
                .and().csrf().disable();

        //添加过滤器
        http.addFilterAt(myFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
