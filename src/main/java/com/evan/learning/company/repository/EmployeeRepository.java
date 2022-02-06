package com.evan.learning.company.repository;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.model.Employee;
import com.evan.learning.company.model.EmployeeKey;
import com.evan.learning.company.vo.EmployeeVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, EmployeeKey> {
    Employee findEmployeeByEmployeeKey_Id(Integer id);
    List<Employee> findEmployeeByEmployeeKey_DepartmentId(Integer id);
    List<Employee> findAll();

}
