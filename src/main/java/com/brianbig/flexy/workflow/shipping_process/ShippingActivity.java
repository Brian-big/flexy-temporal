package com.brianbig.flexy.workflow.shipping_process;

import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.mailing.EmailSender;
import com.brianbig.flexy.shipping.ShippingSimulator;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import io.temporal.workflow.QueryMethod;

import javax.annotation.Nullable;

@ActivityInterface
public interface ShippingActivity {
    EmailSender emailSender = new EmailSender();

    ShippingSimulator shippingSimulator = new ShippingSimulator(emailSender);

    @ActivityMethod
    Order startPackaging(Order order, @Nullable String warehouse);

    @ActivityMethod
    Order assignCourier(Order order,String name);

    @QueryMethod
    String getShipmentStatus();

    @ActivityMethod
    Order deliverPackage(Order order, String pickupLocation);
}
