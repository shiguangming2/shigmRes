package org.shigm.securityjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/24 21:10
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
}
