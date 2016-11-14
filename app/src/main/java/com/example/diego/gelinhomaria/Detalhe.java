package com.example.diego.gelinhomaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detalhe extends AppCompatActivity {

    private  TextView txt ;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        intent = getIntent();
        Long id = intent.getLongExtra("id",0);

        txt = (TextView) findViewById(R.id.teste);
        txt.setText(id.toString());




    }
}
