package dao;

import java.sql.Connection;

import dominio.Venta;
import gestores.Gestor_Conexion;

public class Venta_DAO_PostgreSQL implements Venta_DAO {

	
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_VENTAS_POR_ID_CLIENTE =
			"SELECT * FROM ma.venta WHERE ID = ?";
	
	private static final String SELECT_ALL_VENTAS =
			"SELECT * FROM ma.venta";
	
	private static final String DELETE_VENTA =
			"DELETE FROM ma.venta WHERE ID = ?";
	
	private static final String INSERT_VENTA =
			"INSERT INTO ma.venta (ID_CLIENTE, ID_INMUEBLE, IMPORTE_RESERVA, TIEMPO_VIGENCIA, EMAIL, FECHA_EMISION) VALUES (?,?,?,?,?,?)";
	
	
	
	
	@Override
	public Venta save(Venta v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta buscarPorId(Integer idVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarVenta(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer obtenerIdVentaConIdInmueble(Integer idInmueble) {
		// TODO Auto-generated method stub
		return null;
	}
}
