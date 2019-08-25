package com.example.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/*
service to access the Service class, android has specific ways to access Binder
 */
public class MyService extends Service {

    //Binds mainActivity to a service
    private final IBinder callumsBinder = new MyLocalBinder();

    public MyService() {
    }


    //returns instance of MyLocalBinder
    @Override
    public IBinder onBind(Intent intent) {
        return callumsBinder;
    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        return (df.format(new Date()));
    }


    //myLocalBinder class, returns reference to MyService
    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }


}
