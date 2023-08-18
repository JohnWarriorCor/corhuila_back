package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.IUbicacionDao;
import com.corhuila.corhuila.service.IUbicacionService;
import com.corhuila.corhuila.entities.CabecerasCentrosPoblados;
import com.corhuila.corhuila.entities.Departamento;
import com.corhuila.corhuila.entities.Municipio;
import com.corhuila.corhuila.entities.Pais;

@Service
public class UbicacionServiceImpl implements IUbicacionService{
	
	@Autowired
	private IUbicacionDao ubicacionDao;

	@Override
	public List<Pais> obtenerPaisLocal() {
		
		return ubicacionDao.obtenerPaisLocal();
		
	}

	@Override
	public List<Pais> obtenerPaises() {
		
		return ubicacionDao.obtenerPaises();
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		
		return ubicacionDao.obtenerDepartamentosPorPais(paiCodigo);
		
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo) {
		
		return ubicacionDao.obtenerMunicipiosPorDepartamento(depCodigo);
		
	}

	@Override
	public List<CabecerasCentrosPoblados> obtenerCcpPorMunicipio(String munCodigo) {
		
		return ubicacionDao.obtenerCcpPorMunicipio(munCodigo);
		
	}

}
