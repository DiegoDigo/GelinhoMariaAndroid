package com.example.diego.gelinhomaria;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.diego.gelinhomaria.api.EndPoints;
import com.example.diego.gelinhomaria.modes.SaboresGelinho;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Detalhe extends AppCompatActivity {

    private  TextView txtSabor ,txtQtd, txtPreco ,txtTipo;
    private static  String url = "http://192.168.0.116:8000/";
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);



        intent = getIntent();
        Long id = intent.getLongExtra("id", 0);

        txtSabor = (TextView) findViewById(R.id.sabor);
        txtTipo = (TextView) findViewById(R.id.tipo);
        txtQtd = (TextView) findViewById(R.id.qtd);
        txtPreco = (TextView) findViewById(R.id.preco);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndPoints endPoints = retrofit.create(EndPoints.class);

        Call<SaboresGelinho> sabor = endPoints.getSabor(id);

        sabor.enqueue(new Callback<SaboresGelinho>() {
            @Override
            public void onResponse(Response<SaboresGelinho> response, Retrofit retrofit) {
                preencherDados(response.body());


            }

            @Override
            public void onFailure(Throwable t) {
                    txtSabor.setText(t.getMessage());
            }
        });

    }


    public void preencherDados(SaboresGelinho sabor){
            txtSabor.setText(sabor.getSabor());
            txtTipo.setText(sabor.getTipo_gelinho());
            txtQtd.setText(sabor.getQtd().toString());
            txtPreco.setText("R$ " + sabor.getValor_uni().toString());

    }

}
