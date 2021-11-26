package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dominio.Catalogo;
import dominio.Inmueble;
import excepciones.BaseDeDatosException;

public interface CatalogoDAO 
{
	
	public Catalogo saveOrUpdate(Catalogo c) throws BaseDeDatosException, SQLException;
	public Catalogo buscarCatalogo();
	void eliminarCatalogoPorInmueble(Integer idInmueble, Connection conn);
	public String obtenerFechaEmision(Integer idCatalogo);
	public List<Inmueble> obtenerInmueblesCatalogo(Integer idCliente);
	public List<Integer> obtenerListaIdsInmuebles(Integer idCliente);
	Integer obtenerIdCatalogoPorIdCliente(Integer idCliente);

}
