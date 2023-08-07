package com.corhuila.corhuila.dao;

import com.corhuila.corhuila.entities.Usuario;

public interface IUsuarioDao {
	
	public Usuario buscarUsuario(String username);
	public boolean validarUsuario(String username);

}
