package com.evan.learning.company.controller;

import com.evan.learning.company.service.impl.EmployeeServiceImpl;
import com.evan.learning.company.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(value = "/save")
    public EmployeeVo save(@RequestBody EmployeeVo employeeVo) {
        return employeeServiceImpl.save(employeeVo);
    }

//    @GetMapping(value = "/findByName", produces = "application/json")
//    public EmployeeVo findByName(@RequestParam(required = true, name = "employeeName") String name) {
//        EmployeeVo employee = employeeServiceImpl.findByEmployeeName(name);
//        return employee;
//    }

    @GetMapping(value = "/findByEmployeeId", produces = "application/json")
    public EmployeeVo findById(@RequestParam(required = true, name = "employeeId") Integer employeeId) {
        EmployeeVo employee = employeeServiceImpl.findByEmployeeId(employeeId);
        return employee;
    }

    @GetMapping(value = "/findByDepartmentId", produces = "application/json")
    public List<EmployeeVo> findByDepartmentId(@RequestParam(required = true, name = "departmentId") Integer departmentId) {
        List<EmployeeVo> employee = employeeServiceImpl.findByDepartmentId(departmentId);
        return employee;
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public List<EmployeeVo> findAll() {
        List<EmployeeVo> listEmployee = employeeServiceImpl.findAll();
        return listEmployee;
    }


}
