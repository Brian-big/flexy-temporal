package com.brianbig.flexy.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("customerController")
@RequestMapping("api/customers")
public class Controller {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll(){
        return service.getAllCustomers();
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer){
        return service.registerCustomer(customer);
    }


}
