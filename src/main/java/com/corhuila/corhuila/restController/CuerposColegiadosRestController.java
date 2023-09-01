package com.corhuila.corhuila.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corhuila.entities.CuerposColegiados;
import com.corhuila.corhuila.service.ICuerposColegiadosService;

@RestController
@RequestMapping(path = "cuerposcolegiados")
public class CuerposColegiadosRestController {
	
	@Autowired
	ICuerposColegiadosService cuerposColegiadosService;
	
	@GetMapping(path = "obtener-listado-cuerpos-colegiados")
	public List<CuerposColegiados> obtenerListadoCuerposColegiados() {
		
		return cuerposColegiadosService.obtenerListadoCuerposColegiados();
		
	}
	
	@PostMapping(path = "registrar-cuerpos-colegiados")
	public int registrar(@RequestBody CuerposColegiados cuerposColegiados) {

		return cuerposColegiadosService.registrar(cuerposColegiados);
		
	}
	
	@PutMapping(path = "actualizar-cuerpos-colegiados")
	public int actualizar(@RequestBody CuerposColegiados cuerposColegiados) {
		
		return cuerposColegiadosService.actualizar(cuerposColegiados);
		
	}

}
