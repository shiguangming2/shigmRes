package org.shigm.securitydymic;

import org.junit.jupiter.api.Test;
import org.shigm.securitydymic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityDymicApplicationTests {

    @Autowired
    MenuService menuService;
    @Test
    void contextLoads() {
        System.out.println(menuService.getAllMenus());
    }

}
