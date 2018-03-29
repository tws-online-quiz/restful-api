package com.example.employee.restfulapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String companyName;

    @NotNull
    private Integer employeesNumber;

    @Transient
    private Set<Employee> employees;

    public Company() {
    }

    public Company(@NotNull String companyName, @NotNull Integer employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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
