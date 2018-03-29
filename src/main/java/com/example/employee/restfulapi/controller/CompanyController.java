package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping(value = "")
    public ResponseEntity getCompanies() throws Exception {
        List<Company> companyList = companyRepository.findAll();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCompanyById(@PathVariable long id) throws Exception {
        Company company = companyRepository.findOne(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/employees")
    public ResponseEntity getCompanyEmployee(@PathVariable long id) throws Exception {
        Company company = companyRepository.findOne(id);
        Set<Employee> employees = company.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/page/{page}/pageSize/{pageSize}")
    public ResponseEntity getCompanyPage(@PathVariable int page, @PathVariable int pageSize) throws Exception {

        List<Company> companyList = companyRepository.findAll();
        List<Company> result = new ArrayList<>();
        int count = companyRepository.findAll().size();
        int startIndex = (page - 1) * pageSize;
        int endIndex = page * pageSize;
        for (int i = startIndex; i < endIndex; i++) {
            result.add(companyList.get(i));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}


