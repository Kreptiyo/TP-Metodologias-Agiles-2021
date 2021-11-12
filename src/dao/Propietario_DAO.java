package dao;

import java.sql.SQLException;
import java.util.List;
import dominio.Propietario;
import excepciones.BaseDeDatosException;

public interface Propietario_DAO
{	
	public Propietario saveOrUpdate(Propietario p) throws BaseDeDatosException, SQLException;
	public List<Propietario> buscarTodas();
	public void eliminarPropietario(Integer id);
	public Propietario buscarPorId(Integer id);
	
}