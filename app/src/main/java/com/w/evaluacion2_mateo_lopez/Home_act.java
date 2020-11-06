package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.gms.common.api.Api;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {
            flip_image(images[i]);
        }
    }

    // función que me permitirá configurar el slider
    public void flip_image(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);           // añadimos al viewflipper el contenido del slider
        vf.setFlipInterval(2000);   // duración intervalo de imagenes
        vf.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Prestamo(View v) {
        Intent i = new Intent(this, Prestamo_act.class);
        startActivity(i);
    }

    public void Clientes(View v) {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }

    public void Info(View v) {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Security(View v) {
        Intent i = new Intent(this, Security_act.class);
        startActivity(i);
    }
}