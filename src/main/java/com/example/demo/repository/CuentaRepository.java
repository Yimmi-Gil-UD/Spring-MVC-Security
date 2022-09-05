package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CuentaBancaria;

import reactor.core.publisher.Flux;



@Repository
public class CuentaRepository {

	List<CuentaBancaria> cuentas = new ArrayList<>();
	
	public String crearCuenta(CuentaBancaria cuenta) {
		
		try {
			cuentas.add(cuenta);
			return "Cuenta Creada";
		} catch (Exception e) {
			return "Errro" + e;
		}
		
	}
	
	public List<CuentaBancaria> datosCuenta(){
		return cuentas;
	}
	
	public Flux<CuentaBancaria> detailCuenta(String  tipoCuenta) {
		return Flux.fromIterable(cuentas).filter(c->c.getTipoCuenta().equals(tipoCuenta));
		//return cuentas.stream().filter(c->c.getTipoCuenta().equals(tipoCuenta)).findAny().orElse(null);
	}
	
	public boolean eliminarCuenta(int id) {
		return cuentas.removeIf(cuenta->cuenta.getId() == id);
	}
	
	
	
	
}
