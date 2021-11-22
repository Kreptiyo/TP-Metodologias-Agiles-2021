package dao;

import java.sql.SQLException;
import java.util.List;

import dominio.Catalogo;
import excepciones.BaseDeDatosException;

public interface CatalogoDAO 
{
	
	public Catalogo saveOrUpdate(Catalogo c) throws BaseDeDatosException, SQLException;
	public Catalogo buscarCatalogo();
	void eliminarCatalogoPorInmueble(Integer idInmueble);

}
