package com.brianbig.flexy.shipping;

import com.brianbig.flexy.mailing.EmailSender;
import com.brianbig.flexy.mailing.MailSimulator;

public class ShipExample {

    private static final MailSimulator mailSimulator = new EmailSender();
    private static final ShippingSimulator simulator = new ShippingSimulator(mailSimulator);
    public static void main(String[] args) {
//        mailSimulator.sendMail("user@flexy.ca");
//        simulator.onPackagingStarted("Nairobi");
//        simulator.onCourierAssigned("G4S");
//        simulator.onCourierUpdate("Nakuru");
//        simulator.onDelivered("Kisumu");
    }
}
