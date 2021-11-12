package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import dominio.Inmueble.Tipo_Inmueble;
import dominio.Propietario;
import dominio.Propietario.Tipo_Documento;
import dominio.TipoInmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Cliente_DAO_PostgreSQL implements Cliente_DAO{

	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_CLIENTE =
			"SELECT * FROM ma.cliente";
	
	private static final String INSERT_CLIENTE =
			"INSERT INTO ma.cliente (NOMBRE, APELLIDO, TELEFONO, TIPO_INMUEBLE, LOCALIDAD, BARRIO, CARACTERISTICAS_INMUEBLE, MONTO) VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_CLIENTE =
			"UPDATE ma.cliente SET NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, TIPO_INMUEBLE = ?, LOCALIDAD = ?, BARRIO = ?, CARACTERISTICAS_INMUEBLE = ?, MONTO = ? "+
		    "WHERE ID = ?";
	
	private static final String DELETE_CLIENTE =
			"DELETE FROM ma.cliente WHERE ID = ?";
	
	@Override
	public Cliente saveOrUpdate(Cliente c) throws BaseDeDatosException, SQLException
	{
		PreparedStatement pstmt = null;
		
		try 
		{
				if(c.getId() != null && c.getId() > 0)
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(UPDATE_CLIENTE);
					pstmt.setString(1, c.getNombre());
					pstmt.setString(2, c.getApellido());
					pstmt.setInt(3, c.getTelefono());
					pstmt.setString(4, c.getTipoInmueble().toString());
					pstmt.setString(5, c.getLocalidad());
					pstmt.setString(6, c.getBarrio());
				//	pstmt.setString(7, c.getCaracteristicas().toString());
					pstmt.setInt(8, c.getMonto());
					pstmt.setInt(9, c.getId());
					pstmt.executeUpdate();
					conn.commit();
					
				}
				else
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_CLIENTE);
					pstmt.setString(1, c.getNombre());
					pstmt.setString(2, c.getApellido());
					pstmt.setInt(3, c.getTelefono());
					pstmt.setString(4, c.getTipoInmueble().toString());
					pstmt.setString(5, c.getLocalidad());
					pstmt.setString(6, c.getBarrio());
				//	pstmt.setString(7, c.getCaracteristicas().toString());
					pstmt.setInt(8, c.getMonto());
					pstmt.setInt(9, c.getId());
					conn.commit();
				}					
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
		return c;
	}

	@Override
	public List<Cliente> buscarTodos() 
	{
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_CLIENTE);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Cliente c = new Cliente();
				c.setId(rs.getInt("ID"));
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setTelefono(rs.getInt("TELEFONO"));
				
				switch(rs.getString("TIPO_INMUEBLE"))
				{
				case "L":
					c.setTipoInmueble(Tipo_Inmueble.L);
					break;
				case "C":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "D":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "T":
					c.setTipoInmueble(Tipo_Inmueble.T);
					break;
				case "Q":
					c.setTipoInmueble(Tipo_Inmueble.Q);
					break;
				case "G":
					c.setTipoInmueble(Tipo_Inmueble.G);
					break;
				}
				c.setLocalidad(rs.getString("LOCALIDAD"));
				c.setBarrio(rs.getString("BARRIO"));
				//c.setCaracteristicas(rs.getString("CARACTERISTICAS_INMUEBLE"));
				c.setMonto(rs.getInt("MONTO"));
				lista.add(c);
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
	public void eliminarCliente(Integer id) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_CLIENTE);
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
	
	
}
