package dao;

import dominio.Venta;

public interface Venta_DAO {

	Venta save(Venta v);
	Venta buscarPorId(Integer idVenta);
	void eliminarVenta(Integer id);
	Integer obtenerIdVentaConIdInmueble(Integer idInmueble);

}
