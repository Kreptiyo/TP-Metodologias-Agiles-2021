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
	
	public Gestor_Propietario() 
	{
		super();
		this.listaDePropietarios = new ArrayList<Propietario>();
		this.propietarioDAO = new Propietario_DAO_PostgreSQL();
	}
	
	
	public Propietario crear_Propietario(Integer id_Propietario, String nombre, String apellido, String tipoDocumento, String numDocumento, String numTelefono, String email, String calle, Integer numCalle, String provincia, String localidad) throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException 
	{
		/*la excepcion de datos invalidos la vuelvo a relanzar para atraparla en la gui de alta de propietario con el fin de marcar los campos
		 * en los cuales ocurrieron errores*/

		this.validar_Datos(nombre, apellido, tipoDocumento, numDocumento, numTelefono, email, calle, numCalle, provincia, localidad);
		
		Propietario p = new Propietario(nombre, apellido, tipoDocumento, numDocumento, calle, numCalle, localidad, provincia, numTelefono, email);
		
		if(id_Propietario > 0) p.setId(id_Propietario);

		return propietarioDAO.saveOrUpdate(p);
	}
	
	
	/*valida que los campos este completos, caso contrario lanza una excepcion de campos invalidos*/
	
	public void validar_Datos(String nombre, String apellido, String tipoDocumento, String numDocumento, String numTelefono, String email,
			String calle, Integer numCalle, String provincia, String localidad) throws Datos_Invalidos_Exception{
		
		StringBuilder mensajeAMostrar = new StringBuilder();
		
		//Se crea la lista de campos erroneos, se la recorre y se muestra el mensaje correspondiente
		
		List<String> lista_de_campos_erroneos = new ArrayList<String>();
	
		if(nombre.isEmpty())						lista_de_campos_erroneos.add("Nombre");				
		if(apellido.isEmpty())						lista_de_campos_erroneos.add("Apellido");				
		if(tipoDocumento.equals("SELECCIONAR"))		lista_de_campos_erroneos.add("Tipo de documento");				
		if(numDocumento == null)					lista_de_campos_erroneos.add("Numero de documento");				
		if(numTelefono == null)						lista_de_campos_erroneos.add("telefono");				
		if(email.isEmpty())							lista_de_campos_erroneos.add("Email");				
		if(calle.isEmpty())							lista_de_campos_erroneos.add("Calle");				
		if(numCalle == null)						lista_de_campos_erroneos.add("Numero de calle");				
		if(provincia.equals("SELECCIONAR"))			lista_de_campos_erroneos.add("Provincia");				
		if(localidad.equals("SELECCIONAR"))			lista_de_campos_erroneos.add("Localidad");

		
		if(lista_de_campos_erroneos.size()>0) {
			
			for (String campoErroneo : lista_de_campos_erroneos)  mensajeAMostrar.append("\n - " + campoErroneo + ". (Campo incompleto)" + "\n");			 
		    
			throw new Datos_Invalidos_Exception(mensajeAMostrar.toString(), lista_de_campos_erroneos);
		}
		
	}

	
	
	public List<Propietario> listarTodas()
	{
		this.listaDePropietarios.clear();
		this.listaDePropietarios.addAll(propietarioDAO.buscarTodas());
		return this.listaDePropietarios;
	}
	
	public Propietario buscarPorNroDocumento(String nroDocumento)
	{
		Propietario p = propietarioDAO.buscarPorNroDocumento(nroDocumento);
		return p;
	}
	
	public void eliminarPropietario(Integer id)
	{
		propietarioDAO.eliminarPropietario(id);
	}
}
