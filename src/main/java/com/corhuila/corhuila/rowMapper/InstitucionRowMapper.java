package com.corhuila.corhuila.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.corhuila.corhuila.entities.Institucion;

public class InstitucionRowMapper implements RowMapper<Institucion>{

	@Override
	public Institucion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Institucion institucion = new Institucion();
		institucion.setCodigo(rs.getInt("ins_codigo"));
		institucion.setNit(rs.getString("ins_nit"));
		institucion.setIes(rs.getInt("ins_ies"));
		institucion.setIesPadre(rs.getInt("ins_ies_padre"));
		institucion.setNaturaleza(new NaturalezaJuridicaRowMapper().mapRow(rs, rowNum));
		institucion.setSector(new SectorRowMapper().mapRow(rs, rowNum));
		institucion.setCaracter(new CaracterAcademicoRowMapper().mapRow(rs, rowNum));
		institucion.setNombre(rs.getString("ins_nombre"));
		institucion.setPais(new PaisRowMapper().mapRow(rs, rowNum));
		institucion.setDepartamento(new DepartamentoRowMapper().mapRow(rs, rowNum));
		institucion.setMunicipio(new MunicipioRowMapper().mapRow(rs, rowNum));
		institucion.setDireccion(rs.getString("ins_direccion"));
		institucion.setTelefono(rs.getString("ins_telefono"));
		institucion.setUrl(rs.getString("ins_pagina_web"));
		institucion.setNorma(rs.getString("ins_norma_creacion"));
		institucion.setFechaNorma(rs.getDate("ins_fecha_norma"));
		institucion.setEstado(rs.getInt("ins_estado"));
		return institucion;
	}

}