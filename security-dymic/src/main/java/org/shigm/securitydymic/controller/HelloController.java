package org.shigm.securitydymic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/17 21:41
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "hello login";
    }

    @GetMapping("/db/hello")
    public String Hello1() {
        return "hello db";
    }

    @GetMapping("/user/hello")
    public String Hello2() {
        return "hello user";
    }

    @GetMapping("/admin/hello")
    public String Hello3() {
        return "hello admin";
    }

}


