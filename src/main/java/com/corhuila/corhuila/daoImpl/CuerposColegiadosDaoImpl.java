package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.ICuerposColegiadosDao;
import com.corhuila.corhuila.entities.CuerposColegiados;
import com.corhuila.corhuila.resultSetExtractor.CuerposColegiadosSetExtractor;

@Repository
public class CuerposColegiadosDaoImpl implements ICuerposColegiadosDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CuerposColegiados> obtenerListadoCuerposColegiados() {
		
		String sql = "select * from general.cuerpos_colegiados cc where cc.cuc_estado = 1 ";
		return jdbcTemplate.query(sql, new CuerposColegiadosSetExtractor());
		
	}

	@Override
	public int registrar(CuerposColegiados cuerposColegiados) {
		
		String sql = "INSERT INTO general.cuerpos_colegiados "
				+ "(cuc_nombre, cuc_nombre_corto, cuc_numero_norma, cuc_nombre_norma, cuc_fecha_norma, cuc_cantidad_miembros) "
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				cuerposColegiados.getNombre(),
				cuerposColegiados.getNombreCorto(),
				cuerposColegiados.getNumeroNorma(),
				cuerposColegiados.getNombreNorma(),
				cuerposColegiados.getFechaNorma(),
				cuerposColegiados.getCantidadMiembros(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", cuerposColegiados.getNombre());
			parameter.addValue("nombreCorto", cuerposColegiados.getNombreCorto());
			parameter.addValue("numeroNorma", cuerposColegiados.getNumeroNorma());
			parameter.addValue("nombreNorma", cuerposColegiados.getNombreNorma());
			parameter.addValue("fechaNorma", cuerposColegiados.getFechaNorma());
			parameter.addValue("cantidadMiembros", cuerposColegiados.getCantidadMiembros());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(CuerposColegiados cuerposColegiados) {
		
		String sql = "UPDATE general.cuerpos_colegiados "
				+ "SET cuc_nombre=?, cuc_nombre_corto=?, cuc_numero_norma=?, cuc_nombre_norma=?, cuc_fecha_norma=?, cuc_cantidad_miembros=?, cuc_estado=? "
				+ "WHERE cuc_codigo = ? ;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				cuerposColegiados.getNombre(),
				cuerposColegiados.getNombreCorto(),
				cuerposColegiados.getNumeroNorma(),
				cuerposColegiados.getNombreNorma(),
				cuerposColegiados.getFechaNorma(),
				cuerposColegiados.getCantidadMiembros(),
				cuerposColegiados.getEstado(),
				cuerposColegiados.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", cuerposColegiados.getNombre());
			parameter.addValue("nombreCorto", cuerposColegiados.getNombreCorto());
			parameter.addValue("numeroNorma", cuerposColegiados.getNumeroNorma());
			parameter.addValue("nombreNorma", cuerposColegiados.getNombreNorma());
			parameter.addValue("fechaNorma", cuerposColegiados.getFechaNorma());
			parameter.addValue("cantidadMiembros", cuerposColegiados.getCantidadMiembros());
			parameter.addValue("estado", cuerposColegiados.getEstado());
			parameter.addValue("codigo", cuerposColegiados.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
		
	}
}
