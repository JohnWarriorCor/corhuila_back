package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.CineAmplio;
import com.corhuila.corhuila.rowMapper.CineAmplioRowMapper;

public class CineAmplioSetExtractor implements ResultSetExtractor<List<CineAmplio>>{

	@Override
	public List<CineAmplio> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CineAmplio> list = new ArrayList<CineAmplio>();
		while (rs.next()) {
			list.add(new CineAmplioRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
