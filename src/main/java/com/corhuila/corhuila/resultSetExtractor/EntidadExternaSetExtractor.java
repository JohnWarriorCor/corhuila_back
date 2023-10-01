package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.EntidadExterna;
import com.corhuila.corhuila.rowMapper.EntidadExternaRowMapper;

public class EntidadExternaSetExtractor implements ResultSetExtractor<List<EntidadExterna>>{

	@Override
	public List<EntidadExterna> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<EntidadExterna> list = new ArrayList<EntidadExterna>();
		while (rs.next()) {
			list.add(new EntidadExternaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
