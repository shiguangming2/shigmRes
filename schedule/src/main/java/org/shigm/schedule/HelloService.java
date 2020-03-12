package org.shigm.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shigm
 * @date 2019/11/28 22:40
 */
@Service
public class HelloService {

//    @Scheduled(fixedDelay = 2000L) //后一次任务结束时间和这次任务的开始时间间隔
    public void fixedDelay() throws InterruptedException {
        System.out.println("fixedDelay" + new Date());
        Thread.sleep(2000);
    }

//    @Scheduled(fixedRate = 2000L) //每隔两秒执行一次
    public void fixedRate() throws InterruptedException {
        System.out.println("fixedDelay" + new Date());
        Thread.sleep(2000);

    }

    /**
     * cron 表达式
     */

    @Scheduled(cron = "0/3 * * * * ?")
    public void cron() {
        System.out.println("cron" + new Date());
    }
}
