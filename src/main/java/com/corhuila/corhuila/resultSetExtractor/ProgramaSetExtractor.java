package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Programa;
import com.corhuila.corhuila.rowMapper.ProgramaRowMapper;

public class ProgramaSetExtractor implements ResultSetExtractor<List<Programa>>{

	@Override
	public List<Programa> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Programa> list = new ArrayList<Programa>();
		while (rs.next()) {
			list.add(new ProgramaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
