package com.employeemicroservices.clint;


import com.employeemicroservices.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressClint {

    @Autowired
    private RestTemplate restTemplate;

    public void saveAddress(AddressResponse addressResponse,String id){


        System.out.println(addressResponse.getId());
        addressResponse.setEmployeeid(id);

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AddressResponse> httpEntity=new HttpEntity<>(addressResponse,headers);

        restTemplate.exchange("http://localhost:8081/address-service/address", HttpMethod.POST,httpEntity,String.class);
    }

    public AddressResponse getaddress(Long id){
        AddressResponse addressResponse1= restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id);
        return addressResponse1;
    }
}
