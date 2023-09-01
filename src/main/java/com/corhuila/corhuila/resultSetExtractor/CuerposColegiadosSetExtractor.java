package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.CuerposColegiados;
import com.corhuila.corhuila.rowMapper.CuerposColegiadosRowMapper;

public class CuerposColegiadosSetExtractor implements ResultSetExtractor<List<CuerposColegiados>>{

	@Override
	public List<CuerposColegiados> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CuerposColegiados> list = new ArrayList<CuerposColegiados>();
		while (rs.next()) {
			list.add(new CuerposColegiadosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
