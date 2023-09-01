package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.IRepresentanteLegalDao;
import com.corhuila.corhuila.entities.RepresentanteLegal;
import com.corhuila.corhuila.service.IRepresentanteLegalSevice;

@Service
public class RepresentanteLegalSeviceImpl implements IRepresentanteLegalSevice{
	
	@Autowired
	private IRepresentanteLegalDao representanteLegalDao;

	@Override
	public List<RepresentanteLegal> obtenerListadoRepresentanteLegal() {
		
		return representanteLegalDao.obtenerListadoRepresentanteLegal();
		
	}

	@Override
	public int registrar(RepresentanteLegal representanteLegal) {
		
		return representanteLegalDao.registrar(representanteLegal);
		
	}

	@Override
	public int actualizar(RepresentanteLegal representanteLegal) {
		
		return representanteLegalDao.actualizar(representanteLegal);
		
	}
}
