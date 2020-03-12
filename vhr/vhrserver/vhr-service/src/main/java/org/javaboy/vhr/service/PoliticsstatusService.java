package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PoliticsstatusMapper;
import org.javaboy.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2020/3/1 21:01
 */
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper mapper;

    public List<Politicsstatus> getAllPolicies() {
        return  mapper.getAllPoliticsstatus();
    }
}
