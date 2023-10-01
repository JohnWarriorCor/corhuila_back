package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.EntidadExterna;

public class EntidadExternaRowMapper implements RowMapper<EntidadExterna>{

	@Override
	public EntidadExterna mapRow(ResultSet rs, int rowNum) throws SQLException {
		EntidadExterna entidad = new EntidadExterna();
		entidad.setCodigo(rs.getInt("ene_codigo"));
		entidad.setNombre(rs.getString("ene_nombre"));
		entidad.setEstado(rs.getInt("ene_estado"));
		return entidad;
	}
}
