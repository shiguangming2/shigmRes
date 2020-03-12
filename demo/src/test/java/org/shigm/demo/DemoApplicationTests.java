package org.shigm.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shigm.demo.bean.User;
import org.shigm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService service;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("阳杰1");
        user.setAge(19);
        service.addUser(user);
    }

    @Test
    public void test1(){
        User user = new User();
        user.setId(2);
        user.setName("时光明");
        service.updateUser(user);

    }

    @Test
    public void test2(){
        List<User> users = service.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void test3(){
        List<User> users = service.getAll2();
        System.out.println(users.toString());
    }
}
