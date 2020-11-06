package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import Clases.AsyncLogin;
import Clases.IComunicacion;

public class MainActivity extends AppCompatActivity implements IComunicacion {

    private ProgressBar pg;
    private Button btnLogin;
    private EditText nombre, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        nombre = (EditText) findViewById(R.id.edtNombre);
        pass = (EditText) findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncLogin(MainActivity.this).execute(nombre.getText().toString(), pass.getText().toString(), 3000); // ejecuta mi tarea asíncrona.
            }
        });
    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status){
            pg.setVisibility(View.VISIBLE);
        } else{
            pg.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}