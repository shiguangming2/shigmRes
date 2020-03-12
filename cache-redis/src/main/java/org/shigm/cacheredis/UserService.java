package org.shigm.cacheredis;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author shigm
 * @date 2019/11/9 16:29
 */
@CacheConfig(cacheNames = "c1")
@Service
public class UserService {

    @Cacheable(key = "#id")
    public User getUserById(Integer id,String name) {
        System.out.println("invoker method..."+id);
        User user = new User();
        user.setAddr("安徽姚李镇");
        user.setId(2);
        user.setName("shigm");
        return user;
    }

    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        System.out.println("delete>>>>"+id);
    }

    @CachePut(key = "#user.id")
    public User update(User user) {
        return user;
    }
}

