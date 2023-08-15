package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.GrupoSanguineo;
import com.corhuila.corhuila.rowMapper.GrupoSanguineoRowMapper;

public class GrupoSanguineoSetExtractor implements ResultSetExtractor<List<GrupoSanguineo>>{

	@Override
	public List<GrupoSanguineo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GrupoSanguineo> list = new ArrayList<GrupoSanguineo>();
		while (rs.next()) {
			list.add(new GrupoSanguineoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}