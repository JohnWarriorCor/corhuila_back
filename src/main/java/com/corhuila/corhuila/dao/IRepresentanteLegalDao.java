package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.RepresentanteLegal;

public interface IRepresentanteLegalDao {
	
	public List<RepresentanteLegal> obtenerListadoRepresentanteLegal();
	
	public int registrar(RepresentanteLegal representanteLegal);
	
	int actualizar(RepresentanteLegal representanteLegal);

}
