package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;


/*
Creates a notification object, so your app can send a notification for your device

Note: I couldn't get this to work for myself, it just crashes
 */
public class MainActivity extends AppCompatActivity {



    NotificationCompat.Builder notification;
    private static final int uniqueID = 123456789;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification.Builder notification = new Notification.Builder(this);
        notification.setAutoCancel(true);
    }

    public void callumsButtonClicked(View view){
        //Build the notification
        notification.setSmallIcon(R.drawable.ic_launcher_notification);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Knock Knock");
        notification.setContentText("Hello");

        Intent intent = new Intent(this, MainActivity.class);

        //gives your device access to the intents in your app
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }

}
