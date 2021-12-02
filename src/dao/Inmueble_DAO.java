package dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import dominio.Inmueble;
import excepciones.BaseDeDatosException;

public interface Inmueble_DAO 
{
	public Inmueble saveOrUpdate(Inmueble i) throws BaseDeDatosException, SQLException;
	public List<Inmueble> buscarTodos();
	public List<Inmueble> buscarTodosConFiltros(String provincia, String localidad, String barrio, String tipoInmueble, Integer dormitorios);
	public void eliminarInmueble(Integer id);
	public Inmueble buscarPorId(Integer id);
	public List<Inmueble> buscarTodosPorNroDocumentoPropietario(String nroDocumento);
	void eliminarInmueblePropietario(String nroDocumento);
	List<Inmueble> buscarPorCatalogo(List<Integer> id);
	public String devolverEstadoInmueble(Integer id);
}
