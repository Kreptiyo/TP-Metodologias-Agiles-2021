package dominio;

public class Propietario 
{
	private Integer id;
	private String nombre;
	private String apellido;
	private Tipo_Documento tipodocumento;
	private String nrodocumento;
	private String calle;
	private Integer nrocalle;
	private String localidad;
	private String provincia;
	private String telefono;
	private String email;
	
	public enum Tipo_Documento
	{
		DNI, CI, LC, LE, Pasaporte
	}
	
	public Propietario()
	{
		super();
	}
	
	public Propietario(Integer id, String nombre, String apellido, Tipo_Documento tipodocumento, String nrodocumento, String calle,
			Integer nrocalle, String localidad, String provincia, String telefono, String email)
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodocumento = tipodocumento;
		this.nrodocumento = nrodocumento;
		this.calle = calle;
		this.nrocalle = nrocalle;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Propietario(String nombre, String apellido, Tipo_Documento tipodocumento, String nrodocumento, String calle,
			Integer nrocalle, String localidad, String provincia, String telefono, String email)
	{
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodocumento = tipodocumento;
		this.nrodocumento = nrodocumento;
		this.calle = calle;
		this.nrocalle = nrocalle;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	public Tipo_Documento getTipodocumento() 
	{
		return tipodocumento;
	}

	public void setTipodocumento(Tipo_Documento tipodocumento) 
	{
		this.tipodocumento = tipodocumento;
	}

	public String getNrodocumento() 
	{
		return nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) 
	{
		this.nrodocumento = nrodocumento;
	}

	public String getCalle() 
	{
		return calle;
	}

	public void setCalle(String calle) 
	{
		this.calle = calle;
	}

	public Integer getNrocalle() 
	{
		return nrocalle;
	}

	public void setNrocalle(Integer nrocalle) 
	{
		this.nrocalle = nrocalle;
	}

	public String getLocalidad() 
	{
		return localidad;
	}

	public void setLocalidad(String localidad) 
	{
		this.localidad = localidad;
	}

	public String getProvincia() 
	{
		return provincia;
	}

	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}

	public String getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
}