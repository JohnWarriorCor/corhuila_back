package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.CuerposColegiados;
import com.corhuila.corhuila.entities.Funciones;

public interface ICuerposColegiadosService {
	
	public List<CuerposColegiados> obtenerListadoCuerposColegiados();
	
	public List<Funciones> obtenerListadoFunciones();
	
	public int registrar(CuerposColegiados cuerposColegiados);
	
	int actualizar(CuerposColegiados cuerposColegiados);

}
