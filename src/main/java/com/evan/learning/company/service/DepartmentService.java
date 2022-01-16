package com.evan.learning.company.service;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.vo.DepartmentVo;

import java.io.Serializable;
import java.util.List;

public interface DepartmentService extends Serializable {
    DepartmentVo findByDepartmentName(String name);

    DepartmentVo findByDepartmentId(Integer id);

    List<DepartmentVo> findAll();

    DepartmentVo save(DepartmentVo departmentVo);

    //    DepartmentVo update(DepartmentVo departmentVo);
    DepartmentVo update(Integer id, String name);

    boolean delete(Integer id);

    DepartmentVo deactivate(Integer sourceDepartmentId, Integer targetDepartmentId);
}
