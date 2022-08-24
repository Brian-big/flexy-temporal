package com.brianbig.flexy.workflow;

import com.brianbig.flexy.domain.orders.Order;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import io.temporal.workflow.QueryMethod;

import javax.annotation.Nullable;

@ActivityInterface
public interface OrderActivityInterface {

    @ActivityMethod
    Order makeOrder(Order order);

    @ActivityMethod
    Order startPackaging(Order order, @Nullable String warehouse);

    @ActivityMethod
    Order assignCourier(Order order,String name);

    @QueryMethod
    String getShipmentStatus();

    @ActivityMethod
    Order findOrderById(long id);

    @ActivityMethod
    Order deliverPackage(Order order, String pickupLocation);
}
