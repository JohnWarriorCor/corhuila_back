package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.Facultad;

public interface IFacultadService {
	
	public List<Facultad> obtenerListadoFacultades();
	
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo);
	
	public int registrar(Facultad facultad);
	
	public int actualizar(Facultad facultad);

}
