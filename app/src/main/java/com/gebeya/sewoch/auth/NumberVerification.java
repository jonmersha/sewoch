package com.gebeya.sewoch.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.sms.MessageListener;
import com.gebeya.sewoch.sms.SMSReciver;

public class NumberVerification extends AppCompatActivity implements MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_verification_actitvity);
        SMSReciver.bindListener(this);
    }
    @Override
    public void messageReceived(String message) {
        Toast.makeText(this, "New Message Received: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendMessage(String destination, String message) {
           // Intent sms = new Intent(Intent.ACTION_VIEW);
          //sms.putExtra("address", new String[]{destination});
         //sms.putExtra("sms_body",mesage);
        //sms.setType("vnd.android-dir/mms-sms");



         //  SmsManager smgr = SmsManager.getDefault();
        // smgr.sendTextMessage(destination,null,message,null,null);

    }
    public void sendMessage(View v){
    //  SmsManager smgr = SmsManager.getDefault();
    //  smgr.sendTextMessage("0913153125",null,"testMessage",null,null);

        //Intent intent = new Intent();
        //intent.setAction("com.tutorialspoint.CUSTOM_INTENT"); sendBroadcast(intent);

        Intent intent = new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT"); sendBroadcast(intent);
    }
}
