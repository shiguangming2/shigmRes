package org.shigm.aop;

import org.shigm.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/test1")
    public String get(Integer id){

        return service.getUserNameById(id);
    }

    @GetMapping("/test2")
    public void delete(Integer id){
        service.deleteUserById(id);
    }
}
