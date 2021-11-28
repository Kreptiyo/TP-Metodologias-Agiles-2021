package dominio;

import java.util.Date;

public class Vendedor {

	private Integer id;
	private String nombre;
	private String apellido;
	private Tipo_Documento tipodocumento;
	private String nrodocumento;
	private String localidad;
	private String provincia;
	private Date fechaNacimiento;
	private String contraseña;
	private String usuario;
	
	
	public enum Tipo_Documento
	{
		DNI, CI, LC, LE, Pasaporte
	}

	public String toString() {
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(tipodocumento);
		System.out.println(nrodocumento);
		System.out.println(localidad);
		System.out.println(provincia);
		System.out.println(fechaNacimiento);
		System.out.println(contraseña);
		System.out.println(usuario);
		return nombre;
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


	public Tipo_Documento getTipodocumento() {
		return tipodocumento;
	}


	public void setTipodocumento(Tipo_Documento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public String getNrodocumento() {
		return nrodocumento;
	}


	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
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


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
