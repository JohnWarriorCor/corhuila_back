package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Funciones;

public class FuncionesRowMapper implements RowMapper<Funciones>{

	@Override
	public Funciones mapRow(ResultSet rs, int rowNum) throws SQLException {
		Funciones funciones = new Funciones();
		funciones.setCodigo(rs.getInt("fun_codigo"));
		funciones.setNombre(rs.getString("fun_nombre"));
		funciones.setEstado(rs.getInt("fun_estado"));
		return funciones;
	}
}
