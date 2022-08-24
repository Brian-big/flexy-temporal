package com.brianbig.flexy.domain.orders;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository repository;

    public List<Order> getAllOrders(){
        return repository.findAll();
    }
    public Order makeOrder(Order order){
        Order order_ =  Order.builder()
                .customer(order.getCustomer())
                .product(order.getProduct())
                .build();
        return repository.save(order_);
    }

    public Order getOrderById(long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Order updateOrder(Order order){
        if (order.getShipmentStatus().equals(""))
            return null;
        Order orderById = repository.findById(order.getId()).orElse(null);
        if (orderById == null) return null;
        if (Objects.equals(order.getShipmentStatus(), orderById.getShipmentStatus()))
            return orderById;
        orderById.setShipmentStatus(order.getShipmentStatus());
        return orderById;
    }


}
