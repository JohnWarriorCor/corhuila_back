package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.Institucion;
import com.corhuila.corhuila.rowMapper.InstitucionRowMapper;

public class InstitucionSetExtractor implements ResultSetExtractor<List<Institucion>>{

	@Override
	public List<Institucion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Institucion> list = new ArrayList<Institucion>();
		while (rs.next()) {
			list.add(new InstitucionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}
