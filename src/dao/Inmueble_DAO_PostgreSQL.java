package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Inmueble;
import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Conexion;

public class Inmueble_DAO_PostgreSQL implements Inmueble_DAO
{
	private Connection conn = Gestor_Conexion.getConnection();
	
	private static final String SELECT_ALL_INMUEBLE =
			"SELECT * FROM ma.inmueble";
	
	private static final String INSERT_INMUEBLE =
			"INSERT INTO ma.inmueble (PROVINCIA, LOCALIDAD, CALLE_NUMERO, PISO_DEPARTAMENTO, BARRIO, TIPO_INMUEBLE, PRECIO, OBSERVACION, ORIENTACION, "
			+ "FRENTE, FONDO, SUPERFICIE, PROPIEDAD_HORIZONTAL, ANTIGUEDAD, DORMITORIOS, BAÑOS, GARAJE, PATIO, PISCINA, AGUA_CORRIENTE, CLOACAS, GAS_NATURAL, "
			+ "AGUA_CALIENTE, TELEFONO, LAVADERO, PAVIMENTO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE_INMUEBLE =
			"UPDATE ma.inmueble SET PROVINCIA = ?, LOCALIDAD = ?, CALLE_NUMERO = ?, PISO_DEPARTAMENTO = ?, BARRIO = ?, TIPO_INMUEBLE = ?, PRECIO = ?, OBSERVACION = ?, ORIENTACION = ?, "
			+ "FRENTE = ?, FONDO = ?, SUPERFICIE = ?, PROPIEDAD_HORIZONTAL = ?, ANTIGUEDAD = ?, DORMITORIOS = ?, BAÑOS = ?, GARAJE = ?, PATIO = ?, PISCINA = ?, AGUA_CORRIENTE = ?, CLOACAS = ?, GAS_NATURAL = ?, "
			+ "AGUA_CALIENTE = ?, TELEFONO = ?, LAVADERO = ?, PAVIMENTO = ?";
	
	private static final String DELETE_INMUEBLE =
			"DELETE FROM ma.inmueble WHERE ID = ?";
	
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
				pstmt.setString(1, i.getProvincia());
				pstmt.setString(2, i.getLocalidad());
				pstmt.setString(3, i.getCalleNumero());
				pstmt.setInt(4, i.getPisoDepartamento());
				pstmt.setString(5, i.getBarrio());
				pstmt.setString(6, i.getTipoDeInmueble().toString());
				pstmt.setInt(7, i.getPrecioDeVenta());
				pstmt.setString(8, i.getObservacion());
				pstmt.setString(9, i.getOrientacion().toString());
				pstmt.setInt(10, i.getFrente());
				pstmt.setInt(11, i.getFondo());
				pstmt.setInt(12, i.getSuperficie());
				pstmt.setBoolean(0, i.getPropiedadHorizontal());
				pstmt.setInt(14, i.getAntiguedad());
				pstmt.setInt(15, i.getDormitorios());
				pstmt.setInt(16, i.getBaños());
				pstmt.setBoolean(17, i.getGaraje());
				pstmt.setBoolean(18, i.getPatio());
				pstmt.setBoolean(19, i.getPiscina());
				pstmt.setBoolean(20, i.getAguaCorriente());
				pstmt.setBoolean(22, i.getCloacas());
				pstmt.setBoolean(23, i.getAguaCaliente());
				pstmt.setBoolean(24, i.getTelefono());
				pstmt.setBoolean(25, i.getLavadero());
				pstmt.setBoolean(26, i.getPavimento());
				pstmt.executeUpdate();
				conn.commit();
				
			}
			else
			{
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(INSERT_INMUEBLE);
				pstmt.setString(1, i.getProvincia());
				pstmt.setString(2, i.getLocalidad());
				pstmt.setString(3, i.getCalleNumero());
				pstmt.setInt(4, i.getPisoDepartamento());
				pstmt.setString(5, i.getBarrio());
				pstmt.setString(6, i.getTipoDeInmueble().toString());
				pstmt.setInt(7, i.getPrecioDeVenta());
				pstmt.setString(8, i.getObservacion());
				pstmt.setString(9, i.getOrientacion().toString());
				pstmt.setInt(10, i.getFrente());
				pstmt.setInt(11, i.getFondo());
				pstmt.setInt(12, i.getSuperficie());
				pstmt.setBoolean(0, i.getPropiedadHorizontal());
				pstmt.setInt(14, i.getAntiguedad());
				pstmt.setInt(15, i.getDormitorios());
				pstmt.setInt(16, i.getBaños());
				pstmt.setBoolean(17, i.getGaraje());
				pstmt.setBoolean(18, i.getPatio());
				pstmt.setBoolean(19, i.getPiscina());
				pstmt.setBoolean(20, i.getAguaCorriente());
				pstmt.setBoolean(22, i.getCloacas());
				pstmt.setBoolean(23, i.getAguaCaliente());
				pstmt.setBoolean(24, i.getTelefono());
				pstmt.setBoolean(25, i.getLavadero());
				pstmt.setBoolean(26, i.getPavimento());
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
				i.setProvincia(rs.getString("PROVINCIA"));
				i.setLocalidad(rs.getString("LOCALIDAD"));
				i.setCalleNumero(rs.getString("CALLE_NUMERO"));
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
				i.setAntiguedad(rs.getInt("ANTIGUEDAD"));
				i.setDormitorios(rs.getInt("DORMITORIOS"));
				i.setBaños(rs.getInt("BAÑOS"));
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
		try 
		{
				conn.setAutoCommit(false);
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
	
	
}
