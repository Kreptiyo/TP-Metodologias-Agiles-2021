package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.DB;
import dominio.Cliente;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Cliente_DAO_PostgreSQL implements Cliente_DAO{

	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_CLIENTE =
			"SELECT * FROM ma.cliente";
	
	private static final String SELECT_CLIENTE_POR_ID =
			"SELECT * FROM ma.cliente WHERE ID = ? ";
	
	private static final String SELECT_CLIENTE_NOMBRE_APELLIDO =
			"SELECT * FROM ma.cliente WHERE NOMBRE = ? AND APELLIDO =? ";
	
	private static final String SELECT_CLIENTE_NOMBRE =
			"SELECT * FROM ma.cliente WHERE NOMBRE = ? ";
	
	private static final String SELECT_CLIENTE_APELLIDO =
			"SELECT * FROM ma.cliente WHERE  APELLIDO =? ";
	
	private static final String INSERT_CLIENTE =
			"INSERT INTO ma.cliente (NOMBRE, APELLIDO, TELEFONO, TIPO_INMUEBLE, LOCALIDAD, BARRIO, MONTO , ORIENTACION, "
			+ "FRENTE, FONDO, SUPERFICIE, PROPIEDAD_HORIZONTAL, ANTIGUEDAD, DORMITORIOS, BANOS, GARAJE, PATIO, PISCINA, AGUA_CORRIENTE, CLOACAS,  "
			+ "AGUA_CALIENTE, HAYTELEFONO, LAVADERO, PAVIMENTO, GAS_NATURAL) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_CLIENTE =
			"UPDATE ma.cliente SET NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, TIPO_INMUEBLE = ?, LOCALIDAD = ?, BARRIO = ?, MONTO = ?, ORIENTACION = ?,FRENTE = ?, FONDO = ?, SUPERFICIE = ?, PROPIEDAD_HORIZONTAL = ?, ANTIGUEDAD = ?, DORMITORIOS = ?, BANOS = ?, GARAJE = ?, PATIO = ?, PISCINA = ?, AGUA_CORRIENTE = ?, CLOACAS = ?,"
			+ "AGUA_CALIENTE = ?, HAYTELEFONO = ?, LAVADERO = ?, PAVIMENTO = ?,  GAS_NATURAL = ? "+
		    "WHERE ID = ?";
	
	private static final String DELETE_CLIENTE =
			"DELETE FROM ma.cliente WHERE ID = ?";
	
	@Override
	public Cliente saveOrUpdate(Cliente c) throws BaseDeDatosException, SQLException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = Gestor_Conexion.getConnection();
		try 
		{
				if(c.getId() != null && c.getId() > 0)
				{
					System.out.println("Ejecuta update");
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(UPDATE_CLIENTE);
					pstmt.setString(1, c.getNombre());
					pstmt.setString(2, c.getApellido());
					pstmt.setLong(3, c.getTelefono());
					pstmt.setString(4, c.getTipoInmueble().toString());
					pstmt.setString(5, c.getLocalidad());
					pstmt.setString(6, c.getBarrio());
					pstmt.setInt(7, c.getMonto());
					pstmt.setString(8, c.getOrientacion().toString());
					pstmt.setInt(9, c.getFrente());
					pstmt.setInt(10, c.getFondo());
					pstmt.setInt(11, c.getSuperficie());
					pstmt.setBoolean(12, c.getPropiedadHorizontal());
					pstmt.setInt(13, c.getAntiguedad());
					pstmt.setInt(14, c.getDormitorios());
					pstmt.setInt(15, c.getBaños());
					pstmt.setBoolean(16, c.getGaraje());
					pstmt.setBoolean(17, c.getPatio());
					pstmt.setBoolean(18, c.getPiscina());
					pstmt.setBoolean(19, c.getAguaCorriente());
					pstmt.setBoolean(20, c.getCloacas());
					pstmt.setBoolean(21, c.getGasNatural());
					pstmt.setBoolean(22, c.getAguaCaliente());
					pstmt.setBoolean(23, c.getHaytelefono());
					pstmt.setBoolean(24, c.getLavadero());
					pstmt.setBoolean(25, c.getPavimento());
					pstmt.setInt(26, c.getId());
					pstmt.executeUpdate();
					conn.commit();
					
				}
				else
				{
					System.out.println("Ejecuta insert");
					conn.setAutoCommit(false);
					pstmt = conn.prepareStatement(INSERT_CLIENTE);
					pstmt.setString(1, c.getNombre());
					pstmt.setString(2, c.getApellido());
					pstmt.setLong(3, c.getTelefono());
					pstmt.setString(4, c.getTipoInmueble().toString());
					pstmt.setString(5, c.getLocalidad());
					pstmt.setString(6, c.getBarrio());
					pstmt.setInt(7, c.getMonto());
					pstmt.setString(8, c.getOrientacion().toString());
					pstmt.setInt(9, c.getFrente());
					pstmt.setInt(10, c.getFondo());
					pstmt.setInt(11, c.getSuperficie());
					pstmt.setBoolean(12, c.getPropiedadHorizontal());
					pstmt.setInt(13, c.getAntiguedad());
					pstmt.setInt(14, c.getDormitorios());
					pstmt.setInt(15, c.getBaños());
					pstmt.setBoolean(16, c.getGaraje());
					pstmt.setBoolean(17, c.getPatio());
					pstmt.setBoolean(18, c.getPiscina());
					pstmt.setBoolean(19, c.getAguaCorriente());
					pstmt.setBoolean(20, c.getCloacas());
					pstmt.setBoolean(21, c.getGasNatural());
					pstmt.setBoolean(22, c.getAguaCaliente());
					pstmt.setBoolean(23, c.getHaytelefono());
					pstmt.setBoolean(24, c.getLavadero());
					pstmt.setBoolean(25, c.getPavimento());
					//pstmt.setInt(26, c.getId());
					pstmt.executeUpdate();
					conn.commit();
				}					
		} 
		catch (SQLException e) 
		{
			conn.rollback();
			e.printStackTrace();
			throw new BaseDeDatosException(e.getMessage());
		}
		finally {
			try 
			{
				if(pstmt!=null) pstmt.close();				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println("Listo");
		return c;
	}

	@Override
	public List<Cliente> buscarTodos() 
	{
		List<Cliente> lista = new ArrayList<Cliente>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_CLIENTE);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Cliente c = new Cliente();
				c.setId(rs.getInt("ID"));
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setTelefono(rs.getInt("TELEFONO"));
				
				switch(rs.getString("TIPO_INMUEBLE"))
				{
				case "L":
					c.setTipoInmueble(Tipo_Inmueble.L);
					break;
				case "C":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "D":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "T":
					c.setTipoInmueble(Tipo_Inmueble.T);
					break;
				case "Q":
					c.setTipoInmueble(Tipo_Inmueble.Q);
					break;
				case "G":
					c.setTipoInmueble(Tipo_Inmueble.G);
					break;
				}
				
				switch(rs.getString("ORIENTACION"))
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
				
				
				c.setLocalidad(rs.getString("LOCALIDAD"));
				c.setBarrio(rs.getString("BARRIO"));
				c.setMonto(rs.getInt("MONTO"));
				
				c.setFrente(rs.getInt("FRENTE"));
				c.setFondo(rs.getInt("FONDO"));
				c.setSuperficie(rs.getInt("SUPERFICIE"));
				c.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				c.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				c.setDormitorios(rs.getInt("DORMITORIOS"));
				c.setBaños(rs.getInt("BANOS"));
				c.setGaraje(rs.getBoolean("GARAJE"));
				c.setPatio(rs.getBoolean("PATIO"));
				c.setPiscina(rs.getBoolean("PISCINA"));
				c.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				c.setCloacas(rs.getBoolean("CLOACAS"));
				c.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				c.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				c.setHaytelefono(rs.getBoolean("HAYTELEFONO"));
				c.setLavadero(rs.getBoolean("LAVADERO"));
				c.setPavimento(rs.getBoolean("PAVIMENTO"));
				
				lista.add(c);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	@Override
	public void eliminarCliente(Integer id) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_CLIENTE);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstmt!=null) pstmt.close();				
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Cliente> buscarTodos(String nom, String ape) {

			List<Cliente> lista = new ArrayList<Cliente>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try
			{
				if(nom.length()==0) {
					pstmt = conn.prepareStatement(SELECT_CLIENTE_APELLIDO);
					pstmt.setString(1, ape);
					rs = pstmt.executeQuery();
					System.out.println("apellido");
				}
				else if(ape.length()==0) {
					pstmt = conn.prepareStatement(SELECT_CLIENTE_NOMBRE);
					pstmt.setString(1, nom);
					rs = pstmt.executeQuery();
					System.out.println("nombre");
				}else {
					pstmt = conn.prepareStatement(SELECT_CLIENTE_NOMBRE_APELLIDO);
					pstmt.setString(1, nom);
					pstmt.setString(2, ape);
					rs = pstmt.executeQuery();
					System.out.println("los 2");
				}
				
				
				while(rs.next())
				{
					Cliente c = new Cliente();
					c.setId(rs.getInt("ID"));
					c.setNombre(rs.getString("NOMBRE"));
					c.setApellido(rs.getString("APELLIDO"));
					c.setTelefono(rs.getInt("TELEFONO"));
					
					switch(rs.getString("TIPO_INMUEBLE"))
					{
					case "L":
						c.setTipoInmueble(Tipo_Inmueble.L);
						break;
					case "C":
						c.setTipoInmueble(Tipo_Inmueble.C);
						break;
					case "D":
						c.setTipoInmueble(Tipo_Inmueble.C);
						break;
					case "T":
						c.setTipoInmueble(Tipo_Inmueble.T);
						break;
					case "Q":
						c.setTipoInmueble(Tipo_Inmueble.Q);
						break;
					case "G":
						c.setTipoInmueble(Tipo_Inmueble.G);
						break;
					}
					
					switch(rs.getString("ORIENTACION"))
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
					
					
					c.setLocalidad(rs.getString("LOCALIDAD"));
					c.setBarrio(rs.getString("BARRIO"));
					c.setMonto(rs.getInt("MONTO"));
					
					c.setFrente(rs.getInt("FRENTE"));
					c.setFondo(rs.getInt("FONDO"));
					c.setSuperficie(rs.getInt("SUPERFICIE"));
					c.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
					c.setAntiguedad(rs.getInt("ANTIGUEDAD"));
					c.setDormitorios(rs.getInt("DORMITORIOS"));
					c.setBaños(rs.getInt("BANOS"));
					c.setGaraje(rs.getBoolean("GARAJE"));
					c.setPatio(rs.getBoolean("PATIO"));
					c.setPiscina(rs.getBoolean("PISCINA"));
					c.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
					c.setCloacas(rs.getBoolean("CLOACAS"));
					c.setGasNatural(rs.getBoolean("GAS_NATURAL"));
					c.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
					c.setHaytelefono(rs.getBoolean("HAYTELEFONO"));
					c.setLavadero(rs.getBoolean("LAVADERO"));
					c.setPavimento(rs.getBoolean("PAVIMENTO"));
					
					lista.add(c);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			return lista;
		}

	@Override
	public Cliente buscarPorId(Integer id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cliente c = new Cliente();
		
		try
		{
			
				pstmt = conn.prepareStatement(SELECT_CLIENTE_POR_ID);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
			while(rs.next()) {
				
				c.setId(rs.getInt("ID"));
				c.setNombre(rs.getString("NOMBRE"));
				c.setApellido(rs.getString("APELLIDO"));
				c.setTelefono(rs.getInt("TELEFONO"));
				
				switch(rs.getString("TIPO_INMUEBLE"))
				{
				case "L":
					c.setTipoInmueble(Tipo_Inmueble.L);
					break;
				case "C":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "D":
					c.setTipoInmueble(Tipo_Inmueble.C);
					break;
				case "T":
					c.setTipoInmueble(Tipo_Inmueble.T);
					break;
				case "Q":
					c.setTipoInmueble(Tipo_Inmueble.Q);
					break;
				case "G":
					c.setTipoInmueble(Tipo_Inmueble.G);
					break;
				}
				
				switch(rs.getString("ORIENTACION"))
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
				
				
				c.setLocalidad(rs.getString("LOCALIDAD"));
				c.setBarrio(rs.getString("BARRIO"));
				c.setMonto(rs.getInt("MONTO"));
				
				c.setFrente(rs.getInt("FRENTE"));
				c.setFondo(rs.getInt("FONDO"));
				c.setSuperficie(rs.getInt("SUPERFICIE"));
				c.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				c.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				c.setDormitorios(rs.getInt("DORMITORIOS"));
				c.setBaños(rs.getInt("BANOS"));
				c.setGaraje(rs.getBoolean("GARAJE"));
				c.setPatio(rs.getBoolean("PATIO"));
				c.setPiscina(rs.getBoolean("PISCINA"));
				c.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				c.setCloacas(rs.getBoolean("CLOACAS"));
				c.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				c.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				c.setHaytelefono(rs.getBoolean("HAYTELEFONO"));
				c.setLavadero(rs.getBoolean("LAVADERO"));
				c.setPavimento(rs.getBoolean("PAVIMENTO"));
				
		}
			}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return c;
	}
	
	
	
}
