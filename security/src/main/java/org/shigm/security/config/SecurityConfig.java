package org.shigm.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shigm
 * @date 2019/11/10 15:33
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true) //开启方法安全认证权限校验
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    ;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("yangj")
                .password("123")
                .roles("admin")
                .and()
                .withUser("jim")
                .password("456")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasRole("admin")
                .antMatchers("user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin") //配置登录接口 ，方便postman 测试使用
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = httpServletResponse.getWriter();
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 200);
                        map.put("msg", authentication.getPrincipal());
                        writer.write(new ObjectMapper().writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 500);
                        if (e instanceof LockedException) {
                            map.put("msg", "登录失败，账户锁定");
                        } else if (e instanceof BadCredentialsException) {
                            map.put("msg", "用户名或者密码错误");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "用户被禁用，登录失败");
                        } else {
                            map.put("msg", "登录失败");
                        }
                        writer.write(new ObjectMapper().writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logOut")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = resp.getWriter();
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 500);
                        map.put("msg", "签退成功");
                        writer.write(new ObjectMapper().writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                })
                .and()
                .csrf().disable();
    }
}
