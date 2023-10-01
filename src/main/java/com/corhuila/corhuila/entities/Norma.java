package com.corhuila.corhuila.entities;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Norma implements Serializable {
	
	private int codigo;
	private int entidadCodigo;
	private String entidad;
	private int entidadExternaCodigo;
	private String entidadExterna;
	private int rectoria;
	private int cuerpoColegiadoCodigo;
	private String cuerpoColegiado;
	private int normaTipoCodigo;
	private String normaTipo;
	private int numero;
	private String nombre;
	private String url;
	private int medioCodigo;
	private String medio;
	private Date fechaExpedicion;
	private Date fechaVigencia;
	private int deroga;
	private String observacion;
	private int estado;
	
	private static final long serialVersionUID = 1L;
}
