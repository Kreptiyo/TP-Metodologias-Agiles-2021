package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import dominio.Catalogo;
import dominio.Inmueble;
import dominio.Inmueble.Estado_Inmueble;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Catalogo_DAO_PostgreSQL implements CatalogoDAO{
	
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String INSERT_CATALOGO =
			"INSERT INTO ma.catalogo (ID_CATALOGO, ID_CLIENTE, FECHA_EMISION) VALUES (?,?,?)";
	
	private static final String INSERT_RENGLON_CATALOGO =
			"INSERT INTO ma.renglon_catalogo (ID_CATALOGO, ID_INMUEBLE) VALUES (?,?)";
	
	private static final String ELIMINAR_CATALOGO =
			"DELETE FROM ma.catalogo where ID_CATALOGO = ?";
	
	private static final String ELIMINAR_RENGLON_CATALOGO =
			"DELETE FROM ma.renglon_catalogo where ID_CATALOGO = ?";
	
	private static final String ELIMINAR_RENGLON_CATALOGO_POR_INMUEBLE =
			"DELETE FROM ma.renglon_catalogo where ID_INMUEBLE = ?";
	
	private static final String FECHA_EMISION = 
			"SELECT fecha_emision FROM ma.catalogo WHERE id_cliente = ?";
	
	private static final String OBTENER_ID_CATALOGO =
			"SELECT id_catalogo FROM ma.catalogo WHERE id_cliente = ?";
	
	private static final String OBTENER_IDS_INMUEBLES =
			"SELECT id_inmueble FROM ma.renglon_catalogo WHERE id_catalogo = ?";
	
	private static final String SELECT_CATALOGO =
			"SELECT * from ma.catalogo WHERE id_cliente = ?";

	@Override
	public Catalogo saveOrUpdate(Catalogo c) throws BaseDeDatosException, SQLException {
		PreparedStatement pstmt = null;
		
		try 
		{
				conn.setAutoCommit(false);
				/*elimina el catalogo viejo*/
				this.eliminarCatalogo(c.getIdCatalogo(), conn);
				pstmt = conn.prepareStatement(INSERT_CATALOGO);
				pstmt.setInt(1, c.getIdCatalogo());
				pstmt.setInt(2, c.getIdPropietario());
				pstmt.setString(3, c.getFechaEmision());
				pstmt.executeUpdate();
				/*luego de crear el catalogo crea el renglon*/
				this.insertarRenglonCatalogo(c.getIdCatalogo(), c.getInmuebles(), conn);
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
		return c;
	}
	
	public void insertarRenglonCatalogo(Integer idCatalogo, List<Inmueble> listaInmuebles, Connection conn) throws SQLException, BaseDeDatosException
	{
		PreparedStatement pstmt = null;
		try 
		{
			pstmt = conn.prepareStatement(INSERT_RENGLON_CATALOGO);
			
			for(Inmueble i: listaInmuebles) {
				
				pstmt = conn.prepareStatement(INSERT_RENGLON_CATALOGO);
				pstmt.setInt(1, idCatalogo);
				pstmt.setInt(2, i.getId());
				pstmt.executeUpdate();		
			}		
		} 
		catch (SQLException e) 
		{
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
	}
	
	public void eliminarCatalogo(Integer idCatalogo, Connection conn) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				pstmt = conn.prepareStatement(ELIMINAR_RENGLON_CATALOGO);
				pstmt.setInt(1, idCatalogo);
				pstmt.executeUpdate();
				pstmt = conn.prepareStatement(ELIMINAR_CATALOGO);
				pstmt.setInt(1, idCatalogo);
				pstmt.executeUpdate();
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
	public void eliminarCatalogoPorInmueble(Integer idInmueble, Connection conn) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				pstmt = conn.prepareStatement(ELIMINAR_RENGLON_CATALOGO_POR_INMUEBLE);
				pstmt.setInt(1, idInmueble);
				pstmt.executeUpdate();
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
	public Catalogo buscarCatalogo(Integer idCliente) 
	{
		Catalogo c = new Catalogo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_CATALOGO);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				c.setIdCatalogo(rs.getInt("ID_CATALOGO"));
				c.setFechaEmision(rs.getString("FECHA_EMISION"));
				c.setInmuebles(this.obtenerInmueblesCatalogo(idCliente));
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
		return c;
	}
	
	@Override
	public List<Inmueble> obtenerInmueblesCatalogo(Integer idCliente) {
		Inmueble_DAO inmuebleDAO = new Inmueble_DAO_PostgreSQL();
		return inmuebleDAO.buscarPorCatalogo(this.obtenerListaIdsInmuebles(idCliente));
	}
	
	@Override
	public List<Integer> obtenerListaIdsInmuebles(Integer idCliente) {
		List<Integer> resultado = new ArrayList<Integer>();
		Integer idCatalogo = this.obtenerIdCatalogoPorIdCliente(idCliente);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(OBTENER_IDS_INMUEBLES);
			pstmt.setInt(1, idCatalogo);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				resultado.add(rs.getInt("ID_INMUEBLE"));
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
		return resultado;
	}
	
	@Override
	public Integer obtenerIdCatalogoPorIdCliente(Integer idCliente) {
		Integer resultado = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(OBTENER_ID_CATALOGO);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				resultado = rs.getInt("ID_CATALOGO");
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
		return resultado;
	}

}
