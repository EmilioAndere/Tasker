package com.upt.taker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    public String[] task;
    public int indice;
    private Button btVer;
    private EditText edtTitulo, edtDesc;
    private Spinner spnStatus;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        btVer = findViewById(R.id.btnVer);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDesc = findViewById(R.id.edtDescription);
        spnStatus = findViewById(R.id.spnEstado);
        ArrayList<String[]> tareas = (ArrayList<String[]>) getIntent().getExtras().getSerializable("tareas");
        String id = getIntent().getExtras().getString("id");
        for(int i=0; i<tareas.size();i++){
            if(tareas.get(i)[3].equals(id)){
                task = tareas.get(i);
                indice = i;
            }
        }
        edtTitulo.setText(task[0]);
        edtDesc.setText(task[1]);
        String[] pos = getResources().getStringArray(R.array.estados);
        for(int i =0;i<pos.length;i++){
            if(pos[i].equals(task[2])){
                index = i;
            }
        }
        spnStatus.setSelection(index);

        btVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = edtTitulo.getText().toString();
                String desc = edtDesc.getText().toString();
                String estado = spnStatus.getSelectedItem().toString();
                String[] tempTask = {titulo,desc,estado,task[3]};
                tareas.get(indice)[0] = titulo;
                tareas.get(indice)[1] = desc;
                tareas.get(indice)[2] = estado;
                tareas.get(indice)[3] = task[3];
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                back.putExtra("tareas", tareas);
                startActivity(back);
            }
        });
    }
}