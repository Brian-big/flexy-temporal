package com.brianbig.flexy.domain.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("productsController")
@RequestMapping("api/products")
public class Controller {
    @Autowired
    private ProductsService service;

    @GetMapping
    public List<Product> all(){
        return service.products();
    }

    @PostMapping
    public Product add(@RequestBody Product product){
        return service.add(product);
    }

    @GetMapping("/{id}")
    public  Product getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }
}
