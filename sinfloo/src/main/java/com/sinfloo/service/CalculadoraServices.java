package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.CalculadoraInterface;
import com.sinfloo.modelo.Calculadora;
import com.sinfloo.modeloDAO.CalculadoraDAO;

@Service
public class CalculadoraServices implements CalculadoraInterface{
	@Autowired
	CalculadoraDAO dao;
	@Override
	public List<Map<String, Object>> listar() {
		
		return dao.listar();
	}

	@Override
	public List<Map<String, Object>> listar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Calculadora c) {
		
		return dao.add(c);
	}

	@Override
	public int edit(Calculadora c) {
		// TODO Auto-generated method stub
		return dao.edit(c);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
		
	}
	

}
