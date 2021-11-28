package dao;

public interface Login_DAO 
{
	public Integer verificarUsuario(String numDocumento, String password, String tipoUsuario);
}