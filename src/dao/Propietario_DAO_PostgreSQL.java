package dao;

import dominio.Propietario;
import dominio.Propietario.Tipo_Documento;
import gestores.Gestor_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import excepciones.BaseDeDatosException;

public class Propietario_DAO_PostgreSQL implements Propietario_DAO
{
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_PROPIETARIO =
			"SELECT * FROM ma.propietario";
	
	private static final String INSERT_PROPIETARIO =
			"INSERT INTO ma.propietario (NOMBRE, APELLIDO, TIPO_DOCUMENTO, NRO_DOCUMENTO, CALLE, NRO_CALLE, LOCALIDAD, PROVINCIA, TELEFONO, EMAIL) VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_PROPIETARIO =
			"UPDATE ma.propietario SET NOMBRE = ?, APELLIDO = ?, TIPO_DOCUMENTO = ?, NRO_DOCUMENTO = ?, CALLE = ?, NRO_CALLE = ?, LOCALIDAD = ?, PROVINCIA = ?, TELEFONO = ?, EMAIL = ?"+
		    "WHERE ID = ?";
	
	private static final String DELETE_PROPIETARIO =
			"DELETE FROM ma.propietario WHERE ID = ?";
	
	@Override
	public Propietario saveOrUpdate(Propietario p) throws BaseDeDatosException, SQLException
	{
		PreparedStatement pstmt = null;
		
		try 
		{
				if(p.getId() != null && p.getId() > 0)
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(UPDATE_PROPIETARIO);
					pstmt.setString(1, p.getNombre());
					pstmt.setString(2, p.getApellido());
					pstmt.setString(3, p.getTipodocumento().toString());
					pstmt.setInt(4, p.getNrodocumento());
					pstmt.setString(5, p.getCalle());
					pstmt.setInt(6, p.getNrocalle());
					pstmt.setString(7, p.getLocalidad());
					pstmt.setString(8, p.getProvincia());
					pstmt.setInt(9, p.getTelefono());
					pstmt.setString(10, p.getEmail());
					pstmt.executeUpdate();
					conn.commit();
					
				}
				else
				{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_PROPIETARIO);
					pstmt.setString(1, p.getNombre());
					pstmt.setString(2, p.getApellido());
					pstmt.setString(3, p.getTipodocumento().toString());
					pstmt.setInt(4, p.getNrodocumento());
					pstmt.setString(5, p.getCalle());
					pstmt.setInt(6, p.getNrocalle());
					pstmt.setString(7, p.getLocalidad());
					pstmt.setString(8, p.getProvincia());
					pstmt.setInt(9, p.getTelefono());
					pstmt.setString(10, p.getEmail());
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
		return p;
	}

	@Override
	public List<Propietario> buscarTodas() 
	{
		List<Propietario> lista = new ArrayList<Propietario>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_PROPIETARIO);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Propietario p = new Propietario();
				p.setId(rs.getInt("ID"));
				p.setNombre(rs.getString("NOMBRE"));
				p.setApellido(rs.getString("APELLIDO"));
				switch(rs.getString("TIPO_DOCUMENTO"))
				{
				case "DNI":
					p.setTipodocumento(Tipo_Documento.DNI);
					break;
				case "CI":
					p.setTipodocumento(Tipo_Documento.CI);
					break;
				case "LC":
					p.setTipodocumento(Tipo_Documento.LC);
					break;
				case "LE":
					p.setTipodocumento(Tipo_Documento.LE);
					break;
				case "Pasaporte":
					p.setTipodocumento(Tipo_Documento.Pasaporte);
					break;
				}
				p.setNrodocumento(rs.getInt("NRO_DOCUMENTO"));
				p.setCalle(rs.getString("CALLE"));
				p.setNrocalle(rs.getInt("NRO_CALLE"));
				p.setLocalidad(rs.getString("LOCALIDAD"));
				p.setProvincia(rs.getString("PROVINCIA"));
				p.setTelefono(rs.getInt("TELEFONO"));
				p.setEmail(rs.getString("EMAIL"));
				lista.add(p);
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
	public void eliminarPropietario(Integer id) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_PROPIETARIO);
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