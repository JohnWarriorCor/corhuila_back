package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.FuncionesCuerpoColegiado;
import com.corhuila.corhuila.rowMapper.FuncionesCuerpoColegiadoRowMapper;

public class FuncionesCuerpoColegiadoSetExtractor implements ResultSetExtractor<List<FuncionesCuerpoColegiado>>{

	@Override
	public List<FuncionesCuerpoColegiado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<FuncionesCuerpoColegiado> list = new ArrayList<FuncionesCuerpoColegiado>();
		while (rs.next()) {
			list.add(new FuncionesCuerpoColegiadoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
