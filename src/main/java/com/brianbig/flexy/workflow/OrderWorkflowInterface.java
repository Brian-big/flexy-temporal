package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.orders.Order;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import javax.annotation.Nullable;

@WorkflowInterface
public interface OrderWorkflowInterface {

    @WorkflowMethod
    Order makeOrder(Order order);

    @QueryMethod
    Order assignCourier(Order order, String courierName);


    @QueryMethod
    Order deliverPackage(Order order, String pickupLocation);

    @QueryMethod
    String getShipmentStatus();
    @QueryMethod
    String getCustomerEmail();

    @QueryMethod
    Order startPackaging(Order order, @Nullable String warehouse);

}
