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
	
	
	public void actualizarCliente(String nombre, String localidad, String apellido, Integer telefono, String barrio, Integer monto)
	{
		c.setNombre(nombre);
		c.setLocalidad(localidad);
		c.setApellido(apellido);
		c.setTelefono(telefono);
		c.setBarrio(barrio);
		c.setMonto(monto);
		System.out.println(c.toString());
	}
	
	public void actualizarModelo_Datos_Inmueble(
			String tipoInmueble, 
			String orientacion, 
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
			Boolean pavimento)
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
		case "LOCAL U OFICINA":
			c.setTipoInmueble(Tipo_Inmueble.L);
			break;
		case "CASA":
			c.setTipoInmueble(Tipo_Inmueble.C);
			break;
		case "DEPARTAMENTO":
			c.setTipoInmueble(Tipo_Inmueble.D);
			break;
		case "TERRENO":
			c.setTipoInmueble(Tipo_Inmueble.T);
			break;
		case "QUINTA":
			c.setTipoInmueble(Tipo_Inmueble.Q);
			break;
		case "GALPON":
			c.setTipoInmueble(Tipo_Inmueble.G);
			break;
		}

		switch(orientacion)
		{
		case "NORTE":
			c.setOrientacion(Orientacion.NORTE);
			break;
		case "SUR":
			c.setOrientacion(Orientacion.SUR);
			break;
		case "ESTE":
			c.setOrientacion(Orientacion.ESTE);
			break;
		case "OESTE":
			c.setOrientacion(Orientacion.OESTE);
			break;
		case "NORESTE":
			c.setOrientacion(Orientacion.NORESTE);
			break;
		case "NOROESTE":
			c.setOrientacion(Orientacion.NOROESTE);
			break;
		case "SURESTE":
			c.setOrientacion(Orientacion.SURESTE);
			break;
		case "SUROESTE":
			c.setOrientacion(Orientacion.SUROESTE);
			break;
		}
		
	}	
	
	
	public List<Cliente> listarTodos()
	{
		this.listaDeClientes.clear();
		this.listaDeClientes.addAll(clienteDAO.buscarTodos());
		return this.listaDeClientes;
	}
	
	
	public void eliminarCliente(Integer id)
	{
		clienteDAO.eliminarCliente(id);
	}
}
