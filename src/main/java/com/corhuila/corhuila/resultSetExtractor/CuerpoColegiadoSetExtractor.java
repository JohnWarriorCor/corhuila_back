package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.CuerpoColegiado;
import com.corhuila.corhuila.rowMapper.CuerpoColegiadoRowMapper;

public class CuerpoColegiadoSetExtractor implements ResultSetExtractor<List<CuerpoColegiado>>{

	@Override
	public List<CuerpoColegiado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CuerpoColegiado> list = new ArrayList<CuerpoColegiado>();
		while (rs.next()) {
			list.add(new CuerpoColegiadoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
