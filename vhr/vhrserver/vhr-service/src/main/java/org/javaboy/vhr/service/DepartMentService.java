package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2020/2/19 16:11
 */
@Service
public class DepartMentService {

    @Autowired
    DepartmentMapper mapper;

    public List<Department> getAllDepts() {
        return mapper.getAllDepartmentsByParentId(-1);
    }

    public void add(Department department) {
        department.setEnabled(true);
        mapper.addDep(department);
    }

    public void deleteDep(Department department) {
        mapper.deleteDepById(department);
    }

    public List<Department> getAllDeptsWithOutChildren() {
        return  mapper.getAllDepartmentsWithOutChildren();
    }
}
