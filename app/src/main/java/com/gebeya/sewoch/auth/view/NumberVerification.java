package com.gebeya.sewoch.auth.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.sms.MessageListener;
import com.gebeya.sewoch.sms.SMSReciver;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NumberVerification extends AppCompatActivity{

    @BindView(R.id.verificationCode)
    EditText verificationCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_verification_actitvity);
        ButterKnife.bind(this);

    }

}
