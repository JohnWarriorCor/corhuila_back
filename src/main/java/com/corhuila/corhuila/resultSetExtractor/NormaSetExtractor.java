package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Norma;
import com.corhuila.corhuila.rowMapper.NormaRowMapper;

public class NormaSetExtractor implements ResultSetExtractor<List<Norma>>{

	@Override
	public List<Norma> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Norma> list = new ArrayList<Norma>();
		while (rs.next()) {
			list.add(new NormaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
