package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.CuerposColegiados;

public interface ICuerposColegiadosService {
	
	public List<CuerposColegiados> obtenerListadoCuerposColegiados();
	
	public int registrar(CuerposColegiados cuerposColegiados);
	
	int actualizar(CuerposColegiados cuerposColegiados);

}
