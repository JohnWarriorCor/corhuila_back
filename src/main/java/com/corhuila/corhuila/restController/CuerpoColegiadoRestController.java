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

import com.corhuila.corhuila.entities.CuerpoColegiado;
import com.corhuila.corhuila.entities.FuncionesCuerpoColegiado;
import com.corhuila.corhuila.service.ICuerpoColegiadoService;

@RestController
@RequestMapping(path = "cuerpocolegiado")
public class CuerpoColegiadoRestController {
	
	@Autowired
	ICuerpoColegiadoService cuerposColegiadosService;
	
	@GetMapping(path = "obtener-listado-cuerpos-colegiados")
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados() {
		
		return cuerposColegiadosService.obtenerListadoCuerposColegiados();
		
	}
	
	@GetMapping(path = "obtener-listado-funciones/{codigoCuerpoColegiado}")
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(@PathVariable int codigoCuerpoColegiado) {
		
		return cuerposColegiadosService.obtenerListadoFunciones(codigoCuerpoColegiado);
		
	}
	
	@PostMapping(path = "registrar-cuerpos-colegiados")
	public int registrarCuerpoColegiado(@RequestBody CuerpoColegiado cuerposColegiados) {

		return cuerposColegiadosService.registrarCuerpoColegiado(cuerposColegiados);
		
	}
	
	@PutMapping(path = "actualizar-cuerpos-colegiados")
	public int actualizarCuerpoColegiado(@RequestBody CuerpoColegiado cuerposColegiados) {
		
		return cuerposColegiadosService.actualizarCuerpoColegiado(cuerposColegiados);
		
	}
	
	@PostMapping(path = "registrar-funciones-cuerpo-colegiado")
	public int registrarFuncion(@RequestBody FuncionesCuerpoColegiado funcion) {

		return cuerposColegiadosService.registrarFuncion(funcion);
		
	}
	
	@PutMapping(path = "actualizar-funciones-cuerpo-colegiado")
	public int actualizarFuncion(@RequestBody FuncionesCuerpoColegiado funcion) {
		
		return cuerposColegiadosService.actualizarFuncion(funcion);
		
	}

}
