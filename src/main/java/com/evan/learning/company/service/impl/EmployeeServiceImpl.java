package com.evan.learning.company.service.impl;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.model.Employee;
import com.evan.learning.company.model.EmployeeKey;
import com.evan.learning.company.repository.DepartmentRepository;
import com.evan.learning.company.repository.EmployeeRepository;
import com.evan.learning.company.service.EmployeeService;
import com.evan.learning.company.vo.DepartmentVo;
import com.evan.learning.company.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public EmployeeVo save(EmployeeVo employeeVo) {
        if (employeeVo != null) {
            Employee employee = new Employee();
            EmployeeKey employeeKey = new EmployeeKey();
            employeeKey.setId(employeeVo.getId());
            employeeKey.setDepartmentId(employeeVo.getDepartmentId());
            employee.setName(employeeVo.getName());
            employee.setSalary(employeeVo.getSalary());
            employee.setEmployeeKey(employeeKey);
//            employee.setDepartmentId(employeeVo.getDepartmentId());
            employeeRepository.save(employee);
            employeeVo.setId(employee.getEmployeeKey().getId());
        }
        return employeeVo;
    }

    //    @Override
//    public EmployeeVo findByEmployeeName(String name) {
//        return null;
//    }
    @Transactional
    @Override
    public EmployeeVo findByEmployeeId(Integer id) {
        EmployeeVo employeeVo = null;
        Employee employee = employeeRepository.findEmployeeByEmployeeKey_Id(id);
        if (employee != null) {
            employeeVo = new EmployeeVo();
            employeeVo.setId(id);
            employeeVo.setDepartmentId(employee.getEmployeeKey().getDepartmentId());
            Department department = departmentRepository.findById(employeeVo.getDepartmentId()).orElse(null);
            employeeVo.setName(employee.getName());
            employeeVo.setDepartmentName(department.getDepartmentName());
            employeeVo.setSalary(employee.getSalary());
        }
        return employeeVo;
    }

    @Transactional
    @Override
    public List<EmployeeVo> findAll() {
        List<EmployeeVo> listEmployeeVo = null;
        List<Employee> listEmployee = employeeRepository.findAll();
        if (listEmployee != null) {
            listEmployeeVo = new ArrayList<>();
            EmployeeVo employeeVo = null;
            for (Employee employee : listEmployee) {
                employeeVo = new EmployeeVo();
                employeeVo.setId(employee.getEmployeeKey().getId());
                employeeVo.setDepartmentId(employee.getEmployeeKey().getDepartmentId());
                employeeVo.setName(employee.getName());
                employeeVo.setSalary(employee.getSalary());
                listEmployeeVo.add(employeeVo);
            }
        }
        return listEmployeeVo;
    }

    @Transactional
    @Override
    public List<EmployeeVo> findByDepartmentId(Integer id) {
        List<EmployeeVo> listEmployeeVo = null;
        List<Employee> listEmployee = employeeRepository.findEmployeeByEmployeeKey_DepartmentId(id);
        if (listEmployee != null) {
            listEmployeeVo = new ArrayList<>();
            EmployeeVo employeeVo = null;
            Department department = null;
            for (Employee employee : listEmployee) {
                department = departmentRepository.findById(employee.getEmployeeKey().getDepartmentId()).orElse(null);
                employeeVo = new EmployeeVo();
                employeeVo.setId(employee.getEmployeeKey().getId());
                employeeVo.setDepartmentId(employee.getEmployeeKey().getDepartmentId());
                employeeVo.setName(employee.getName());
                employeeVo.setSalary(employee.getSalary());
                employeeVo.setDepartmentName(department.getDepartmentName());
                listEmployeeVo.add(employeeVo);
            }
        }
        return listEmployeeVo;
    }


}
