package com.example.apples_and_bacon;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/*
Creates an intent service
 */
public class CallumsIntentService extends IntentService{

    private static final String TAG = "com.example.apples_and_bacon";

    public CallumsIntentService() {
        super("CallumsIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        Log.i(TAG, "The service has now started.");
    }

}
