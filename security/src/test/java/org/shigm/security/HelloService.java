package org.shigm.security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author shigm
 * @date 2019/11/12 22:47
 */
@Service
public class HelloService {
    @PreAuthorize("hasAnyRole('user')")
    public String hello() {
        return "hell";
    }

    @Secured("ROLE_user")
    public String hello1() {
        return "hell";
    }
}
