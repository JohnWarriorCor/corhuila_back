package com.corhuila.corhuila.daoImpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.INormaDao;
import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.resultSetExtractor.EntidadExternaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.NormaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.NormaTipoSetExtractor;


@Repository
public class NormaDaoImpl implements INormaDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Norma> obtenerNormas() {
		
		String sql = "select * from general.norma n "
				+ "inner join general.norma_entidad ne on n.noe_codigo = ne.noe_codigo "
				+ "inner join general.norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "inner join general.norma_medio nm on n.nom_codigo = nm.nom_codigo "
				+ "left join general.cuerpos_colegiados cc on n.cuc_codigo = cc.cuc_codigo "
				+ "left join general.entidad_externa ee on n.ene_codigo = ee.ene_codigo "
				+ "where n.nor_estado = 1";
		return jdbcTemplate.query(sql, new NormaSetExtractor());
		
	}

	@Override
	public List<EntidadExterna> obtenerEntidadesExternas() {
		
		String sql = "select * from general.entidad_externa ee where ee.ene_estado = 1 order by ee.ene_nombre asc";
		return jdbcTemplate.query(sql, new EntidadExternaSetExtractor());
		
	}

	@Override
	public List<NormaTipo> obtenerNormasTipo(int entidadCodigo) {
		
		String sql = "select * from general.norma_tipo nt "
				+ "inner join general.norma_entidad ne on nt.noe_codigo = ne.noe_codigo "
				+ "where nt.noe_codigo = " + entidadCodigo + " and nt.not_estado = 1 order by nt.not_nombre asc";
		return jdbcTemplate.query(sql, new NormaTipoSetExtractor());
		
	}

	@Override
	public int registrarNorma(Norma norma) {
		String sql = "INSERT INTO general.norma "
				+ "(noe_codigo, ene_codigo, nor_rectoria, cuc_codigo, not_codigo, nor_numero, nor_nombre, nor_url, nom_codigo, nor_fecha_expedicion, nor_fecha_vigencia, nor_deroga, nor_observacion) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				norma.getEntidadCodigo(),
				norma.getEntidadExternaCodigo(),
				norma.getRectoria(),
				norma.getCuerpoColegiadoCodigo(),
				norma.getNormaTipoCodigo(),
				norma.getNumero(),
				norma.getNombre(),
				norma.getUrl(),
				norma.getMedioCodigo(),
				norma.getFechaExpedicion(),
				norma.getFechaVigencia(),
				norma.getDeroga(),
				norma.getObservacion(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("entidadCodigo", norma.getEntidadCodigo());
			parameter.addValue("entidadExternaCodigo", norma.getEntidadExternaCodigo(), Types.INTEGER);
			parameter.addValue("rectoria", norma.getRectoria());
			parameter.addValue("cuerpoColegiadoCodigo", norma.getCuerpoColegiadoCodigo(), Types.INTEGER);
			parameter.addValue("normaTipoCodigo", norma.getNormaTipoCodigo());
			parameter.addValue("numero", norma.getNumero());
			parameter.addValue("nombre", norma.getNombre());
			parameter.addValue("url", norma.getUrl());
			parameter.addValue("medioCodigo", norma.getMedioCodigo());
			parameter.addValue("fechaExpedicion", norma.getFechaExpedicion());
			parameter.addValue("fechaVigencia", norma.getFechaVigencia(), Types.DATE);
			parameter.addValue("deroga", norma.getDeroga());
			parameter.addValue("observacion", norma.getObservacion());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarNorma(Norma norma) {
		String sql = "UPDATE general.norma "
				+ "SET noe_codigo=?, ene_codigo=?, nor_rectoria=?, cuc_codigo=?, not_codigo=?, nor_numero=?, nor_nombre=?, nor_url=?, nom_codigo=?, nor_fecha_expedicion=?, nor_fecha_vigencia=?, nor_deroga=?, nor_observacion=?, nor_estado=? "
				+ "WHERE nor_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				norma.getEntidadCodigo(),
				norma.getEntidadExternaCodigo(),
				norma.getRectoria(),
				norma.getCuerpoColegiadoCodigo(),
				norma.getNormaTipoCodigo(),
				norma.getNumero(),
				norma.getNombre(),
				norma.getUrl(),
				norma.getMedioCodigo(),
				norma.getFechaExpedicion(),
				norma.getFechaVigencia(),
				norma.getDeroga(),
				norma.getObservacion(),
				norma.getEstado(),
				norma.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("entidadCodigo", norma.getEntidadCodigo());
			parameter.addValue("entidadExternaCodigo", norma.getEntidadExternaCodigo(),Types.INTEGER);
			parameter.addValue("rectoria", norma.getRectoria());
			parameter.addValue("cuerpoColegiadoCodigo", norma.getCuerpoColegiadoCodigo(),Types.INTEGER);
			parameter.addValue("normaTipoCodigo", norma.getNormaTipoCodigo());
			parameter.addValue("numero", norma.getNumero());
			parameter.addValue("nombre", norma.getNombre());
			parameter.addValue("url", norma.getUrl());
			parameter.addValue("medioCodigo", norma.getMedioCodigo());
			parameter.addValue("fechaExpedicion", norma.getFechaExpedicion());
			parameter.addValue("fechaVigencia", norma.getFechaVigencia(), Types.DATE);
			parameter.addValue("deroga", norma.getDeroga());
			parameter.addValue("observacion", norma.getObservacion());
			parameter.addValue("estado", norma.getEstado());
			parameter.addValue("codigo", norma.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

}
