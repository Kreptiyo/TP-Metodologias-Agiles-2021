package base_de_datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DB 
{
	private static boolean _TABLAS_CREADAS = false;
	
	private static final String TABLE_CREATE_PROPIETARIO =
			"CREATE TABLE IF NOT EXISTS ma.propietario ( "+
			"				 ID SERIAL, "+
			"				 NOMBRE VARCHAR(30), "+
			"				 APELLIDO VARCHAR(30), "+
			"				 TIPO_DOCUMENTO VARCHAR(5), "+
			"				 NRO_DOCUMENTO INTEGER, "+
			"				 CALLE VARCHAR(100), "+
			"				 NRO_CALLE INTEGER, "+
			"				 LOCALIDAD VARCHAR(30), "+
			"				 PROVINCIA VARCHAR(30), "+
			"				 TELEFONO INTEGER, "+
			"				 EMAIL VARCHAR(100), "+
			"				 PRIMARY KEY(ID)) ";
	
	public static void verificarCrearTablas(Connection conn)
	{
		if(!_TABLAS_CREADAS)
		{
			Statement stmt = null;
			try
			{
				stmt = conn.createStatement();
				stmt.execute(TABLE_CREATE_PROPIETARIO);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(stmt!=null) stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}