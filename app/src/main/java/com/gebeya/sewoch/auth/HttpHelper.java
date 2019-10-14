package com.gebeya.sewoch.auth;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HttpHelper {
    String userNumber;
    String key;


public  void sighUpPost(String number,String keyval){
    MediaType MEDIA_TYPE = MediaType.parse("application/json");
    String url = "http://192.168.1.5:3000/send";
    OkHttpClient client = new OkHttpClient();
    JSONObject postdata = new JSONObject();
    try {
        postdata.put("mobileNumber", number);
        postdata.put("key", FirebaseInstanceId.getInstance().getToken());
    } catch(JSONException e){
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    RequestBody body = RequestBody.create(MEDIA_TYPE, postdata.toString());
    Request request = new Request.Builder()
            .url(url)
            .post(body)
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            String mMessage = e.getMessage().toString();
            Log.w("failure Response", mMessage);
            call.cancel();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            String mMessage = response.body().string();
            Log.e(TAG, mMessage);
        }
    });

}

}
