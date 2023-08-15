package com.corhuila.corhuila.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.corhuila.entities.ComunidadNegra;
import com.corhuila.corhuila.entities.DiscapacidadTipo;
import com.corhuila.corhuila.entities.EstadoCivil;
import com.corhuila.corhuila.entities.Estrato;
import com.corhuila.corhuila.entities.GrupoEtnico;
import com.corhuila.corhuila.entities.GrupoSanguineo;
import com.corhuila.corhuila.entities.PersonaDiscapacidad;
import com.corhuila.corhuila.entities.PuebloIndigena;
import com.corhuila.corhuila.entities.SexoBiologico;
import com.corhuila.corhuila.entities.TalentoExcepcional;
import com.corhuila.corhuila.entities.TipoIdentificacion;
import com.corhuila.corhuila.service.IPersonaService;

@RestController
@RequestMapping(path = "persona")
public class PersonaRestController {
	
	@Autowired
	IPersonaService personaService;
	
	@GetMapping(path = "obtener-tipo-id")
	public List<TipoIdentificacion> obtenerPaisLocal() {
		
		return personaService.obtenerTipoId();
		
	}
	
	@GetMapping(path = "obtener-sexo-biologico")
	public List<SexoBiologico> obtenerSexoBiologico() {
		
		return personaService.obtenerSexoBiologico();
		
	}
	
	@GetMapping(path = "obtener-grupo-sanguineo")
	public List<GrupoSanguineo> obtenerGrupoSanguineo() {
		
		return personaService.obtenerGrupoSanguineo();
		
	}
	
	@GetMapping(path = "obtener-estado-civil")
	public List<EstadoCivil> obtenerEstadoCivil() {
		
		return personaService.obtenerEstadoCivil();
		
	}
	
	@GetMapping(path = "obtener-comunidades-negras")
	public List<ComunidadNegra> obtenerComunidadesNegras() {
		
		return personaService.obtenerComunidadesNegras();
		
	}
	
	@GetMapping(path = "obtener-tipos-discapacidades")
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades() {
		
		return personaService.obtenerTiposDiscapacidades();
		
	}
	
	@GetMapping(path = "obtener-estratos")
	public List<Estrato> obtenerEstratos() {
		
		return personaService.obtenerEstratos();
		
	}
	
	@GetMapping(path = "obtener-grupos-etnicos")
	public List<GrupoEtnico> obtenerGruposEtnicos() {
		
		return personaService.obtenerGruposEtnicos();
		
	}
	
	@GetMapping(path = "obtener-personas-discapacidad")
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad() {
		
		return personaService.obtenerPersonasDiscapacidad();
		
	}
	
	@GetMapping(path = "obtener-pueblos-indigenas")
	public List<PuebloIndigena> obtenerPueblosIndigenas() {
		
		return personaService.obtenerPueblosIndigenas();
		
	}
	
	@GetMapping(path = "obtener-talentos-excepcionales")
	public List<TalentoExcepcional> obtenerTalentosExcepcionales() {
		
		return personaService.obtenerTalentosExcepcionales();
		
	}

}
