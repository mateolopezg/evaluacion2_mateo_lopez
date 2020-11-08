package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private TextView textView;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        textView = (TextView)findViewById(R.id.textView);
        video = (VideoView)findViewById(R.id.video);

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.n));
        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        video.start();
    }

    public void Maps(View v) {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
}