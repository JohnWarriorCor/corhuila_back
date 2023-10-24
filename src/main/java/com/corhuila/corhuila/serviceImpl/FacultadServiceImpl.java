package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.IFacultadDao;
import com.corhuila.corhuila.entities.Facultad;
import com.corhuila.corhuila.service.IFacultadService;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	@Autowired
	private IFacultadDao facultadDao;

	@Override
	public List<Facultad> obtenerListadoFacultades() {
		
		return facultadDao.obtenerListadoFacultades();
		
	}
	
	@Override
	public List<Facultad> obtenerListadoFacultadSede(int sedeCodigo) {
		
		return facultadDao.obtenerListadoFacultadSede(sedeCodigo);
		
	}

	@Override
	public int registrar(Facultad facultad) {
		
		return facultadDao.registrar(facultad);
		
	}

	@Override
	public int actualizar(Facultad facultad) {
		
		return facultadDao.actualizar(facultad);
		
	}

}
