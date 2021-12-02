package gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Venta_DAO;
import dao.Venta_DAO_PostgreSQL;
import dominio.Venta;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;


public class Gestor_Venta {

	private Venta_DAO ventaDAO;

	
	public Gestor_Venta() 
	{
		super();
		this.ventaDAO = new Venta_DAO_PostgreSQL();
	}
	
	public Venta crear_Venta(Integer idCliente, Integer idInmueble, String nombreCliente, String apellidoCliente, String telefonoCliente, 
			String provincia,  String localidad, String calleNumero, String barrio, String precioVenta, Integer tipoInmueble) throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException 
	{
		
		Venta v = new Venta();
		v.setIdCliente(idCliente);
		v.setIdInmueble(idInmueble);
		v.setNombreCliente(nombreCliente);
		v.setApellidoCliente(apellidoCliente);
		v.setTelefonoCliente(telefonoCliente);
		v.setProvincia(provincia);
		v.setLocalidad(localidad);
		v.setCalleNumero(calleNumero);
		v.setBarrio(barrio);
		v.setPrecioVenta(precioVenta);
		
		switch (tipoInmueble) 
		{
		case 1:		v.setTipoInmueble(Tipo_Inmueble.L);		break;
		case 2:		v.setTipoInmueble(Tipo_Inmueble.C);		break;
		case 3:		v.setTipoInmueble(Tipo_Inmueble.D);		break;
		case 4:		v.setTipoInmueble(Tipo_Inmueble.T);		break;
		case 5:		v.setTipoInmueble(Tipo_Inmueble.Q);		break;
		case 6:		v.setTipoInmueble(Tipo_Inmueble.G);		break;
		}
		
		
		return ventaDAO.save(v);
	}
	
	public Venta buscarPorIdVenta(Integer idVenta)
	{
		Venta r = ventaDAO.buscarPorId(idVenta);
		return r;
	}
	
	public void eliminarVenta(Integer id)
	{
		ventaDAO.eliminarVenta(id);
	}
	
	public Integer obtenerIdVentaConIdInmueble(Integer idInmueble)
	{
		return ventaDAO.obtenerIdVentaConIdInmueble(idInmueble);
	}
	
}
