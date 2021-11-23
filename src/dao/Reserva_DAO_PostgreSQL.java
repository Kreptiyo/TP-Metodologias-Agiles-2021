package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dominio.Reserva;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Reserva_DAO_PostgreSQL implements Reserva_DAO{
	
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_RESERVAS_POR_ID_CLIENTE =
			"SELECT * FROM ma.reserva WHERE ID = ?";
	
	private static final String INSERT_RESERVA =
			"INSERT INTO ma.reserva (ID_CLIENTE, ID_INMUEBLE, IMPORTE_RESERVA, TIEMPO_VIGENCIA, EMAIL, FECHA_EMISION) VALUES (?,?,?,?,?,?)";
	

	@Override
	public Reserva save(Reserva r) throws BaseDeDatosException, SQLException {

		PreparedStatement pstmt = null;
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarReserva(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reserva buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
