package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.IUbicacionDao;
import com.corhuila.corhuila.resultSetExtractor.DepartamentoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.MunicipioSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.PaisSetExtractor;
import com.corhuila.corhuila.entities.Pais;
import com.corhuila.corhuila.entities.Departamento;
import com.corhuila.corhuila.entities.Municipio;

@Repository
public class UbicacionDaoImpl implements IUbicacionDao{
	
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pais> obtenerPaisLocal() {
		
		String sql = "select * from general.pais p where p.pai_codigo = 43";

		return jdbcTemplate.query(sql, new PaisSetExtractor());
	}

	@Override
	public List<Pais> obtenerPaises() {
		
		String sql = "select * from general.pais ";

		return jdbcTemplate.query(sql, new PaisSetExtractor());
		
	}

	@Override
	public List<Departamento> obtenerDepartamentosPorPais(int paiCodigo) {
		String sql = "select * from general.departamento d "
				+ "inner join general.pais p on d.pai_codigo = p.pai_codigo "
				+ "where d.pai_codigo = "+ paiCodigo + " ";

		return jdbcTemplate.query(sql, new DepartamentoSetExtractor());
	}

	@Override
	public List<Municipio> obtenerMunicipiosPorDepartamento(String depCodigo) {
		String sql = "select * from general.municipio m "
				+ "inner join general.departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join general.pais p on d.pai_codigo = p.pai_codigo "
				+ "where m.dep_divipola = '" + depCodigo + "'";

		return jdbcTemplate.query(sql, new MunicipioSetExtractor());
	}

}

