package com.brianbig.flexy.mailing;

public class EmailSender extends MailSimulator {
    public void setEmail(String email) {
        this.email = email;
    }

    private  String email;

    @Override
    public String getRecipientAddress() {
        return email;
    }

    @Override
    public void sendMail(String content,String email) {
        System.out.println("to: "+ email+" content: " +content );
    }

}
