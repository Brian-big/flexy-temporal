package com.brianbig.flexy.mailing;


public class SMSSender extends MailSimulator{

    private final int mobileNumber;

    public SMSSender(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    @Override
    public String getRecipientAddress() {
        return parseMobileNumber(mobileNumber);
    }

    @Override
    public void sendMail(String content, String email) {

    }

    private String parseMobileNumber(int mobileNumber) {
        return "+254" + mobileNumber;
    }

}
