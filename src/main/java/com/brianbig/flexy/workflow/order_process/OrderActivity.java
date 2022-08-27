package com.brianbig.flexy.workflow.order_process;

import com.brianbig.flexy.domain.orders.Order;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import io.temporal.workflow.QueryMethod;

@ActivityInterface
public interface OrderActivity {

    @ActivityMethod
    Order makeOrder(Order order);

    @QueryMethod
    String getOrderStatus();

    @ActivityMethod
    String getCustomerEmail();
}
