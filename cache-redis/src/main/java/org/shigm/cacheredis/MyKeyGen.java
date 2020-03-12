package org.shigm.cacheredis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author shigm
 * @date 2019/11/9 17:25
 */
@Component
public class MyKeyGen implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {

        return method.getName() + ":" + Arrays.toString(objects);
    }
}
