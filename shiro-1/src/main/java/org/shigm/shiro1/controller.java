package org.shigm.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/24 15:48
 */
@RestController
public class controller {
    @GetMapping("/login")
    public  String login() {
        return "please login";
    }
    @PostMapping("/doLogin")
    public void doLogin(String username,String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("login success");
        } catch (AuthenticationException e) {
            System.out.println("login fail");
            e.printStackTrace();
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello shiro";
    }
}
