package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private TextView textView;
    private VideoView video;
    private ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        imgBtn = (ImageButton) findViewById(R.id.imgBtnMap);
        textView = (TextView) findViewById(R.id.textView);
        video = (VideoView) findViewById(R.id.video);

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.n));
        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        video.start();

        String msg =
                "\n\n"+"Bienvenido a Banco BPM donde podrás manejar tus finanzas y solicitar los prestamos de nuestro banco" +
                " , ofrecemos los mejores beneficios para nuestros clientes. No esperes más y se parte de uno de los bancos más " +
                " grandes a nivel latinoamericano y comienza a ganar con nosotros y cumplir tus sueños";
        textView.setText(msg);
    }

    public void Maps(View v) {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
}