package com.corhuila.corhuila.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corhuila.entities.Sede;
import com.corhuila.corhuila.entities.SedeTipo;
import com.corhuila.corhuila.service.ISedeService;

@RestController
@RequestMapping(path = "sede")
public class SedeRestController {
	
	@Autowired
	ISedeService sedeService;
	
	@GetMapping(path = "obtener-listado-tipo-sedes")
	public List<SedeTipo> obtenerListadoTiposSedes() {
		
		return sedeService.obtenerListadoTiposSedes();
		
	}
	
	@GetMapping(path = "obtener-listado-sedes")
	public List<Sede> obtenerListadoSedes() {
		
		return sedeService.obtenerListadoSedes();
		
	}
	
	@PostMapping(path = "registrar-sede")
	public int registrar(@RequestBody Sede sede) {

		return sedeService.registrar(sede);
		
	}
	
	@PutMapping(path = "actualizar-sede")
	public int actualizar(@RequestBody Sede sede) {
		
		return sedeService.actualizar(sede);
		
	}

}
