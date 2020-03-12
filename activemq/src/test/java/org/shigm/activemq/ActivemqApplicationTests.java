package org.shigm.activemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqApplicationTests {

    @Autowired
    JmsComponent component;
    @Test
    void contextLoads() {
        Message message = new Message();
        message.setContent("大家好啊 我叫时光明");
        message.setDate(new Date());
        component.send(message);
    }

}
