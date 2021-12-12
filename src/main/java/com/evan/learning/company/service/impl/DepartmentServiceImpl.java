package com.evan.learning.company.service.impl;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.repository.DepartmentRepository;
import com.evan.learning.company.service.DepartmentService;
import com.evan.learning.company.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public DepartmentVo findByDepartmentName(String name) {
        DepartmentVo departmentVo = null;
        Department department = departmentRepository.findByDepartmentName(name);
        if (department != null) {
            departmentVo = new DepartmentVo();
            departmentVo.setId(department.getId());
            departmentVo.setName(department.getDepartmentName());
        }
        return departmentVo;
    }

    @Transactional
    @Override
    public DepartmentVo findByDepartmentId(Integer id) {
        DepartmentVo departmentVo = null;
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            // inisiasi object
            departmentVo = new DepartmentVo();
            departmentVo.setId((department.getId()));
            departmentVo.setName(department.getDepartmentName());
        }
        return departmentVo;
    }

    @Transactional
    @Override
    public List<DepartmentVo> findAll() {
        List<DepartmentVo> listDepartmentVo = null;
        List<Department> listDepartment = departmentRepository.findAll();
        if (listDepartment != null) {
            listDepartmentVo = new ArrayList<>();
            DepartmentVo departmentVo = null;
            for (Department dept : listDepartment) {
                departmentVo = new DepartmentVo();
                departmentVo.setId(dept.getId());
                departmentVo.setName(dept.getDepartmentName());
                listDepartmentVo.add(departmentVo);
            }
        }
        return listDepartmentVo;
    }

    @Transactional
    @Override
    public DepartmentVo save(DepartmentVo departmentVo) {
        if (departmentVo != null) {
            Department department = new Department();
            department.setId(departmentVo.getId());
            department.setDepartmentName(departmentVo.getName());
            departmentRepository.save(department);
            departmentVo.setId(department.getId());
        }
        return departmentVo;
    }

//    @Override
//    public DepartmentVo update(DepartmentVo departmentVo) {
//        Department department = departmentRepository.findById(departmentVo.getId()).orElse(null);
//        if (department != null) {
//            department.setDepartmentName(departmentVo.getName());
//            departmentRepository.save(department);
//            return departmentVo;
//        }
//        return null;
//    }

    @Override
    public DepartmentVo update(Integer departmentId, String departmentName) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null) {
            department.setDepartmentName(departmentName);
            departmentRepository.save(department);

            DepartmentVo departmentVo = new DepartmentVo();
            departmentVo.setId((department.getId()));
            departmentVo.setName(department.getDepartmentName());
            return departmentVo;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            departmentRepository.delete(department);
            return true;
        }
        return false;
    }


}
