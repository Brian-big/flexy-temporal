package com.brianbig.flexy.domain.orders;

import com.brianbig.flexy.workflow.OrderWorker;
import com.brianbig.flexy.workflow.OrderWorkflowInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("ordersController")
@RequestMapping("api/orders/")
public class Controller {
    @Autowired
    private  OrderService service;

    private final OrderWorkflowInterface workflow = OrderWorker.getWorkFlow();

    @GetMapping
    public List<Order> getAll(){
        return service.getAllOrders();
    }

    @PostMapping
    public Order makeOrder(@RequestBody Order order){
        return service.makeOrder(order);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id){
        return service.getOrderById(id);
    }

    @PutMapping
    public Order update(@RequestBody Order order){
        return service.updateOrder(order);
    }

}
