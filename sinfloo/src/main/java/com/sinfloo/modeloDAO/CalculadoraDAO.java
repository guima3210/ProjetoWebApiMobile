package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinfloo.interfaces.CalculadoraInterface;
import com.sinfloo.modelo.Calculadora;
@Repository
public class CalculadoraDAO implements CalculadoraInterface{
	@Autowired
	JdbcTemplate template;
	@Override
	public List<Map<String, Object>> listar() {
		List<Map<String , Object>>lista=template.queryForList("select * from operacao");
		return lista;
	}

	@Override
	public List<Map<String, Object>> listar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Calculadora c) {
		String sql = "INSERT INTO operacao(valora,valorb,operacao,resultado) VALUES (?, ?, ?,?)";
		return template.update(sql,c.getValora(),c.getValorb(),c.getOperacao(),c.getResultado());
	}

	@Override
	public int edit(Calculadora c) {
		String sql = "update operacao set valora=?, valorb=?,operacao=?,resultado=? where id=?";
		return template.update(sql,c.getValora(),c.getValorb(),c.getOperacao(),c.getResultado(),c.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "delete  from operacao where id=?";
		return template.update(sql,id);
		
	}

}
