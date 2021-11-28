package gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Cliente_DAO;
import dao.Cliente_DAO_PostgreSQL;
import dao.Inmueble_DAO;
import dao.Inmueble_DAO_PostgreSQL;
import dominio.Cliente;
import dominio.Inmueble;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;

public class Gestor_Cliente {
	private Cliente_DAO clienteDAO;
	private Gestor_Propietario gestorPropietario;
	private Cliente c;
	private List<Cliente> listaDeClientes;
	
	public Gestor_Cliente()
	{
		super();
		this.c = new Cliente();
		this.listaDeClientes = new ArrayList<Cliente>();
		this.clienteDAO = new Cliente_DAO_PostgreSQL();
	}
	
	public Cliente crear_Cliente() throws SQLException, BaseDeDatosException 
	{
		return clienteDAO.saveOrUpdate(c);
	}
	
	
	public void actualizarCliente(Integer id, String nombre, String localidad, String apellido, String telefono, String barrio, Integer monto, String mail, String contraseña, String documento)
	{	
		c.setId(id);
		c.setNombre(nombre);
		c.setLocalidad(localidad);
		c.setApellido(apellido);
		c.setTelefono(telefono);
		c.setBarrio(barrio);
		c.setMonto(monto);
		c.setMail(mail);
		c.setContraseña(contraseña);
		c.setNroDocumento(documento);
	}
	
	public void actualizarCliente(String nombre, String localidad, String apellido, String telefono, String barrio, Integer monto, String mail, String contraseña, String documento)
	{	
		c.setNombre(nombre);
		c.setLocalidad(localidad);
		c.setApellido(apellido);
		c.setTelefono(telefono);
		c.setBarrio(barrio);
		c.setMonto(monto);
		c.setNroDocumento(documento);
		c.setMail(mail);
		c.setContraseña(contraseña);
	}
	
	public void actualizarModelo_Datos_Inmueble(
			int tipoInmueble, 
			int orientacion, 
			Integer frente, 
			Integer fondo, 
			Integer superficie, 
			Boolean propiedadHorizontal, 
			Integer antiguedad, 
			Integer dormitorios, 
			Integer baños,
			Boolean garaje, 
			Boolean patio, 
			Boolean piscina, 
			Boolean aguaCorriente, 
			Boolean cloacas, 
			Boolean gasNatural, 
			Boolean aguaCaliente, 
			Boolean telefono, 
			Boolean lavadero, 
			Boolean pavimento) throws SQLException, BaseDeDatosException
	{
		
		c.setFrente(frente);
		c.setFondo(fondo);
		c.setSuperficie(superficie);
		c.setPropiedadHorizontal(propiedadHorizontal);
		c.setAntiguedad(antiguedad);
		c.setDormitorios(dormitorios);
		c.setBaños(baños);
		c.setGaraje(garaje);
		c.setPatio(patio);
		c.setPiscina(piscina);
		c.setAguaCorriente(aguaCorriente);
		c.setCloacas(cloacas);
		c.setGasNatural(gasNatural);
		c.setAguaCaliente(aguaCaliente);
		c.setHaytelefono(telefono);
		c.setLavadero(lavadero);
		c.setPavimento(pavimento);

		switch (tipoInmueble) 
		{
		case 1:
			c.setTipoInmueble(Tipo_Inmueble.L);
			break;
		case 2:
			c.setTipoInmueble(Tipo_Inmueble.C);
			break;
		case 3:
			c.setTipoInmueble(Tipo_Inmueble.D);
			break;
		case 4:
			c.setTipoInmueble(Tipo_Inmueble.T);
			break;
		case 5:
			c.setTipoInmueble(Tipo_Inmueble.Q);
			break;
		case 6:
			c.setTipoInmueble(Tipo_Inmueble.G);
			break;
		}

		switch(orientacion)
		{
		case 1:
			c.setOrientacion(Orientacion.NORTE);
			break;
		case 2:
			c.setOrientacion(Orientacion.SUR);
			break;
		case 3:
			c.setOrientacion(Orientacion.ESTE);
			break;
		case 4:
			c.setOrientacion(Orientacion.OESTE);
			break;
		case 5:
			c.setOrientacion(Orientacion.NORESTE);
			break;
		case 6:
			c.setOrientacion(Orientacion.NOROESTE);
			break;
		case 7:
			c.setOrientacion(Orientacion.SURESTE);
			break;
		case 8:
			c.setOrientacion(Orientacion.SUROESTE);
			break;
		}
		
		this.crear_Cliente();
	}	
	
	
	public List<Cliente> listarTodos()
	{
		this.listaDeClientes.clear();
		this.listaDeClientes.addAll(clienteDAO.buscarTodos());
		return this.listaDeClientes;
	}
	
	public List<Cliente> buscarPorNombreApellido(String nom, String ape)
	{
		this.listaDeClientes.clear();
		this.listaDeClientes.addAll(clienteDAO.buscarTodos(nom,ape));
		return this.listaDeClientes;
	}
	
	
	public void eliminarCliente(Integer id)
	{
		clienteDAO.eliminarCliente(id);
	}
}

