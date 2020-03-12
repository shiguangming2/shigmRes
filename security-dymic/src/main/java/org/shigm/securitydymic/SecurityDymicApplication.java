package org.shigm.securitydymic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.shigm.securitydymic.mapper")
public class SecurityDymicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDymicApplication.class, args);
    }

}
