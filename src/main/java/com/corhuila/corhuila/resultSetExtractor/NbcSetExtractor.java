package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Nbc;
import com.corhuila.corhuila.rowMapper.NbcRowMapper;

public class NbcSetExtractor implements ResultSetExtractor<List<Nbc>>{

	@Override
	public List<Nbc> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Nbc> list = new ArrayList<Nbc>();
		while (rs.next()) {
			list.add(new NbcRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
