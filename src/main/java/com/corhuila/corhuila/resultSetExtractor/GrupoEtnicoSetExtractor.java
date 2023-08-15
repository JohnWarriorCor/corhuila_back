package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.GrupoEtnico;
import com.corhuila.corhuila.rowMapper.GrupoEtnicoRowMapper;

public class GrupoEtnicoSetExtractor implements ResultSetExtractor<List<GrupoEtnico>>{

	@Override
	public List<GrupoEtnico> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<GrupoEtnico> list = new ArrayList<GrupoEtnico>();
		while (rs.next()) {
			list.add(new GrupoEtnicoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}

}