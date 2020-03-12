package org.shigm.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/21 22:45
 */
@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String hello() {
        return "hello amdin";
    }

    @GetMapping("/user/hello")
    public String hello1() {
        return "hello user";
    }

    @GetMapping("/hello")
    public String hello2() {
        return "hello";
    }
}
