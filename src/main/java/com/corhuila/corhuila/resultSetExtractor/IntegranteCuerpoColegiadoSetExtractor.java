package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.IntegranteCuerpoColegiado;
import com.corhuila.corhuila.rowMapper.IntegranteCuerpoColegiadoRowMapper;

public class IntegranteCuerpoColegiadoSetExtractor implements ResultSetExtractor<List<IntegranteCuerpoColegiado>>{

	@Override
	public List<IntegranteCuerpoColegiado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<IntegranteCuerpoColegiado> list = new ArrayList<IntegranteCuerpoColegiado>();
		while (rs.next()) {
			list.add(new IntegranteCuerpoColegiadoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
	
}
