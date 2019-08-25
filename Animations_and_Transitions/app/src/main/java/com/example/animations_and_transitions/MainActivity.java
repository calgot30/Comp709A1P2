package com.example.animations_and_transitions;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;
import android.os.Bundle;

/*
listens for button click, when click happens moves the button to the bottom left
of the screen while increasing size of the button. Uses TransitionManager to make it
animated across the screen
 */
public class MainActivity extends AppCompatActivity {

    ViewGroup callumsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callumsLayout = (ViewGroup) findViewById(R.id.callumsLayout);

        //listener for is button is clicked, calls movebutton() method
        callumsLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        moveButton();
                        return true;
                    }

                }
        );
    }

    /*
    changes the position and size of the button
     */
    public void moveButton(){
        View callumsButton = findViewById(R.id.callumsButton);

        //allows the settings to be changed over time as an animation rather than instantly
        TransitionManager.beginDelayedTransition(callumsLayout);

        //Change the position of the button, with the use of position rules
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        callumsButton.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = callumsButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        callumsButton.setLayoutParams(sizeRules);
    }
}
