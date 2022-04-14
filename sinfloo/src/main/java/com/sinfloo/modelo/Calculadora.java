package com.sinfloo.modelo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

	@Entity
public class Calculadora {
	@Id
	public int id;
    public float valora;
    public float valorb;
    public float resultado;
    public String operacao;
    public Timestamp data;
    
	public Calculadora() {
		super();
	}
	public Calculadora(int id, float valora, float valorb, float resultado, String operacao, Timestamp data) {
		super();
		this.id = id;
		this.valora = valora;
		this.valorb = valorb;
		this.resultado = resultado;
		this.operacao = operacao;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
    
	
    
    

}
