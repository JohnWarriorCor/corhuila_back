package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.CuerposColegiados;

public class CuerposColegiadosRowMapper implements RowMapper<CuerposColegiados>{

	@Override
	public CuerposColegiados mapRow(ResultSet rs, int rowNum) throws SQLException {
		CuerposColegiados cuerposColegiados = new CuerposColegiados();
		cuerposColegiados.setCodigo(rs.getInt("cuc_codigo"));
		cuerposColegiados.setNombre(rs.getString("cuc_nombre"));
		cuerposColegiados.setNombreCorto(rs.getString("cuc_nombre_corto"));
		cuerposColegiados.setNumeroNorma(rs.getInt("cuc_numero_norma"));
		cuerposColegiados.setNombreNorma(rs.getString("cuc_nombre_norma"));
		cuerposColegiados.setFechaNorma(rs.getDate("cuc_fecha_norma"));
		cuerposColegiados.setFunciones(new FuncionesRowMapper().mapRow(rs, rowNum));
		cuerposColegiados.setFechaCreacion(rs.getDate("cuc_fecha_creacion"));
		cuerposColegiados.setCantidadMiembros(rs.getInt("cuc_cantidad_miembros"));
		cuerposColegiados.setEstado(rs.getInt("cuc_estado"));
		return cuerposColegiados;
	}

}
