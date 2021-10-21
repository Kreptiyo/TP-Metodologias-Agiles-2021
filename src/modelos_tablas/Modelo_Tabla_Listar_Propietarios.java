package modelos_tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import dominio.Propietario;



public class Modelo_Tabla_Listar_Propietarios extends AbstractTableModel {
	
	private String[] columnNames =  {"Nombre","Apellido", "Tipo Documento", "N° Documento","Provincia" ,"Localidad", "Calle", "N° Calle", "Telefono", "Email"};
	private List<Propietario> data ;

	public Modelo_Tabla_Listar_Propietarios(List<Propietario> propietarios) {
	    	this.data = propietarios;
	    }

	public int getColumnCount() {
	        return columnNames.length;
	    }

	public String getColumnName(int col) {
	        return columnNames[col];
	    }

	
	    public Object getValueAt(int row, int col) {
	    
	    	Propietario p = data.get(row);
	    	
	            switch(col) {
	    	        case 0:
	    	        	return p.getNombre();
	    	        case 1:
	    	        	return p.getApellido(); 
	    	        case 2:
	    	        	return p.getTipodocumento();
	    	        case 3:
	    	        	return p.getNrodocumento(); 
	    	        case 4:
	    	        	return p.getProvincia(); 
	    	        case 5:
	    	        	return p.getLocalidad(); 
	    	        case 6:
	    	        	return p.getCalle(); 
	    	        case 7:
	    	        	return p.getNrocalle(); 
	    	        case 8:
	    	        	return p.getTelefono(); 
	    	        case 9:
	    	        	return p.getEmail(); 
						
					default:
						break;
	    	        	
	            }
	            return null;
	        }

	    public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	    }
	        
	    public Integer obtenerIdCompetencia(int row){
	            Propietario p = data.get(row);
	            return p.getId();
	    }

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

}

