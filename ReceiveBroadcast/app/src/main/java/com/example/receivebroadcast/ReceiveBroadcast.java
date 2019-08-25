package com.example.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//creates toast popup that lets you know that the intent from SENDBROADCAST has been sent

//Note: this didn't work for me
public class ReceiveBroadcast extends BroadcastReceiver {

    public ReceiveBroadcast(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast has been received!", Toast.LENGTH_LONG).show();
    }
}
