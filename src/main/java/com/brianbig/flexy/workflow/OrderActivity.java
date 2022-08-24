package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.customer.CustomerService;
import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.domain.orders.OrderService;
import com.brianbig.flexy.mailing.EmailSender;
import com.brianbig.flexy.mailing.MailSimulator;
import com.brianbig.flexy.shipping.ShippingSimulator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

public class OrderActivity implements OrderActivityInterface{
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    private final EmailSender mailSimulator = new EmailSender();
    private final ShippingSimulator shippingSimulator = new ShippingSimulator(mailSimulator);

    private String shipmentStatus = "";
    @Override
    public Order makeOrder(Order order) {
        Order order_ = orderService.makeOrder(order);
        mailSimulator.setEmail(order_.getCustomer().getEmail());
        shipmentStatus = order_.getShipmentStatus();
        return order_;
    }

    @Override
    public Order findOrderById(long id) {
        return orderService.getOrderById(id);
    }

    @Override
    public Order startPackaging(Order order, @Nullable String wareHouse) {
        order.setShipmentStatus("PACKAGING");
        Order order_ = orderService.updateOrder(order);
        shipmentStatus = wareHouse == null ? shippingSimulator.onPackagingStarted(Shared.MAIN_WAREHOUSE)
                : shippingSimulator.onPackagingStarted(wareHouse);

        return order_;
    }

    @Override
    public Order assignCourier(Order order,String name) {
        order.setShipmentStatus("IN TRANSIT");
        Order order_ = orderService.updateOrder(order);
        shippingSimulator.onCourierAssigned(name);
        return order_;
    }

    @Override
    public Order deliverPackage(Order order, String pickupLocation) {
        order.setShipmentStatus("DELIVERED");
        Order order_ = orderService.updateOrder(order);
        shipmentStatus =shippingSimulator.onDelivered(pickupLocation);
        return order_;
    }

    @Override
    public String getShipmentStatus() {
        return shipmentStatus;
    }
}
