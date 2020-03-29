package org.shgigm.provider;

import org.shigm.commons.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2020/3/29 16:33
 */
@RestController
public class UserController {

    @PostMapping("/addUser")
    public User addUser(User user) {
        return user;
    }

    @PostMapping("/addUser2")
    public User addUser2(@RequestBody User user) {
        return user;
    };
}
