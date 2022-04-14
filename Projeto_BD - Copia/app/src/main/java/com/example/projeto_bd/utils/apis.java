package com.example.projeto_bd.utils;

public class apis {
    public static final String URL_001="http://192.168.0.10:8080/calculadora/";
    public static CalculadoraServices getCalculadoraServices(){
        return Cliente.getCliente(URL_001).create(CalculadoraServices.class);
    }
}
