package modelos_tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dominio.Inmueble;

public class Modelo_Tabla_Ver_Catalogo extends AbstractTableModel 
{
	private String[] columnNames =  {"Foto", "Código", "Tipo", "Localidad", "Dirección", "Barrio", "Dormitorios", "Baños", "Garaje", "Patio", "Sup. Terreno", "Sup. Edificada", "Precio"};
	private List<Inmueble> data ;

	public Modelo_Tabla_Ver_Catalogo(List<Inmueble> inmuebles) {
	    	this.data = inmuebles;
	    }

	public int getColumnCount() {
	        return columnNames.length;
	    }

	public String getColumnName(int col) {
	        return columnNames[col];
	    }

	public int getRowCount() 
	{
		return data.size();
	} 
	
	    public Object getValueAt(int row, int col) {
	    
	    	Inmueble i = data.get(row);
	    	
	            switch(col) {
	    	        case 0:
	    	        	return "Sin foto";
	    	        case 1:
	    	        	return i.getId(); 
	    	        case 2:
	    	        	return i.getTipoDeInmueble();
	    	        case 3:
	    	        	return i.getLocalidad(); 
	    	        case 4:
	    	        	return i.getCalle(); 
	    	        case 5:
	    	        	return i.getBarrio(); 
	    	        case 6:
	    	        	return i.getDormitorios(); 
	    	        case 7:
	    	        	return i.getBaños(); 
	    	        case 8:
	    	        	if(i.getGaraje())
	    	        		{
	    	        		return "Si";
	    	        		}
	    	        		else
	    	        		{
	    	        			return "No";
	    	        		}
	    	        case 9:
	    	        	if(i.getPatio())
    	        		{
    	        		return "Si";
    	        		}
    	        		else
    	        		{
    	        			return "No";
    	        		}
	    	        case 10:
	    	        	return i.getSuperficie();
	    	        case 11:
	    	        	return i.getSuperficieEdificio();
	    	        case 12:
	    	        	return i.getPrecioDeVenta();
	    	        	
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

}