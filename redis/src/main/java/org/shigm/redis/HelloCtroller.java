package org.shigm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * auth shigm
 */
@RestController
public class HelloCtroller {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/set")
    public void setVal(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name", "shigm");


    }
    @GetMapping("get")
    public void getVal(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        System.out.println(ops.get("name"));
    }
}
