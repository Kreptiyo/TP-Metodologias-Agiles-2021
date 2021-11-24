package gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.Cliente_DAO;
import dao.Cliente_DAO_PostgreSQL;
import dao.Vendedor_DAO;
import dao.Vendedor_DAO_PostgreSQL;
import dominio.Cliente;
import dominio.Vendedor;
import dominio.Vendedor.Tipo_Documento;

public class Gestor_Vendedor {

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
	
	public void actualizarVendedor(Integer id, String nombre, String apellido, String localidad, String provincia, Tipo_Documento tipodocumento, String nrodocumento, Date fechaNacimiento, String contraseña, String usuario)
	{
		v.setId(id);
		v.setNombre(nombre);
		v.setApellido(apellido);
		v.setLocalidad(localidad);
		v.setProvincia(provincia);
		v.setTipodocumento(tipodocumento);
		v.setNrodocumento(nrodocumento);
		v.setFechaNacimiento(fechaNacimiento);
		v.setContraseña(contraseña);
		v.setUsuario(usuario);
	}
	
	public void actualizarVendedor(String nombre, String apellido, String localidad, String provincia, Tipo_Documento tipodocumento, String nrodocumento, Date fechaNacimiento, String contraseña, String usuario)
	{

		v.setNombre(nombre);
		v.setApellido(apellido);
		v.setLocalidad(localidad);
		v.setProvincia(provincia);
		v.setTipodocumento(tipodocumento);
		v.setNrodocumento(nrodocumento);
		v.setFechaNacimiento(fechaNacimiento);
		v.setContraseña(contraseña);
		v.setUsuario(usuario);
	}
	
	
	
	public List<Vendedor> listarTodos()
	{
		this.listaDeVendedores.clear();
		this.listaDeVendedores.addAll(vendedorDAO.buscarTodos());
		return this.listaDeVendedores;
	}
	
//	public List<Vendedor> buscarPorNombreApellido(String nom, String ape)
//	{
//		this.listaDeVendedores.clear();
//		this.listaDeVendedores.addAll(vendedorDAO.buscarTodos(nom,ape));
//		return this.listaDeVendedores;
//	}
	
	
	public void eliminarCliente(Integer id)
	{
		vendedorDAO.eliminarVendedor(id);
	}
}
