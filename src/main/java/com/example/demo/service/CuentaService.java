package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.CuentaRepository;

import reactor.core.publisher.Flux;

@Service
public class CuentaService {
	
	@Autowired
	public CuentaRepository repositorio;
	
	public String adicionarCuenta(CuentaBancaria cuenta) {
		return repositorio.crearCuenta(cuenta);
	}
	
	public List<CuentaBancaria> getDatos(){
		return repositorio.datosCuenta();
	}
	
	public Flux<CuentaBancaria> detailTipoCuenta(String tipoCuenta) {
		return repositorio.detailCuenta(tipoCuenta);
	}
	
	public boolean eliminarCuenta(int id) {
		return repositorio.eliminarCuenta(id);
	}

}
