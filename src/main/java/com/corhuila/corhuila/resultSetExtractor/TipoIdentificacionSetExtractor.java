package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.TipoIdentificacion;
import com.corhuila.corhuila.rowMapper.TipoIdentificacionRowMapper;

public class TipoIdentificacionSetExtractor implements ResultSetExtractor<List<TipoIdentificacion>>{

	@Override
	public List<TipoIdentificacion> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<TipoIdentificacion> list = new ArrayList<TipoIdentificacion>();
		while (rs.next()) {
			list.add(new TipoIdentificacionRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}
