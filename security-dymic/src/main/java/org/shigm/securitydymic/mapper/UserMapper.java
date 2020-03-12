package org.shigm.securitydymic.mapper;

import org.shigm.securitydymic.bean.Role;
import org.shigm.securitydymic.bean.User;

import java.util.List;

/**
 * @author shigm
 * @date 2019/11/17 21:14
 */
public interface UserMapper {

    public User loadUserByUsername(String username);

    public List<Role> getRolesById(Integer id);
}
