package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.INormaDao;
import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaClasificacion;
import com.corhuila.corhuila.entities.NormaDeroga;
import com.corhuila.corhuila.entities.NormaGrupo;
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
	public List<Norma> obtenerNorma(int normaCodigo) {
		
		return normaDao.obtenerNorma(normaCodigo);
		
	}
	
	@Override
	public List<Norma> obtenerNormasNoDerogadas() {
		
		return normaDao.obtenerNormasNoDerogadas();
		
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
	
	@Override
	public int suspenderNorma(Norma norma) {
		
		return normaDao.suspenderNorma(norma);
		
	}
	
///////DEROGACIÓN

	@Override
	public List<NormaDeroga> obtenerNormaDerogada(int norma) {

		return normaDao.obtenerNormaDerogada(norma);
		
	}

	@Override
	public int registrarNormaDeroga(NormaDeroga deroga) {
		
		return normaDao.registrarNormaDeroga(deroga);
		
	}

	@Override
	public int actualizarNormaDeroga(NormaDeroga deroga) {
		
		return normaDao.actualizarNormaDeroga(deroga);
	}
	
/////CLASIFICACION
	
	@Override
	public List<NormaGrupo> obtenerNormaGrupos() {
		
		return normaDao.obtenerNormaGrupos();
		
	}

	@Override
	public List<Norma> obtenerNormaSinClasificar(int normaGrupoCodigo) {
		
		return normaDao.obtenerNormaSinClasificar(normaGrupoCodigo);
		
	}

	@Override
	public List<NormaClasificacion> obtenerNormaClasificada(int normaGrupoCodigo) {
		
		return normaDao.obtenerNormaClasificada(normaGrupoCodigo);
		
	}

	@Override
	public int registrarNormaClasificada(NormaClasificacion normaClasificacion) {
		
		return normaDao.registrarNormaClasificada(normaClasificacion);
		
	}

	@Override
	public int actualizarNormaClasificada(NormaClasificacion normaClasificacion) {
		
		return normaDao.actualizarNormaClasificada(normaClasificacion);
		
	}

	@Override
	public List<NormaGrupo> obtenerNormaGruposAgrupados() {
		
		return normaDao.obtenerNormaGruposAgrupados();
		
	}

	@Override
	public int registrarNormaGrupo(NormaGrupo normaGrupo) {
		
		return normaDao.registrarNormaGrupo(normaGrupo);
		
	}

	@Override
	public int actualizarNormaGrupo(NormaGrupo normaGrupo) {
		
		return normaDao.actualizarNormaGrupo(normaGrupo);
		
	}
	
}
