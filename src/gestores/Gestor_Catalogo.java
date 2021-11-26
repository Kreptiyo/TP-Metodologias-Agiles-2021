package gestores;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.Catalogo_DAO_PostgreSQL;
import dao.CatalogoDAO;
import dominio.Catalogo;
import dominio.Inmueble;
import excepciones.BaseDeDatosException;

public class Gestor_Catalogo {
	
	private CatalogoDAO catalogoDao;
	private Catalogo c;
	private Gestor_Inmueble gestorInmueble;
	
	public Gestor_Catalogo() {
		super();
		catalogoDao = new Catalogo_DAO_PostgreSQL();
		c = new Catalogo();
		gestorInmueble = new Gestor_Inmueble();
	}
	
	
	public void generarCatalogo(Integer idCliente, List<String> idsInmuebles) throws BaseDeDatosException, SQLException {
		
		c.setFechaEmision(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
		
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		
		/*Busca en la base de datos todos los inmuebles cuyos ids los recibe por parametro*/
		for(String unId: idsInmuebles) {
			inmuebles.add(gestorInmueble.buscarPorId(Integer.parseInt(unId)));
			
		}
		
		c.setInmuebles(inmuebles);
		c.setIdPropietario(idCliente);
		c.setIdCatalogo(idCliente);
		
		for(Inmueble i: c.getInmuebles()) {
			System.out.println("id del inmueble seleccionado para catalogo: "+i.getId());
		}
		
		/*metodo de persistencia de datos*/
		catalogoDao.saveOrUpdate(c);
	}
	
	public List<Inmueble> inmueblesCatalogo(Integer idCliente)
	{
		return catalogoDao.obtenerInmueblesCatalogo(idCliente);
	}
	
	public Catalogo buscarCatalogo(Integer idCliente)
	{
		return catalogoDao.buscarCatalogo(idCliente);
	}

}
