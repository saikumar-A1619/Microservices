package com.employeemicroservices.service;


import com.employeemicroservices.Dto.EmployeeDto;
import com.employeemicroservices.clint.AddressClint;
import com.employeemicroservices.entity.EmployeeEntity;
import com.employeemicroservices.repository.EmployeeRepository;
import com.employeemicroservices.response.AddressResponse;
import com.employeemicroservices.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AddressClint  addressClint;

//    public EmployeeResponse getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
//        EmployeeResponse employeeResponse = modelMapper.map(employeeEntity, EmployeeResponse.class);
//
//        AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id);
//        employeeResponse.setAddressResponse(addressResponse);
//        return employeeResponse;
//    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeEntity savedEmployee=employeeRepository.save(employeeDto.getEmployeeEntity());
        if (savedEmployee!=null&&savedEmployee.getId()>0){
           addressClint.saveAddress(employeeDto.getAddressResponse(),savedEmployee.getId().toString());
        }
        System.out.println(employeeDto);
        System.out.println(employeeDto.getAddressResponse().getId());
        return employeeDto;
    }

    public EmployeeDto getaddress(Long id){
        EmployeeDto employeeDto=new EmployeeDto();
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeDto.setEmployeeEntity(employeeEntity);
        employeeDto.setAddressResponse(addressClint.getaddress(id));
        return employeeDto;
    }
}
