package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.corhuila.corhuila.dao.IInstitucionDao;
import com.corhuila.corhuila.entities.CaracterAcademico;
import com.corhuila.corhuila.entities.Institucion;
import com.corhuila.corhuila.entities.NaturalezaJuridica;
import com.corhuila.corhuila.entities.Sector;
import com.corhuila.corhuila.resultSetExtractor.CaracterAcademicoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.InstitucionSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.NaturalezaJuridicaSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.SectorSetExtractor;

@Repository
public class InstitucionDaoImpl implements IInstitucionDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<CaracterAcademico> obtenerListadoCaracterAcademico() {
		String sql = "select * from general.caracter_academico ca where ca.caa_estado = 1";
		return jdbcTemplate.query(sql, new CaracterAcademicoSetExtractor());
	}

	@Override
	public List<NaturalezaJuridica> obtenerListadoNaturalezaJuridica() {
		String sql = "select * from general.naturaleza_juridica nj where nj.naj_estado = 1";
		return jdbcTemplate.query(sql, new NaturalezaJuridicaSetExtractor());
	}

	@Override
	public List<Sector> obtenerListadoSector() {
		String sql = "select * from general.sector s where s.sec_estado = 1";
		return jdbcTemplate.query(sql, new SectorSetExtractor());
	}
	
	@Override
	public List<Institucion> obtenerInstitucion() {
		String sql = "SELECT DISTINCT ON (i.ins_nit) i.ins_nit, i.*, nj.*, s.*, ca.*, ccp.*, m.*, d.*, p.*, n.* "
				+ "FROM general.institucion i "
				+ "INNER JOIN general.naturaleza_juridica nj ON i.naj_codigo = nj.naj_codigo "
				+ "INNER JOIN general.sector s ON i.sec_codigo = s.sec_codigo "
				+ "INNER JOIN general.caracter_academico ca ON i.caa_codigo = ca.caa_codigo "
				+ "INNER JOIN general.cabeceras_centros_poblados ccp ON i.ccp_divipola = ccp.ccp_divipola "
				+ "INNER JOIN general.municipio m ON ccp.mun_divipola = m.mun_divipola "
				+ "INNER JOIN general.departamento d ON m.dep_divipola = d.dep_divipola "
				+ "INNER JOIN general.pais p ON d.pai_codigo = p.pai_codigo "
				+ "INNER JOIN general.norma n on i.nor_codigo = n.nor_codigo "
				+ "inner join general.norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "ORDER BY i.ins_nit, i.ins_codigo DESC;";
		return jdbcTemplate.query(sql, new InstitucionSetExtractor());
	}

	@Override
	public List<Institucion> obtenerListadoInstitucion() {
		String sql = "select * from general.institucion i "
				+ "inner join general.naturaleza_juridica nj on i.naj_codigo = nj.naj_codigo "
				+ "inner join general.sector s on i.sec_codigo = s.sec_codigo "
				+ "inner join general.caracter_academico ca on i.caa_codigo = ca.caa_codigo "
				+ "inner join general.cabeceras_centros_poblados ccp on i.ccp_divipola = ccp.ccp_divipola "
				+ "inner join general.municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join general.departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join general.pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join general.norma n on i.nor_codigo = n.nor_codigo "
				+ "inner join general.norma_tipo nt on n.not_codigo = nt.not_codigo "
				+ "order by i.ins_codigo desc";
		return jdbcTemplate.query(sql, new InstitucionSetExtractor());
	}

	@Override
	public int registrar(Institucion institucion) {
		String sql = "INSERT INTO general.institucion "
				+ "(ins_nit, ins_snies, ins_snies_padre, naj_codigo, sec_codigo, caa_codigo, ins_nombre, ccp_divipola, ins_direccion, ins_telefono, ins_pagina_web, nor_codigo, ins_fecha_norma) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				institucion.getNit(),
				institucion.getIes(),
				institucion.getIesPadre(),
				institucion.getNaturaleza().getCodigo(),
				institucion.getSector().getCodigo(),
				institucion.getCaracter().getCodigo(),
				institucion.getNombre(),
				institucion.getCcp().getDivipola(),
				institucion.getDireccion(),
				institucion.getTelefono(),
				institucion.getUrl(),
				institucion.getNormaCodigo(),
				institucion.getFechaNorma(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nit", institucion.getNit());
			parameter.addValue("ies", institucion.getIes());
			parameter.addValue("iesPadre", institucion.getIesPadre());
			parameter.addValue("naturaleza", institucion.getNaturaleza().getCodigo());
			parameter.addValue("sector", institucion.getSector().getCodigo());
			parameter.addValue("caracter", institucion.getCaracter().getCodigo());
			parameter.addValue("nombre", institucion.getNombre());
			parameter.addValue("ccp", institucion.getCcp().getDivipola());
			parameter.addValue("direccion", institucion.getDireccion());
			parameter.addValue("telefono", institucion.getTelefono());
			parameter.addValue("url", institucion.getUrl());
			parameter.addValue("norma", institucion.getNormaCodigo());
			parameter.addValue("fechaNorma", institucion.getFechaNorma());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(Institucion institucion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
