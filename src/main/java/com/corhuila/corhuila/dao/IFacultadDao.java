package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.Facultad;

public interface IFacultadDao {	
	
	public List<Facultad> obtenerListadoFacultades();
	
	public int registrar(Facultad facultad);
	
	int actualizar(Facultad facultad);

}
