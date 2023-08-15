package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.ComunidadNegra;
import com.corhuila.corhuila.rowMapper.ComunidadNegraRowMapper;

public class ComunidadNegraSetExtractor implements ResultSetExtractor<List<ComunidadNegra>>{

	@Override
	public List<ComunidadNegra> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ComunidadNegra> list = new ArrayList<ComunidadNegra>();
		while (rs.next()) {
			list.add(new ComunidadNegraRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}