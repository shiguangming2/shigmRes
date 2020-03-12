package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.RoleMapper;
import org.javaboy.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2020/2/17 20:37
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper mapper;

    public List<Role> getAllRoles() {
        return mapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return mapper.insert(role);
    }

    public Integer deleteRole(Integer id) {
         return mapper.deleteByPrimaryKey(id);
    }
}
