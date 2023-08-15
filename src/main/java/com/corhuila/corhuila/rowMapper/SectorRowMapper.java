package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Sector;

public class SectorRowMapper implements RowMapper<Sector>{

	@Override
	public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sector sector = new Sector();
		sector.setCodigo(rs.getInt("sec_codigo"));
		sector.setNombre(rs.getString("sec_nombre"));
		sector.setEstado(rs.getInt("sec_estado"));
		return sector;
	}

}