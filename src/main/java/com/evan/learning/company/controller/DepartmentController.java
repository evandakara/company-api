package com.evan.learning.company.controller;

import com.evan.learning.company.model.Department;
import com.evan.learning.company.service.impl.DepartmentServiceImpl;
import com.evan.learning.company.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @GetMapping(value = "/findByName", produces = "application/json")
    public DepartmentVo findByName(@RequestParam(required = true, name = "departmentName") String departmentName) {
        DepartmentVo department = departmentServiceImpl.findByDepartmentName(departmentName);
        return department;
    }

    @GetMapping(value = "/findById", produces = "application/json")
    public DepartmentVo findById(@RequestParam(required = true, name = "departmentId") Integer departmentId) {
        DepartmentVo department = departmentServiceImpl.findByDepartmentId(departmentId);
        return department;
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public List<DepartmentVo> findAll() {
        List<DepartmentVo> listDepartment = departmentServiceImpl.findAll();
        return listDepartment;
    }

    @PostMapping(value = "/save")
    public DepartmentVo save(@RequestBody DepartmentVo departmentVo) {
        return departmentServiceImpl.save(departmentVo);
    }

    //    @PutMapping(value = "/update", produces = "application/json")
//    public DepartmentVo update(@RequestBody DepartmentVo departmentVo){
//        return departmentServiceImpl.update(departmentVo);
//
//    }
    @PutMapping(value = "/update", produces = "application/json")
    public DepartmentVo update(@RequestParam(required = true, name = "id") Integer departmentId,
                               @RequestParam(required = true, name = "name") String departmentName) {
        return departmentServiceImpl.update(departmentId, departmentName);
    }

    @DeleteMapping(value = "/delete")
    public boolean delete(@RequestParam(required = true, name = "id") Integer departmentId) {
        return departmentServiceImpl.delete(departmentId);
    }

    @PatchMapping(value = "/deactivate")
    public DepartmentVo deactivate(@RequestParam(required = true, name = "source") Integer sourceDepartmentId,
                                   @RequestParam(required = true, name = "target") Integer targetDepartmentId) {
        return departmentServiceImpl.deactivate(sourceDepartmentId, targetDepartmentId);
    }
}