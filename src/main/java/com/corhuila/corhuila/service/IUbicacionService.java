package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.Departamento;
import com.corhuila.corhuila.entities.Municipio;
import com.corhuila.corhuila.entities.Pais;

public interface IUbicacionService {
	
	public List<Pais> obtenerPaisLocal();
	
	public List<Pais> obtenerPaises();
	
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo);
	
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo);

}
