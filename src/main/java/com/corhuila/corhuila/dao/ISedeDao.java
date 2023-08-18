package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.Sede;
import com.corhuila.corhuila.entities.SedeTipo;

public interface ISedeDao {
	
	public List<SedeTipo> obtenerListadoTiposSedes();
	
	public List<Sede> obtenerListadoSedes();
	
	public int registrar(Sede sede);
	
	int actualizar(Sede sede);

}
