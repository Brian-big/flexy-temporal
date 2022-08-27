package com.brianbig.flexy.shipping;

import com.brianbig.flexy.domain.orders.Order;

public interface ShippingListener {


    long estTime = 100;
    public String onPackagingStarted(Order order,String warehouseName);
    public String onPackagingReady(Order order);
    public String onCourierAssigned(Order order, String courierName);
    public String onCourierUpdate(Order order, String currentLocation);
    public String onDelivered(Order order, String pickUpPoint);
}
