package com.evan.learning.company.repository;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.vo.DepartmentVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findByDepartmentName(String name);
    List<Department> findAll();
}