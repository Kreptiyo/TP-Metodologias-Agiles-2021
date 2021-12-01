package dominio;

import dominio.Inmueble.Tipo_Inmueble;

public class Venta {

	private Integer id;
	private Integer idInmueble;
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String telefonoCliente;
	private String provincia;
	private String localidad;
	private String calleNumero;
	private String barrio;
	private String precioVenta;
	private Tipo_Inmueble tipoInmueble;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCalleNumero() {
		return calleNumero;
	}
	public void setCalleNumero(String calleNumero) {
		this.calleNumero = calleNumero;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Tipo_Inmueble getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(Tipo_Inmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	
	
	
}
