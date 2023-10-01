package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.INormaDao;
import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.service.INormaService;

@Service
public class NormaServiceImpl implements INormaService{
	
	@Autowired
	private INormaDao normaDao;
	
	@Override
	public List<Norma> obtenerNormas() {
		
		return normaDao.obtenerNormas();
				
	}

	@Override
	public List<EntidadExterna> obtenerEntidadesExternas() {
		
		return normaDao.obtenerEntidadesExternas();
		
	}

	@Override
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo) {
		
		return normaDao.obtenerNormasTipo(entidadCodigo);
		
	}

	@Override
	public int registrarNorma(Norma norma) {
		
		return normaDao.registrarNorma(norma);
		
	}

	@Override
	public int actualizarNorma(Norma norma) {
		
		return normaDao.actualizarNorma(norma);
		
	}
	
}
