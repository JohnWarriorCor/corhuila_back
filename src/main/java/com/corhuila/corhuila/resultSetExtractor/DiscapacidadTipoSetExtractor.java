package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.DiscapacidadTipo;
import com.corhuila.corhuila.rowMapper.DiscapacidadTipoRowMapper;

public class DiscapacidadTipoSetExtractor implements ResultSetExtractor<List<DiscapacidadTipo>>{

	@Override
	public List<DiscapacidadTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<DiscapacidadTipo> list = new ArrayList<DiscapacidadTipo>();
		while (rs.next()) {
			list.add(new DiscapacidadTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}