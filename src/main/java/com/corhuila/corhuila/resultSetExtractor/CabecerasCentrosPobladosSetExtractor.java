package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.CabecerasCentrosPoblados;
import com.corhuila.corhuila.rowMapper.CabecerasCentrosPobladosRowMapper;

public class CabecerasCentrosPobladosSetExtractor implements ResultSetExtractor<List<CabecerasCentrosPoblados>>{

	@Override
	public List<CabecerasCentrosPoblados> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CabecerasCentrosPoblados> list = new ArrayList<CabecerasCentrosPoblados>();
		while (rs.next()) {
			list.add(new CabecerasCentrosPobladosRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}