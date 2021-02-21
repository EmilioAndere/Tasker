package com.upt.taker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TareasActivity extends AppCompatActivity {

    private ArrayList<String[]> lstTarea = new ArrayList<String[]>();
    private LinearLayout lnLayout;
    public String[] task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        lnLayout = findViewById(R.id.lnlayout);

        //lnLayout.addView(card);
        lstTarea = (ArrayList<String[]>) getIntent().getExtras().getSerializable("tareas");
        for(String[] t: lstTarea){

            View card = View.inflate(getApplicationContext(), R.layout.card_task, null);
            TextView txvId = card.findViewById(R.id.txvId);
            TextView txvTitle = card.findViewById(R.id.txvTitle);
            TextView txvState = card.findViewById(R.id.txvState);
            ImageView imvPonits = card.findViewById(R.id.imvPonits);
            ImageView imvEye = card.findViewById(R.id.imvEye);
            txvTitle.setText(t[0]);
            txvState.setText(t[2]);
            txvId.setText(t[3]);
            imvPonits.setImageDrawable(getDrawable(R.drawable.ic_drag_indicator_24px));
            imvEye.setImageDrawable(getDrawable(R.drawable.ic_visibility_24px));

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**/
                    Intent ver = new Intent(getApplicationContext(), ShowActivity.class);
                    ver.putExtra("tareas", lstTarea);
                    ver.putExtra("id", txvId.getText().toString());
                    startActivity(ver);
                }
            });
            lnLayout.addView(card);
        }


    }
}