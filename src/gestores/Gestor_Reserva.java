package gestores;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.Reserva_DAO;
import dao.Reserva_DAO_PostgreSQL;
import dominio.Reserva;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;


public class Gestor_Reserva {
	
	private Reserva_DAO reservaDAO;
	private List<Reserva> listaDeReservas;
	
	public Gestor_Reserva() 
	{
		super();
		this.listaDeReservas = new ArrayList<Reserva>();
		this.reservaDAO = new Reserva_DAO_PostgreSQL();
	}
	
	
	public Reserva crear_Reserva(Integer idCliente, Integer idInmueble, Integer importeReserva, Integer tiempoVigencia, 
			String email) throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException 
	{
		this.validar_Datos(importeReserva, tiempoVigencia, email);
		Reserva r = new Reserva();
		this.actualizarModelo(r, idCliente, idInmueble, importeReserva, tiempoVigencia, email);	
		return reservaDAO.save(r);
	}
	
	/*valida que los campos este completos, caso contrario lanza una excepcion de campos invalidos*/
	
	public void validar_Datos(Integer importeReserva, Integer tiempoVigencia, String email) throws Datos_Invalidos_Exception 
	{
		/*si alguno de los campos esta vacio, agrega el campo a la lista de errores y un mensaje a la lista de mensaje a mostrar. */
		
		StringBuilder mensajeAMostrar = new StringBuilder();
		List<String> lista_de_campos_erroneos = new ArrayList<String>();
		
		if(importeReserva.equals(-1))
		{
			lista_de_campos_erroneos.add("Importe de la reserva");
			mensajeAMostrar.append("\n"+"- Importe de la reserva. (Campo incompleto)"+"\n");
		}
		
		if(tiempoVigencia.equals(-1))
		{
			lista_de_campos_erroneos.add("Tiempo de vigencia de la reserva");
			mensajeAMostrar.append("\n"+"- Tiempo de vigencia. (Campo incompleto)"+"\n");
		}
		
		if(email.isEmpty())
		{
			lista_de_campos_erroneos.add("Email");
			mensajeAMostrar.append("\n"+"- Email. (Campo incompleto)"+"\n");
		}
		
		if(!email.isEmpty()) {
			
			Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			
			Matcher mather = pattern.matcher(email);

			/*VALIDA QUE EL FORMATO DEL EMAIL SEA EL CORRECTO*/
			
			if (mather.find() == false) {
				
				lista_de_campos_erroneos.add("Email");
				mensajeAMostrar.append("\n"+"- Formato inválido para Correo Electrónico."+"\n");
			}
			
		}
		
		/*si el mensaje a mostrar no esta vacio quiere decir que hay errores, por lo cual lanzamos una excepcion*/
		
		if(mensajeAMostrar.length() != 0)
		{
			throw new Datos_Invalidos_Exception(mensajeAMostrar.toString(), lista_de_campos_erroneos);
		}
		
	}
	
	public void actualizarModelo(Reserva r, Integer idCliente, Integer idInmueble, Integer importeReserva, Integer tiempoVigencia, String email)
	{
		r.setIdCliente(idCliente);
		r.setIdInmueble(idInmueble);
		r.setImporteReserva(importeReserva);
		r.setTiempoVigencia(tiempoVigencia);
		r.setEmail(email);
		r.setFechaEmision(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		
	}
	
	public List<Reserva> listarTodas()
	{
		this.listaDeReservas.clear();
		this.listaDeReservas.addAll(reservaDAO.buscarTodas());
		return this.listaDeReservas;
	}
	
	public Reserva buscarPorIdReserva(Integer idReserva)
	{
		Reserva r = reservaDAO.buscarPorId(idReserva);
		return r;
	}
	
	public void eliminarReserva(Integer id)
	{
		reservaDAO.eliminarReserva(id);
	}

}
