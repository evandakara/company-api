package com.evan.learning.company.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "department")
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String departmentName;
//    private List<Employee> employeeList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    @OneToMany(targetEntity = Employee.class,fetch = FetchType.EAGER)
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void setEmployeeList(List<Employee> employeeList) {
//        this.employeeList = employeeList;
//    }
}


