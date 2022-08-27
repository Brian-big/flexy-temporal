package com.brianbig.flexy.workflow.order_process;

import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.mailing.EmailSender;
import com.brianbig.flexy.shipping.ShippingSimulator;
import com.brianbig.flexy.workflow.ApiHelper;

public class OrderActivityImpl implements OrderActivity {

    private final ApiHelper apiHelper = new ApiHelper();

    private final EmailSender mailSimulator = new EmailSender();
    private final ShippingSimulator shippingSimulator = new ShippingSimulator(mailSimulator);

    private String shipmentStatus = "";
    private String customerEmail = "";
    @Override
    public Order makeOrder(Order order) {
        return apiHelper.makeOrder(order);
    }

    @Override
    public String getOrderStatus() {
        return shipmentStatus;
    }
    @Override
    public String getCustomerEmail() {
        return shipmentStatus;
    }
}
