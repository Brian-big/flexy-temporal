package com.brianbig.flexy.common;

import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.domain.products.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

abstract public class FlexyRestClient {
    protected final String baseApiURL = "http://localhost:9090/api/";
    protected final RestTemplate restTemplate = new RestTemplate();

    public List<Product> fetchProducts() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity(
                baseApiURL + "products/",
                Product[].class
        );
        return List.of(response.getBody());
    }
    public List<Customer> fetchCustomers() {
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(
                baseApiURL + "customers/",
                Customer[].class
        );
        return List.of(response.getBody());
    }
    public List<Order> fetchOrders() {
        ResponseEntity<Order[]> response = restTemplate.getForEntity(
                baseApiURL + "orders/",
                Order[].class
        );
        return List.of(response.getBody());
    }

    public Order getOrderById(long id) {
        ResponseEntity<Order> response = restTemplate.getForEntity(
                baseApiURL + "orders/"+id, Order.class
        );
        return response.getBody();
    }
}
