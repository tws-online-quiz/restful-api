package com.example.employee.restfulapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class EmployeeController {


    @PostMapping(value = "/registerState")
    ResponseEntity save(@RequestBody Map<String, String> registerState) throws Exception {

        String address = registerState.get("address");

        Map<String, String> result = new HashMap<>();
        result.put("step", "2");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}


