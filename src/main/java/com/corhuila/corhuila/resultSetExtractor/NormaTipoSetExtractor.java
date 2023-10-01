package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.NormaTipo;
import com.corhuila.corhuila.rowMapper.NormaTipoRowMapper;

public class NormaTipoSetExtractor implements ResultSetExtractor<List<NormaTipo>>{

	@Override
	public List<NormaTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaTipo> list = new ArrayList<NormaTipo>();
		while (rs.next()) {
			list.add(new NormaTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
