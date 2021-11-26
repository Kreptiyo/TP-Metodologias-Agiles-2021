package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gestores.Gestor_Reserva;
import modelos_tablas.Modelo_Tabla_Ver_Reservas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Interfaz_Grafica_Ver_Reservas extends JPanel {
	private JTextField txtCodigoReserva;
	private JTable table;
	private Modelo_Tabla_Ver_Reservas modeloTabla;
	private Gestor_Reserva gestorReservas;

	
	public Interfaz_Grafica_Ver_Reservas(JFrame pantallaPrincipal) {
		gestorReservas = new Gestor_Reserva();
		this.armarPanel(pantallaPrincipal);
	}

	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		JLabel lblFiltroDeBusqueda = new JLabel("Filtro de busqueda");
		lblFiltroDeBusqueda.setForeground(Color.BLACK);
		lblFiltroDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiltroDeBusqueda.setBounds(10, 40, 196, 25);
		add(lblFiltroDeBusqueda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 55, 798, 20);
		add(separator);
		
		JLabel lblCodigoReserva = new JLabel("C\u00F3digo de reserva:");
		lblCodigoReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigoReserva.setBounds(70, 96, 185, 25);
		add(lblCodigoReserva);
		
		txtCodigoReserva = new JTextField();
		txtCodigoReserva.setColumns(10);
		txtCodigoReserva.setBounds(265, 100, 150, 25);
		add(txtCodigoReserva);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(914, 717, 100, 40);
		add(btnVolver);
		
		modeloTabla = new Modelo_Tabla_Ver_Reservas(gestorReservas.listarTodas());
		table = new JTable();
		table.setBounds(10, 214, 1004, 404);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 194, 1004, 432);
		TableRowSorter<TableModel> orden =  new TableRowSorter<TableModel>(modeloTabla);
		table.setRowSorter(orden);
		add(scrollPane);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFiltrar.setBounds(644, 143, 180, 40);
		btnFiltrar.addActionListener(e->
		{
				LinkedList<RowFilter> listaDeFiltros = new LinkedList<RowFilter>();
				
				if(!txtCodigoReserva.getText().isEmpty()) {
					
					listaDeFiltros.add(RowFilter.regexFilter(txtCodigoReserva.getText().toString(),0));
				}
				
				if(listaDeFiltros.size()!=0) {
					
					orden.setRowFilter(RowFilter.andFilter((Iterable)listaDeFiltros));
					
				}
			});
		add(btnFiltrar);
		
		JButton btnLimpiarFiltro = new JButton("Limpiar Filtros");
		btnLimpiarFiltro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiarFiltro.setBounds(834, 143, 180, 40);
		btnLimpiarFiltro.addActionListener(e->
		{
			
			this.txtCodigoReserva.setText("");
			orden.setRowFilter(RowFilter.regexFilter("",0));
			
		});
		add(btnLimpiarFiltro);

	}
}
