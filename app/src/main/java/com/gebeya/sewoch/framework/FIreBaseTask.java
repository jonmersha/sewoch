package com.gebeya.sewoch.framework;

import android.util.Log;
import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.io.IOException;

public class FIreBaseTask {

    String token;
    public String getIntanceID() {
        return FirebaseInstanceId.getInstance().getToken();
    }
}
