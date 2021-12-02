package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dominio.Login;
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
		
		JButton btnVender = new JButton("Vender");
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVender.setBounds(697, 717, 164, 40);
		btnVender.setEnabled(true);
		
		add(btnVender);
		
		JButton btnVolver = new JButton("Volver");
		
		btnVolver.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelMenuPrincipal = new Menu_Principal(pantallaPrincipal);
			pantallaPrincipal.setContentPane(panelMenuPrincipal);
			pantallaPrincipal.setTitle("MENU PRINCIPAL");
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(914, 717, 100, 40);
		add(btnVolver);
		if(Login.tipoUsuario.equals("VENDEDOR") || Login.tipoUsuario.equals("ADMINISTRADOR"))
		{
			modeloTabla = new Modelo_Tabla_Ver_Reservas(gestorReservas.listarTodas());
		}
		else if(Login.tipoUsuario.equals("CLIENTE"))
		{
			modeloTabla = new Modelo_Tabla_Ver_Reservas(gestorReservas.listarTodasPorIdCliente(Login.id));
		}
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
		
		if(Login.tipoUsuario.equals("CLIENTE") || Login.tipoUsuario.equals("ADMINISTRADOR"))
		{
			btnVender.setEnabled(false);
			
		}
		
		btnVender.addActionListener(e->{	
			
		
			if(table.getSelectedRow() != -1) 
			{
				int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de vender este inmueble?");
				if(resp==JOptionPane.YES_OPTION)
				{
					Integer idReserva = modeloTabla.obtenerIdReserva(table.getSelectedRow());
					
					this.setVisible(false);
					JPanel panelVentaInmueble = new Venta_Inmueble(pantallaPrincipal,idReserva );
					panelVentaInmueble.setVisible(true);
					pantallaPrincipal.setContentPane(panelVentaInmueble);
					pantallaPrincipal.setTitle("Venta Inmueble");
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(pantallaPrincipal,
					    "Debe seleccionar una reserva","Advertencia",
					    JOptionPane.WARNING_MESSAGE);
			}
		
	  		
		});

	}
}
