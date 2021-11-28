package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestores.Gestor_Conexion;

public class Login_DAO_PostgreSQL implements Login_DAO
{
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ID_USUARIO_CLIENTE =
			"SELECT ID FROM ma.cliente WHERE NRO_DOCUMENTO = ? AND PASSWORD = ?";
	
	private static final String SELECT_ID_USUARIO_VENDEDOR =
			"SELECT ID FROM ma.vendedor WHERE NRO_DOCUMENTO = ? AND CONTRASENA = ?";
	
	private static final String SELECT_ID_USUARIO_ADMINISTRADOR =
			"SELECT ID FROM ma.administrador WHERE NRO_DOCUMENTO = ? AND PASSWORD = ?";
	@Override
	public Integer verificarUsuario(String numDocumento, String password, String tipoUsuario) 
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer resultado = -1;
		try 
		{
				if(tipoUsuario == "CLIENTE")
				{
					pstmt = conn.prepareStatement(SELECT_ID_USUARIO_CLIENTE);
				}
				else if(tipoUsuario == "VENDEDOR")
				{
					pstmt = conn.prepareStatement(SELECT_ID_USUARIO_VENDEDOR);
				}
				else if(tipoUsuario == "ADMINISTRADOR")
				{
					pstmt = conn.prepareStatement(SELECT_ID_USUARIO_ADMINISTRADOR);;
				}
				pstmt.setString(1, numDocumento);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					resultado = rs.getInt("ID");
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
	
}

