package test;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;

import dominio.Propietario;
import dominio.Vendedor.Tipo_Documento;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Propietario;

import junit.framework.TestCase;

public class Tests extends TestCase{

	private Gestor_Propietario gestPropietario;
	private Propietario p;

	
	public void inicializar() {
		gestPropietario = new Gestor_Propietario();
		p = new Propietario();
		p.setId(4);
		p.setNombre("RAMIRO");
		p.setApellido("GRIPPO");
		p.setTipodocumento(dominio.Propietario.Tipo_Documento.DNI);
		p.setNrodocumento("5653");
		p.setTelefono("2323");
		p.setEmail("RAMA@GMAIL.COM");
		p.setCalle("SAN JERONIMO");
		p.setNrocalle(333);
		p.setProvincia("SANTA FE");
		p.setLocalidad("SANTA FE");   
	}
	
	@Test
	public void testNro1() throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException {
		inicializar();
		try {
			//El test trata de crear un propietario con un numero de telefono incorrecto "e2423" y valida si captura la excepcion
		gestPropietario.crear_Propietario(1, "RAMIRO", "GRIPPO", "DNI", "5614", "e2423", "RAMA@GMAIL.COM", "SAN JERONIMO", 333, "SANTA FE", "SANTA FE");
		}	catch(BaseDeDatosException e) {}		
	}

	@Test
	public void testNro2() throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException, PSQLException  {
		inicializar();
		try {
			//El test trata de crear un propietario con un numero de documento incorrecto "56asd14"y valida si captura la excepcion
		gestPropietario.crear_Propietario(2, "RAMIRO", "GRIPPO", "DNI", "56asd14", "2455423", "RAMA@GMAIL.COM", "SAN JERONIMO", 333, "SANTA FE", "SANTA FE");
		}	catch(BaseDeDatosException e) {}		
	}
	
	@Test
	public void testNro3() throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException, PSQLException {
		inicializar();
		try {
			//El test trata de crear un propietario con un nompre con longitud de caracteres > 30 y valida si captura la excepcion
		gestPropietario.crear_Propietario(3, "RAMIRORAMIRORAMIRORAMIRORAMIRORAMIRO", "GRIPPO", "DNI", "5653", "2323", "RAMA@GMAIL.COM", "SAN JERONIMO", 333, "SANTA FE", "SANTA FE");
		}	catch(BaseDeDatosException e) {}		
	}
	
	@Test
	public void testNro4() throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException, PSQLException  {
		inicializar();
		try {
			//El test trata de crear un propietario con un apellido nulo y valida si captura la excepcion
		gestPropietario.crear_Propietario(5, "RAMIRO", null, "DNI", "5653", "2323", "RAMA@GMAIL.COM", "SAN JERONIMO", 333, "SANTA FE", "SANTA FE");
		}	catch(NullPointerException e) {}		
	}
	
	@Test
	public void testNro5() throws Datos_Invalidos_Exception, SQLException, BaseDeDatosException, PSQLException  {
		inicializar();
		
			//El test trata de crear un propietario con todos los datos correctos y valida si es igual al que se crea en el metodo inicializar
		Propietario p1 = new Propietario();
		Propietario p2 = new Propietario();
		p1 = this.p;
		p2 = gestPropietario.crear_Propietario(4, "RAMIRO", "GRIPPO", "DNI", "5653", "2323", "RAMA@GMAIL.COM", "SAN JERONIMO", 333, "SANTA FE", "SANTA FE");
		assertTrue(p1.equals(p2));	
	}
}
