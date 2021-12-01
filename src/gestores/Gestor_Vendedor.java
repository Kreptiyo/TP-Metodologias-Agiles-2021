package gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.Cliente_DAO;
import dao.Cliente_DAO_PostgreSQL;
import dao.Vendedor_DAO;
import dao.Vendedor_DAO_PostgreSQL;
import dominio.Cliente;
import dominio.Vendedor;
import dominio.Inmueble.Tipo_Inmueble;
import dominio.Vendedor.Tipo_Documento;
import excepciones.BaseDeDatosException;

public class Gestor_Vendedor {

	
	//creacion de los atributos necesarios e inicializacion 
	
	private Vendedor_DAO vendedorDAO;
	private Vendedor v;
	private List<Vendedor> listaDeVendedores;
	
	public Gestor_Vendedor()
	{
		super();
		this.v = new Vendedor();
		this.listaDeVendedores = new ArrayList<Vendedor>();
		this.vendedorDAO = new Vendedor_DAO_PostgreSQL();
	}
	
	//Metodo que llama a la clase DAO para persistir el vendedor en la base de datos
	
	public Vendedor crear_Vendedor() throws SQLException, BaseDeDatosException {
		return vendedorDAO.saveOrUpdate(v);
	}
	
	//Metodo que llama a la clase DAO para buscar todos los vendedores guardaos en la BD
	//y los guarda en la lista de vendedorss
	
	public List<Vendedor> listarTodos()
	{
		this.listaDeVendedores.clear();
		this.listaDeVendedores.addAll(vendedorDAO.buscarTodos());
		return this.listaDeVendedores;
	}
	
	//Metodo que llama a la clase DAO para eliminar el vendedor en la base de datos
	public void eliminarVendedor(String dni)
	{
		vendedorDAO.eliminarVendedor(dni);
	}

	
	public void actualizarVendedor(Integer id, String nombre, String apellido, String localidad, String provincia, Integer tipodocumento, String nrodocumento, String fechaNacimiento, String contraseña, String usuario)
	{
		
		//En este metodo se setan los datos del  vendedor traidos de la pantalla alta o modificacion de vendedor
		// todos estos datos ya se encuentran validados y verificados en la clase de la interfaz
		
		v.setId(id);
		v.setNombre(nombre);
		v.setApellido(apellido);
		v.setLocalidad(localidad);
		v.setProvincia(provincia);
		
		switch (tipodocumento) 
		{
		case 1:
			v.setTipodocumento(Tipo_Documento.DNI);
			break;
		case 2:
			v.setTipodocumento(Tipo_Documento.CI);
			break;
		case 3:
			v.setTipodocumento(Tipo_Documento.LC);
			break;
		case 4:
			v.setTipodocumento(Tipo_Documento.LE);
			break;
		case 5:
			v.setTipodocumento(Tipo_Documento.Pasaporte);
			break;

		}
		
		v.setNrodocumento(nrodocumento);
		v.setFechaNacimiento(fechaNacimiento);
		v.setContraseña(contraseña);
		v.setUsuario(usuario);
		
		try {
			
			this.crear_Vendedor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BaseDeDatosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarVendedor(String nombre, String apellido, String localidad, String provincia, Integer tipodocumento, String nrodocumento, String fechaNacimiento, String contraseña, String usuario)
	{

		v.setNombre(nombre);
		v.setApellido(apellido);
		v.setLocalidad(localidad);
		v.setProvincia(provincia);
		switch (tipodocumento) 
		{
		case 1:
			v.setTipodocumento(Tipo_Documento.DNI);
			break;
		case 2:
			v.setTipodocumento(Tipo_Documento.CI);
			break;
		case 3:
			v.setTipodocumento(Tipo_Documento.LC);
			break;
		case 4:
			v.setTipodocumento(Tipo_Documento.LE);
			break;
		case 5:
			v.setTipodocumento(Tipo_Documento.Pasaporte);
			break;

		}
		v.setNrodocumento(nrodocumento);
		v.setFechaNacimiento(fechaNacimiento);
		v.setContraseña(contraseña);
		v.setUsuario(usuario);
		
		v.toString();
		try {
			this.crear_Vendedor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BaseDeDatosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<Vendedor> buscarPorNombreApellidoDNI(String nom, String ape, String dni) {
		this.listaDeVendedores.clear();
		this.listaDeVendedores.addAll(vendedorDAO.buscarTodos(nom,ape,dni));
		return this.listaDeVendedores;
	}
}
