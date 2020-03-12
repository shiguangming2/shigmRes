package org.shigm.securitydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/13 23:14
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/dba/hello")
    public String hello1() {
        return "hell dba";
    }

    @GetMapping("/admin/hello")
    public String hello2() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String hello3() {
        return "hello user ";
    }

}
