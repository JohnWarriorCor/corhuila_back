package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

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
import com.corhuila.corhuila.resultSetExtractor.ComunidadNegraSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.DiscapacidadTipoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.EstadoCivilSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.EstratoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.GrupoEtnicoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.GrupoSanguineoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PersonaDiscapacidadSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PersonaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PuebloIndigenaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.SexoBiologicoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.TalentoExcepcionalSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.TipoIdentificacionSetExtractor;

@Repository
public class PersonaDaoImpl implements IPersonaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Persona> obtenerPersonaIdentificacion(String id) {
		
		String sql = "select * from general.persona p "
				+ "INNER JOIN general.tipo_identificacion ti on p.tii_codigo = ti.tii_codigo "
				+ "INNER JOIN general.sexo_biologico sb on p.seb_codigo = sb.seb_codigo "
				+ "INNER JOIN general.estado_civil ec on p.esc_codigo = ec.esc_codigo "
				+ "INNER JOIN general.estrato e on p.est_codigo = e.est_codigo "
				+ "INNER JOIN general.grupo_etnico ge on p.gre_codigo = ge.gre_codigo "
				+ "INNER JOIN general.pueblo_indigena pui on p.pui_codigo = pui.pui_codigo "
				+ "INNER JOIN general.comunidad_negra cn on p.con_codigo = cn.con_codigo "
				+ "INNER JOIN general.persona_discapacidad pd on p.ped_codigo = pd.ped_codigo "
				+ "INNER JOIN general.discapacidad_tipo dt on p.dit_codigo = dt.dit_codigo "
				+ "INNER JOIN general.talento_excepcional te on p.tae_codigo = te.tae_codigo "
				+ "INNER JOIN general.grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo "
				+ "where p.per_identificacion = '" + id + "' and p.per_estado = 1 ";
		return jdbcTemplate.query(sql, new PersonaSetExtractor());
		
	}

	@Override
	public List<TipoIdentificacion> obtenerTipoId() {
		
		String sql = "select * from general.tipo_identificacion ti where ti.tii_estado = 1";
		return jdbcTemplate.query(sql, new TipoIdentificacionSetExtractor());
		
	}

	@Override
	public List<SexoBiologico> obtenerSexoBiologico() {
		
		String sql = "select * from general.sexo_biologico sb where sb.seb_estado = 1";
		return jdbcTemplate.query(sql, new SexoBiologicoSetExtractor());
	}

	@Override
	public List<GrupoSanguineo> obtenerGrupoSanguineo() {
		
		String sql = "select * from general.grupo_sanguineo gs where gs.grs_estado = 1";
		return jdbcTemplate.query(sql, new GrupoSanguineoSetExtractor());
		
	}

	@Override
	public List<EstadoCivil> obtenerEstadoCivil() {
		
		String sql = "select * from general.estado_civil ec where ec.esc_estado = 1";
		return jdbcTemplate.query(sql, new EstadoCivilSetExtractor());
		
	}

	@Override
	public List<ComunidadNegra> obtenerComunidadesNegras() {
		
		String sql = "select * from general.comunidad_negra cn where cn.con_estado = 1";
		return jdbcTemplate.query(sql, new ComunidadNegraSetExtractor());
		
	}
	
	@Override
	public List<DiscapacidadTipo> obtenerTiposDiscapacidades() {
		
		String sql = "select * from general.discapacidad_tipo dt where dt.dit_estado = 1";
		return jdbcTemplate.query(sql, new DiscapacidadTipoSetExtractor());
		
	}

	@Override
	public List<Estrato> obtenerEstratos() {
		
		String sql = "select * from general.estrato e where e.est_estado = 1";
		return jdbcTemplate.query(sql, new EstratoSetExtractor());
		
	}

	@Override
	public List<GrupoEtnico> obtenerGruposEtnicos() {
		
		String sql = "select * from general.grupo_etnico ge where ge.gre_estado = 1";
		return jdbcTemplate.query(sql, new GrupoEtnicoSetExtractor());
		
	}

	@Override
	public List<PersonaDiscapacidad> obtenerPersonasDiscapacidad() {
		
		String sql = "select * from general.persona_discapacidad pd where pd.ped_estado = 1";
		return jdbcTemplate.query(sql, new PersonaDiscapacidadSetExtractor());
		
	}

	@Override
	public List<PuebloIndigena> obtenerPueblosIndigenas() {
		
		String sql = "select * from general.pueblo_indigena pui where pui.pui_estado = 1";
		return jdbcTemplate.query(sql, new PuebloIndigenaSetExtractor());
		
	}

	@Override
	public List<TalentoExcepcional> obtenerTalentosExcepcionales() {
		
		String sql = "select * from general.talento_excepcional te where te.tae_estado = 1";
		return jdbcTemplate.query(sql, new TalentoExcepcionalSetExtractor());
		
	}

	@Override
	public List<Persona> obtenerPersonas() {
		
		String sql = "select * from general.persona p "
				+ "INNER JOIN general.tipo_identificacion ti on p.tii_codigo = ti.tii_codigo "
				+ "INNER JOIN general.sexo_biologico sb on p.seb_codigo = sb.seb_codigo "
				+ "INNER JOIN general.estado_civil ec on p.esc_codigo = ec.esc_codigo "
				+ "INNER JOIN general.estrato e on p.est_codigo = e.est_codigo "
				+ "INNER JOIN general.grupo_etnico ge on p.gre_codigo = ge.gre_codigo "
				+ "INNER JOIN general.pueblo_indigena pui on p.pui_codigo = pui.pui_codigo "
				+ "INNER JOIN general.comunidad_negra cn on p.con_codigo = cn.con_codigo "
				+ "INNER JOIN general.persona_discapacidad pd on p.ped_codigo = pd.ped_codigo "
				+ "INNER JOIN general.discapacidad_tipo dt on p.dit_codigo = dt.dit_codigo "
				+ "INNER JOIN general.talento_excepcional te on p.tae_codigo = te.tae_codigo "
				+ "INNER JOIN general.grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo "
				+ "where p.per_estado = 1 "
				+ "order by p.per_codigo desc";
		return jdbcTemplate.query(sql, new PersonaSetExtractor());
		
	}

	@Override
	public int registrar(Persona persona) {
		String sql = "INSERT INTO general.persona "
				+ "(per_identificacion, tii_codigo, per_libreta_militar, per_apellido, per_nombre, seb_codigo, per_lugar_expedicion, per_fecha_expedicion, per_fecha_nacimiento, per_direccion_residencia, per_telefono_movil, per_telefono_fijo, esc_codigo, per_lugar_nacimiento, est_codigo, per_pais_residencia, per_departamento_residencia, per_municipio_residencia, per_lugar_residencia, per_barrio, gre_codigo, pui_codigo, con_codigo, ped_codigo, dit_codigo, tae_codigo, per_familiar_direccion, per_familiar_nombre, per_familiar_telefono, per_familiar_lugar_residencia, per_email, grs_codigo) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				persona.getIdentificacion(),
		        persona.getTipoId().getCodigo(),
		        persona.getLibretaMilitar(),
		        persona.getApellido(),
		        persona.getNombre(),
		        persona.getSexoBiologico().getCodigo(),
		        persona.getLugarExpedicion(),
		        persona.getFechaExpedicion(),
		        persona.getFechaNacimiento(),
		        persona.getDireccion(),
		        persona.getMovil(),
		        persona.getFijo(),
		        persona.getEstadoCivil().getCodigo(),
		        persona.getLugarNacimiento(),
		        persona.getEstrato().getCodigo(),
		        persona.getPaisResidencia(),
		        persona.getDepartamentoResidencia(),
		        persona.getMunicipioResidencia(),
		        persona.getLugarResidencia(),
		        persona.getBarrio(),
		        persona.getGrupoEtnico().getCodigo(),
		        persona.getPuebloIndigena().getCodigo(),
		        persona.getComunidadNegra().getCodigo(),
		        persona.getPersonaDiscapacidad().getCodigo(),
		        persona.getDiscapacidadTipo().getCodigo(),
		        persona.getTalentoExepcional().getCodigo(),
		        persona.getFamiliarDireccion(),
		        persona.getFamiliarNombre(),
		        persona.getFamiliarTelefono(),
		        persona.getFamiliarLugarResidencia(),
		        persona.getCorreo(),
		        persona.getGrupoSanguineo().getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("identificacion", persona.getIdentificacion());
			parameter.addValue("tipoId", persona.getTipoId().getCodigo()); 
			parameter.addValue("libretaMilitar", persona.getLibretaMilitar());
			parameter.addValue("apellido", persona.getApellido());
			parameter.addValue("nombre", persona.getNombre());
			parameter.addValue("sexoBiologico", persona.getSexoBiologico().getCodigo());
			parameter.addValue("lugarExpedición", persona.getLugarExpedicion());
			parameter.addValue("fechaExpedicion", persona.getFechaExpedicion());
			parameter.addValue("fechaNacimiento", persona.getFechaNacimiento());
			parameter.addValue("direccion", persona.getDireccion());
			parameter.addValue("movil", persona.getMovil());
			parameter.addValue("fijo", persona.getFijo());
			parameter.addValue("estadoCivil", persona.getEstadoCivil().getCodigo()); 
			parameter.addValue("lugarNacimiento", persona.getLugarNacimiento());
			parameter.addValue("estrato", persona.getEstrato().getCodigo()); 
			parameter.addValue("paisResidencia", persona.getPaisResidencia()); 
			parameter.addValue("departamentoResidencia", persona.getDepartamentoResidencia()); 
			parameter.addValue("municipioResidencia", persona.getMunicipioResidencia()); 
			parameter.addValue("lugarResidencia", persona.getLugarResidencia()); 
			parameter.addValue("barrio", persona.getBarrio()); 
			parameter.addValue("grupoEtnico", persona.getGrupoEtnico().getCodigo()); 
			parameter.addValue("puebloIndigena", persona.getPuebloIndigena().getCodigo()); 
			parameter.addValue("comunidadNegra", persona.getComunidadNegra().getCodigo()); 
			parameter.addValue("personaDiscapacidad", persona.getPersonaDiscapacidad().getCodigo()); 
			parameter.addValue("discapacidadTipo", persona.getDiscapacidadTipo().getCodigo()); 
			parameter.addValue("talentoExepcional", persona.getTalentoExepcional().getCodigo()); 
			parameter.addValue("familiarDireccion", persona.getFamiliarDireccion());
			parameter.addValue("familiarNombre", persona.getFamiliarNombre());
			parameter.addValue("familiarTelefono", persona.getFamiliarTelefono());
			parameter.addValue("familiarLugarResidencia", persona.getFamiliarLugarResidencia());
			parameter.addValue("correo", persona.getCorreo());
			parameter.addValue("grupoSanguineo", persona.getGrupoSanguineo().getCodigo()); 

			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(Persona persona) {
		String sql = "UPDATE general.persona "
				+ "SET per_identificacion = ?, tii_codigo = ?, per_libreta_militar = ?, per_apellido = ?, per_nombre = ?, seb_codigo = ?, per_lugar_expedicion = ?, per_fecha_expedicion = ?, per_fecha_nacimiento = ?, per_direccion_residencia = ?, per_telefono_movil = ?, per_telefono_fijo = ?, esc_codigo = ?, per_lugar_nacimiento = ?, est_codigo = ?, per_pais_residencia = ?, per_departamento_residencia = ?, per_municipio_residencia = ?, per_lugar_residencia = ?, per_barrio = ?, gre_codigo = ?, pui_codigo = ?, con_codigo = ?, ped_codigo = ?, dit_codigo = ?, tae_codigo = ?, per_familiar_direccion = ?, per_familiar_nombre = ?, per_familiar_telefono = ?, per_familiar_lugar_residencia = ?, per_email = ?, grs_codigo = ?, per_estado = ? "
				+ "WHERE per_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				persona.getIdentificacion(),
		        persona.getTipoId().getCodigo(),
		        persona.getLibretaMilitar(),
		        persona.getApellido(),
		        persona.getNombre(),
		        persona.getSexoBiologico().getCodigo(),
		        persona.getLugarExpedicion(),
		        persona.getFechaExpedicion(),
		        persona.getFechaNacimiento(),
		        persona.getDireccion(),
		        persona.getMovil(),
		        persona.getFijo(),
		        persona.getEstadoCivil().getCodigo(),
		        persona.getLugarNacimiento(),
		        persona.getEstrato().getCodigo(),
		        persona.getPaisResidencia(),
		        persona.getDepartamentoResidencia(),
		        persona.getMunicipioResidencia(),
		        persona.getLugarResidencia(),
		        persona.getBarrio(),
		        persona.getGrupoEtnico().getCodigo(),
		        persona.getPuebloIndigena().getCodigo(),
		        persona.getComunidadNegra().getCodigo(),
		        persona.getPersonaDiscapacidad().getCodigo(),
		        persona.getDiscapacidadTipo().getCodigo(),
		        persona.getTalentoExepcional().getCodigo(),
		        persona.getFamiliarDireccion(),
		        persona.getFamiliarNombre(),
		        persona.getFamiliarTelefono(),
		        persona.getFamiliarLugarResidencia(),
		        persona.getCorreo(),
		        persona.getGrupoSanguineo().getCodigo(),
		        persona.getEstado(),
				persona.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("identificacion", persona.getIdentificacion());
			parameter.addValue("tipoId", persona.getTipoId().getCodigo()); 
			parameter.addValue("libretaMilitar", persona.getLibretaMilitar());
			parameter.addValue("apellido", persona.getApellido());
			parameter.addValue("nombre", persona.getNombre());
			parameter.addValue("sexoBiologico", persona.getSexoBiologico().getCodigo());
			parameter.addValue("lugarExpedición", persona.getLugarExpedicion());
			parameter.addValue("fechaExpedicion", persona.getFechaExpedicion());
			parameter.addValue("fechaNacimiento", persona.getFechaNacimiento());
			parameter.addValue("direccion", persona.getDireccion());
			parameter.addValue("movil", persona.getMovil());
			parameter.addValue("fijo", persona.getFijo());
			parameter.addValue("estadoCivil", persona.getEstadoCivil().getCodigo()); 
			parameter.addValue("lugarNacimiento", persona.getLugarNacimiento());
			parameter.addValue("estrato", persona.getEstrato().getCodigo()); 
			parameter.addValue("paisResidencia", persona.getPaisResidencia()); 
			parameter.addValue("departamentoResidencia", persona.getDepartamentoResidencia()); 
			parameter.addValue("municipioResidencia", persona.getMunicipioResidencia()); 
			parameter.addValue("lugarResidencia", persona.getLugarResidencia()); 
			parameter.addValue("barrio", persona.getBarrio());  
			parameter.addValue("grupoEtnico", persona.getGrupoEtnico().getCodigo()); 
			parameter.addValue("puebloIndigena", persona.getPuebloIndigena().getCodigo()); 
			parameter.addValue("comunidadNegra", persona.getComunidadNegra().getCodigo()); 
			parameter.addValue("personaDiscapacidad", persona.getPersonaDiscapacidad().getCodigo()); 
			parameter.addValue("discapacidadTipo", persona.getDiscapacidadTipo().getCodigo()); 
			parameter.addValue("talentoExepcional", persona.getTalentoExepcional().getCodigo()); 
			parameter.addValue("familiarDireccion", persona.getFamiliarDireccion());
			parameter.addValue("familiarNombre", persona.getFamiliarNombre());
			parameter.addValue("familiarTelefono", persona.getFamiliarTelefono());
			parameter.addValue("familiarLugarResidencia", persona.getFamiliarLugarResidencia());
			parameter.addValue("correo", persona.getCorreo());
			parameter.addValue("grupoSanguineo", persona.getGrupoSanguineo().getCodigo()); 
			parameter.addValue("codigo", persona.getCodigo());
			parameter.addValue("estado", persona.getEstado()); 

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}
	
}
