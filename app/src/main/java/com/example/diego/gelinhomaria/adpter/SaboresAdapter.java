package com.example.diego.gelinhomaria.adpter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.diego.gelinhomaria.R;
import com.example.diego.gelinhomaria.modes.SaboresGelinho;

import java.util.List;

/**
 * Created by diego on 13/11/16.
 */

public class SaboresAdapter extends ArrayAdapter<SaboresGelinho>{

    private List<SaboresGelinho> sabores ;
    private TextView sabor , qtd , tipo;

    public SaboresAdapter(Context context, List<SaboresGelinho> sabores) {
        super(context, R.layout.sabores_layout , sabores);
        this.sabores = sabores;
    }

    public View getView(int position , View convertView , ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.sabores_layout,null);

        sabor = (TextView) item.findViewById(R.id.txtSabor);
        tipo = (TextView) item.findViewById(R.id.txtTipo);
        qtd = (TextView) item.findViewById(R.id.txtQtd);

        sabor.setText(sabores.get(position).getSabor());
        tipo.setText(sabores.get(position).getTipo_gelinho());
        qtd.setText(sabores.get(position).getQtd().toString());

        return item;
    }

    @Override
    public int getCount() {
        if (sabores == null) return 0;
        return sabores.size();
    }

    @Override
    public SaboresGelinho getItem(final int position) {
        if (sabores == null || sabores.size() == 0) return null;
        return sabores.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).getId(); // or something like an id that suits you.
    }
}
