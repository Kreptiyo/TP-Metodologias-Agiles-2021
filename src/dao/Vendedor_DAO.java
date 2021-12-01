package dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import dominio.Vendedor;
import excepciones.BaseDeDatosException;

public interface Vendedor_DAO {

	//Interfaz Vendedor DAO donde se definen los metodos que se utilziaran en
	// la clase Vendedor DAO Postgre SQL
	
	Vendedor saveOrUpdate(Vendedor p) throws BaseDeDatosException, SQLException;
	List<Vendedor> buscarTodos();
	String obtenerNroDocumentoVendedor(Integer id);
	Vendedor buscarPorNroDocumento(String nroDocumento);
	List<Vendedor> buscarTodos(String nom, String ape, String dni);
	void eliminarVendedor(String dni);

	
	
}
