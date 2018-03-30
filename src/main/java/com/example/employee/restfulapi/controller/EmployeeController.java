package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    public ResponseEntity getAllEmployees() throws Exception {
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOneEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findOne(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping(value = "/page/{page}/pageSize/{pageSize}")
    public ResponseEntity getEmployeePage(@PathVariable int page, @PathVariable int pageSize) throws Exception {
        Pageable pageable = new PageRequest(page-1, pageSize);
        Page employees = employeeRepository.findAll(pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/male")
    public ResponseEntity getEmployeeByGender() throws Exception {
        List<Employee> employeeList = employeeRepository.findByGender("male");
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity addEmployee(@RequestBody Employee employee) throws Exception {
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) throws Exception {
        Employee employee = employeeRepository.findOne(id);
        employee.setAge(newEmployee.getAge());
        employee.setGender(newEmployee.getGender());
        employee.setName(newEmployee.getName());
        employee.setSalary(newEmployee.getSalary());
        employee.setCompanyId(newEmployee.getCompanyId());
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEmployee(@PathVariable long id) throws Exception {
        employeeRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


