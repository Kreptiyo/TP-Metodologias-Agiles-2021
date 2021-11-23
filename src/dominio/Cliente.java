package dominio;

import dominio.Inmueble.Orientacion;
import dominio.Inmueble.Tipo_Inmueble;

public class Cliente {

	private Integer id;
	private String nombre;
	private String apellido;
	private String nroDocumento;
	private String mail;
	private String contraseña;
	private String telefono;
	private String localidad;
	private String barrio;
	private Integer monto;
	private Tipo_Inmueble tipoInmueble;
	Orientacion orientacion;
	Integer frente;
	Integer fondo;
	Integer superficie;
	Boolean propiedadHorizontal;
	Integer antiguedad;
	Integer dormitorios;
	Integer baños;
	Boolean garaje;
	Boolean patio;
	Boolean piscina;
	Boolean aguaCorriente;
	Boolean cloacas;
	Boolean gasNatural;
	Boolean aguaCaliente;
	Boolean haytelefono;
	Boolean lavadero;
	Boolean pavimento;
	
	
	public String toString() {
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(localidad);
		System.out.println(telefono);
		System.out.println(barrio);
		System.out.println(monto);
		System.out.println("DOCUMENTO" + nroDocumento);
		System.out.println(tipoInmueble);
		System.out.println(orientacion);
		System.out.println(frente);
		System.out.println(fondo);
		System.out.println(superficie);
		System.out.println(propiedadHorizontal);
		System.out.println(dormitorios);
		System.out.println(baños);
		System.out.println(garaje);
		System.out.println(patio);
		System.out.println(piscina);
		System.out.println(aguaCorriente);
		System.out.println(cloacas);
		System.out.println(gasNatural);
		System.out.println(aguaCaliente);
		return nombre;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Tipo_Inmueble getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(Tipo_Inmueble c) {
		this.tipoInmueble = c;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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
	
	public Orientacion getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	public Integer getFrente() {
		return frente;
	}
	public void setFrente(Integer frente) {
		this.frente = frente;
	}
	public Integer getFondo() {
		return fondo;
	}
	public void setFondo(Integer fondo) {
		this.fondo = fondo;
	}
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	public Boolean getPropiedadHorizontal() {
		return propiedadHorizontal;
	}
	public void setPropiedadHorizontal(Boolean propiedadHorizontal) {
		this.propiedadHorizontal = propiedadHorizontal;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Integer getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}
	public Integer getBaños() {
		return baños;
	}
	public void setBaños(Integer baños) {
		this.baños = baños;
	}
	public Boolean getGaraje() {
		return garaje;
	}
	public void setGaraje(Boolean garaje) {
		this.garaje = garaje;
	}
	public Boolean getPatio() {
		return patio;
	}
	public void setPatio(Boolean patio) {
		this.patio = patio;
	}
	public Boolean getPiscina() {
		return piscina;
	}
	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}
	public Boolean getAguaCorriente() {
		return aguaCorriente;
	}
	public void setAguaCorriente(Boolean aguaCorriente) {
		this.aguaCorriente = aguaCorriente;
	}
	public Boolean getCloacas() {
		return cloacas;
	}
	public void setCloacas(Boolean cloacas) {
		this.cloacas = cloacas;
	}
	public Boolean getGasNatural() {
		return gasNatural;
	}
	public void setGasNatural(Boolean gasNatural) {
		this.gasNatural = gasNatural;
	}
	public Boolean getAguaCaliente() {
		return aguaCaliente;
	}
	public void setAguaCaliente(Boolean aguaCaliente) {
		this.aguaCaliente = aguaCaliente;
	}
	public Boolean getHaytelefono() {
		return haytelefono;
	}
	public void setHaytelefono(Boolean haytelefono) {
		this.haytelefono = haytelefono;
	}
	public Boolean getLavadero() {
		return lavadero;
	}
	public void setLavadero(Boolean lavadero) {
		this.lavadero = lavadero;
	}
	public Boolean getPavimento() {
		return pavimento;
	}
	public void setPavimento(Boolean pavimento) {
		this.pavimento = pavimento;
	}


	
}
