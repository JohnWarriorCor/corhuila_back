package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Facultad;

public class FacultadRowMapper implements RowMapper<Facultad>{

	@Override
	public Facultad mapRow(ResultSet rs, int rowNum) throws SQLException {
		Facultad facultad = new Facultad();
		facultad.setCodigo(rs.getInt("fac_codigo"));
		facultad.setSede(new SedeRowMapper().mapRow(rs, rowNum));
		facultad.setNombre(rs.getString("fac_nombre"));
		facultad.setDecano(rs.getString("fac_decano"));
		facultad.setCorreo(rs.getString("fac_correo"));
		facultad.setTelefono(rs.getString("fac_telefono"));
		facultad.setFechaCreacion(rs.getDate("fac_fecha_creacion"));
		facultad.setEstado(rs.getInt("fac_estado"));
		return facultad;
	}

}