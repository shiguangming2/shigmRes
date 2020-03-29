package org.shgigm.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2020/3/24 22:13
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    Integer port;

@GetMapping("/hello")
    public String hello() {
        return "hello shigm"+port;
    }
}
