package com.example.threads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import android.os.Bundle;


/*
Creates a runnable object with a long calculation in it, to run the process in the background inside
a thread instance
 */
public class MainActivity extends AppCompatActivity {

    //Handler, is run after the calculation is complete
    //prints out the text
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView callumsText = (TextView) findViewById(R.id.callumsText);
            //never update an interface inside of a runnable
            callumsText.setText("Nice job Hoss!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    When button is clicked, a Runnable object is created to process the calculation.
    this runs in the background so as not to slow down the app

     */
    public void clickCallumsButton(View view){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime - System.currentTimeMillis());
                        }catch(Exception e){

                        }
                    }
                }
                handler.sendEmptyMessage(0);

            }
        };
        //Runs the thread for the long calculation so it can run in the background
        Thread callumsThread = new Thread(r);
        callumsThread.start();


    }
}
