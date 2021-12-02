package modelos_tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.Reserva;

public class Modelo_Tabla_Ver_Reservas extends AbstractTableModel {

	private String[] columnNames =  {"Código de reserva","Código inmueble", "Código de cliente", "Monto de reserva", "Tiempo de vigencia"};
	private List<Reserva> data ;

	public Modelo_Tabla_Ver_Reservas(List<Reserva> reservas) {
	    	this.data = reservas;
	    }

	public int getColumnCount() {
	        return columnNames.length;
	    }

	public String getColumnName(int col) {
	        return columnNames[col];
	    }

	
	    public Object getValueAt(int row, int col) {
	    
	    	Reserva r = data.get(row);
	    	
	            switch(col) {
	    	        case 0:
	    	        	return r.getIdReserva();
	    	        case 1:
	    	        	return r.getIdInmueble(); 
	    	        case 2:
	    	        	return r.getIdCliente();
	    	        case 3:
	    	        	return r.getImporteReserva(); 
	    	        case 4:
	    	        	return r.getTiempoVigencia(); 		
					default:
						break;
	    	        	
	            }
	            return null;
	        }

	    public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	    }
	        
	    public Integer obtenerIdReserva(int row){
	    		Reserva r = data.get(row);
	            return r.getIdReserva();
	    }

	    public int getRowCount() 
		{
			return data.size();
		} 


}
