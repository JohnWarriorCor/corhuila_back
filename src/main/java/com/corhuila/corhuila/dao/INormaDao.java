package com.corhuila.corhuila.dao;

import java.util.List;

import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaClasificacion;
import com.corhuila.corhuila.entities.NormaDeroga;
import com.corhuila.corhuila.entities.NormaGrupo;
import com.corhuila.corhuila.entities.EntidadExterna;

public interface INormaDao {
	
	public List<Norma> obtenerNormas();
	
	public List<Norma> obtenerNorma(int normaCodigo);
	
	public List<Norma> obtenerNormasNoDerogadas();
	
	public List<EntidadExterna> obtenerEntidadesExternas();
	
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo);
	
	public int registrarNorma(Norma norma);
	
	public int actualizarNorma(Norma norma);
	
	public int suspenderNorma(Norma norma);
	
///////DEROGACIÓN
	
	public List<NormaDeroga> obtenerNormaDerogada(int norma);
	
	public int registrarNormaDeroga(NormaDeroga deroga);
	
	public int actualizarNormaDeroga(NormaDeroga deroga);
	
	
///////CLASIFICACION
	
	public List<NormaGrupo> obtenerNormaGruposAgrupados();
	
	public List<NormaGrupo> obtenerNormaGrupos();
	
	public List<Norma> obtenerNormaSinClasificar(int normaGrupoCodigo);
	
	public List<NormaClasificacion> obtenerNormaClasificada(int normaGrupoCodigo);
	
	public int registrarNormaClasificada(NormaClasificacion normaClasificacion);
	
	public int actualizarNormaClasificada(NormaClasificacion normaClasificacion);
	
	public int registrarNormaGrupo(NormaGrupo normaGrupo);
	
	public int actualizarNormaGrupo(NormaGrupo normaGrupo);

}
