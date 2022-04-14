package com.example.projeto_bd;

import java.sql.Timestamp;

public class Calculadora {
    public int id;
    public float valora;
    public float valorb;
    public float resultado;
    public String operacao;
    public Timestamp data;

    public float getValora() {
        return valora;
    }

    public void setValora(float valora) {
        this.valora = valora;
    }

    public float getValorb() {
        return valorb;
    }

    public void setValorb(float valorb) {
        this.valorb = valorb;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public String getoperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp hora) {
        this.data = data;
    }

    public Calculadora(float valora, float valorb, float resultado, String operacao) {
        this.valora = valora;
        this.valorb = valorb;
        this.resultado = resultado;
        this.operacao = operacao;
    }

    public Calculadora(int id, float valora, float valorb, float resultado, String operacao, Timestamp data) {
        this.id = id;
        this.valora = valora;
        this.valorb = valorb;
        this.resultado = resultado;
        this.operacao = operacao;
        this.data = data;
    }

    public Calculadora() {
    }
}
