package com.brianbig.flexy.domain.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer registerCustomer(Customer customer){
        Customer customerWithEmail = repository.findByEmail(customer.getEmail());
        if (customerWithEmail != null)
            return customerWithEmail;
        return repository.save(
                Customer.builder()
                        .address(customer.getAddress())
                        .email(customer.getEmail())
                        .telephone(customer.getTelephone())
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
