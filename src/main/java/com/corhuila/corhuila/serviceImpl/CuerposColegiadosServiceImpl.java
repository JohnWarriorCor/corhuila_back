package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.ICuerposColegiadosDao;
import com.corhuila.corhuila.entities.CuerposColegiados;
import com.corhuila.corhuila.entities.Funciones;
import com.corhuila.corhuila.service.ICuerposColegiadosService;

@Service
public class CuerposColegiadosServiceImpl implements ICuerposColegiadosService{
	
	@Autowired
	private ICuerposColegiadosDao cuerposColegiadosDao;

	@Override
	public List<CuerposColegiados> obtenerListadoCuerposColegiados() {
		
		return cuerposColegiadosDao.obtenerListadoCuerposColegiados();
		
	}
	
	@Override
	public List<Funciones> obtenerListadoFunciones() {
		
		return cuerposColegiadosDao.obtenerListadoFunciones();
		
	}

	@Override
	public int registrar(CuerposColegiados cuerposColegiados) {
		
		return cuerposColegiadosDao.registrar(cuerposColegiados);
		
	}

	@Override
	public int actualizar(CuerposColegiados cuerposColegiados) {
		
		return cuerposColegiadosDao.actualizar(cuerposColegiados);
		
	}

}
