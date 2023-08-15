package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.PersonaDiscapacidad;
import com.corhuila.corhuila.rowMapper.PersonaDiscapacidadRowMapper;

public class PersonaDiscapacidadSetExtractor implements ResultSetExtractor<List<PersonaDiscapacidad>>{

	@Override
	public List<PersonaDiscapacidad> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PersonaDiscapacidad> list = new ArrayList<PersonaDiscapacidad>();
		while (rs.next()) {
			list.add(new PersonaDiscapacidadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}