package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Sede;

public class SedeRowMapper implements RowMapper<Sede>{

	@Override
	public Sede mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sede sede = new Sede();
		sede.setCodigo(rs.getInt("sed_codigo"));
		sede.setNit(rs.getString("ins_nit"));
		sede.setNombre(rs.getString("sed_nombre"));
		sede.setPais(new PaisRowMapper().mapRow(rs, rowNum));
		sede.setDepartamento(new DepartamentoRowMapper().mapRow(rs, rowNum));
		sede.setMunicipio(new MunicipioRowMapper().mapRow(rs, rowNum));
		sede.setCcp(new CabecerasCentrosPobladosRowMapper().mapRow(rs, rowNum));
		sede.setDireccion(rs.getString("sed_direccion"));
		sede.setTelefono(rs.getString("sed_telefono"));
		sede.setSedeTipo(new SedeTipoRowMapper().mapRow(rs, rowNum));
		sede.setFechaCreacion(rs.getDate("sed_fecha_creacion"));
		sede.setEstado(rs.getInt("sed_estado"));
		return sede;
	}

}