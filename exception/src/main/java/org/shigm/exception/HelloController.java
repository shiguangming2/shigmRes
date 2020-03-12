package org.shigm.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/hello")
//    @CrossOrigin(origins="http://localhost:8081")
    public String hello(Date date){
//        int i = 1 / 0;
        System.out.println(date);
        return "hello";
    }
}
