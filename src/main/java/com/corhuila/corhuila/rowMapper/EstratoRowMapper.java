package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Estrato;

public class EstratoRowMapper implements RowMapper<Estrato>{

	@Override
	public Estrato mapRow(ResultSet rs, int rowNum) throws SQLException {
		Estrato estrato = new Estrato();
		estrato.setCodigo(rs.getInt("est_codigo"));
		estrato.setNombre(rs.getString("est_nombre"));
		estrato.setEstado(rs.getInt("est_estado"));
		return estrato;
	}

}