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
        try {
            Thread.sleep(delayTime*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
