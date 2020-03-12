package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shigm
 * @date 2020/2/14 11:18
 */
@Service
public class PositionService {


    @Autowired
    PositionMapper mapper;

    public List<Position> getAllPositions(){

        return mapper.getAllPositions();
    };

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
     return mapper.insertSelective(position);
    }

    public Integer updatePosiion(Position position) {

        return mapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletePosPatch(Integer[] ids) {
        return mapper.deletePositionsByIds(ids);
    }
}
