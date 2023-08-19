package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Facultad;
import com.corhuila.corhuila.rowMapper.FacultadRowMapper;

public class FacultadSetExtractor implements ResultSetExtractor<List<Facultad>>{

	@Override
	public List<Facultad> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Facultad> list = new ArrayList<Facultad>();
		while (rs.next()) {
			list.add(new FacultadRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}