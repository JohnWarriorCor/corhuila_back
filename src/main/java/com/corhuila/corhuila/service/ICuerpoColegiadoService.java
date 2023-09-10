package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.CuerpoColegiado;
import com.corhuila.corhuila.entities.FuncionesCuerpoColegiado;

public interface ICuerpoColegiadoService {
	
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados();
	
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(int codigoCuerpoColegiado);
	
	public int registrarCuerpoColegiado(CuerpoColegiado cuerpoColegiado);
	
	int actualizarCuerpoColegiado(CuerpoColegiado cuerpoColegiado);
	
	public int registrarFuncion(FuncionesCuerpoColegiado funcion);
	
	int actualizarFuncion(FuncionesCuerpoColegiado funcion);

}
