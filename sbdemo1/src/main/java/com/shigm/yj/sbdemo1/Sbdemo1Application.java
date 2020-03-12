package com.shigm.yj.sbdemo1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Sbdemo1Application {

    public static void main(String[] args) {
//        SpringApplication.run(Sbdemo1Application.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Sbdemo1Application.class);
        SpringApplication build = builder.build();
        build.setBannerMode(Banner.Mode.OFF);
        build.run(args);

    }
    @GetMapping("/hello")
    public String hello(){
        return "hello yj";
    }

}
