package com.example.employee.restfulapi.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private String gender;

    @NotNull
    private Integer salary;


    public Employee() {
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Employee setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
