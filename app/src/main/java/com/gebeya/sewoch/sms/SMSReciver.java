package com.gebeya.sewoch.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReciver extends BroadcastReceiver {

    private static MessageListener mlistener;

    @Override
    public void onReceive(Context context, Intent intent) {
        mlistener.messageReceived("message");

       // Toast.makeText(this,"Incomind MEssage",Toast.LENGTH_LONG).show();

       // Log.e("Message","================================================INcoming Message",null);
//        Bundle data = intent.getExtras();
//        Object[] pdus = (Object[]) data.get("pdus");
//        for(int i=0; i<pdus.length; i++){
//            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
//            String message = "Sender : " + smsMessage.getDisplayOriginatingAddress()
//                    + "Email From: " + smsMessage.getEmailFrom()
//                    + "Emal Body: " + smsMessage.getEmailBody()
//                    + "Display message body: " + smsMessage.getDisplayMessageBody()
//                    + "Time in millisecond: " + smsMessage.getTimestampMillis()
//                    + "Message: " + smsMessage.getMessageBody();
//                   mlistener.messageReceived(message);
//
//        }

    }

    public static void bindListener(MessageListener listener){
        mlistener = listener;
    }

}
