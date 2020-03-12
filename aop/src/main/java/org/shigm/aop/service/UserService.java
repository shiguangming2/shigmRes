package org.shigm.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserNameById(Integer id){
        System.out.println("getUserNameById");
        return "shigm";
    }

    public void deleteUserById(Integer id){
        System.out.println("deleteUserById");
    }
}
