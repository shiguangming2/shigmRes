package org.shigm.securitydymic.service;

import org.shigm.securitydymic.bean.Menu;
import org.shigm.securitydymic.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2019/11/17 22:49
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper mapper;
    public List<Menu> getAllMenus(){
        return  mapper.getAllMenus();
    }
}
