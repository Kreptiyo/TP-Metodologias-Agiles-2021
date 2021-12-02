package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Inmueble;
import dominio.Propietario;
import dominio.Reserva;
import dominio.Inmueble.Estado_Inmueble;
import dominio.Propietario.Tipo_Documento;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;
import gestores.Gestor_Inmueble;

public class Reserva_DAO_PostgreSQL implements Reserva_DAO{
	
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_RESERVAS_POR_ID_CLIENTE =
			"SELECT * FROM ma.reserva WHERE ID_CLIENTE = ?";
	
	private static final String SELECT_RESERVA_POR_ID =
			"SELECT * FROM ma.reserva WHERE ID_RESERVA = ?";
	
	private static final String SELECT_ALL_RESERVAS =
			"SELECT * FROM ma.reserva";
	
	private static final String DELETE_RESERVA =
			"DELETE FROM ma.reserva WHERE ID_RESERVA = ?";
	
	private static final String INSERT_RESERVA =
			"INSERT INTO ma.reserva (ID_CLIENTE, ID_INMUEBLE, IMPORTE_RESERVA, TIEMPO_VIGENCIA, EMAIL, FECHA_EMISION) VALUES (?,?,?,?,?,?)";
	
	private static final String INMUEBLE_YA_RESERVADO =
			"SELECT id_reserva FROM ma.reserva WHERE id_inmueble = ? ";

	@Override
	public Reserva save(Reserva r) throws BaseDeDatosException, SQLException {

		PreparedStatement pstmt = null;
		
		Gestor_Inmueble gi = new Gestor_Inmueble();
		
		Inmueble i;
		
		Inmueble_DAO inmuebleDAO = new  Inmueble_DAO_PostgreSQL();
		
		try 
		{
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_RESERVA);
					pstmt.setInt(1, r.getIdCliente());
					pstmt.setInt(2, r.getIdInmueble());
					pstmt.setInt(3, r.getImporteReserva());
					pstmt.setInt(4, r.getTiempoVigencia());
					pstmt.setString(5, r.getEmail());
					pstmt.setString(6, r.getFechaEmision());
					pstmt.executeUpdate();
					i = gi.buscarPorId( r.getIdInmueble());
					i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
					inmuebleDAO.saveOrUpdate(i);
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
		return r;
	}

	@Override
	public List<Reserva> buscarTodas() {
		
		List<Reserva> lista = new ArrayList<Reserva>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_RESERVAS);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Reserva r = new Reserva();
				r.setIdReserva(rs.getInt("ID_RESERVA"));
				r.setIdCliente(rs.getInt("ID_CLIENTE"));
				r.setIdInmueble(rs.getInt("ID_INMUEBLE"));
				r.setImporteReserva(rs.getInt("IMPORTE_RESERVA"));
				r.setTiempoVigencia(rs.getInt("TIEMPO_VIGENCIA"));
				r.setEmail(rs.getString("EMAIL"));
				r.setFechaEmision(rs.getString("FECHA_EMISION"));
				lista.add(r);
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
	public List<Reserva> buscarTodasPorIdCliente(Integer idCliente) {
		
		List<Reserva> lista = new ArrayList<Reserva>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_RESERVAS_POR_ID_CLIENTE);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Reserva r = new Reserva();
				r.setIdReserva(rs.getInt("ID_RESERVA"));
				r.setIdCliente(rs.getInt("ID_CLIENTE"));
				r.setIdInmueble(rs.getInt("ID_INMUEBLE"));
				r.setImporteReserva(rs.getInt("IMPORTE_RESERVA"));
				r.setTiempoVigencia(rs.getInt("TIEMPO_VIGENCIA"));
				r.setEmail(rs.getString("EMAIL"));
				r.setFechaEmision(rs.getString("FECHA_EMISION"));
				lista.add(r);
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
	public void eliminarReserva(Integer id) {
		
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_RESERVA);
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
	public Integer obtenerIdReservaConIdInmueble(Integer idInmueble) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer resultado = -1;
		
		try
		{
			pstmt = conn.prepareStatement(INMUEBLE_YA_RESERVADO);
			pstmt.setInt(1, idInmueble);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				resultado = rs.getInt("ID_RESERVA");
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
	public Reserva buscarPorIdReserva(Integer id) {
		Reserva r = new Reserva();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_RESERVA_POR_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				r.setIdReserva(rs.getInt("ID_RESERVA"));
				r.setIdCliente(rs.getInt("ID_CLIENTE"));
				r.setIdInmueble(rs.getInt("ID_INMUEBLE"));
				r.setImporteReserva(rs.getInt("IMPORTE_RESERVA"));
				r.setTiempoVigencia(rs.getInt("TIEMPO_VIGENCIA"));
				r.setEmail(rs.getString("EMAIL"));
				r.setFechaEmision(rs.getString("FECHA_EMISION"));
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
		return r;
	}

}
