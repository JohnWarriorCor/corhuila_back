package com.corhuila.corhuila.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.corhuila.corhuila.entities.NormaGrupo;
import com.corhuila.corhuila.rowMapper.NormaGrupoRowMapper;

public class NormaGrupoSetExtractor implements ResultSetExtractor<List<NormaGrupo>>{

	@Override
	public List<NormaGrupo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<NormaGrupo> list = new ArrayList<NormaGrupo>();
		while (rs.next()) {
			list.add(new NormaGrupoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
