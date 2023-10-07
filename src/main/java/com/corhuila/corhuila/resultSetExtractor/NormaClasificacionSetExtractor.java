package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.NormaClasificacion;
import com.corhuila.corhuila.rowMapper.NormaClasificacionRowMapper;

public class NormaClasificacionSetExtractor implements ResultSetExtractor<List<NormaClasificacion>>{

	@Override
	public List<NormaClasificacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaClasificacion> list = new ArrayList<NormaClasificacion>();
		while (rs.next()) {
			list.add(new NormaClasificacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
