package com.brianbig.flexy.shipping;

import com.brianbig.flexy.domain.orders.Order;
import com.brianbig.flexy.mailing.MailSimulator;
import org.aspectj.weaver.ast.Or;


public class ShippingSimulator implements ShippingListener {

    private final MailSimulator mailSimulator;

    private String wareHouse;

    public ShippingSimulator(MailSimulator mailSimulator) {
        this.mailSimulator = mailSimulator;
    }

    public void setWareHouse(String wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public String onPackagingStarted(Order order, String warehouseName) {
        setWareHouse(warehouseName);
        mailSimulator.sendMail("Packaging started at: " + warehouseName,
                order.getCustomer().getEmail());
        return warehouseName;
    }

    @Override
    public String onPackagingReady(Order order) {
        return wareHouse;
    }

    @Override
    public String onCourierAssigned(Order order, String courierName) {
        mailSimulator.sendMail("Shipping for your order item: " + order.getProduct().getName()
                        + " started by courier: "
                        + courierName + " estimated time is: " + estTime,
                order.getCustomer().getEmail());
        return courierName;
    }

    @Override
    public String onCourierUpdate(Order order,String currentLocation) {
        mailSimulator.sendMail("Your package location update: " + currentLocation,
                order.getCustomer().getAddress()
                );
        return currentLocation;
    }

    @Override
    public String onDelivered(Order order, String pickUpPoint) {
        mailSimulator.sendMail("Your package has been delivered to our pick up point: " + pickUpPoint +
                "\nThank you for shopping with us!",
                order.getCustomer().getEmail()
                );
        return pickUpPoint;
    }
}
