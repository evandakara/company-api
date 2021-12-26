package com.evan.learning.company.service;

import com.evan.learning.company.vo.EmployeeVo;

import java.io.Serializable;
import java.util.List;

public interface EmployeeService extends Serializable {
    EmployeeVo save(EmployeeVo employeeVo);
    EmployeeVo findByEmployeeId(Integer id);
//    EmployeeVo findByEmployeeName(String name);
    List<EmployeeVo> findAll();
    List<EmployeeVo> findByDepartmentId(Integer id);
}
