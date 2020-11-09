package com.w.evaluacion2_mateo_lopez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Clases.Cliente;
import Clases.DataBaseHelper;

public class Clientes_act extends AppCompatActivity {

    private Button btnGuardar, btnMostrar, btnEditar, btnBorrar;
    private EditText edtCodigo, edtNombre, edtSueldo;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        db = new DataBaseHelper(this);

        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnMostrar = (Button)findViewById(R.id.btnMostrar);
        btnEditar = (Button)findViewById(R.id.btnActualizar);
        btnBorrar = (Button)findViewById(R.id.btnEliminar);

        edtCodigo = (EditText)findViewById(R.id.edtCodigo);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtSueldo = (EditText)findViewById(R.id.edtSalario);
    }

    public void insertar(View v) {
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = edtCodigo.getText().toString();
                    String n = edtNombre.getText().toString();
                    String s = edtSueldo.getText().toString();
                    boolean isInsert = db.insert(c, n, s);
                    if (isInsert == true)
                        Toast.makeText(Clientes_act.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Clientes_act.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void viewAll(View v) {
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor res = db.getAllData();
                    if (res.getCount() == 0) {
                        showMessage("Error", "No hay datos");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Código : " + res.getString(0) + "\n");
                        buffer.append("Nombre : " + res.getString(1) + "\n");
                        buffer.append("Salario : " + res.getString(2) + "\n\n");
                    }
                    showMessage("Data ", buffer.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void update(View v){
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = edtCodigo.getText().toString();
                    String n = edtNombre.getText().toString();
                    String s = edtSueldo.getText().toString();
                    boolean isUpdate = db.update(c, n, s);
                    if (isUpdate)
                        Toast.makeText(Clientes_act.this, "Data Update", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Clientes_act.this, "Data Not Update", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    public void delete(View v){
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = edtCodigo.getText().toString();
                    Integer deleteRows = db.delete(c);
                    if (deleteRows > 0)
                        Toast.makeText(Clientes_act.this, "Deleted Data", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Clientes_act.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}