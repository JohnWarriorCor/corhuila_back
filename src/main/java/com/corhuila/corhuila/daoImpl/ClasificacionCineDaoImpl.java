package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.IClasificacionCineDao;
import com.corhuila.corhuila.entities.CineAmplio;
import com.corhuila.corhuila.entities.CineDetallado;
import com.corhuila.corhuila.entities.CineEspecifico;
import com.corhuila.corhuila.resultSetExtractor.CineAmplioSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.CineDetalladoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.CineEspecificoSetExtractor;

@Repository
public class ClasificacionCineDaoImpl implements IClasificacionCineDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<CineAmplio> obtenerListadoClasificacionCineAmplio() {
		
		String sql = "select * from general.campo_amplio_cine cac where cac.cac_estado = 1";
		return jdbcTemplate.query(sql, new CineAmplioSetExtractor());
		
	}

	@Override
	public List<CineEspecifico> obtenerListadoClasificacionCineEspecifico() {
		
		String sql = "select * from general.campo_especifico_cine cec "
				+ "left join general.campo_amplio_cine cac on cec.cac_codigo = cac.cac_codigo "
				+ "where cec.cec_estado = 1";
		return jdbcTemplate.query(sql, new CineEspecificoSetExtractor());
		
	}

	@Override
	public List<CineDetallado> obtenerListadoClasificacionCineDetallado() {
		
		String sql = "select * from general.campo_detallado_cine cdc "
				+ "left join general.campo_especifico_cine cec on cdc.cec_codigo = cec.cec_codigo "
				+ "left join general.campo_amplio_cine cac on cec.cac_codigo = cac.cac_codigo "
				+ "where cdc.cdc_estado = 1";
		return jdbcTemplate.query(sql, new CineDetalladoSetExtractor());
		
	}

	@Override
	public List<CineDetallado> obtenerListadoCineDetallado(int codigo) {
		
		String sql = "select * from general.campo_detallado_cine cdc "
				+ "left join general.campo_especifico_cine cec on cdc.cec_codigo = cec.cec_codigo "
				+ "left join general.campo_amplio_cine cac on cec.cac_codigo = cac.cac_codigo "
				+ "where cdc.cdc_estado = 1 where cdc.cdc_codigo = " + codigo;
		return jdbcTemplate.query(sql, new CineDetalladoSetExtractor());
		
	}
	
	@Override
	public List<CineEspecifico> obtenerListadoEspecificoAmplio(int cineAmplioCodigo) {
		
		String sql = "select * from general.campo_especifico_cine cec "
				+ "left join general.campo_amplio_cine cac on cec.cac_codigo = cac.cac_codigo "
				+ "where cec.cec_estado = 1 and cec.cac_codigo = " + cineAmplioCodigo;
		return jdbcTemplate.query(sql, new CineEspecificoSetExtractor());
		
	}

	@Override
	public int registrarCineAmplio(CineAmplio amplio) {
		
		String sql = "INSERT INTO general.campo_amplio_cine "
				+ "(cac_nombre, cac_cine) "
				+ "VALUES(?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				amplio.getNombre(),
				amplio.getCine()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", amplio.getNombre());
			parameter.addValue("cine", amplio.getCine());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarCineAmplio(CineAmplio amplio) {
		
		String sql = "UPDATE general.campo_amplio_cine "
				+ "SET cac_nombre=?, cac_cine=?, cac_estado=? "
				+ "WHERE cac_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				amplio.getNombre(),
				amplio.getCine(),
				amplio.getEstado(),
				amplio.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", amplio.getNombre());
			parameter.addValue("cine", amplio.getCine());
			parameter.addValue("estado", amplio.getEstado());
			parameter.addValue("codigo", amplio.getCodigo());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int registrarCineEspecifico(CineEspecifico especifico) {
		
		String sql = "INSERT INTO general.campo_especifico_cine "
				+ "(cac_codigo, cec_nombre, cec_cine) "
				+ "VALUES(?,?,?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				especifico.getAmplioCodigo(),
				especifico.getNombre(),
				especifico.getCine()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("amplio", especifico.getAmplioCodigo());
			parameter.addValue("nombre", especifico.getNombre());
			parameter.addValue("cine", especifico.getCine());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarCineEspecifico(CineEspecifico especifico) {
		
		String sql = "UPDATE general.campo_especifico_cine "
				+ "SET cac_codigo=?, cec_nombre=?, cec_cine=?, cec_estado=? "
				+ "WHERE cec_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				especifico.getAmplioCodigo(),
				especifico.getNombre(),
				especifico.getCine(),
				especifico.getEstado(),
				especifico.getCodigo(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("amplio", especifico.getAmplioCodigo());
			parameter.addValue("nombre", especifico.getNombre());
			parameter.addValue("cine", especifico.getCine());
			parameter.addValue("estado", especifico.getEstado());
			parameter.addValue("codigo", especifico.getCodigo());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int registrarCineDetallado(CineDetallado detallado) {
		
		String sql = "INSERT INTO general.campo_detallado_cine "
				+ "(cec_codigo, cdc_nombre, cdc_cine) "
				+ "VALUES(?,?,?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				detallado.getEspecificoCodigo(),
				detallado.getNombre(),
				detallado.getCine()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("especifico", detallado.getEspecificoCodigo());
			parameter.addValue("nombre", detallado.getNombre());
			parameter.addValue("cine", detallado.getCine());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int actualizarCineDetallado(CineDetallado detallado) {
		
		String sql = "UPDATE general.campo_detallado_cine "
				+ "SET cec_codigo=?, cdc_nombre=?, cdc_cine=?, cdc_estado=? "
				+ "WHERE cdc_codigo=?;";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				detallado.getEspecificoCodigo(),
				detallado.getNombre(),
				detallado.getCine(),
				detallado.getEstado(),
				detallado.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("especifico", detallado.getEspecificoCodigo());
			parameter.addValue("nombre", detallado.getNombre());
			parameter.addValue("cine", detallado.getCine());
			parameter.addValue("estado", detallado.getEstado());
			parameter.addValue("codigo", detallado.getCodigo());
			
			return result;
			
			

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}
	
}
