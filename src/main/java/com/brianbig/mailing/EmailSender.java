package com.brianbig.mailing;

public class EmailSender extends MailSimulator {
    private final String email;
    public EmailSender(String email) {
        this.email = email;
    }

    @Override
    public String getRecipientAddress() {
        return email;
    }

}
