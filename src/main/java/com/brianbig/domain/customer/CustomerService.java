package com.brianbig.domain.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer registerCustomer(String name, String email){
        return repository.save(
                Customer.builder()
                        .email(email)
                        .build()
        );
    }
    public Customer getCustomerById(long id){
        return repository.findById(id).orElse(null);
    }
    public Customer getCustomerByEmail(String email){
        return  repository.findByEmail(email);
    }
}
