package dao;

import java.sql.SQLException;
import java.util.List;

import dominio.Venta;
import excepciones.BaseDeDatosException;

public interface Venta_DAO {

	Venta save(Venta v) throws BaseDeDatosException, SQLException;
	List<Venta> buscarTodas();
	void eliminarVenta(Integer id);
	Integer obtenerIdVentaConIdInmueble(Integer idInmueble);
	Venta buscarPorId(Integer idVenta);

}
