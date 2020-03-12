package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.JobLevelMapper;
import org.javaboy.vhr.model.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shigm
 * @date 2020/2/17 10:12
 */
@Service
public class JobLevelService {

    @Autowired
    JobLevelMapper mapper;


    public List<JobLevel> getAllJobLevels() {
        return mapper.getAllJobLevels();
    }


    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return mapper.insertSelective(jobLevel);
    }


    public Integer updateJobLever(JobLevel jobLevel){
        return mapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletePatch(Integer[] ids) {
        return mapper.deleteJobLevelsByIds(ids);
    }
}
