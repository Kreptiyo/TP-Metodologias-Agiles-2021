package dominio;

public class Cliente {

	private Integer id;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private TipoInmueble tipoInmueble;
	private String localidad;
	
	public int frente;
	public int fondo;
	public int superficie; 
	public int antig�edad;
	public int dormitorios;
	public int ba�os;
	public boolean esHorizontal;
	public boolean hayGaraje;
	public boolean hayPatio;
	public boolean hayPiscina;
	public boolean hayAguaCorriente;
	public boolean hayCloacas;
	public boolean hayGasNatural;
	public boolean hayAguaCaliente;
	public boolean hayTel�fono;
	public boolean hayLavadero;
	public boolean hayPavimento;
	public Orientaci�n orientacion;
	
	public enum Orientaci�n {norte, sur, este, oeste, noreste, noroeste, sureste, suroeste};

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

	public int getFrente() {
		return frente;
	}
	public void setFrente(int frente) {
		this.frente = frente;
	}
	public int getFondo() {
		return fondo;
	}
	public void setFondo(int fondo) {
		this.fondo = fondo;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public int getAntig�edad() {
		return antig�edad;
	}
	public void setAntig�edad(int antig�edad) {
		this.antig�edad = antig�edad;
	}
	public int getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}
	public int getBa�os() {
		return ba�os;
	}
	public void setBa�os(int ba�os) {
		this.ba�os = ba�os;
	}
	public boolean isEsHorizontal() {
		return esHorizontal;
	}
	public void setEsHorizontal(boolean esHorizontal) {
		this.esHorizontal = esHorizontal;
	}
	public boolean isHayGaraje() {
		return hayGaraje;
	}
	public void setHayGaraje(boolean hayGaraje) {
		this.hayGaraje = hayGaraje;
	}
	public boolean isHayPatio() {
		return hayPatio;
	}
	public void setHayPatio(boolean hayPatio) {
		this.hayPatio = hayPatio;
	}
	public boolean isHayPiscina() {
		return hayPiscina;
	}
	public void setHayPiscina(boolean hayPiscina) {
		this.hayPiscina = hayPiscina;
	}
	public boolean isHayAguaCorriente() {
		return hayAguaCorriente;
	}
	public void setHayAguaCorriente(boolean hayAguaCorriente) {
		this.hayAguaCorriente = hayAguaCorriente;
	}
	public boolean isHayCloacas() {
		return hayCloacas;
	}
	public void setHayCloacas(boolean hayCloacas) {
		this.hayCloacas = hayCloacas;
	}
	public boolean isHayGasNatural() {
		return hayGasNatural;
	}
	public void setHayGasNatural(boolean hayGasNatural) {
		this.hayGasNatural = hayGasNatural;
	}
	public boolean isHayAguaCaliente() {
		return hayAguaCaliente;
	}
	public void setHayAguaCaliente(boolean hayAguaCaliente) {
		this.hayAguaCaliente = hayAguaCaliente;
	}
	public boolean isHayTel�fono() {
		return hayTel�fono;
	}
	public void setHayTel�fono(boolean hayTel�fono) {
		this.hayTel�fono = hayTel�fono;
	}
	public boolean isHayLavadero() {
		return hayLavadero;
	}
	public void setHayLavadero(boolean hayLavadero) {
		this.hayLavadero = hayLavadero;
	}
	public boolean isHayPavimento() {
		return hayPavimento;
	}
	public void setHayPavimento(boolean hayPavimento) {
		this.hayPavimento = hayPavimento;
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
