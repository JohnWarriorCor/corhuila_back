package com.corhuila.corhuila.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Municipio implements Serializable {

	private int codigo;

	private String nombre;
	
	private String divipola;

	private String tipo;
	
	private String area;
	
	private Departamento departamento;
	
	private static final long serialVersionUID = 1L;
	
}
