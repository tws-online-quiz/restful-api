package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(value = "/")
    ResponseEntity getCompanies() throws Exception {
        Map<String, String> result = new HashMap<>();
        List<Company> companyList = companyRepository.findAll();
//        Iterator<Company> companyIterator = companyList.listIterator();
//        while(companyIterator.hasNext())
//        {
//            Company company = companyIterator.next();
//            company.getCompanyName();
//        }
//
//        result.put("step", "2");
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }
}


