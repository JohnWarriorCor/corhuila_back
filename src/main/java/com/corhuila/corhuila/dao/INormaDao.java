package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.EntidadExterna;

public interface INormaDao {
	
	public List<Norma> obtenerNormas();
	
	public List<EntidadExterna> obtenerEntidadesExternas();
	
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo);
	
	public int registrarNorma(Norma norma);
	
	public int actualizarNorma(Norma norma);

}
