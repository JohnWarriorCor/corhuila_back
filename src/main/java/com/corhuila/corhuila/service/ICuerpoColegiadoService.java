package com.corhuila.corhuila.service;

import java.util.List;

import com.corhuila.corhuila.entities.CuerpoColegiado;
import com.corhuila.corhuila.entities.FuncionesCuerpoColegiado;
import com.corhuila.corhuila.entities.IntegranteCuerpoColegiado;

public interface ICuerpoColegiadoService {
	
	public List<CuerpoColegiado> obtenerListadoCuerposColegiados();
	
	public List<CuerpoColegiado> obtenerCuerpoColegiadoDisponibilidad();
	
	public List<FuncionesCuerpoColegiado> obtenerListadoFunciones(int codigoCuerpoColegiado);
	
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiado();
	
	public List<IntegranteCuerpoColegiado> obtenerListadoIntegrantesCuerpoColegiadoCodigo(int codigoCuerpoColegiado);
	
	public int registrarCuerpoColegiado(CuerpoColegiado cuerpoColegiado);
	
	int actualizarCuerpoColegiado(CuerpoColegiado cuerpoColegiado);
	
	public int registrarFuncion(FuncionesCuerpoColegiado funcion);
	
	int actualizarFuncion(FuncionesCuerpoColegiado funcion);
	
	public int registrarIntegrante(IntegranteCuerpoColegiado integrante);
	
	int actualizarIntegrante(IntegranteCuerpoColegiado integrante);

}
