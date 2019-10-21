package com.gebeya.sewoch.firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.gebeya.sewoch.MainActivity;
import com.gebeya.sewoch.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class SewochMessaginService extends FirebaseMessagingService {
    NotificationManager notificationManager;
    Notification notification;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if(remoteMessage.getNotification()!=null){
            String title=remoteMessage.getNotification().getTitle();
            String message=remoteMessage.getNotification().getBody();
            generateNotification(title,message);
           // Toast.makeText(this,title+" "+message,Toast.LENGTH_LONG).show();
            Log.e("NOTIFICATION",title+" "+message);
        }
        if(remoteMessage.getData().size()>0){
           // String statusValue=remoteMessage.getData().get("status");
            String userName=remoteMessage.getData().get("userName");
            String mobileNUmber=remoteMessage.getData().get("mobileNUmber");
            String sender=remoteMessage.getData().get("sender");
          //Log.e("STATUS",statusValue);
            Log.e("STATUS",userName);
            Log.e("STATUS",mobileNUmber);
            Log.e("STATUS",sender);

        }
    }
    public void generateNotification(String title,String message){


        Intent intent=new Intent(SewochMessaginService.this, MainActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("title",message);

        PendingIntent pendingIntent=PendingIntent.getActivity(SewochMessaginService.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        if(Build.VERSION.SDK_INT>=26){
            String chanelID="com.gebeya.sewoch";
            String channelName="FCMDemo";
            NotificationChannel notificationChannel=new NotificationChannel(chanelID,channelName,NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            assert notificationManager!=null;
            notificationManager.createNotificationChannel(notificationChannel);
            NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(SewochMessaginService.this,chanelID);
            notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_logo)
                    .setColor(Color.BLUE)
                    .setAutoCancel(true)
                    .setTicker(message)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSound(alarmSound)
                    .setDefaults(Notification.DEFAULT_VIBRATE|Notification.DEFAULT_LIGHTS)
                    .setContentIntent(pendingIntent);
            notification=notificationBuilder.build();
            startForeground(0,notification);
        }else{
            NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(SewochMessaginService.this);
            notificationBuilder.setSmallIcon(R.drawable.ic_logo)
                                .setContentText(message)
                                .setContentTitle(title)
                                .setContentIntent(pendingIntent)
                                .setSound(alarmSound)
                                .build();

            notification=notificationBuilder.getNotification();
            notification.flags=Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(0,notification);
        }
    }
}
