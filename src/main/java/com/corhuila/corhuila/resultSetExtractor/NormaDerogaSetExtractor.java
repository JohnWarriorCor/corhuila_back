package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.NormaDeroga;
import com.corhuila.corhuila.rowMapper.NormaDerogaRowMapper;

public class NormaDerogaSetExtractor implements ResultSetExtractor<List<NormaDeroga>>{

	@Override
	public List<NormaDeroga> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaDeroga> list = new ArrayList<NormaDeroga>();
		while (rs.next()) {
			list.add(new NormaDerogaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
