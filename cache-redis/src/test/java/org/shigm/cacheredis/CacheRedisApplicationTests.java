package org.shigm.cacheredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheRedisApplicationTests {

    @Autowired
    UserService service;

    public CacheRedisApplicationTests() {
    }

    @Test
    public void contextLoads() {
        User user1 = service.getUserById(1, "aa1");
//        service.delete(1);
        User u = new User();
        u.setId(1);
        service.update(u);
        User user2 = service.getUserById(1, "bb");
        System.out.println(user1);
        System.out.println(user2);
        if ("2".equals(u)) {
            System.out.println("aaW");
        }
    }

}
