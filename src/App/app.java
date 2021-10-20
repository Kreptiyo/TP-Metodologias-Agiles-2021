package App;

import java.sql.Connection;

import gestores.Gestor_Conexion;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = Gestor_Conexion.getConnection();
	}

}
