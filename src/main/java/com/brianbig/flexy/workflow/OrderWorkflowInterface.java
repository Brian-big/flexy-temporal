package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.orders.Order;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflowInterface {

    @WorkflowMethod
    Order makeOrder(Order order);

    @QueryMethod
    String getShipmentStatus();

    @QueryMethod
    Order startPackaging(long id, String warehouse);

    @QueryMethod
    Order assignCourier(long id, String courierName);

    @QueryMethod
    Order deliverPackage(long id, String pickupLocation);
}
