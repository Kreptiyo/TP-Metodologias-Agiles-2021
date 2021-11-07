package gestores;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dao.Inmueble_DAO;
import dao.Inmueble_DAO_PostgreSQL;
import dominio.Inmueble;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;

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
	
	public Inmueble crear_Inmueble() throws SQLException, BaseDeDatosException 
	{
		return inmuebleDAO.saveOrUpdate(i);
	}
	
	public void validar_Datos_Ubicacion(String provincia, String localidad,String calle, Integer numCalle,String barrio, Integer numDepto) throws Datos_Invalidos_Exception
	{
		
		StringBuilder mensajeAMostrar = new StringBuilder();
		List<String> lista_de_campos_erroneos = new ArrayList<String>();
		
		if(provincia.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Provincia");
			mensajeAMostrar.append("\n"+"- Provincia. (Campo incompleto)"+"\n");
		}
		
		
		if(localidad.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("localidad");
			mensajeAMostrar.append("\n"+"- localidad. (Campo incompleto)"+"\n");
		}
		
		if(localidad.isEmpty())
		{
			lista_de_campos_erroneos.add("localidad");
			mensajeAMostrar.append("\n"+"- localidad. (Campo incompleto)"+"\n");
		}
		
		if(calle.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Calle");
			mensajeAMostrar.append("\n"+"- Calle. (Campo incompleto)"+"\n");
		}
		
		if(calle.isEmpty())
		{
			lista_de_campos_erroneos.add("Calle");
			mensajeAMostrar.append("\n"+"- Calle. (Campo incompleto)"+"\n");
		}
		
		if(numCalle == null)
		{
			lista_de_campos_erroneos.add("Numero Calle");
			mensajeAMostrar.append("\n"+"- Número de Calle. (Campo incompleto)"+"\n");
		}
		
		if(barrio.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Barrio");
			mensajeAMostrar.append("\n"+"- Barrio. (Campo incompleto)"+"\n");
		}
		
		if(numDepto == null)
		{
			lista_de_campos_erroneos.add("Numero piso/departamento");
			mensajeAMostrar.append("\n"+"- Número de piso/departamento. (Campo incompleto)"+"\n");
		}
		
		/*si el mensaje a mostrar no esta vacio quiere decir que hay errores, por lo cual lanzamos una excepcion*/
		
		if(mensajeAMostrar.length() != 0)
		{
			throw new Datos_Invalidos_Exception(mensajeAMostrar.toString(), lista_de_campos_erroneos);
		}
		
	}
	
	public void validar_Datos_Inmueble(String tipoInmueble, Integer precioInmueble, String orientacion,
			Integer metrosFondo, Integer metrosFrente, Integer superficieTerreno) throws Datos_Invalidos_Exception
	{		
		StringBuilder mensajeAMostrar = new StringBuilder();
		List<String> lista_de_campos_erroneos = new ArrayList<String>();
		
		
		if(tipoInmueble.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Tipo inmueble");
			mensajeAMostrar.append("\n"+"- Tipo inmueble. (Campo incompleto)"+"\n");
		}
		
		
		if(precioInmueble == null)
		{
			lista_de_campos_erroneos.add("Precio inmueble");
			mensajeAMostrar.append("\n"+"- Precio del inmueble. (Campo incompleto)"+"\n");
		}
		
		if(orientacion.equals("SELECCIONAR"))
		{
			lista_de_campos_erroneos.add("Orientacion");
			mensajeAMostrar.append("\n"+"- Orientación. (Campo incompleto)"+"\n");
		}
		
		if(metrosFondo == null)
		{
			lista_de_campos_erroneos.add("Metros de fondo");
			mensajeAMostrar.append("\n"+"- Metros de fondo. (Campo incompleto)"+"\n");
		}
		
		if(metrosFrente == null)
		{
			lista_de_campos_erroneos.add("Metros de frente");
			mensajeAMostrar.append("\n"+"- Metros de frente. (Campo incompleto)"+"\n");
		}
		
		if(superficieTerreno == null)
		{
			lista_de_campos_erroneos.add("Superficie del terreno");
			mensajeAMostrar.append("\n"+"- Superficie del terreno. (Campo incompleto)"+"\n");
		}
		
		/*si el mensaje a mostrar no esta vacio quiere decir que hay errores, por lo cual lanzamos una excepcion*/
		
		if(mensajeAMostrar.length() != 0)
		{
			throw new Datos_Invalidos_Exception(mensajeAMostrar.toString(), lista_de_campos_erroneos);
		}
	}
	
	
	public void actualizarModelo_Ubicacion(String provincia, String localidad, String calle, Integer numero, String barrio, Integer pisoDepartamento)
	{
		i.setProvincia(provincia);
		i.setLocalidad(localidad);
		i.setCalle(calle);
		i.setCalleNumero(numero);
		i.setBarrio(barrio);
		i.setPisoDepartamento(pisoDepartamento);
	}
	
	public void actualizarModelo_Datos_Inmueble(String tipoInmueble, Integer precio, String orientacion, Integer frente, Integer fondo, Integer superficie, 
			Boolean propiedadHorizontal, Integer superficieEdificio, Integer antiguedad, Integer dormitorios, Integer baños, Boolean garaje, Boolean patio, Boolean piscina, 
			Boolean aguaCorriente, Boolean cloacas, Boolean gasNatural, Boolean aguaCaliente, Boolean telefono, Boolean lavadero, Boolean pavimento)
	{
		switch (tipoInmueble) 
		{
		case "L / LOCAL U OFICINA":
			i.setTipoDeInmueble(Tipo_Inmueble.L);
			break;
		case "C / CASA":
			i.setTipoDeInmueble(Tipo_Inmueble.C);
			break;
		case "D / DEPARTAMENTO":
			i.setTipoDeInmueble(Tipo_Inmueble.D);
			break;
		case "T / TERRENO":
			i.setTipoDeInmueble(Tipo_Inmueble.T);
			break;
		case "Q / QUINTA":
			i.setTipoDeInmueble(Tipo_Inmueble.Q);
			break;
		case "G / GALPÓN":
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
		i.setSuperficieEdificio(superficieEdificio);
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
	
	public List<Inmueble> buscarTodos(Integer idPropietario)
	{
		this.listaDeInmuebles.clear();
		this.listaDeInmuebles.addAll(inmuebleDAO.buscarTodosPorIdPropietario(idPropietario));
		return this.listaDeInmuebles;
	}
	
	public Inmueble buscarPorId(Integer id) {
		return inmuebleDAO.buscarPorId(id);
	}
	
	public void eliminarInmueble(Integer id)
	{
		inmuebleDAO.eliminarInmueble(id);
	}
}
