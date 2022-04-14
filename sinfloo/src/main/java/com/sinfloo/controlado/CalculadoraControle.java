package com.sinfloo.controlado;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinfloo.modelo.Calculadora;
import com.sinfloo.service.CalculadoraServices;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraControle {
	@Autowired
	CalculadoraServices service;
	@GetMapping("/listar")
	public List<Map<String, Object>> listar() {
		return service.listar(); 
	}
	@PostMapping("/add")
	public String addCalculadora(@RequestBody Calculadora calculadora) {
		int  r = service.add(calculadora);
		if(r==0) {
			return "deu errado";
		}else {
		return "deu tudo certo";
		}
	}
	@PostMapping("/update/{id}")
	public String addCalculadora(@RequestBody Calculadora calculadora,@PathVariable int id) {
		calculadora.setId(id);
		int r=service.edit(calculadora);
		if(r==0) {
			return "deu errado";
		}else {
		return "deu tudo certo";
		}
	}
	@PostMapping("/deleta/{id}")
	public String delete(@PathVariable int id) {
		int r=service.delete(id);
		if(r==0) {
			return "deu errado";
		}else {
		return "deu tudo certo";
		}
	}
	
}
