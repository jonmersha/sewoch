package com.gebeya.sewoch.framework.http_helper;

import com.gebeya.sewoch.auth.model.AccountCreateResponse;
import com.gebeya.sewoch.auth.model.UserObject;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/sendsms")
    Call<AccountCreateResponse> sendNumber(@Body JsonObject body);

    @POST("auth/verifycode")
    Call<UserObject> sendVerification(@Body JsonObject body);

}
