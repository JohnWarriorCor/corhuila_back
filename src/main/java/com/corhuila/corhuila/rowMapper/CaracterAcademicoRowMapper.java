package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.CaracterAcademico;

public class CaracterAcademicoRowMapper implements RowMapper<CaracterAcademico>{

	@Override
	public CaracterAcademico mapRow(ResultSet rs, int rowNum) throws SQLException {
		CaracterAcademico caracterAcademico = new CaracterAcademico();
		caracterAcademico.setCodigo(rs.getInt("caa_codigo"));
		caracterAcademico.setNombre(rs.getString("caa_nombre"));
		caracterAcademico.setEstado(rs.getInt("caa_estado"));
		return caracterAcademico;
	}

}