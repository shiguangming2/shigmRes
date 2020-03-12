package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shigm
 * @date 2020/2/29 15:25
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper mapper;

   /* public RespPageBean getEmployeeByPage(Integer page, Integer size, String name) {
        if (page != null && size != null) {
            page = page * size - 1;
        }
        List<Employee> data=mapper.getEmployeeByPage(page,size,name);
        Long total=mapper.getTotal(name);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }*/

    public Integer addEmp(Employee employee) {
        return mapper.insertSelective(employee);
    }

//    public Integer getMaxId() {
//        return mapper.getMaxId();
//    }

    public Integer deleteByEmpId(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer addEmps(List<Employee> list) {
        return mapper.addEmps(list);
    }
}
