package dominio;

public class CaracteristicasInmueble {

	public int frente;
	public int fondo;
	public int superficie; 
	public int antigüedad;
	public int dormitorios;
	public int baños;
	public boolean esHorizontal;
	public boolean hayGaraje;
	public boolean hayPatio;
	public boolean hayPiscina;
	public boolean hayAguaCorriente;
	public boolean hayCloacas;
	public boolean hayGasNatural;
	public boolean hayAguaCaliente;
	public boolean hayTeléfono;
	public boolean hayLavadero;
	public boolean hayPavimento; 
	public enum Orientación {norte, sur, este, oeste, noreste, noroeste, sureste, suroeste};
}
