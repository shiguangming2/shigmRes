package org.shigm.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

/**
 * @author shigm
 * @date 2019/11/27 21:55
 */
@Configuration
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate template;
    @Autowired
    Queue queue;

    public void send(Message message) {
        template.convertAndSend(this.queue, message);
    }

    @JmsListener(destination = "hello.java")
    public void receive(Message message) {
        System.out.println(message);
    }
}
