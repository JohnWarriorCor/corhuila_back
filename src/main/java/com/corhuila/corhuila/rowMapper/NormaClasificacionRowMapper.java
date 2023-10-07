package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.NormaClasificacion;

public class NormaClasificacionRowMapper implements RowMapper<NormaClasificacion>{

	@Override
	public NormaClasificacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		NormaClasificacion normaClasificacion = new NormaClasificacion();
		normaClasificacion.setCodigo(rs.getInt("noc_codigo"));
		normaClasificacion.setNorma(new NormaRowMapper().mapRow(rs, rowNum));
		normaClasificacion.setNormaGrupo(new NormaGrupoRowMapper().mapRow(rs, rowNum));
		normaClasificacion.setEstado(rs.getInt("noc_estado"));
		return normaClasificacion;
	}
}
