package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Credito;

public class Prestamo_act extends AppCompatActivity {

    private TextView textView;
    private Button btnPrestamo, btnDeuda;
    private Spinner spCredito, spCliente;
    private int saldo = 0;
    private String flag; //obtiene las iniciales de lo seleccionado en los spinner y así poder calcular la deuda

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo_act);

        textView = (TextView) findViewById(R.id.textViewvPrestamo);
        btnPrestamo = (Button) findViewById(R.id.btnCalcularPrestamo);
        btnDeuda = (Button) findViewById(R.id.btnCalcularDeudas);
        spCliente = (Spinner) findViewById(R.id.spnCliente);
        spCredito = (Spinner) findViewById(R.id.spnCredito);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");


        ArrayAdapter<String> aadapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        spCliente.setAdapter(aadapt);
        spCredito.setAdapter(adapt);
    }

    public void CalcularCredito(View v) {
        String cliente = spCliente.getSelectedItem().toString();
        String creditoSelected = spCredito.getSelectedItem().toString();
        Credito credito = new Credito();
        btnDeuda.setEnabled(true);  //Asigna valor true al botón para calcular la deuda
        try {
            int hipotecario = credito.getHipotecario();
            int automotriz = credito.getAutomotriz();

            //clientes.add("Axel");
            //clientes.add("Roxana");
            //clientes.add("Betzabe");
            //clientes.add("Matías");

            if (cliente.equals("Axel") && creditoSelected.equals("Crédito Hipotecario")) {
                saldo = 750000 + hipotecario;
                flag = "A-H";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            if (cliente.equals("Axel") && creditoSelected.equals("Crédito Automotriz")) {
                saldo = 750000 + automotriz;
                flag = "A-A";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            ///
            if (cliente.equals("Roxana") && creditoSelected.equals("Crédito Hipotecario")) {
                saldo = 900000 + hipotecario;
                flag = "R-H";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            if (cliente.equals("Roxana") && creditoSelected.equals("Crédito Automotriz")) {
                saldo = 900000 + automotriz;
                flag = "R-A";
                textView.setText("El saldo final del cliente " + cliente + "es: " + saldo);
            }

            ///
            if (cliente.equals("Betzabe") && creditoSelected.equals("Crédito Hipotecario")) {
                saldo = 800000 + hipotecario;
                flag = "B-H";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            if (cliente.equals("Betzabe") && creditoSelected.equals("Crédito Automotriz")) {
                saldo = 800000 + automotriz;
                flag = "B-A";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            ///
            if (cliente.equals("Matías") && creditoSelected.equals("Crédito Hipotecario")) {
                saldo = 200000 + hipotecario;
                flag = "M-H";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

            if (cliente.equals("Matías") && creditoSelected.equals("Crédito Automotriz")) {
                saldo = 200000 + automotriz;
                flag = "M-A";
                textView.setText("El saldo final del cliente " + cliente + " es: " + saldo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CalcularDeuda(View v) {
        //hipotecario se divide en 12
        //automotriz se divide en 8
        //dividir saldo final + prestamo y la division en cuotas
        btnDeuda.setEnabled(false);
        String cliente = spCliente.getSelectedItem().toString();
        String creditoSelected = spCredito.getSelectedItem().toString();

        if (flag.equals("A-H")){
            saldo = saldo/12;
            textView.setText("La deuda final del cliente " + cliente + " son 12 cuotas de : " + saldo + " c/u");
        }
        if (flag.equals("A-A")){
            saldo = saldo/8;
            textView.setText("La deuda final del cliente " + cliente + " son 8 cuotas de : " + saldo + " c/u");
        }

        ////
        if (flag.equals("R-H")){
            saldo = saldo/12;
            textView.setText("La deuda final del cliente " + cliente + " son 12 cuotas de : " + saldo + " c/u");
        }
        if (flag.equals("R-A")){
            saldo = saldo/8;
            textView.setText("La deuda final del cliente " + cliente + " son 8 cuotas de : " + saldo + " c/u");
        }

        ////
        if (flag.equals("B-H")){
            saldo = saldo/12;
            textView.setText("La deuda final del cliente " + cliente + " son 12 cuotas de : " + saldo + " c/u");
        }
        if (flag.equals("B-A")){
            saldo = saldo/8;
            textView.setText("La deuda final del cliente " + cliente + " son 8 cuotas de : " + saldo + " c/u");
        }

        ////
        if (flag.equals("M-H")){
            saldo = saldo/12;
            textView.setText("La deuda final del cliente " + cliente + " son 12 cuotas de : " + saldo + " c/u");
        }
        if (flag.equals("M-A")){
            saldo = saldo/8;
            textView.setText("La deuda final del cliente " + cliente + " son 8 cuotas de : " + saldo + " c/u");
        }
    }
}