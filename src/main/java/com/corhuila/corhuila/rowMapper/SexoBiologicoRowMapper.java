package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.SexoBiologico;

public class SexoBiologicoRowMapper implements RowMapper<SexoBiologico>{

	@Override
	public SexoBiologico mapRow(ResultSet rs, int rowNum) throws SQLException {
		SexoBiologico genero = new SexoBiologico();
		genero.setCodigo(rs.getInt("seb_codigo"));
		genero.setNombre(rs.getString("seb_nombre"));
		genero.setEstado(rs.getInt("seb_estado"));
		return genero;
	}

}
