package com.employeemicroservices.Dto;


import com.employeemicroservices.entity.EmployeeEntity;
import com.employeemicroservices.response.AddressResponse;
import lombok.Data;

@Data
public class EmployeeDto {

    private AddressResponse addressResponse;
    private EmployeeEntity employeeEntity;
}
