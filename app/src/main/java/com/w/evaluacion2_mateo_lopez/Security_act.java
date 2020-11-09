package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Security_act extends AppCompatActivity {

    private EditText mensaje;
    private Button btnCifrar;
    private TextView cifrado;

    private static final String AES = "AES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_act);

        mensaje = (EditText) findViewById(R.id.edtPassword);
        btnCifrar = (Button) findViewById(R.id.btnCifrar);
        cifrado = (TextView) findViewById(R.id.textViewCifrado);

        btnCifrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    cifrar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void cifrar() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] bytes = secretKey.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        String mmensaje = mensaje.getText().toString();
        byte[] ccifrado = cipher.doFinal(mmensaje.getBytes());
        cifrado.setText(ccifrado.toString());
    }
}