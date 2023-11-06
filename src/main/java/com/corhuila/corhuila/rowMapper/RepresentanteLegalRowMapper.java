package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.RepresentanteLegal;

public class RepresentanteLegalRowMapper implements RowMapper<RepresentanteLegal>{

	@Override
	public RepresentanteLegal mapRow(ResultSet rs, int rowNum) throws SQLException {
		RepresentanteLegal representanteLegal = new RepresentanteLegal();
		representanteLegal.setCodigo(rs.getInt("rel_codigo"));
		representanteLegal.setPersona(new PersonaRowMapper().mapRow(rs, rowNum));
		representanteLegal.setPersonaNombreCompleto(rs.getString("per_nombre")+" "+rs.getString("per_apellido"));
		representanteLegal.setPersonaCorreo(rs.getString("per_email"));
		representanteLegal.setFechaInicio(rs.getDate("rel_fecha_inicio_nombramiento"));
		representanteLegal.setFechaFin(rs.getDate("rel_fecha_fin_nombramiento"));
		representanteLegal.setJustificacion(rs.getString("rel_observacion"));
		representanteLegal.setEstado(rs.getInt("rel_estado"));
		return representanteLegal;
	}

}
