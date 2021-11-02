package dominio;

public class Cliente {

	private Integer id;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private TipoInmueble tipoInmueble;
	private String localidad;
	private CaracteristicasInmueble caracteristicas;
	private String barrio;
	private Integer monto;
	
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public TipoInmueble getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(TipoInmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public CaracteristicasInmueble getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(CaracteristicasInmueble caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	
}
