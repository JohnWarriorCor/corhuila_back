package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Funciones;
import com.corhuila.corhuila.rowMapper.FuncionesRowMapper;

public class FuncionesSetExtractor implements ResultSetExtractor<List<Funciones>>{

	@Override
	public List<Funciones> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Funciones> list = new ArrayList<Funciones>();
		while (rs.next()) {
			list.add(new FuncionesRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
