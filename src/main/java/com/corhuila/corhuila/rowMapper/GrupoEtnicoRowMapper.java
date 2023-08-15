package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.GrupoEtnico;

public class GrupoEtnicoRowMapper implements RowMapper<GrupoEtnico>{

	@Override
	public GrupoEtnico mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoEtnico grupoEtnico = new GrupoEtnico();
		grupoEtnico.setCodigo(rs.getInt("gre_codigo"));
		grupoEtnico.setNombre(rs.getString("gre_nombre"));
		grupoEtnico.setEstado(rs.getInt("gre_estado"));
		return grupoEtnico;
	}

}