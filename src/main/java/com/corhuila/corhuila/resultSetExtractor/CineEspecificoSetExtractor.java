package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.CineEspecifico;
import com.corhuila.corhuila.rowMapper.CineEspecificoRowMapper;

public class CineEspecificoSetExtractor implements ResultSetExtractor<List<CineEspecifico>>{

	@Override
	public List<CineEspecifico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CineEspecifico> list = new ArrayList<CineEspecifico>();
		while (rs.next()) {
			list.add(new CineEspecificoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
