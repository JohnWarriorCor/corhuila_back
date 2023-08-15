package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.TalentoExcepcional;
import com.corhuila.corhuila.rowMapper.TalentoExcepcionalRowMapper;

public class TalentoExcepcionalSetExtractor implements ResultSetExtractor<List<TalentoExcepcional>>{

	@Override
	public List<TalentoExcepcional> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TalentoExcepcional> list = new ArrayList<TalentoExcepcional>();
		while (rs.next()) {
			list.add(new TalentoExcepcionalRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}