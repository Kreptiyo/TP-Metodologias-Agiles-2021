package dominio;

public class Inmueble 
{
	Integer id;
	Propietario propietario;
	String provincia;
	String localidad;
	String calle;
	Integer calleNumero;
	Integer pisoDepartamento;
	String barrio;
	Tipo_Inmueble tipoDeInmueble;
	Integer precioDeVenta;
	String observacion;
	//foto
	Orientacion orientacion;
	Integer frente;
	Integer fondo;
	Integer superficie;
	Boolean propiedadHorizontal;
	Integer superficieEdificio;
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
	Boolean telefono;
	Boolean lavadero;
	Boolean pavimento;
	Boolean Reservado;
	
	public Boolean getReservado() {
		return Reservado;
	}

	public void setReservado(Boolean reservado) {
		Reservado = reservado;
	}

	public enum Tipo_Inmueble
	{
		L, C, D, T, Q, G
	}
	
	public enum Orientacion
	{
		NORTE, SUR, ESTE, OESTE, NORESTE, NOROESTE, SURESTE, SUROESTE
	}
	
	public Inmueble()
	{
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getCalleNumero() {
		return calleNumero;
	}

	public void setCalleNumero(Integer calleNumero) {
		this.calleNumero = calleNumero;
	}

	public Integer getPisoDepartamento() {
		return pisoDepartamento;
	}

	public void setPisoDepartamento(Integer pisoDepartamento) {
		this.pisoDepartamento = pisoDepartamento;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Tipo_Inmueble getTipoDeInmueble() {
		return tipoDeInmueble;
	}

	public void setTipoDeInmueble(Tipo_Inmueble tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}

	public Integer getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(Integer precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	
	
	public Integer getSuperficieEdificio() {
		return superficieEdificio;
	}

	public void setSuperficieEdificio(Integer superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
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

	public Boolean getTelefono() {
		return telefono;
	}

	public void setTelefono(Boolean telefono) {
		this.telefono = telefono;
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
