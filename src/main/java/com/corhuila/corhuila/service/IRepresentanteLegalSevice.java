package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.RepresentanteLegal;

public interface IRepresentanteLegalSevice {
	
	public List<RepresentanteLegal> obtenerListadoRepresentanteLegal();
	
	public int registrar(RepresentanteLegal representanteLegal);
	
	int actualizar(RepresentanteLegal representanteLegal);

}
