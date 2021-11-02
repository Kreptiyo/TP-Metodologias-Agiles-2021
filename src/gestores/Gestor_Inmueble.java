package gestores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Inmueble_DAO;
import dao.Inmueble_DAO_PostgreSQL;
import dominio.Inmueble;
import dominio.Propietario;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;

public class Gestor_Inmueble 
{
	private Inmueble_DAO inmuebleDAO;
	private Inmueble i;
	private List<Inmueble> listaDeInmuebles;
	
	public Gestor_Inmueble()
	{
		super();
		this.i = new Inmueble();
		this.listaDeInmuebles = new ArrayList<Inmueble>();
		this.inmuebleDAO = new Inmueble_DAO_PostgreSQL();
	}
	
	public Inmueble crear_Inmueble() throws BaseDeDatosException, SQLException
	{
		return inmuebleDAO.saveOrUpdate(i);
	}
	
	public void validar_Datos_Ubicacion()
	{
		
	}
	
	public void validar_Datos_Inmueble()
	{
		
	}
	
	public void validar_Datos_Extras()
	{
		
	}
	
	public void actualizarModelo_Ubicacion(String provincia, String localidad, String calle, Integer numero, String barrio, Integer pisoDepartamento)
	{
		i.setProvincia(provincia);
		i.setLocalidad(localidad);
		i.setCalleNumero(calle.concat(numero.toString()));
		i.setBarrio(barrio);
		i.setPisoDepartamento(pisoDepartamento);
	}
	
	public void actualizarModelo_Datos_Inmueble(String tipoInmueble, Integer precio, String orientacion, Integer frente, Integer fondo, Integer superficie, Boolean propiedadHorizontal, 
			Integer superficieEdificio, Integer antiguedad, Integer dormitorios, Integer baños, Boolean garaje, Boolean patio, Boolean piscina, 
			Boolean aguaCorriente, Boolean cloacas, Boolean gasNatural, Boolean aguaCaliente, Boolean telefono, Boolean lavadero, Boolean pavimento)
	{
		switch (tipoInmueble) 
		{
		case "L":
			i.setTipoDeInmueble(Tipo_Inmueble.L);
			break;
		case "C":
			i.setTipoDeInmueble(Tipo_Inmueble.C);
			break;
		case "D":
			i.setTipoDeInmueble(Tipo_Inmueble.D);
			break;
		case "T":
			i.setTipoDeInmueble(Tipo_Inmueble.T);
			break;
		case "Q":
			i.setTipoDeInmueble(Tipo_Inmueble.Q);
			break;
		case "G":
			i.setTipoDeInmueble(Tipo_Inmueble.G);
			break;
		}
		i.setPrecioDeVenta(precio);
		switch(orientacion)
		{
		case "NORTE":
			i.setOrientacion(Orientacion.NORTE);
			break;
		case "SUR":
			i.setOrientacion(Orientacion.SUR);
			break;
		case "ESTE":
			i.setOrientacion(Orientacion.ESTE);
			break;
		case "OESTE":
			i.setOrientacion(Orientacion.OESTE);
			break;
		case "NORESTE":
			i.setOrientacion(Orientacion.NORESTE);
			break;
		case "NOROESTE":
			i.setOrientacion(Orientacion.NOROESTE);
			break;
		case "SURESTE":
			i.setOrientacion(Orientacion.SURESTE);
			break;
		case "SUROESTE":
			i.setOrientacion(Orientacion.SUROESTE);
			break;
		}
		i.setFrente(frente);
		i.setFondo(fondo);
		i.setSuperficie(superficie);
		i.setPropiedadHorizontal(propiedadHorizontal);
		i.setAntiguedad(antiguedad);
		i.setDormitorios(dormitorios);
		i.setBaños(baños);
		i.setGaraje(garaje);
		i.setPatio(patio);
		i.setPiscina(piscina);
		i.setAguaCorriente(aguaCorriente);
		i.setCloacas(cloacas);
		i.setGasNatural(gasNatural);
		i.setAguaCaliente(aguaCaliente);
		i.setTelefono(telefono);
		i.setLavadero(lavadero);
		i.setPavimento(pavimento);
	}
	
	public void actualizarModelo_Datos_Extras(String observaciones)
	{
		i.setObservacion(observaciones);
	}
	
	public List<Inmueble> listarTodos()
	{
		this.listaDeInmuebles.clear();
		this.listaDeInmuebles.addAll(inmuebleDAO.buscarTodos());
		return this.listaDeInmuebles;
	}
	
	public void eliminarInmueble(Integer id)
	{
		inmuebleDAO.eliminarInmueble(id);
	}
}
