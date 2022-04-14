package com.example.projeto_bd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projeto_bd.utils.CalculadoraServices;
import com.example.projeto_bd.utils.apis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tela2 extends AppCompatActivity {
    //CalculadoraDAO cd = new CalculadoraDAO();
    List<Calculadora> Ca = new ArrayList<>();
    ArrayList<Calculadora> Ca2 = new ArrayList<>();
    Calculadora c;
    ListView l;
    CalculadoraServices calculadoraServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        l = findViewById(R.id.listview);
        ListarCalculos();
    }
    public void ListarCalculos(){
        calculadoraServices = apis.getCalculadoraServices();
        Call<List<Calculadora>> call = calculadoraServices.getCalculadora();
        call.enqueue(new Callback<List<Calculadora>>() {
            @Override
            public void onResponse(Call<List<Calculadora>> call, Response<List<Calculadora>> response) {
                Ca = response.body();
                CalcAdapter adapter = new CalcAdapter(Tela2.this,R.layout.list_adpter,Ca);
                l.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Calculadora>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }

}