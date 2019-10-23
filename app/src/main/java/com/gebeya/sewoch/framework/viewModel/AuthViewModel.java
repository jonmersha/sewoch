package com.gebeya.sewoch.framework.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gebeya.sewoch.App;
import com.gebeya.sewoch.auth.model.AccountCreateResponse;
import com.gebeya.sewoch.framework.http_helper.ApiService;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthViewModel extends AndroidViewModel {
    private Retrofit retrofit;
    private MutableLiveData<AccountCreateResponse> accountCreationResponce;

    public AuthViewModel(@NonNull Application application) {
        super(application);
        retrofit=((App)application).getRetrofit();
        accountCreationResponce= new MutableLiveData<>();


    }

    public MutableLiveData<AccountCreateResponse> getAccountCreationResponce() {
        return accountCreationResponce;
    }

    public void createAccount(JsonObject userNumebr) {
        ApiService service=retrofit.create(ApiService.class);
        service.sendNumber(userNumebr).enqueue(new Callback<AccountCreateResponse>() {
            @Override
            public void onResponse(Call<AccountCreateResponse> call, Response<AccountCreateResponse> response) {
                accountCreationResponce.setValue(response.body());
            }
            @Override
            public void onFailure(Call<AccountCreateResponse> call, Throwable t) {

            }
        });
    }
}
