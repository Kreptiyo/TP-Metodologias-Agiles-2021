package dominio;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	
	private Integer idCatalogo;
	private String fechaEmision;
	private List<Inmueble> inmuebles;
	private Integer idPropietario;
	
	public Catalogo(String fechaEmision, List<Inmueble> inmuebles, Integer idPropietario) {
		super();
		this.fechaEmision = fechaEmision;
		this.inmuebles = inmuebles;
		this.idPropietario = idPropietario;
	}
	
	public Catalogo() {
		super();
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Integer getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Integer getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

}
