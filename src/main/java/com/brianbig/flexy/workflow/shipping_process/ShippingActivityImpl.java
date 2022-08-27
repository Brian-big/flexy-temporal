package com.brianbig.flexy.workflow.shipping_process;

import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.workflow.ApiHelper;
import com.brianbig.flexy.workflow.Shared;

import javax.annotation.Nullable;

public class ShippingActivityImpl implements ShippingActivity {

    String shipmentStatus = "";
    private final ApiHelper apiHelper = new ApiHelper();
    @Override
    public Order startPackaging(Order order, @Nullable String warehouse) {
        shipmentStatus = "PACKAGING";
        order.setShipmentStatus(shipmentStatus);
        String warehouse_ = "";
        if (warehouse == null) warehouse_ = Shared.MAIN_WAREHOUSE; else  warehouse_ = warehouse;
        shippingSimulator.onPackagingStarted(order, warehouse_);
        return apiHelper.updateOrder(order);
    }

    @Override
    public Order assignCourier(Order order, String name) {
        shipmentStatus = "SHIPPING STARTED";
        order.setShipmentStatus(shipmentStatus);
        shippingSimulator.onCourierAssigned(order,name);
        return apiHelper.updateOrder(order);
    }

    @Override
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    @Override
    public Order deliverPackage(Order order, String pickupLocation) {
        shipmentStatus = "DELIVERED";
        order.setShipmentStatus(shipmentStatus);
        shippingSimulator.onDelivered(order, order.getCustomer().getAddress());
        return apiHelper.updateOrder(order);
    }
}
