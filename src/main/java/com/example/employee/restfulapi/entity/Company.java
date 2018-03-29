package com.example.employee.restfulapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "companyName")
    private String companyName;

    @NotNull
    @Column(name = "employeesNumber")
    private Integer employeesNumber;

    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
