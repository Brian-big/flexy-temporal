package com.brianbig.domain.products;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class ProductsService {
    @Autowired ProductRepository repository;

    public List<Product> products(){
        return repository.findAll();
    }

    public Product getProductById(long id){
        return repository.findById(id).orElse(null);
    }

    private Product add(Product product){
        return repository.save(product);
    }
}
