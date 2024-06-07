package com.employeemicroservices.controller;

import com.employeemicroservices.Dto.EmployeeDto;
import com.employeemicroservices.entity.EmployeeEntity;
import com.employeemicroservices.response.EmployeeResponse;
import com.employeemicroservices.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServices employeeServices;


//    @GetMapping(value = "/employees/{id}")
//    public EmployeeResponse getEmployeeDetails(@PathVariable("id") Long id) {
//        EmployeeResponse employeeResponse = employeeServices.getEmployeeById(id);
//        return employeeResponse;
//    }

    @PostMapping(value = "/employees")
    public EmployeeDto saveEmployeeDetails(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeResponse = employeeServices.saveEmployee(employeeDto);
        return employeeResponse;
    }


    @GetMapping(value = "/employee/{id}")
    public EmployeeDto getEmployeeDto(@PathVariable("id") Long id) {
        EmployeeDto employeeResponse = employeeServices.getaddress(id);
        return employeeResponse;
    }
}
