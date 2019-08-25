package com.example.boundservices;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.example.boundservices.MyService.MyLocalBinder;
import android.os.Bundle;


/*
Creates a bound connection to the service intent
 */
public class MainActivity extends AppCompatActivity {

    //
    MyService callumsService;
    boolean isBound = false;

    //displays the time on screen
    public void showTime(View view){
        //references to the Service connection method, which gives us
        //access to the MyService class and its methods.
        String currentTime = callumsService.getCurrentTime();
        TextView callumsText = (TextView) findViewById(R.id.callumsText);
        callumsText.setText(currentTime);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class);
        bindService(i, callumsConnection, Context.BIND_AUTO_CREATE);
    }

    //connects to the binder
    private ServiceConnection callumsConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyLocalBinder binder = (MyLocalBinder) iBinder;
            callumsService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

}
