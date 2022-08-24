package com.brianbig.shipping;

import com.brianbig.mailing.EmailSender;
import com.brianbig.mailing.MailSimulator;

public class ShipExample {

    private static final MailSimulator mailSimulator = new EmailSender("user@gmail.com");
    private static final ShippingSimulator simulator = new ShippingSimulator(mailSimulator);
    public static void main(String[] args) {
        simulator.onPackagingStarted("Nairobi");
        simulator.onCourierAssigned("G4S");
        simulator.onCourierUpdate("Nakuru");
        simulator.onDelivered("Kisumu");
    }
}
