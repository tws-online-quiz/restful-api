package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "")
    ResponseEntity getEmployees() throws Exception {
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getEmployeeById(@PathVariable long id) throws Exception {
        Employee employee = employeeRepository.findOne(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/page/{page}/pageSize/{pageSize}")
    public ResponseEntity getEmployeePage(@PathVariable int page, @PathVariable int pageSize) throws Exception {

        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> result = new ArrayList<>();
        int count = employeeRepository.findAll().size();
        int startIndex = (page - 1) * pageSize;
        int endIndex = page * pageSize;
        for (int i = startIndex; i < endIndex; i++) {
            result.add(employeeList.get(i));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/male")
    ResponseEntity getEmployeeMale(@RequestParam("gender") String gender) throws Exception {
        List<Employee> employeeList = employeeRepository.findByGender(gender);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity addCompany(@RequestBody Map<String, String> employeeInfo) throws Exception {
        String name = employeeInfo.get("name");
        int age = Integer.parseInt(employeeInfo.get("age"));
        String gender = employeeInfo.get("gender");
        int salary = Integer.parseInt(employeeInfo.get("salary"));
        Long companyId = (long) Integer.parseInt(employeeInfo.get("companyId"));
        employeeRepository.save(new Employee(name, age, gender, salary, companyId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateCompany(@PathVariable long id, @RequestBody Map<String, String> employeeInfo) throws Exception {
        int age = Integer.parseInt(employeeInfo.get("age"));
        String gender = employeeInfo.get("gender");
        Employee employee = employeeRepository.findOne(id);
        employee.setAge(age);
        employee.setGender(gender);
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCompany(@PathVariable long id) throws Exception {
        employeeRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


