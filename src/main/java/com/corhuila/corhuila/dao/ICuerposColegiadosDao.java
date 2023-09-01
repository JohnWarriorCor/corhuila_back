package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.CuerposColegiados;

public interface ICuerposColegiadosDao {
	
	public List<CuerposColegiados> obtenerListadoCuerposColegiados();
	
	public int registrar(CuerposColegiados cuerposColegiados);
	
	int actualizar(CuerposColegiados cuerposColegiados);

}
