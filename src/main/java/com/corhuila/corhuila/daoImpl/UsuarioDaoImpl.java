package com.corhuila.corhuila.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.IUsuarioDao;
import com.corhuila.corhuila.entities.Usuario;
import com.corhuila.corhuila.rowMapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public Usuario buscarUsuario(String username) {
		String sql = "SELECT * FROM general.vista_usuario_general vug "
				+ "WHERE vug.usu_nombre = ? AND vug.usu_estado = 1 "
				+ "LIMIT 1;";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean validarUsuario(String username) {
		int result = 0;
		String sql = "select COUNT(usu_nombre) from general.vista_usuario_general " 
				+ "where usu_nombre = ? ";
		result =  jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
		return result > 0 ? true : false;
	}

}