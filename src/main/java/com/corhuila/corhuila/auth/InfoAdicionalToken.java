package com.corhuila.corhuila.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.corhuila.corhuila.entities.Usuario;
import com.corhuila.corhuila.serviceImpl.UsuarioServiceImpl;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.buscarUsuario(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		info.put("per_codigo", usuario.getPersona().getCodigo());
		info.put("nombre", usuario.getPersona().getNombre());
		info.put("apellido",usuario.getPersona().getApellido());
		
		
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}