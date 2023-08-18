package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.ISedeDao;
import com.corhuila.corhuila.entities.Sede;
import com.corhuila.corhuila.entities.SedeTipo;
import com.corhuila.corhuila.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{
	
	@Autowired
	private ISedeDao sedeDao;

	@Override
	public List<SedeTipo> obtenerListadoTiposSedes() {

		return sedeDao.obtenerListadoTiposSedes();
	}

	@Override
	public List<Sede> obtenerListadoSedes() {
		
		return sedeDao.obtenerListadoSedes();
		
	}

	@Override
	public int registrar(Sede sede) {

		return sedeDao.registrar(sede);
		
	}

	@Override
	public int actualizar(Sede sede) {
		
		return sedeDao.actualizar(sede);
		
	}
}
