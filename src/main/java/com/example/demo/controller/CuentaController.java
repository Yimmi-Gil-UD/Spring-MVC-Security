package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.CuentaService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@PostMapping("/crearCuenta")
	public String crearCuentaBancaria(@RequestBody CuentaBancaria cuenta)
	{
		return cuentaService.adicionarCuenta(cuenta);
	}
	
	@GetMapping("/datosCuenta")
	public List<CuentaBancaria> datosCuenta(){
		return cuentaService.getDatos();
	}
	
	@GetMapping("/detailTipoCuenta")
	public Flux<CuentaBancaria> detalleCuentasTipo(String tipoCuenta) {
		return cuentaService.detailTipoCuenta(tipoCuenta);
	}

	@DeleteMapping("/eliminarCuenta")
	public boolean eliminarCuenta(int id) {
		return cuentaService.eliminarCuenta(id);
	}
}
