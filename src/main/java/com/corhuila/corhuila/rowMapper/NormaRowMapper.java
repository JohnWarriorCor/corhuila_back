package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Norma;

public class NormaRowMapper implements RowMapper<Norma>{

	@Override
	public Norma mapRow(ResultSet rs, int rowNum) throws SQLException {
		Norma norma = new Norma();
		norma.setCodigo(rs.getInt("nor_codigo"));
		norma.setEntidadCodigo(rs.getInt("noe_codigo"));
		norma.setEntidad(rs.getString("noe_nombre"));
		norma.setEntidadExternaCodigo(rs.getInt("ene_codigo"));
		norma.setEntidadExterna(rs.getString("ene_nombre"));
		norma.setRectoria(rs.getInt("nor_rectoria"));
		norma.setCuerpoColegiadoCodigo(rs.getInt("cuc_codigo"));
		norma.setCuerpoColegiado(rs.getString("cuc_nombre"));
		norma.setNormaTipoCodigo(rs.getInt("not_codigo"));
		norma.setNormaTipo(rs.getString("not_nombre"));
		norma.setNumero(rs.getInt("nor_numero"));
		norma.setNombre(rs.getString("nor_nombre"));
		norma.setUrl(rs.getString("nor_url"));
		norma.setMedioCodigo(rs.getInt("nom_codigo"));
		norma.setMedio(rs.getString("nom_nombre"));
		norma.setFechaExpedicion(rs.getDate("nor_fecha_expedicion"));
		norma.setFechaVigencia(rs.getDate("nor_fecha_vigencia"));
		norma.setDeroga(rs.getInt("nor_deroga"));
		norma.setObservacion(rs.getString("nor_observacion"));
		norma.setEstado(rs.getInt("nor_estado"));
		return norma;
	}
}
