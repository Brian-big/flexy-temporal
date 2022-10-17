package com.brianbig.flexy.mailing;

abstract public class MailSimulator {
    public abstract String getRecipientAddress();

    public abstract void sendMail(String content, String email);
}
