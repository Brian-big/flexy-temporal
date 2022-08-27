package com.brianbig.flexy.mailing;

abstract public class MailSimulator {
    public abstract String getRecipientAddress();
    private long delayTime = 5;

    public void setDelayTime(int delayTime){
        this.delayTime = delayTime;
    }


    public void sendMail(String content){
        System.out.println("Sending email to "+ getRecipientAddress() );
        System.out.println(content);
    }

    public abstract void sendMail(String content, String email);
}
