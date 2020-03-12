package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.mapper.MenuRoleMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shigm
 * @date 2020/1/6 22:20
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper mapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenuByHrId() {
        //登录的用户信息 保存在security中
        return mapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    //    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return mapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return mapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer id) {
        return mapper.getMidsByRid(id);
    }

    @Transactional
    public boolean updateMidsByRid(Integer[] mids, Integer rid) {
       menuRoleMapper.deleteByRid(rid);
       Integer result= menuRoleMapper.insertRecord(rid,mids);
       return result==mids.length;
    }
}
