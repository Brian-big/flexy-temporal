package com.brianbig.flexy.shipping;

public interface ShippingListener {

    long estTime = 100;
    public String onPackagingStarted(String warehouseName);
    public String onPackagingReady();
    public String onCourierAssigned(String courierName);
    public String onCourierUpdate(String currentLocation);
    public String onDelivered(String pickUpPoint);
}
