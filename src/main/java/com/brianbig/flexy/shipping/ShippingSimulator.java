package com.brianbig.flexy.shipping;

import com.brianbig.flexy.mailing.MailSimulator;


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
    public String onPackagingStarted(String warehouseName) {
        setWareHouse(warehouseName);
        mailSimulator.sendMail("Packaging started at: " + warehouseName);
        return warehouseName;
    }

    @Override
    public String onPackagingReady() {
        return wareHouse;
    }

    @Override
    public String onCourierAssigned(String courierName) {
        mailSimulator.sendMail("Your package assigned to: " + courierName + " for delivery.\nEstimated" +
                " time: " + estTime);
        return courierName;
    }

    @Override
    public String onCourierUpdate(String currentLocation) {
        mailSimulator.sendMail("Your package location update: " + currentLocation);
        return currentLocation;
    }

    @Override
    public String onDelivered(String pickUpPoint) {
        mailSimulator.sendMail("Your package has been delivered to our pick up point: " + pickUpPoint +
                "\nThank you for shopping with us");
        return pickUpPoint;
    }
}
