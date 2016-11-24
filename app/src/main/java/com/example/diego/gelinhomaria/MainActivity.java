package com.example.diego.gelinhomaria;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diego.gelinhomaria.adpter.SaboresAdapter;
import com.example.diego.gelinhomaria.api.EndPoints;
import com.example.diego.gelinhomaria.modes.SaboresGelinho;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView msg ;
    ListView listaSabores ;
    private static  String url = "http://192.168.0.116:8000/";
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         msg = (TextView) findViewById(R.id.txtMsg);
        listaSabores = (ListView) findViewById(R.id.listaSabores);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        EndPoints endPoints = retrofit.create(EndPoints.class);

        Call<List<SaboresGelinho>> call = endPoints.getSabores();

        call.enqueue(new Callback<List<SaboresGelinho>>() {
            @Override
            public void onResponse(Response<List<SaboresGelinho>> response, Retrofit retrofit) {
                final SaboresAdapter adapter = new SaboresAdapter(getBaseContext(), response.body());
                listaSabores.setAdapter(adapter);
                listaSabores.setOnItemClickListener(chamarDetalhes());

            }

            @Override
            public void onFailure(Throwable t) {
                msg.setText(t.getMessage());

            }
        });



    }

    private AdapterView.OnItemClickListener  chamarDetalhes(){
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getBaseContext(),Detalhe.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}
