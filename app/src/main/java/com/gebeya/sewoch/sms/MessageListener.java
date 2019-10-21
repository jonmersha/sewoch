package com.gebeya.sewoch.sms;

public interface MessageListener {
    void messageReceived(String message);
    void sendMessage(String destination,String mesage);
}
