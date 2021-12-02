package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Inmueble;
import dominio.Reserva;
import dominio.Venta;
import dominio.Inmueble.Estado_Inmueble;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;
import gestores.Gestor_Inmueble;
import gestores.Gestor_Reserva;

public class Venta_DAO_PostgreSQL implements Venta_DAO {

	
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_VENTAS_POR_ID_CLIENTE =
			"SELECT * FROM ma.venta WHERE ID = ?";
	
	private static final String SELECT_ALL_VENTAS =
			"SELECT * FROM ma.venta";
	
	private static final String DELETE_VENTA =
			"DELETE FROM ma.venta WHERE ID = ?";
	
	private static final String INSERT_VENTA =
			"INSERT INTO ma.venta (ID_CLIENTE, ID_INMUEBLE, NOMBRE_CLIENTE, APELLIDO_CLIENTE, TELEFONO_CLIENTE, "
			+ "PROVINCIA, LOCALIDAD, BARRIO, CALLE_NUMERO, PRECIO_VENTA, TIPO_INMUEBLE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	@Override
	public Venta save(Venta v) throws BaseDeDatosException, SQLException {
		
		PreparedStatement pstmt = null;
		
		Gestor_Inmueble gi = new Gestor_Inmueble();		
		Inmueble i;	
		Inmueble_DAO inmuebleDAO = new  Inmueble_DAO_PostgreSQL();
		Gestor_Reserva gr = new Gestor_Reserva();		
		Reserva_DAO_PostgreSQL reservaDAO = new  Reserva_DAO_PostgreSQL();
		
		try 
		{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_VENTA);
					pstmt.setInt(1, v.getIdCliente());
					pstmt.setInt(2, v.getIdInmueble());
					pstmt.setString(3, v.getNombreCliente());
					pstmt.setString(4, v.getApellidoCliente());
					pstmt.setString(5, v.getTelefonoCliente());
					pstmt.setString(6, v.getProvincia());
					pstmt.setString(7, v.getLocalidad());
					pstmt.setString(8, v.getBarrio());
					pstmt.setString(9, v.getCalleNumero());
					pstmt.setString(10, v.getPrecioVenta());
					pstmt.setString(11, v.getTipoInmueble().toString());
					
					pstmt.executeUpdate();
					
					i = gi.buscarPorId( v.getIdInmueble());
					
					i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
					
					inmuebleDAO.saveOrUpdate(i);
					
					gr.eliminarReserva(gr.obtenerIdReservaConIdInmueble(v.getIdInmueble()));
					
					conn.commit();					
		} 
		catch (SQLException e) 
		{
			conn.rollback();
			e.printStackTrace();
			throw new BaseDeDatosException(e.getMessage());
		}
		finally 
		{
			try 
			{
				if(pstmt!=null) pstmt.close();				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return v;
	}

	@Override
	public Venta buscarPorId(Integer idVenta) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Venta v = new Venta();
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_VENTAS_POR_ID_CLIENTE);
			pstmt.setInt(1, idVenta);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				v.setId(rs.getInt("ID_VENTA"));
				v.setIdCliente(rs.getInt("ID_CLIENTE"));
				v.setIdInmueble(rs.getInt("ID_INMUEBLE"));
				v.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
				v.setApellidoCliente(rs.getString("APELLIDO_CLIENTE"));
				v.setTelefonoCliente(rs.getString("TELEFONO_CLIENTE"));
				v.setProvincia(rs.getString("PROVINCIA"));
				v.setLocalidad(rs.getString("LOCALIDAD"));
				v.setBarrio(rs.getString("BARRIO")); //TIPO_INMUEBLE
				v.setCalleNumero(rs.getString("CALLE_NUMERO"));
				v.setPrecioVenta(rs.getString("PRECIO_VENTA"));

				switch(rs.getString("TIPO_INMUEBLE"))
				{
				case "L":
					v.setTipoInmueble(Tipo_Inmueble.L);
					break;
				case "C":
					v.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "D":
					v.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "T":
					v.setTipoInmueble(Tipo_Inmueble.T);
					break;
				case "Q":
					v.setTipoInmueble(Tipo_Inmueble.Q);
					break;
				case "G":
					v.setTipoInmueble(Tipo_Inmueble.G);
					break;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return v;
	}
	
	@Override
	public List<Venta> buscarTodas() {
		
		List<Venta> lista = new ArrayList<Venta>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_VENTAS);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Venta v = new Venta();
				
				v.setId(rs.getInt("ID_VENTA"));
				v.setIdCliente(rs.getInt("ID_CLIENTE"));
				v.setIdInmueble(rs.getInt("ID_INMUEBLE"));
				v.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
				v.setApellidoCliente(rs.getString("APELLIDO_CLIENTE"));
				v.setTelefonoCliente(rs.getString("TELEFONO_CLIENTE"));
				v.setProvincia(rs.getString("PROVINCIA"));
				v.setLocalidad(rs.getString("LOCALIDAD"));
				v.setBarrio(rs.getString("BARRIO")); //TIPO_INMUEBLE
				v.setCalleNumero(rs.getString("CALLE_NUMERO"));
				v.setPrecioVenta(rs.getString("PRECIO_VENTA"));

				switch(rs.getString("TIPO_INMUEBLE"))
				{
				case "L":
					v.setTipoInmueble(Tipo_Inmueble.L);
					break;
				case "C":
					v.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "D":
					v.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "T":
					v.setTipoInmueble(Tipo_Inmueble.T);
					break;
				case "Q":
					v.setTipoInmueble(Tipo_Inmueble.Q);
					break;
				case "G":
					v.setTipoInmueble(Tipo_Inmueble.G);
					break;
				}
				
				lista.add(v);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public void eliminarVenta(Integer id) {
		
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_VENTA);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstmt!=null) pstmt.close();				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer obtenerIdVentaConIdInmueble(Integer idInmueble) {
		// TODO Auto-generated method stub
		return null;
	}
}
