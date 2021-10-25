package gestores;

import java.sql.SQLException;
import java.util.ArrayList;



import java.util.List;

import dao.Propietario_DAO;
import dao.Propietario_DAO_PostgreSQL;
import dominio.Propietario;
import dominio.Propietario.Tipo_Documento;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;


public class Gestor_Propietario {

	
	private Propietario_DAO propietarioDAO;
	private List<Propietario> listaDePropietarios;
	
	public Gestor_Propietario() {
		super();
		this.listaDePropietarios = new ArrayList<Propietario>();
		this.propietarioDAO = new Propietario_DAO_PostgreSQL();
	}
	
	
	public Propietario crear_Propietario(String nombre, String apellido, String tipoDocumento, Integer numDocumento, Integer numTelefono, String email,
								  String calle, Integer numCalle, String provincia, String localidad) throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException 
	{
		/*la excepcion de datos invalidos la vuelvo a relanzar para atraparla en la gui de alta de propietario con el fin de marcar los campos
		 * en los cuales ocurrieron errores*/
		this.validar_Datos(nombre, apellido, tipoDocumento, numDocumento, numTelefono, email, calle, numCalle, provincia, localidad);
		Propietario p = new Propietario();
		this.actualizarModelo(p, nombre, apellido, tipoDocumento, numDocumento, numTelefono, email, calle, numCalle, provincia, localidad);
		return propietarioDAO.saveOrUpdate(p);
	}
	
	
	/*valida que los campos este completos, caso contrario lanza una excepcion de campos invalidos*/
	
	public void validar_Datos(String nombre, String apellido, String tipoDocumento, Integer numDocumento, Integer numTelefono, String email,
			String calle, Integer numCalle, String provincia, String localidad) throws Datos_Invalidos_Exception 
	{
		/*si alguno de los campos esta vacio, agrega el campo a la lista de errores y un mensaje a la lista de mensaje a mostrar. */
		
		StringBuilder mensajeAMostrar = new StringBuilder();
		List<String> lista_de_campos_erroneos = new ArrayList<String>();
		
		if(nombre.isEmpty())
		{
			lista_de_campos_erroneos.add("Nombre");
			mensajeAMostrar.append("\n"+"- Nombre. (Campo incompleto)"+"\n");
		}
		
		if(apellido.isEmpty())
		{
			lista_de_campos_erroneos.add("Apellido");
			mensajeAMostrar.append("\n"+"- Apellido. (Campo incompleto)"+"\n");
		}
		
		if(tipoDocumento.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Tipo de documento");
			mensajeAMostrar.append("\n"+"- Tipo de documento. (Campo incompleto)"+"\n");
		}
		
		if(numDocumento == null)
		{
			lista_de_campos_erroneos.add("Numero de documento");
			mensajeAMostrar.append("\n"+"- Número de documento. (Campo incompleto)"+"\n");
		}
		
		if(numTelefono == null)
		{
			lista_de_campos_erroneos.add("telefono");
			mensajeAMostrar.append("\n"+"- Número de telefono. (Campo incompleto)"+"\n");
		}
		
		if(email.isEmpty())
		{
			lista_de_campos_erroneos.add("Email");
			mensajeAMostrar.append("\n"+"- Email. (Campo incompleto)"+"\n");
		}
		
		if(calle.isEmpty())
		{
			lista_de_campos_erroneos.add("Calle");
			mensajeAMostrar.append("\n"+"- Calle. (Campo incompleto)"+"\n");
		}
		
		if(numCalle == null)
		{
			lista_de_campos_erroneos.add("Numero de calle");
			mensajeAMostrar.append("\n"+"- Número de calle. (Campo incompleto)"+"\n");
		}
		
		if(provincia.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Provincia");
			mensajeAMostrar.append("\n"+"- Provincia. (Campo incompleto)"+"\n");
		}
		
		if(localidad.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Localidad");
			mensajeAMostrar.append("\n"+"- Localidad. (Campo incompleto)"+"\n");
		}
		
		/*si el mensaje a mostrar no esta vacio quiere decir que hay errores, por lo cual lanzamos una excepcion*/
		
		if(mensajeAMostrar.length() != 0)
		{
			throw new Datos_Invalidos_Exception(mensajeAMostrar.toString(), lista_de_campos_erroneos);
		}
		
	}
	
	public void actualizarModelo(Propietario p, String nombre, String apellido, String tipoDocumento, Integer numDocumento, Integer numTelefono, String email,
			String calle, Integer numCalle, String provincia, String localidad)
	{
		p.setNombre(nombre);
		p.setApellido(apellido);
		switch(tipoDocumento)
		{
		case "DNI":
			p.setTipodocumento(Tipo_Documento.DNI);
			break;
		case "CI":
			p.setTipodocumento(Tipo_Documento.CI);
			break;
		case "LC":
			p.setTipodocumento(Tipo_Documento.LC);
			break;
		case "LE":
			p.setTipodocumento(Tipo_Documento.LE);
			break;
		case "Pasaporte":
			p.setTipodocumento(Tipo_Documento.Pasaporte);
			break;
		}
		p.setNrodocumento(numDocumento);
		p.setTelefono(numTelefono);
		p.setEmail(email);
		p.setCalle(calle);
		p.setNrocalle(numCalle);
		p.setProvincia(provincia);
		p.setLocalidad(localidad);
	}
	
	public List<Propietario> listarTodas()
	{
		this.listaDePropietarios.clear();
		this.listaDePropietarios.addAll(propietarioDAO.buscarTodas());
		return this.listaDePropietarios;
	}
	
	public void eliminarPropietario(Integer id)
	{
		propietarioDAO.eliminarPropietario(id);
	}
}
