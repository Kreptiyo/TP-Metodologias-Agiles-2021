package excepciones;

import java.util.List;

public class Datos_Invalidos_Exception extends Exception {
	
	private String nombreCampo;
	private List<String> camposErroneos;
	
	public Datos_Invalidos_Exception(String nc, List<String> camposErroneos) {
		super(" Los siguientes campos son obligatorios: " + "\n" 
				+nc +"\n"+ "Por favor, ingrese los mismos.");
		this.nombreCampo = nc;
		this.camposErroneos = camposErroneos;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public List<String> getCamposErroneos() {
		return camposErroneos;
	}

	public void setCamposErroneos(List<String> camposErroneos) {
		this.camposErroneos = camposErroneos;
	}

}
