package dao;

import java.sql.SQLException;
import java.util.List;
import dominio.Reserva;
import excepciones.BaseDeDatosException;

public interface Reserva_DAO {
	
	public Reserva save(Reserva r) throws BaseDeDatosException, SQLException;
	public List<Reserva> buscarTodas();
	public void eliminarReserva(Integer id);
	public Reserva buscarPorId(Integer id);

}
