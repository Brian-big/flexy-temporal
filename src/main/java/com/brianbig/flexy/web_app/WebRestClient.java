package com.brianbig.flexy.web_app;

import com.brianbig.flexy.common.FlexyRestClient;
import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.orders.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WebRestClient extends FlexyRestClient {


    public Customer addCustomer(Customer customer){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Customer> orderHttpEntity = new HttpEntity<>(customer, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Customer> customer_ = restTemplate.postForEntity(
                baseApiURL + "customers/", orderHttpEntity, Customer.class
        );
        return customer_.getBody();
    }
}
