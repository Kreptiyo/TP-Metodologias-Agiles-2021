package gestores;

import dao.Login_DAO;
import dao.Login_DAO_PostgreSQL;

public class Gestor_Login 
{
	private Login_DAO loginDAO;
	
	public Gestor_Login()
	{
		super();
		this.loginDAO = new Login_DAO_PostgreSQL();
	}
	
	public Integer verificarUsuario(String numDocumento, String password, String tipoUsuario)
	{
		return this.loginDAO.verificarUsuario(numDocumento, password, tipoUsuario);
	}
}
