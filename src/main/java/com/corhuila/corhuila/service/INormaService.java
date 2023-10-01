package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaTipo;

public interface INormaService {
	
	public List<Norma> obtenerNormas();
	
	public List<EntidadExterna> obtenerEntidadesExternas();
	
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo);
	
	public int registrarNorma(Norma norma);
	
	public int actualizarNorma(Norma norma);

}
