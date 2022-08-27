package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.orders.Order;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class OrderWorkflow implements OrderWorkflowInterface{

    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(60))
            .build();

    private final OrderActivityInterface orderActivity = Workflow.newActivityStub(
            OrderActivityInterface.class, options
    );

    @Override
    public Order makeOrder(Order order) {
       return orderActivity.makeOrder(order);
    }

    @Override
    public Order startPackaging(long id, String warehouse) {
        Order order = orderActivity.findOrderById(id);
        orderActivity.startPackaging(order, warehouse);

        return order;
    }

    @Override
    public Order assignCourier(long id, String courierName) {
        Order order = orderActivity.findOrderById(id);
        orderActivity.assignCourier(order, courierName);
        return order;
    }

    @Override
    public Order deliverPackage(long id, String pickupLocation) {
        Order order = orderActivity.findOrderById(id);
        orderActivity.deliverPackage(order, pickupLocation);
        return null;
    }

    @Override
    public String getShipmentStatus() {
        return null;
    }
}
