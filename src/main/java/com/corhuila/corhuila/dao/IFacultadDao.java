package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.Facultad;

public interface IFacultadDao {	
	
	public List<Facultad> obtenerListadoFacultades();
	
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo);
	
	public int registrar(Facultad facultad);
	
	public int actualizar(Facultad facultad);

}
