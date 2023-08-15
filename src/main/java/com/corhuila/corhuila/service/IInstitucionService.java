package com.corhuila.corhuila.service;

import java.util.List;


import com.corhuila.corhuila.entities.CaracterAcademico;
import com.corhuila.corhuila.entities.Institucion;
import com.corhuila.corhuila.entities.NaturalezaJuridica;
import com.corhuila.corhuila.entities.Sector;

public interface IInstitucionService {
	
	public List<CaracterAcademico> obtenerListadoCaracterAcademico();
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica();
	public List<Sector> obtenerListadoSector();
	
	public List<Institucion> obtenerListadoInstitucion();
	public int registrar(Institucion institucion);
	int actualizar(Institucion institucion);

}
