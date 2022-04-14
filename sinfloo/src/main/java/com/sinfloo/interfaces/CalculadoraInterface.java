package com.sinfloo.interfaces;

import java.util.*;

import com.sinfloo.modelo.Calculadora;

public interface CalculadoraInterface {
	public List<Map<String,Object >>listar();
	public List<Map<String,Object >>listar(int id);
	public int add(Calculadora c);
	public int edit(Calculadora c);
	public int delete(int id);

}
