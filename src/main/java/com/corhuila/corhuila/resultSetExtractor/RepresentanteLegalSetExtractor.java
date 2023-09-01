package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.RepresentanteLegal;
import com.corhuila.corhuila.rowMapper.RepresentanteLegalRowMapper;

public class RepresentanteLegalSetExtractor implements ResultSetExtractor<List<RepresentanteLegal>>{

	@Override
	public List<RepresentanteLegal> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<RepresentanteLegal> list = new ArrayList<RepresentanteLegal>();
		while (rs.next()) {
			list.add(new RepresentanteLegalRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
