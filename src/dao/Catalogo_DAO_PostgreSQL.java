package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import dominio.Catalogo;
import dominio.Inmueble;
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
	public Catalogo buscarCatalogo() {
		// TODO Auto-generated method stub
		return null;
	}

}
