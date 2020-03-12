package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.NationMapper;
import org.javaboy.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2020/3/1 20:53
 */
@Service
public class NationService {

    @Autowired
    NationMapper mapper;

    public List<Nation> getAllNations() {
        return mapper.getAllNations();
    }
}
