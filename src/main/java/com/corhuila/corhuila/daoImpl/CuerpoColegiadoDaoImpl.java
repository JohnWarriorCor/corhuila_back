package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.ICuerpoColegiadoDao;
import com.corhuila.corhuila.entities.CuerpoColegiado;
import com.corhuila.corhuila.entities.FuncionesCuerpoColegiado;
import com.corhuila.corhuila.resultSetExtractor.CuerpoColegiadoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.FuncionesCuerpoColegiadoSetExtractor;

@Repository
public class CuerpoColegiadoDaoImpl implements ICuerpoColegiadoDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados() {
		
		String sql = "select * from general.cuerpos_colegiados cc "
				+ "where cc.cuc_estado = 1 ";
		return jdbcTemplate.query(sql, new CuerpoColegiadoSetExtractor());
		
	}
	
	@Override
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(int codigoCuerpoColegiado) {
		
		String sql = "select * from general.funciones_curpos_colegiados f "
				+ "left join general.cuerpos_colegiados cc on f.cuc_codigo = cc.cuc_codigo "
				+ "where f.cuc_codigo = " + codigoCuerpoColegiado + " and f.fcc_estado = 1 ";
		return jdbcTemplate.query(sql, new FuncionesCuerpoColegiadoSetExtractor());
		
	}

	@Override
	public int registrarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
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
	public int actualizarCuerpoColegiado(CuerpoColegiado cuerposColegiados) {
		
		String sql = "UPDATE general.cuerpos_colegiados "
				+ "SET cuc_nombre=?, cuc_nombre_corto=?, cuc_numero_norma=?, cuc_nombre_norma=?, cuc_fecha_norma=?, cuc_cantidad_miembros=?, cuc_estado=?"
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

	@Override
	public int registrarFuncion(FuncionesCuerpoColegiado funcion) {
		String sql = "INSERT INTO general.funciones_curpos_colegiados "
				+ "(cuc_codigo, fcc_nombre) "
				+ "VALUES(?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				funcion.getCuerpoColegiado().getCodigo(),
				funcion.getNombre(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("codigoCuerpoColegiado", funcion.getCuerpoColegiado().getCodigo());
			parameter.addValue("nombre", funcion.getNombre());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizarFuncion(FuncionesCuerpoColegiado funcion) {
		String sql = "UPDATE general.funciones_curpos_colegiados "
				+ "SET fcc_nombre= ?, fcc_estado= ? "
				+ "WHERE fcc_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				funcion.getNombre(),
				funcion.getEstado(),
				funcion.getCodigo(),
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nombre", funcion.getNombre());
			parameter.addValue("estado", funcion.getEstado());
			parameter.addValue("codigo", funcion.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}
	
}
