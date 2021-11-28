package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Inmueble;
import dominio.Inmueble.Estado_Inmueble;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Inmueble_DAO_PostgreSQL implements Inmueble_DAO
{
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_INMUEBLE =
			"SELECT * FROM ma.inmueble";
	
	private static final String SELECT_ALL_INMUEBLE_PROPIETARIO =
			"SELECT * FROM ma.inmueble WHERE NRO_DOCUMENTO_PROPIETARIO = ?";
	
	private static final String SELECT_INMUEBLE =
			"SELECT * FROM ma.inmueble WHERE id = ?";
	
	private static final String INSERT_INMUEBLE =
			"INSERT INTO ma.inmueble (NRO_DOCUMENTO_PROPIETARIO, PROVINCIA, LOCALIDAD, CALLE, CALLE_NUMERO, PISO_DEPARTAMENTO, BARRIO, TIPO_INMUEBLE, PRECIO, OBSERVACION, ORIENTACION, "
			+ "FRENTE, FONDO, SUPERFICIE, PROPIEDAD_HORIZONTAL, SUPERFICIE_EDIFICIO, ANTIGUEDAD, DORMITORIOS, BA�OS, GARAJE, PATIO, PISCINA, AGUA_CORRIENTE, CLOACAS, GAS_NATURAL, "
			+ "AGUA_CALIENTE, TELEFONO, LAVADERO, PAVIMENTO, ESTADO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_INMUEBLE =
			"UPDATE ma.inmueble SET NRO_DOCUMENTO_PROPIETARIO = ?, PROVINCIA = ?, LOCALIDAD = ?, CALLE = ?, CALLE_NUMERO = ?, PISO_DEPARTAMENTO = ?, BARRIO = ?, TIPO_INMUEBLE = ?, PRECIO = ?, OBSERVACION = ?, ORIENTACION = ?, "
			+ "FRENTE = ?, FONDO = ?, SUPERFICIE = ?, PROPIEDAD_HORIZONTAL = ?, SUPERFICIE_EDIFICIO = ?, ANTIGUEDAD = ?, DORMITORIOS = ?, BA�OS = ?, GARAJE = ?, PATIO = ?, PISCINA = ?, AGUA_CORRIENTE = ?, CLOACAS = ?, GAS_NATURAL = ?, "
			+ "AGUA_CALIENTE = ?, TELEFONO = ?, LAVADERO = ?, PAVIMENTO = ?, ESTADO = ? WHERE ID = ?";
	
	private static final String DELETE_INMUEBLE =
			"DELETE FROM ma.inmueble WHERE ID = ?";
	
	private static final String DELETE_INMUEBLE_PROPIETARIO =
			"DELETE FROM ma.inmueble WHERE NRO_DOCUMENTO_PROPIETARIO = ?";
	
	@Override
	public Inmueble saveOrUpdate(Inmueble i) throws BaseDeDatosException, SQLException
	{
		PreparedStatement pstmt = null;
		
		try
		{
			if(i.getId() != null && i.getId() > 0)
			{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(UPDATE_INMUEBLE);
				pstmt.setString(1, i.getPropietario().getNrodocumento());
				pstmt.setString(2, i.getProvincia());
				pstmt.setString(3, i.getLocalidad());
				pstmt.setString(4, i.getCalle());
				pstmt.setInt(5, i.getCalleNumero());
				pstmt.setInt(6, i.getPisoDepartamento());
				pstmt.setString(7, i.getBarrio());
				pstmt.setString(8, i.getTipoDeInmueble().toString());
				pstmt.setInt(9, i.getPrecioDeVenta());
				pstmt.setString(10, i.getObservacion());
				pstmt.setString(11, i.getOrientacion().toString());
				pstmt.setInt(12, i.getFrente());
				pstmt.setInt(13, i.getFondo());
				pstmt.setInt(14, i.getSuperficie());
				pstmt.setBoolean(15, i.getPropiedadHorizontal());
				pstmt.setInt(16, i.getSuperficieEdificio());
				pstmt.setInt(17, i.getAntiguedad());
				pstmt.setInt(18, i.getDormitorios());
				pstmt.setInt(19, i.getBa�os());
				pstmt.setBoolean(20, i.getGaraje());
				pstmt.setBoolean(21, i.getPatio());
				pstmt.setBoolean(22, i.getPiscina());
				pstmt.setBoolean(23, i.getAguaCorriente());
				pstmt.setBoolean(24, i.getCloacas());
				pstmt.setBoolean(25, i.getGasNatural());
				pstmt.setBoolean(26, i.getAguaCaliente());
				pstmt.setBoolean(27, i.getTelefono());
				pstmt.setBoolean(28, i.getLavadero());
				pstmt.setBoolean(29, i.getPavimento());
				pstmt.setString(30, i.getEstadoInmueble().toString());
				pstmt.setInt(31, i.getId());
				pstmt.executeUpdate();
				conn.commit();
				
			}
			else
			{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(INSERT_INMUEBLE);
				pstmt.setString(1, i.getPropietario().getNrodocumento());
				pstmt.setString(2, i.getProvincia());
				pstmt.setString(3, i.getLocalidad());
				pstmt.setString(4, i.getCalle());
				pstmt.setInt(5, i.getCalleNumero());
				pstmt.setInt(6, i.getPisoDepartamento());
				pstmt.setString(7, i.getBarrio());
				pstmt.setString(8, i.getTipoDeInmueble().toString());
				pstmt.setInt(9, i.getPrecioDeVenta());
				pstmt.setString(10, i.getObservacion());
				pstmt.setString(11, i.getOrientacion().toString());
				pstmt.setInt(12, i.getFrente());
				pstmt.setInt(13, i.getFondo());
				pstmt.setInt(14, i.getSuperficie());
				pstmt.setBoolean(15, i.getPropiedadHorizontal());
				pstmt.setInt(16, i.getSuperficieEdificio());
				pstmt.setInt(17, i.getAntiguedad());
				pstmt.setInt(18, i.getDormitorios());
				pstmt.setInt(19, i.getBa�os());
				pstmt.setBoolean(20, i.getGaraje());
				pstmt.setBoolean(21, i.getPatio());
				pstmt.setBoolean(22, i.getPiscina());
				pstmt.setBoolean(23, i.getAguaCorriente());
				pstmt.setBoolean(24, i.getCloacas());
				pstmt.setBoolean(25, i.getGasNatural());
				pstmt.setBoolean(26, i.getAguaCaliente());
				pstmt.setBoolean(27, i.getTelefono());
				pstmt.setBoolean(28, i.getLavadero());
				pstmt.setBoolean(29, i.getPavimento());
				pstmt.setString(30, Estado_Inmueble.DISPONIBLE.name());
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
		return i;
	}

	@Override
	public List<Inmueble> buscarTodos() {
		List <Inmueble> lista = new ArrayList<Inmueble>();
		Propietario_DAO propietarioDAO = new Propietario_DAO_PostgreSQL();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_INMUEBLE);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Inmueble i = new Inmueble();
				i.setId(rs.getInt("ID"));
				i.setPropietario(propietarioDAO.buscarPorNroDocumento(rs.getString("NRO_DOCUMENTO_PROPIETARIO")));
				i.setProvincia(rs.getString("PROVINCIA"));
				i.setLocalidad(rs.getString("LOCALIDAD"));
				i.setCalle(rs.getString("CALLE"));
				i.setCalleNumero(rs.getInt("CALLE_NUMERO"));
				i.setPisoDepartamento(rs.getInt("PISO_DEPARTAMENTO"));
				i.setBarrio(rs.getString("BARRIO"));
				switch(rs.getString("TIPO_INMUEBLE"))
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
				i.setPrecioDeVenta(rs.getInt("PRECIO"));
				i.setObservacion(rs.getString("OBSERVACION"));
				//FALTA VER COMO HACER EL TEMA DE LAS FOTOS
				switch(rs.getString("ORIENTACION"))
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
				i.setFrente(rs.getInt("FRENTE"));
				i.setFondo(rs.getInt("FONDO"));
				i.setSuperficie(rs.getInt("SUPERFICIE"));
				i.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				i.setSuperficieEdificio(rs.getInt("SUPERFICIE_EDIFICIO"));
				i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				i.setDormitorios(rs.getInt("DORMITORIOS"));
				i.setBa�os(rs.getInt("BA�OS"));
				i.setGaraje(rs.getBoolean("GARAJE"));
				i.setPatio(rs.getBoolean("PATIO"));
				i.setPiscina(rs.getBoolean("PISCINA"));
				i.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				i.setCloacas(rs.getBoolean("CLOACAS"));
				i.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				i.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				i.setTelefono(rs.getBoolean("TELEFONO"));
				i.setLavadero(rs.getBoolean("LAVADERO"));
				i.setPavimento(rs.getBoolean("PAVIMENTO"));
				
				switch (rs.getString("ESTADO")) {
				case "DISPONIBLE": 
					i.setEstadoInmueble(Estado_Inmueble.DISPONIBLE);
					break;
				case "RESERVADO": 
					i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
					break;
				case "VENDIDO": 
					i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
					break;
				}
				lista.add(i);
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
	public void eliminarInmueble(Integer id) 
	{
		PreparedStatement pstmt = null;
		CatalogoDAO catalogo_DAO = new Catalogo_DAO_PostgreSQL();
		try 
		{
				conn.setAutoCommit(false);
				catalogo_DAO.eliminarCatalogoPorInmueble(id, conn);
				pstmt = conn.prepareStatement(DELETE_INMUEBLE);
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
	public void eliminarInmueblePropietario(String nroDocumento) 
	{
		PreparedStatement pstmt = null;
		try 
		{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(DELETE_INMUEBLE_PROPIETARIO);
				pstmt.setString(1, nroDocumento);
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
	public Inmueble buscarPorId(Integer id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Inmueble i = new Inmueble();
		Propietario_DAO propietarioDAO = new Propietario_DAO_PostgreSQL();
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_INMUEBLE);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				i.setId(rs.getInt("ID"));
				i.setPropietario(propietarioDAO.buscarPorNroDocumento(rs.getString("NRO_DOCUMENTO_PROPIETARIO")));
				i.setProvincia(rs.getString("PROVINCIA"));
				i.setLocalidad(rs.getString("LOCALIDAD"));
				i.setCalle(rs.getString("CALLE"));
				i.setCalleNumero(rs.getInt("CALLE_NUMERO"));
				i.setPisoDepartamento(rs.getInt("PISO_DEPARTAMENTO"));
				i.setBarrio(rs.getString("BARRIO"));
				switch(rs.getString("TIPO_INMUEBLE"))
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
				i.setPrecioDeVenta(rs.getInt("PRECIO"));
				i.setObservacion(rs.getString("OBSERVACION"));
				//FALTA VER COMO HACER EL TEMA DE LAS FOTOS
				switch(rs.getString("ORIENTACION"))
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
				i.setFrente(rs.getInt("FRENTE"));
				i.setFondo(rs.getInt("FONDO"));
				i.setSuperficie(rs.getInt("SUPERFICIE"));
				i.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				i.setSuperficieEdificio(rs.getInt("SUPERFICIE_EDIFICIO"));
				i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				i.setDormitorios(rs.getInt("DORMITORIOS"));
				i.setBa�os(rs.getInt("BA�OS"));
				i.setGaraje(rs.getBoolean("GARAJE"));
				i.setPatio(rs.getBoolean("PATIO"));
				i.setPiscina(rs.getBoolean("PISCINA"));
				i.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				i.setCloacas(rs.getBoolean("CLOACAS"));
				i.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				i.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				i.setTelefono(rs.getBoolean("TELEFONO"));
				i.setLavadero(rs.getBoolean("LAVADERO"));
				i.setPavimento(rs.getBoolean("PAVIMENTO"));
				
				switch (rs.getString("ESTADO")) {
				case "DISPONIBLE": 
					i.setEstadoInmueble(Estado_Inmueble.DISPONIBLE);
					break;
				case "RESERVADO": 
					i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
					break;
				case "VENDIDO": 
					i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
					break;
				}
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
		return i;
	}

	@Override
	public List<Inmueble> buscarTodosPorNroDocumentoPropietario(String nroDocumento) {
		List <Inmueble> lista = new ArrayList<Inmueble>();
		Propietario_DAO propietarioDAO = new Propietario_DAO_PostgreSQL();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_ALL_INMUEBLE_PROPIETARIO);
			pstmt.setString(1, nroDocumento);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Inmueble i = new Inmueble();
				i.setId(rs.getInt("ID"));
				i.setPropietario(propietarioDAO.buscarPorNroDocumento(nroDocumento));
				i.setProvincia(rs.getString("PROVINCIA"));
				i.setLocalidad(rs.getString("LOCALIDAD"));
				i.setCalle(rs.getString("CALLE"));
				i.setCalleNumero(rs.getInt("CALLE_NUMERO"));
				i.setPisoDepartamento(rs.getInt("PISO_DEPARTAMENTO"));
				i.setBarrio(rs.getString("BARRIO"));
				switch(rs.getString("TIPO_INMUEBLE"))
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
				i.setPrecioDeVenta(rs.getInt("PRECIO"));
				i.setObservacion(rs.getString("OBSERVACION"));
				//FALTA VER COMO HACER EL TEMA DE LAS FOTOS
				switch(rs.getString("ORIENTACION"))
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
				i.setFrente(rs.getInt("FRENTE"));
				i.setFondo(rs.getInt("FONDO"));
				i.setSuperficie(rs.getInt("SUPERFICIE"));
				i.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				i.setSuperficieEdificio(rs.getInt("SUPERFICIE_EDIFICIO"));
				i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				i.setDormitorios(rs.getInt("DORMITORIOS"));
				i.setBa�os(rs.getInt("BA�OS"));
				i.setGaraje(rs.getBoolean("GARAJE"));
				i.setPatio(rs.getBoolean("PATIO"));
				i.setPiscina(rs.getBoolean("PISCINA"));
				i.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				i.setCloacas(rs.getBoolean("CLOACAS"));
				i.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				i.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				i.setTelefono(rs.getBoolean("TELEFONO"));
				i.setLavadero(rs.getBoolean("LAVADERO"));
				i.setPavimento(rs.getBoolean("PAVIMENTO"));
				
				switch (rs.getString("ESTADO")) {
				case "DISPONIBLE": 
					i.setEstadoInmueble(Estado_Inmueble.DISPONIBLE);
					break;
				case "RESERVADO": 
					i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
					break;
				case "VENDIDO": 
					i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
					break;
				}
				
				lista.add(i);
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
	public List<Inmueble> buscarTodosConFiltros(String provincia, String localidad, String barrio, String tipoInmueble,
			Integer dormitorios) {
		//crear sentencia SQL
		StringBuilder statement = new StringBuilder("SELECT * FROM ma.inmueble WHERE ");
		if(provincia != null)
		{
			statement.append("PROVINCIA = '"+ provincia + "' AND ");
		}
		if(localidad != null)
		{
			statement.append("LOCALIDAD = '"+ localidad + "' AND ");
		}
		if(barrio != null)
		{
			statement.append("BARRIO = '"+ barrio + "' AND ");
		}
		if(tipoInmueble != null)
		{
			statement.append("TIPO_INMUEBLE = '"+ tipoInmueble + "' AND ");
		}
		if(dormitorios != null)
		{
			statement.append("DORMITORIOS = "+ dormitorios + " AND ");
		}
		statement.append("TRUE");
		String final_statement = statement.toString();
		
		
		
		List <Inmueble> lista = new ArrayList<Inmueble>();
		Propietario_DAO propietarioDAO = new Propietario_DAO_PostgreSQL();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(final_statement);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Inmueble i = new Inmueble();
				i.setId(rs.getInt("ID"));
				i.setPropietario(propietarioDAO.buscarPorNroDocumento(rs.getString("NRO_DOCUMENTO_PROPIETARIO")));
				i.setProvincia(rs.getString("PROVINCIA"));
				i.setLocalidad(rs.getString("LOCALIDAD"));
				i.setCalle(rs.getString("CALLE"));
				i.setCalleNumero(rs.getInt("CALLE_NUMERO"));
				i.setPisoDepartamento(rs.getInt("PISO_DEPARTAMENTO"));
				i.setBarrio(rs.getString("BARRIO"));
				switch(rs.getString("TIPO_INMUEBLE"))
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
				i.setPrecioDeVenta(rs.getInt("PRECIO"));
				i.setObservacion(rs.getString("OBSERVACION"));
				//FALTA VER COMO HACER EL TEMA DE LAS FOTOS
				switch(rs.getString("ORIENTACION"))
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
				i.setFrente(rs.getInt("FRENTE"));
				i.setFondo(rs.getInt("FONDO"));
				i.setSuperficie(rs.getInt("SUPERFICIE"));
				i.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
				i.setSuperficieEdificio(rs.getInt("SUPERFICIE_EDIFICIO"));
				i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				i.setDormitorios(rs.getInt("DORMITORIOS"));
				i.setBa�os(rs.getInt("BA�OS"));
				i.setGaraje(rs.getBoolean("GARAJE"));
				i.setPatio(rs.getBoolean("PATIO"));
				i.setPiscina(rs.getBoolean("PISCINA"));
				i.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
				i.setCloacas(rs.getBoolean("CLOACAS"));
				i.setGasNatural(rs.getBoolean("GAS_NATURAL"));
				i.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
				i.setTelefono(rs.getBoolean("TELEFONO"));
				i.setLavadero(rs.getBoolean("LAVADERO"));
				i.setPavimento(rs.getBoolean("PAVIMENTO"));
				
				switch (rs.getString("ESTADO")) {
				case "DISPONIBLE": 
					i.setEstadoInmueble(Estado_Inmueble.DISPONIBLE);
					break;
				case "RESERVADO": 
					i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
					break;
				case "VENDIDO": 
					i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
					break;
				}
				
				lista.add(i);
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
	public List<Inmueble> buscarPorCatalogo(List<Integer> ids) {
		List <Inmueble> lista = new ArrayList<Inmueble>();
		Propietario_DAO propietarioDAO = new Propietario_DAO_PostgreSQL();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(SELECT_INMUEBLE);
			for(Integer unId: ids)
			{
				pstmt.setInt(1, unId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Inmueble i = new Inmueble();
					i.setId(rs.getInt("ID"));
					i.setPropietario(propietarioDAO.buscarPorNroDocumento(rs.getString("NRO_DOCUMENTO_PROPIETARIO")));
					i.setProvincia(rs.getString("PROVINCIA"));
					i.setLocalidad(rs.getString("LOCALIDAD"));
					i.setCalle(rs.getString("CALLE"));
					i.setCalleNumero(rs.getInt("CALLE_NUMERO"));
					i.setPisoDepartamento(rs.getInt("PISO_DEPARTAMENTO"));
					i.setBarrio(rs.getString("BARRIO"));
					switch(rs.getString("TIPO_INMUEBLE"))
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
					i.setPrecioDeVenta(rs.getInt("PRECIO"));
					i.setObservacion(rs.getString("OBSERVACION"));
					//FALTA VER COMO HACER EL TEMA DE LAS FOTOS
					switch(rs.getString("ORIENTACION"))
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
					i.setFrente(rs.getInt("FRENTE"));
					i.setFondo(rs.getInt("FONDO"));
					i.setSuperficie(rs.getInt("SUPERFICIE"));
					i.setPropiedadHorizontal(rs.getBoolean("PROPIEDAD_HORIZONTAL"));
					i.setSuperficieEdificio(rs.getInt("SUPERFICIE_EDIFICIO"));
					i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
					i.setDormitorios(rs.getInt("DORMITORIOS"));
					i.setBa�os(rs.getInt("BA�OS"));
					i.setGaraje(rs.getBoolean("GARAJE"));
					i.setPatio(rs.getBoolean("PATIO"));
					i.setPiscina(rs.getBoolean("PISCINA"));
					i.setAguaCorriente(rs.getBoolean("AGUA_CORRIENTE"));
					i.setCloacas(rs.getBoolean("CLOACAS"));
					i.setGasNatural(rs.getBoolean("GAS_NATURAL"));
					i.setAguaCaliente(rs.getBoolean("AGUA_CALIENTE"));
					i.setTelefono(rs.getBoolean("TELEFONO"));
					i.setLavadero(rs.getBoolean("LAVADERO"));
					i.setPavimento(rs.getBoolean("PAVIMENTO"));
					
					switch (rs.getString("ESTADO")) {
					case "DISPONIBLE": 
						i.setEstadoInmueble(Estado_Inmueble.DISPONIBLE);
						break;
					case "RESERVADO": 
						i.setEstadoInmueble(Estado_Inmueble.RESERVADO);
						break;
					case "VENDIDO": 
						i.setEstadoInmueble(Estado_Inmueble.VENDIDO);
						break;
					}
					lista.add(i);
				}
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
	
}
