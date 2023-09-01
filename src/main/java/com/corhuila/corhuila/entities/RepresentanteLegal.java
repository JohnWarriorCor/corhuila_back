package com.corhuila.corhuila.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RepresentanteLegal implements Serializable{

	private int codigo;

	private Persona persona;
	
	private int norma;

	private Date fechaInicio;
	
	private Date fechaFin;
	
	private String justificacion;
	
	private int estado;
	
	private static final long serialVersionUID = 1L;
	
}
