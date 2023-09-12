package com.corhuila.corhuila.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.corhuila.dao.IPersonaDao;
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
import com.corhuila.corhuila.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public List<Persona> obtenerPersonaIdentificacion(String id) {
		
		return personaDao.obtenerPersonaIdentificacion(id);
		
	}

	@Override
	public List<TipoIdentificacion> obtenerTipoId() {
		
		return personaDao.obtenerTipoId();
	}

	@Override
	public List<SexoBiologico> obtenerSexoBiologico() {
		
		return personaDao.obtenerSexoBiologico();
		
	}

	@Override
	public List<GrupoSanguineo> obtenerGrupoSanguineo() {
		
		return personaDao.obtenerGrupoSanguineo();
		
	}

	@Override
	public List<EstadoCivil> obtenerEstadoCivil() {
		
		return personaDao.obtenerEstadoCivil();
		
	}

	@Override
	public List<ComunidadNegra> obtenerComunidadesNegras() {
		
		return personaDao.obtenerComunidadesNegras();
		
	}
	
	@Override
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades() {
		
		return personaDao.obtenerTiposDiscapacidades();
		
	}

	@Override
	public List<Estrato> obtenerEstratos() {
		
		return personaDao.obtenerEstratos();
		
	}

	@Override
	public List<GrupoEtnico> obtenerGruposEtnicos() {
		
		return personaDao.obtenerGruposEtnicos();
		
	}

	@Override
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad() {
		
		return personaDao.obtenerPersonasDiscapacidad();
		
	}

	@Override
	public List<PuebloIndigena> obtenerPueblosIndigenas() {
		
		return personaDao.obtenerPueblosIndigenas();
		
	}

	@Override
	public List<TalentoExcepcional> obtenerTalentosExcepcionales() {
		
		return personaDao.obtenerTalentosExcepcionales();
		
	}

	@Override
	public List<Persona> obtenerPersonas() {
		
		return personaDao.obtenerPersonas();
		
	}

	@Override
	public int registrar(Persona persona) {
		
		return personaDao.registrar(persona);
		
	}

	@Override
	public int actualizar(Persona persona) {
		
		return personaDao.actualizar(persona);
		
	}

}
