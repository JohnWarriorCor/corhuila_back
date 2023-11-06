package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.AreaConocimiento;
import com.corhuila.corhuila.entities.Nbc;
import com.corhuila.corhuila.entities.NivelFormacion;
import com.corhuila.corhuila.entities.Programa;

public interface IProgramaService {
	
	public List<Programa> obtenerListadoProgramas();
	
	public List<NivelFormacion> obtenerListadoNivelesFormacion();
	
	public List<NivelFormacion> obtenerListadoNivelFormacion(int nivelAcademicoCodigo);
	
	public List<AreaConocimiento> obtenerListadoAreaConocimiento();
	
	public List<Nbc> obtenerListadoNbc(int areaConocimientoCodigo);
	
	public int registrarPrograma(Programa programa);
	
	public int actualizarPrograma(Programa programa);

}
