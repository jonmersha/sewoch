package com.gebeya.sewoch.auth.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.gebeya.sewoch.R;
import com.gebeya.sewoch.auth.model.AccountCreateResponse;
import com.gebeya.sewoch.auth.view.NumberVerification;
import com.gebeya.sewoch.framework.viewModel.AuthViewModel;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateAccount extends AppCompatActivity {

    private AuthViewModel authViewModel;

   @BindView(R.id.phoneNumber)
   EditText mobileNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.signUp)
    public void signUpToSewoch() {
        //new HttpHelper().sighUpPost(String.valueOf(mobileNumber.getText()) ,"");
        JsonObject userNumebr = new JsonObject();
        userNumebr.addProperty("phoneNumber",mobileNumber.getText().toString());

        authViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(AuthViewModel.class);
        authViewModel.createAccount(userNumebr);

        authViewModel.getAccountCreationResponce().observe(this, new Observer<AccountCreateResponse>() {
            @Override
            public void onChanged(AccountCreateResponse accountCreateResponses) {
                if(accountCreateResponses.getMessage().equals("sms code sent successfully")){
                    //move to account verification screen
                    Intent codeverification =new Intent(getApplicationContext(), NumberVerification.class);
                    startActivity(codeverification);
                }
            }
        });



    }


}
