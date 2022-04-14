package com.example.projeto_bd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CalcAdapter extends ArrayAdapter<Calculadora> {
    private Context mcontext;
    private int mResource;
    private  List<Calculadora>calculadoras;

    public CalcAdapter(@NonNull Context context, int resource, @NonNull List<Calculadora> objects) {
        super(context, resource, objects);
        this.mcontext = context;
        this.mResource = resource;
        this.calculadoras=objects;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        convertView = layoutInflater.inflate(mResource,parent,false);
        TextView txtid = convertView.findViewById(R.id.txtid);
        TextView txtvalora = convertView.findViewById(R.id.txtvalora);
        TextView txtvalorb = convertView.findViewById(R.id.txtvalorb);
        TextView txtopera = convertView.findViewById(R.id.txtopera);
        TextView txtresul = convertView.findViewById(R.id.txtresul);
        TextView txthora = convertView.findViewById(R.id.txthora);
        txtid.setText(String.valueOf(calculadoras.get(position).getId()));
        txtvalora.setText(String.valueOf(calculadoras.get(position).getValora()));
        txtvalorb.setText(String.valueOf(calculadoras.get(position).getValorb()));
        txtopera.setText(calculadoras.get(position).getoperacao());
        txtresul.setText(String.valueOf(calculadoras.get(position).getResultado()));
        txthora.setText(String.valueOf(calculadoras.get(position).getData()));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, MainActivity.class);
                intent.putExtra("ID",String.valueOf(calculadoras.get(position).getId()));
                intent.putExtra("Valora",String.valueOf(calculadoras.get(position).getValora()));
                intent.putExtra("Valorb",String.valueOf(calculadoras.get(position).getValorb()));
                mcontext.startActivity(intent);
            }
        });
        return convertView;
    }
}
