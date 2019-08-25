package com.example.apples_and_bacon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.example.apples_and_bacon";

    public MyService() {
    }

    /*
    Thread to run the runnable, when button is clicked the LOG TAG displays
    the notification in LOGCAT after waiting for 5 seconds

    Start sticky restarts the service if android destroys your device
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand method called");

        Runnable r = new Runnable(){
            @Override
            public void run(){
                for(int i = 0; i < 5; i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime){
                        synchronized (this){
                            try{
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            }catch(Exception e){}
                        }
                    }
                }
            }
        };

        Thread callumsThread = new Thread(r);
        callumsThread.start();

        //starts service again automatically if anroid destroys application
        return Service.START_STICKY;
    }

    //tag called when app is destroyed
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
