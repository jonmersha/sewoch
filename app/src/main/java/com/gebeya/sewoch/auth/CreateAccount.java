package com.gebeya.sewoch.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.framework.FIreBaseTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccount extends AppCompatActivity {

   @BindView(R.id.phoneNumber)
   EditText mobileNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);
    }


   // @OnClick(R.id.signUp)
    public void signUpToSewoch(View v) {
        new HttpHelper().sighUpPost(String.valueOf(mobileNumber.getText()) ,"");

    }


}
