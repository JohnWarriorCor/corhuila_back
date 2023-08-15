package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.IPersonaDao;
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
import com.corhuila.corhuila.resultSetExtractor.ComunidadNegraSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.DiscapacidadTipoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.EstadoCivilSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.EstratoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.GrupoEtnicoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.GrupoSanguineoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PersonaDiscapacidadSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PuebloIndigenaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.SexoBiologicoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.TalentoExcepcionalSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.TipoIdentificacionSetExtractor;

@Repository
public class PersonaDaoImpl implements IPersonaDao{
	
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;

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
	
}
