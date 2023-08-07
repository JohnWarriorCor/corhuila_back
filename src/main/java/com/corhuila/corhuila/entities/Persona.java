package com.corhuila.corhuila.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona implements Serializable {

	private int codigo;

	private String nombre;

	private String apellido;

	private String identificacion;
	
	private String tipoDocumento;
	
	private String expedicion;
	
	private String edad;
	
	private static final long serialVersionUID = 1L;
}