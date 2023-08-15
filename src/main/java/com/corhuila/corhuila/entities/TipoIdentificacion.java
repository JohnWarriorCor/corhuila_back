package com.corhuila.corhuila.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TipoIdentificacion implements Serializable {

	private int codigo;

	private String nombre;

	private String nombreCorto;
	
	private int estado;
	
	private static final long serialVersionUID = 1L;

}
