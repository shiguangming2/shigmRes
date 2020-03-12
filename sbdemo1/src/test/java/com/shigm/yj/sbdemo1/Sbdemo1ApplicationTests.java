package com.shigm.yj.sbdemo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sbdemo1ApplicationTests {
    @Autowired
    Book book;

    @Autowired
    RedisCluster redis;

    @Test
    public void contextLoads() {
        System.out.println(redis);
    }



}
