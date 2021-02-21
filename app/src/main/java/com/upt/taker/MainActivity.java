package com.upt.taker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnVer, btnAgregar;
    private EditText edtTitulo, edtDescripcion;
    private Spinner spnEstado;
    public ArrayList<String[]> lstTareas= new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ArrayList<String[]> temTask = (ArrayList<String[]>) getIntent().getExtras().getSerializable("tareas");
        if(getIntent().hasExtra("tareas")){
            lstTareas = (ArrayList<String[]>) getIntent().getExtras().getSerializable("tareas");
            Toast.makeText(getApplicationContext(), "Se ha actualizado una Tarea Correctamete", Toast.LENGTH_LONG).show();
        }
        btnVer = findViewById(R.id.btnVer);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verTareas = new Intent(getApplicationContext(), TareasActivity.class);
                verTareas.putExtra("tareas", lstTareas);
                startActivity(verTareas);
            }
        });
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescription);
        spnEstado = findViewById(R.id.spnEstado);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = String.valueOf(lstTareas.size()+1);
                String titulo = edtTitulo.getText().toString();
                String descripcion = edtDescripcion.getText().toString();
                String estado = (!spnEstado.equals("---Seleccione---")) ? spnEstado.getSelectedItem().toString() : "Sin titulo";
                String[] tarea = {titulo, descripcion, estado, id};
                lstTareas.add(tarea);
                edtTitulo.setText("");
                edtDescripcion.setText("");
                spnEstado.setSelection(0);
                //Toast.makeText(getApplicationContext(),String.valueOf(lstTareas.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}