package org.shigm.securitydb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.shigm.securitydb.bean.Role;
import org.shigm.securitydb.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shigm
 * @date 2019/11/13 22:29
 */
@Mapper
@Component
public interface UserMapper  {
    User loadUserByUsername(String name);
    List<Role> getRolesById(Integer id);
}
