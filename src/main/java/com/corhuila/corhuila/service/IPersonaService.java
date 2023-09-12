package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.ComunidadNegra;
import com.corhuila.corhuila.entities.DiscapacidadTipo;
import com.corhuila.corhuila.entities.EstadoCivil;
import com.corhuila.corhuila.entities.Estrato;
import com.corhuila.corhuila.entities.GrupoEtnico;
import com.corhuila.corhuila.entities.GrupoSanguineo;
import com.corhuila.corhuila.entities.Persona;
import com.corhuila.corhuila.entities.PersonaDiscapacidad;
import com.corhuila.corhuila.entities.PuebloIndigena;
import com.corhuila.corhuila.entities.SexoBiologico;
import com.corhuila.corhuila.entities.TalentoExcepcional;
import com.corhuila.corhuila.entities.TipoIdentificacion;

public interface IPersonaService {
	
	public List<Persona> obtenerPersonas();
	
	public List<Persona> obtenerPersonaIdentificacion(String id);
	
	public List<TipoIdentificacion> obtenerTipoId();
	
	public List<SexoBiologico> obtenerSexoBiologico();
	
	public List<GrupoSanguineo> obtenerGrupoSanguineo();
	
	public List<EstadoCivil> obtenerEstadoCivil();
	
	public List<ComunidadNegra> obtenerComunidadesNegras();
	
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades();
	
	public List<Estrato> obtenerEstratos();
	
	public List<GrupoEtnico> obtenerGruposEtnicos();
	
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad();
	
	public List<PuebloIndigena> obtenerPueblosIndigenas();
	
	public List<TalentoExcepcional> obtenerTalentosExcepcionales();
	
	public int registrar(Persona persona);
	
	int actualizar(Persona persona);

}
