package dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import dominio.Cliente;
import dominio.Propietario;
import excepciones.BaseDeDatosException;

public interface Cliente_DAO {

	public Cliente saveOrUpdate(Cliente c) throws BaseDeDatosException, SQLException;
	public List<Cliente> buscarTodos();
	public void eliminarCliente(Integer id);
	public List<Cliente> buscarTodos(String nom, String ape);
	
	
}
