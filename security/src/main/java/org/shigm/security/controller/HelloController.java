package org.shigm.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/10 15:20
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
    @GetMapping("/admin/hello")
    public String hello1(){
        return "hello admin";
    }
    @GetMapping("/user/hello")
    public String hello2(){
        return "hello user";
    }

}
