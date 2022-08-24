package com.brianbig.flexy.domain.products;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductsService {
    @Autowired ProductRepository repository;

    public List<Product> products(){
        return repository.findAll();
    }

    public Product getProductById(long id){
        return repository.findById(id).orElse(null);
    }

    public Product add(Product product){
        return repository.save(product);
    }
}
