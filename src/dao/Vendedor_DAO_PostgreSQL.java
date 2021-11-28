package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Propietario;
import dominio.Propietario.Tipo_Documento;
import dominio.Vendedor;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Vendedor_DAO_PostgreSQL implements Vendedor_DAO{

	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_VENDEDOR =
			"SELECT * FROM ma.vendedor";
	
	private static final String SELECT_VENDEDOR =
			"SELECT * FROM ma.vendedor WHERE NRO_DOCUMENTO = ?";
	
	private static final String INSERT_VENDEDOR =
			"INSERT INTO ma.vendedor (NOMBRE, APELLIDO, TIPO_DOCUMENTO, NRO_DOCUMENTO, LOCALIDAD, PROVINCIA, FECHA_NACIMIENTO, USUARIO, CONTRASENA) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_VENDEDOR =
			"UPDATE ma.vendedor SET NOMBRE = ?, APELLIDO = ?, TIPO_DOCUMENTO = ?, NRO_DOCUMENTO = ?, LOCALIDAD = ?, PROVINCIA = ?, FECHA_NACIMIENTO = ?, USUARIO = ?, CONTRASENA = ?"+
		    "WHERE ID = ?";
	
	private static final String DELETE_VENDEDOR =
			"DELETE FROM ma.vendedor WHERE ID = ?";
	
	private static final String SELECT_NRO_DOCUMENTO_VENDEDOR =
			"SELECT NRO_DOCUMENTO FROM ma.vendedor WHERE ID = ?";
	
	@Override
	public Vendedor saveOrUpdate(Vendedor v) throws BaseDeDatosException, SQLException
	{
		PreparedStatement pstmt = null;
		
		try 
		{
				if(v.getId() != null && v.getId() > 0)
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(UPDATE_VENDEDOR);
					pstmt.setString(1, v.getNombre());
					pstmt.setString(2, v.getApellido());
					pstmt.setString(3, v.getTipodocumento().toString());
					pstmt.setString(4, v.getNrodocumento());
					pstmt.setString(5, v.getLocalidad());
					pstmt.setString(6, v.getProvincia());
					pstmt.setDate(7, (Date) v.getFechaNacimiento());				
					pstmt.setString(8, v.getUsuario());
					pstmt.setString(9, v.getContraseña());
					pstmt.setInt(10, v.getId());
					pstmt.executeUpdate();
					conn.commit();
					
				}
				else
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_VENDEDOR);
					pstmt.setString(1, v.getNombre());
					pstmt.setString(2, v.getApellido());
					pstmt.setString(3, v.getTipodocumento().toString());
					pstmt.setString(4, v.getNrodocumento());
					pstmt.setString(5, v.getLocalidad());
					pstmt.setString(6, v.getProvincia());
					pstmt.setString(7, v.getFechaNacimiento().getDay() + "/" + v.getFechaNacimiento().getMonth() + "/" + v.getFechaNacimiento().getYear());				
					pstmt.setString(8, v.getUsuario());
					pstmt.setString(9, v.getContraseña());
					pstmt.executeUpdate();
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
		return v;
	}

	@Override
	public List<Vendedor> buscarTodos() 
	{
		List<Vendedor> lista = new ArrayList<Vendedor>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_VENDEDOR);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Vendedor v = new Vendedor();
				v.setId(rs.getInt("ID"));
				v.setNombre(rs.getString("NOMBRE"));
				v.setApellido(rs.getString("APELLIDO"));
				switch(rs.getString("TIPO_DOCUMENTO"))
				{
				case "DNI":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.DNI);
					break;
				case "CI":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.CI);
					break;
				case "LC":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.LC);
					break;
				case "LE":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.LE);
					break;
				case "Pasaporte":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.Pasaporte);
					break;
				}
				v.setNrodocumento(rs.getString("NRO_DOCUMENTO"));
				v.setLocalidad(rs.getString("LOCALIDAD"));
				v.setProvincia(rs.getString("PROVINCIA"));
				v.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
				v.setUsuario(rs.getString("USUARIO"));
				v.setContraseña(rs.getString("CONTRASENA"));

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
	public String obtenerNroDocumentoVendedor(Integer id) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String resultado = null;
		try 
		{
				pstmt = conn.prepareStatement(SELECT_NRO_DOCUMENTO_VENDEDOR);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					resultado = rs.getString("NRO_DOCUMENTO");
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
				if(pstmt!=null) pstmt.close();				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	@Override
	public void eliminarVendedor(Integer id) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_VENDEDOR);
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
	public Vendedor buscarPorNroDocumento(String nroDocumento) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vendedor v = new Vendedor();
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_VENDEDOR);
			pstmt.setString(1, nroDocumento);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				v.setId(rs.getInt("ID"));
				v.setNombre(rs.getString("NOMBRE"));
				v.setApellido(rs.getString("APELLIDO"));
				switch(rs.getString("TIPO_DOCUMENTO"))
				{
				case "DNI":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.DNI);
					break;
				case "CI":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.CI);
					break;
				case "LC":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.LC);
					break;
				case "LE":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.LE);
					break;
				case "Pasaporte":
					v.setTipodocumento(dominio.Vendedor.Tipo_Documento.Pasaporte);
					break;
				}
				v.setNrodocumento(rs.getString("NRO_DOCUMENTO"));
				v.setLocalidad(rs.getString("LOCALIDAD"));
				v.setProvincia(rs.getString("PROVINCIA"));
				v.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
				v.setUsuario(rs.getString("USUARIO"));
				v.setContraseña(rs.getString("CONTRASENA"));
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
	
}
