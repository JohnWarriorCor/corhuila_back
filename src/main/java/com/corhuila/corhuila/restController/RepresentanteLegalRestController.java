package com.corhuila.corhuila.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corhuila.entities.RepresentanteLegal;
import com.corhuila.corhuila.service.IRepresentanteLegalSevice;

@RestController
@RequestMapping(path = "representantelegal")
public class RepresentanteLegalRestController {
	
	@Autowired
	IRepresentanteLegalSevice representanteLegalSevice;
	
	@GetMapping(path = "obtener-listado-representante-legal")
	public List<RepresentanteLegal> obtenerListadoRepresentanteLegal() {
		
		return representanteLegalSevice.obtenerListadoRepresentanteLegal();
		
	}
	
	@PostMapping(path = "registrar-representante-legal")
	public int registrar(@RequestBody RepresentanteLegal representanteLegal) {

		return representanteLegalSevice.registrar(representanteLegal);
		
	}
	
	@PutMapping(path = "actualizar-representante-legal")
	public int actualizar(@RequestBody RepresentanteLegal representanteLegal) {
		
		return representanteLegalSevice.actualizar(representanteLegal);
		
	}

}
