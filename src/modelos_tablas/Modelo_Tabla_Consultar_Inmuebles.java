package modelos_tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.Inmueble;

public class Modelo_Tabla_Consultar_Inmuebles extends AbstractTableModel {
	
	private String[] columnNames =  {"Código","Provincia", "Localidad", "Calle","Número de calle", "Barrio", "Tipo Inmueble", "Precio", "Dormitorios"};
	private List<Inmueble> data ;

	public Modelo_Tabla_Consultar_Inmuebles(List<Inmueble> inmuebles) {
	    	this.data = inmuebles;
	    }

	public int getColumnCount() {
	        return columnNames.length;
	    }

	public String getColumnName(int col) {
	        return columnNames[col];
	    }

	
	    public Object getValueAt(int row, int col) {
	    
	    	Inmueble i = data.get(row);
	    	
	            switch(col) {
	    	        case 0:
	    	        	return i.getId();
	    	        case 1:
	    	        	return i.getProvincia(); 
	    	        case 2:
	    	        	return i.getLocalidad();
	    	        case 3:
	    	        	return i.getCalle(); 
	    	        case 4:
	    	        	return i.getCalleNumero(); 
	    	        case 5:
	    	        	return i.getBarrio(); 
	    	        case 6:
	    	        	return i.getTipoDeInmueble(); 
	    	        case 7:
	    	        	return i.getPrecioDeVenta(); 
	    	        case 8:
	    	        	return i.getDormitorios(); 
						
					default:
						break;
	    	        	
	            }
	            return null;
	        }

	    public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	    }
	        
	    public Integer obtenerIdInmueble(int row){
	    		Inmueble i = data.get(row);
	            return i.getId();
	    }

	    public int getRowCount() 
		{
			return data.size();
		} 

}
