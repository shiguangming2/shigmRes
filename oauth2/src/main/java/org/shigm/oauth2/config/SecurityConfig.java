package org.shigm.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author shigm
 * @date 2019/11/21 22:33
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("javaboy").password("$2a$10$7vfoM01YaGukVxm58hMAsOuGbQqBjFIlmkKIZqJxJaqrb449hBScq")
                .roles("admin")
                .and()
                .withUser("shigm").password("$2a$10$7vfoM01YaGukVxm58hMAsOuGbQqBjFIlmkKIZqJxJaqrb449hBScq")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**")
                .authorizeRequests().antMatchers("/oauth/**")
                .permitAll()
                .and().csrf().disable();
    }
}
