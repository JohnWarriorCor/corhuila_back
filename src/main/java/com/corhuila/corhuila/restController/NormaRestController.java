package com.corhuila.corhuila.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.service.INormaService;

@RestController
@RequestMapping(path = "norma")
public class NormaRestController {
	
	@Autowired
	INormaService normaService;
	
	@GetMapping(path = "obtener-normas")
	public List<Norma> obtenerNormas() {
		
		return normaService.obtenerNormas();
		
	}
	
	@GetMapping(path = "obtener-entidades-externas")
	public List<EntidadExterna> obtenerEntidadesExternas() {
		
		return normaService.obtenerEntidadesExternas();
		
	}
	
	@GetMapping(path = "obtener-normas-tipo/{entidadCodigo}")
	public List<NormaTipo> obtenerNormasTipo(@PathVariable int entidadCodigo) {
		
		return normaService.obtenerNormasTipo(entidadCodigo);
		
	}
	
	@PostMapping(path = "registrar-norma")
	public int registrarNorma(@RequestBody Norma norma) {

		return normaService.registrarNorma(norma);
		
	}
	
	@PutMapping(path = "actualizar-norma")
	public int actualizarNorma(@RequestBody Norma norma) {
		
		return normaService.actualizarNorma(norma);
		
	}

}
