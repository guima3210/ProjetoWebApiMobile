package com.example.projeto_bd;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar(){
    Connection conn = null;
    try {
        StrictMode.ThreadPolicy politica;
        politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);
        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.0.14:3306/calculadora",
                "Teste3","grandchase3210");

    }catch (SQLException e ){
        e.getMessage();

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
        return conn;
    }
}
