package dominio;

import java.sql.Date;

public class Reserva {

	private Integer idReserva;
	private Integer idCliente;
	private Integer idInmueble;
	private Integer importeReserva;
	private Integer tiempoVigencia;
	private String Email;
	private String fechaEmision;
	
	public Reserva() {
		super();
	}
	
	public Reserva(Integer idCliente, Integer idInmueble, Integer importeReserva, Integer tiempoVigencia, String email,
			String fechaEmision) {
		super();
		this.idCliente = idCliente;
		this.idInmueble = idInmueble;
		this.importeReserva = importeReserva;
		this.tiempoVigencia = tiempoVigencia;
		Email = email;
		this.fechaEmision = fechaEmision;
	}
	
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(Integer idInmueble) {
		this.idInmueble = idInmueble;
	}
	public Integer getImporteReserva() {
		return importeReserva;
	}
	public void setImporteReserva(Integer importeReserva) {
		this.importeReserva = importeReserva;
	}
	public Integer getTiempoVigencia() {
		return tiempoVigencia;
	}
	public void setTiempoVigencia(Integer tiempoVigencia) {
		this.tiempoVigencia = tiempoVigencia;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
}
