package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.IInstitucionDao;
import com.corhuila.corhuila.entities.CaracterAcademico;
import com.corhuila.corhuila.entities.Institucion;
import com.corhuila.corhuila.entities.NaturalezaJuridica;
import com.corhuila.corhuila.entities.Sector;
import com.corhuila.corhuila.service.IInstitucionService;

@Service
public class InstitucionServiceImp implements IInstitucionService{
	
	@Autowired
	private IInstitucionDao institucionDao;

	@Override
	public List<CaracterAcademico> obtenerListadoCaracterAcademico() {
		
		return institucionDao.obtenerListadoCaracterAcademico();
		
	}

	@Override
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica() {
		return institucionDao.obtenerListadoNaturalezaJuridica();
	}

	@Override
	public List<Sector> obtenerListadoSector() {
		return institucionDao.obtenerListadoSector();
	}

	@Override
	public List<Institucion> obtenerListadoInstitucion() {
		return institucionDao.obtenerListadoInstitucion();
	}
	
	@Override
	public List<Institucion> obtenerInstitucion() {
		return institucionDao.obtenerInstitucion();
	}

	@Override
	public int registrar(Institucion institucion) {
		return institucionDao.registrar(institucion);
	}

	@Override
	public int actualizar(Institucion institucion) {
		return institucionDao.actualizar(institucion);
	}
	
}
