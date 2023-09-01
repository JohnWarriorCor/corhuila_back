package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.IRepresentanteLegalDao;
import com.corhuila.corhuila.entities.RepresentanteLegal;
import com.corhuila.corhuila.resultSetExtractor.RepresentanteLegalSetExtractor;

@Repository
public class RepresentanteLegalDaoImpl implements IRepresentanteLegalDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<RepresentanteLegal> obtenerListadoRepresentanteLegal() {
		
		String sql = "select * from general.representante_legal rl "
				+ "inner join general.persona p ON rl.per_codigo = p.per_codigo "
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
				+ "INNER JOIN general.grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo ";
		return jdbcTemplate.query(sql, new RepresentanteLegalSetExtractor());
		
	}

	@Override
	public int registrar(RepresentanteLegal representanteLegal) {
		
		String sql = "INSERT INTO general.representante_legal "
				+ "(per_codigo, rel_norma, rel_fecha_inicio_nombramiento, rel_fecha_fin_nombramiento, rel_observacion) "
				+ "VALUES(?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				representanteLegal.getPersona().getCodigo(),
				representanteLegal.getNorma(),
				representanteLegal.getFechaInicio(),
				representanteLegal.getFechaFin(),
				representanteLegal.getJustificacion(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("persona", representanteLegal.getPersona().getCodigo());
			parameter.addValue("norma", representanteLegal.getNorma());
			parameter.addValue("fechaInicio", representanteLegal.getFechaInicio());
			parameter.addValue("fechaFin", representanteLegal.getFechaFin());
			parameter.addValue("justificacion", representanteLegal.getJustificacion());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizar(RepresentanteLegal representanteLegal) {
		
		String sql = "UPDATE general.representante_legal "
				+ "SET per_codigo=?, rel_norma=?, rel_fecha_inicio_nombramiento=?, rel_fecha_fin_nombramiento=?, rel_observacion=?, rel_estado=? "
				+ "WHERE rel_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				representanteLegal.getPersona().getCodigo(),
				representanteLegal.getNorma(),
				representanteLegal.getFechaInicio(),
				representanteLegal.getFechaFin(),
				representanteLegal.getJustificacion(),
				representanteLegal.getEstado(),
				representanteLegal.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("persona", representanteLegal.getPersona().getCodigo());
			parameter.addValue("norma", representanteLegal.getNorma());
			parameter.addValue("fechaInicio", representanteLegal.getFechaInicio());
			parameter.addValue("fechaFin", representanteLegal.getFechaFin());
			parameter.addValue("justificacion", representanteLegal.getJustificacion());
			parameter.addValue("estado", representanteLegal.getEstado());
			parameter.addValue("codigo", representanteLegal.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}
}
