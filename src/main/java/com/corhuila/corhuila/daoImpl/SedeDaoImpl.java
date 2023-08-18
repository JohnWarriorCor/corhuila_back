package com.corhuila.corhuila.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.corhuila.corhuila.dao.ISedeDao;
import com.corhuila.corhuila.entities.Sede;
import com.corhuila.corhuila.entities.SedeTipo;
import com.corhuila.corhuila.resultSetExtractor.SedeTipoSetExtractor;
import com.corhuila.corhuila.resultSetExtractor.SedeSetExtractor;

@Repository
public class SedeDaoImpl implements ISedeDao{
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Autowired
	@Qualifier("JDBCTemplateCorhuilaConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<SedeTipo> obtenerListadoTiposSedes() {
		
		String sql = "select * from general.sede_tipo st where st.set_estado = 1";
		return jdbcTemplate.query(sql, new SedeTipoSetExtractor());
		
	}

	@Override
	public List<Sede> obtenerListadoSedes() {
		
		String sql = "select * from general.sede s  "
				+ "inner join general.cabeceras_centros_poblados ccp on s.ccp_divipola = ccp.ccp_divipola "
				+ "inner join general.municipio m on ccp.mun_divipola = m.mun_divipola "
				+ "inner join general.departamento d on m.dep_divipola = d.dep_divipola "
				+ "inner join general.pais p on d.pai_codigo = p.pai_codigo "
				+ "inner join general.sede_tipo st on s.set_tipo = st.set_codigo "
				+ "where s.sed_estado = 1";
		return jdbcTemplate.query(sql, new SedeSetExtractor());
		
	}

	@Override
	public int registrar(Sede sede) {
		String sql = "INSERT INTO general.sede"
				+ "(ins_nit, sed_nombre, ccp_divipola, sed_direccion, sed_telefono, set_tipo)"
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		
		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				sede.getNit(),
				sede.getNombre(),
				sede.getCcp().getDivipola(),
				sede.getDireccion(),
				sede.getTelefono(),
				sede.getSedeTipo().getCodigo(),
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nit", sede.getNit());
			parameter.addValue("nombre", sede.getNombre());
			parameter.addValue("ccp", sede.getCcp().getDivipola());
			parameter.addValue("direccion", sede.getDireccion());
			parameter.addValue("telefono", sede.getTelefono());
			parameter.addValue("sedeTipo", sede.getSedeTipo().getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
			
		}
	}

	@Override
	public int actualizar(Sede sede) {
		String sql = "UPDATE general.sede "
				+ "SET ins_nit = ?, sed_nombre = ?, ccp_divipola = ?, sed_direccion = ?, sed_telefono = ?, set_tipo = ?, sed_estado = ? "
				+ "WHERE sed_codigo = ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				sede.getNit(),
				sede.getNombre(),
				sede.getCcp().getDivipola(),
				sede.getDireccion(),
				sede.getTelefono(),
				sede.getSedeTipo().getCodigo(),
				sede.getEstado(),
				sede.getCodigo()
				});

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("nit", sede.getNit());
			parameter.addValue("nombre", sede.getNombre());
			parameter.addValue("ccp", sede.getCcp().getCodigo());
			parameter.addValue("direccion", sede.getDireccion());
			parameter.addValue("telefono", sede.getTelefono());
			parameter.addValue("sedeTipo", sede.getSedeTipo().getCodigo());
			parameter.addValue("estado", sede.getEstado());
			parameter.addValue("codigo", sede.getCodigo());

			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}
}
