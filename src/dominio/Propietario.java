package dominio;


public class Propietario {
	
	private String nombre;
	private String apellido;
	private String email;
	private String tipoDocumento;
	private Integer numeroDocumento;
	private String calle;
	private int numeroCalle;
	private Integer numeroTelefono;
	private String localidad;
	private String provincia;
	private Integer id;
	
	
	
	public Propietario() {
		super();
	}


	public Propietario(String nombre, String apellido, String email, String tipoDocumento, Integer numeroDocumento,
			String calle, int numeroCalle, Integer numeroTelefono, String localidad, String provincia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.numeroTelefono = numeroTelefono;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumeroCalle() {
		return numeroCalle;
	}


	public void setNumeroCalle(int numeroCalle) {
		this.numeroCalle = numeroCalle;
	}


	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
