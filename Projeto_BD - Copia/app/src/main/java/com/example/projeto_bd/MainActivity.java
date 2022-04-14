package com.example.projeto_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projeto_bd.utils.CalculadoraServices;
import com.example.projeto_bd.utils.apis;

import java.sql.Connection;
import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnssoma;
    private Button btnssub;
    private Button btnsdiv;
    private Button btnsmult;
    private Button btnstela;
    private Button btndeleta;
    private Button btnatt;
    private EditText valora;
    private EditText valorb;
    private EditText valorid2;

    float  v1 , v2, resultado = 0;
    String operacao,tem;
    int id;
    Calculadora c ;
    CalculadoraServices services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*TextView text = findViewById(R.id.tvt);
        Connection conn = Conexao.conectar(getApplicationContext());
        try {
            if (conn != null){
                if (!conn.isClosed()){
                    text.setText("Conectado");}
                else {
                    text.setText("conexao fechada");
                }
            }
            else{
                text.setText("nao conectado");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            text.setText("falhou"+e.getMessage());
        }*/
        btnssoma = (Button)findViewById(R.id.add);
        btnssoma.setOnClickListener(this);
        btnssub = (Button)findViewById(R.id.sub);
        btnssub.setOnClickListener(this);
        btnsdiv = (Button)findViewById(R.id.div);
        btnsdiv.setOnClickListener(this);
        btnsmult = (Button)findViewById(R.id.mult);
        btnsmult.setOnClickListener(this);
        btnstela = (Button)findViewById(R.id.tela);
        btnstela.setOnClickListener(this);
        btndeleta = (Button)findViewById(R.id.botaodeletar);
        btndeleta.setOnClickListener(this);
        btnatt = (Button)findViewById(R.id.botaoupdate);
        btnatt.setOnClickListener(this);
        valora = findViewById(R.id.valorA);
        valorb = findViewById(R.id.Valorb);
        valorid2 = findViewById(R.id.edtxtidupdate);

        Intent intent = getIntent();
        valora.setText(intent.getStringExtra("Valora"));
        valorb.setText(intent.getStringExtra("Valorb"));
        valorid2.setText(intent.getStringExtra("ID"));
    }

    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            v1 = Float.parseFloat(valora.getText().toString());
            v2 = Float.parseFloat(valorb.getText().toString());
            resultado = v1+v2;
            operacao = "+";
            c = new Calculadora(v1,v2,resultado,operacao);
            tem = valorid2.getText().toString();
            if (tem.equals("")){
                addCalculos(c);
            }
            else{
                updateCalculos(c,Integer.parseInt(tem));
            }
            //cd.gravar(c);
            valora.setText("");
            valorb.setText("");
            Toast.makeText(this,"Cálculo armazenado com sucesso "+" e o resultado  = "+resultado,Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.sub) {
            v1 = Float.parseFloat(valora.getText().toString());
            v2 = Float.parseFloat(valorb.getText().toString());
            resultado = v1-v2;
            operacao = "-";
            c = new Calculadora(v1,v2,resultado,operacao);
            tem = valorid2.getText().toString();
            if (tem.equals("")){
                addCalculos(c);
            }
            else{
                updateCalculos(c,Integer.parseInt(tem));
            }
            valora.setText("");
            valorb.setText("");

            Toast.makeText(this,"Cálculo armazenado com sucesso "+" e o resultado  = "+resultado,Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.div) {
            v1 = Float.parseFloat(valora.getText().toString());
            v2 = Float.parseFloat(valorb.getText().toString());
            resultado = v1/v2;
            operacao = "/";
            c = new Calculadora(v1,v2,resultado,operacao);
            tem = valorid2.getText().toString();
            if (tem.equals("")){
                addCalculos(c);
            }
            else{
                updateCalculos(c,Integer.parseInt(tem));
            }
            valora.setText("");
            valorb.setText("");

            Toast.makeText(this,"Cálculo armazenado com sucesso "+" e o resultado  = "+resultado,Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.mult) {
            v1 = Float.parseFloat(valora.getText().toString());
            v2 = Float.parseFloat(valorb.getText().toString());
            resultado = v1*v2;
            operacao = "*";
            c = new Calculadora(v1,v2,resultado,operacao);
            tem = valorid2.getText().toString();
            if (tem.equals("")){
                addCalculos(c);
            }
            else{
                updateCalculos(c,Integer.parseInt(tem));
            };
            valora.setText("");
            valorb.setText("");

            Toast.makeText(this,"Cálculo armazenado com sucesso "+" e o resultado  = "+resultado,Toast.LENGTH_LONG).show();
        }
        if (v.getId() == R.id.tela) {
            Intent n = new Intent(getApplicationContext(),Tela2.class);
            startActivity(n);
        }
        if(v.getId() == R.id.botaodeletar){
            id = Integer.parseInt(valorid2.getText().toString());
            deletaCalculos(id);

        }
        if(v.getId() == R.id.botaoupdate){
            valorid2.setText("");

        }
    }
    public void addCalculos(Calculadora calculadora){
        services = apis.getCalculadoraServices();
        Call<Calculadora> call = services.addCalculo(calculadora) ;
       call.enqueue(new Callback<Calculadora>() {
           @Override
           public void onResponse(Call<Calculadora> call, Response<Calculadora> response) {
                    if(response != null ){
                        Toast.makeText(MainActivity.this, "foi adicionado com successo", Toast.LENGTH_SHORT).show();

                    }
           }

           @Override
           public void onFailure(Call<Calculadora> call, Throwable t) {
               Log.e("Error",t.getMessage());
           }
       });
    }
    public void updateCalculos(Calculadora calculadora,int idd){
       services = apis.getCalculadoraServices();
        Call<Calculadora> call = services.updateCalculo(calculadora,idd) ;
        call.enqueue(new Callback<Calculadora>() {
            @Override
            public void onResponse(Call<Calculadora> call, Response<Calculadora> response) {
                if(response != null ){
                    Toast.makeText(MainActivity.this, "foi atualizado com successo", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Calculadora> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }
    public void deletaCalculos(int idd){
        services = apis.getCalculadoraServices();
        Call<Calculadora> call = services.deletaCalculo(idd) ;
        call.enqueue(new Callback<Calculadora>() {
            @Override
            public void onResponse(Call<Calculadora> call, Response<Calculadora> response) {
                if(response != null ){
                    Toast.makeText(MainActivity.this, "foi deletado com successo", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Calculadora> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
    }
}