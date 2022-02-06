package com.evan.learning.company.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table
@Entity
//@IdClass(EmployeeKey.class)
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private EmployeeKey employeeKey;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @Id
//    private int departmentId;
    private String name;
    private BigDecimal salary;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(int departmentId) {
//        this.departmentId = departmentId;
//    }

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
