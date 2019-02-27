package com.yanis.studentlife;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCMessage";

    public void onMessageReceived(RemoteMessage remoteMessage){

        String message = remoteMessage.getNotification().toString();

        Log.d(TAG,"From: " +remoteMessage.getFrom());
        Log.d(TAG,"Message: " +remoteMessage.getNotification());

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.student_life)
                .setContentTitle("Notification StudentLife")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1, mBuilder.build());

    }
}
