package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Persona;
import com.corhuila.corhuila.rowMapper.PersonaRowMapper;

public class PersonaSetExtractor implements ResultSetExtractor<List<Persona>>{

	@Override
	public List<Persona> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Persona> list = new ArrayList<Persona>();
		while (rs.next()) {
			list.add(new PersonaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}