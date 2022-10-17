package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.workflow.order_process.OrderActivity;
import com.brianbig.flexy.workflow.shipping_process.ShippingActivity;
import com.brianbig.flexy.workflow.shipping_process.ShippingActivityImpl;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import javax.annotation.Nullable;
import java.time.Duration;

public class OrderWorkflow implements OrderWorkflowInterface{

    String customerEmail = "";
    String shipmentStatus = "";

    ActivityOptions options = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(60))
            .build();

    private final OrderActivity orderActivity = Workflow.newActivityStub(
            OrderActivity.class, options
    );

    private final ShippingActivity shippingActivity = Workflow.newActivityStub(
            ShippingActivity.class, options
    );
    @Override
    public Order makeOrder(Order order) {
        System.out.println("Making Order....");
        Order order_ = orderActivity.makeOrder(order);
        customerEmail = order_.getCustomer().getEmail();
        Order packagedOrder = startPackaging(order_, null);
        shipmentStatus = packagedOrder.getShipmentStatus();
        System.out.println(order_);
        return order_;
    }

    @Override
    public Order startPackaging(Order order, @Nullable String warehouse) {
        return shippingActivity.startPackaging(order, warehouse);
    }

    @Override
    public Order assignCourier(Order order, String courierName) {
        return shippingActivity.assignCourier(order, courierName);
    }

    @Override
    public Order deliverPackage(Order order, String pickupLocation) {
        return shippingActivity.deliverPackage(order, pickupLocation);
    }

    @Override
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    @Override
    public String getCustomerEmail() {
        return customerEmail;
    }
}
