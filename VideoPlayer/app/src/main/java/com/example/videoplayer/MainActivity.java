package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.widget.VideoView;
import android.widget.MediaController;
import android.os.Bundle;

/*
Uses a video view to display a video, it uses a link to watch the video

Note: his version wouldnt work with youtube videos so I had to find a solution online, I
referenced the code. It was an intent to use the youtube vid
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView callumsVideoView = (VideoView) findViewById(R.id.callumsVideoView);

            //tried having this code as the video path but it wouldn't work.
            //callumsVideoView.setVideoPath("https://www.ted.com/talks/anita_collins_the_benefits_of_music_education");


        //this line of code was used from https://github.com/ablealias/Android/wiki/How-to-start-YouTube-intent-directly-with-a-video-URL
        //It creates in intent to play the chosen video URL that is embedded within youtube.
        //Buckys method only works with videos that are embedded in other formats on websites
        //Note: this was the same issue most people were having in the comments section and was the
        //most recommended action
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://"+"ZZ5LpwO-An4")));


        //adds controller options to video
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(callumsVideoView);
            callumsVideoView.setMediaController(mediaController);

            callumsVideoView.start();
    }
}
