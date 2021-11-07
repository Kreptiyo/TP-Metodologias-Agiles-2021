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
	public void eliminarInmueble(Integer id);
	public Inmueble buscarPorId(Integer id);
	public List<Inmueble> buscarTodosPorIdPropietario(Integer idPropietario);
}
