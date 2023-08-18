package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.Sede;
import com.corhuila.corhuila.entities.SedeTipo;

public interface ISedeService {
	
	public List<SedeTipo> obtenerListadoTiposSedes();
	
	public List<Sede> obtenerListadoSedes();
	
	public int registrar(Sede sede);
	
	int actualizar(Sede sede);

}
