package org.shigm.securitydymic.service;

import org.shigm.securitydymic.bean.User;
import org.shigm.securitydymic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * @author shigm
 * @date 2019/11/17 21:17
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
   UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.loadUserByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException("用户名未定义");
        }
        user.setRoles(userMapper.getRolesById(user.getId()));
        return user;
    }
}
