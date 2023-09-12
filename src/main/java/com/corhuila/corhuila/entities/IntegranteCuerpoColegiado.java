package com.corhuila.corhuila.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntegranteCuerpoColegiado implements Serializable {

	private int codigo;

	private CuerpoColegiado cuerpoColegiado;
	
	private int personaCodigo;
	
	private String personaIdentificacion;
	
	private String personaNombre;
	
	private String personaApellido;
	
	private int codigoNorma;
	
	private UsuarioTipo usuarioTipo;
	
	private MiembroTipo miembroTipo;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private String observacion;
	
	private int estado;
	
	private static final long serialVersionUID = 1L;

}
