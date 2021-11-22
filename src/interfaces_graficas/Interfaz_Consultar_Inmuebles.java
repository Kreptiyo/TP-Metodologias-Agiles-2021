package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dominio.Inmueble;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Catalogo;
import gestores.Gestor_Inmueble;
import modelos_tablas.Modelo_Tabla_Consultar_Inmuebles;

import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Consultar_Inmuebles extends JPanel {
	
	private JTextField txtDormitorios;
	private JTable table;
	private Modelo_Tabla_Consultar_Inmuebles modeloTabla;
	private Gestor_Inmueble gestorInmueble;
	private Gestor_Catalogo gestorCatalogo;
	private List<Inmueble> listaInmuebles;

	public Interfaz_Consultar_Inmuebles(JFrame pantallaPrincipal) 
	{
		gestorInmueble = new Gestor_Inmueble();
		gestorCatalogo = new Gestor_Catalogo();
		this.listaInmuebles = gestorInmueble.listarTodos();
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
		separator.setBounds(207, 55, 807, 20);
		add(separator);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(66, 86, 185, 25);
		add(lblProvincia);
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(192, 86, 150, 25);
		cbxProvincia.addItem("SELECCIONAR");
		cbxProvincia.addItem("SANTA FE");
		cbxProvincia.addItem("SALTA");
		add(cbxProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(385, 86, 185, 25);
		add(lblLocalidad);
		
		JComboBox cbxLocalidad = new JComboBox();
		cbxLocalidad.setBounds(509, 86, 150, 25);
		cbxLocalidad.addItem("SELECCIONAR");
		cbxLocalidad.addItem("SANTA FE");
		add(cbxLocalidad);
		
		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarrio.setBounds(698, 86, 185, 25);
		add(lblBarrio);
		
		JComboBox cbxBarrio = new JComboBox();
		cbxBarrio.setBounds(792, 86, 150, 25);
		cbxBarrio.addItem("SELECCIONAR");
		cbxBarrio.addItem("UN BARRIO");
		add(cbxBarrio);
		
		JLabel lblTipoInmueble = new JLabel("Tipo inmueble:");
		lblTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoInmueble.setBounds(66, 140, 185, 25);
		add(lblTipoInmueble);
		
		JComboBox cbxTipoInmueble = new JComboBox();
		cbxTipoInmueble.setBounds(207, 140, 135, 25);
		cbxTipoInmueble.addItem("SELECCIONAR");
		cbxTipoInmueble.addItem("L");
		cbxTipoInmueble.addItem("C");
		cbxTipoInmueble.addItem("D");
		cbxTipoInmueble.addItem("T");
		cbxTipoInmueble.addItem("Q");
		cbxTipoInmueble.addItem("G");
		add(cbxTipoInmueble);
		
		JLabel lblDormitorios = new JLabel("Dormitorios:");
		lblDormitorios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDormitorios.setBounds(385, 140, 185, 25);
		add(lblDormitorios);
		
		txtDormitorios = new JTextField();
		txtDormitorios.setBounds(573, 144, 86, 25);
		txtDormitorios.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtDormitorios.getText().length()>2) 
				{
					e.consume();
				}
				char input = e.getKeyChar();
				if((input < '0' || input > '9') && input != '\b')
				{
					e.consume();
				}

			}
		});
		add(txtDormitorios);
		
		JSlider slider = new JSlider();
		slider.setBounds(276, 208, 200, 26);
		add(slider);
		
		JLabel lbl0 = new JLabel("0");
		lbl0.setBounds(259, 213, 46, 14);
		add(lbl0);
		
		JLabel lbl0_1 = new JLabel("100.000");
		lbl0_1.setBounds(485, 213, 59, 14);
		add(lbl0_1);
		
		JLabel lblRangoPrecios = new JLabel("Rango Precios:");
		lblRangoPrecios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRangoPrecios.setBounds(66, 208, 185, 25);
		add(lblRangoPrecios);
		
		modeloTabla = new Modelo_Tabla_Consultar_Inmuebles(this.listaInmuebles);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 264, 1004, 400);
		TableRowSorter<TableModel> orden =  new TableRowSorter<TableModel>(modeloTabla);
		table.setRowSorter(orden);
		add(scrollPane);
		
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFiltrar.setBounds(644, 198, 180, 40);
		btnFiltrar.addActionListener(e->
		{
			
				String provincia = null;
				String localidad = null;
				String barrio = null;
				String tipoInmueble = null;
				Integer dormitorios = null;
				
				
				if(cbxProvincia.getSelectedIndex() != 0) {
					
					provincia = cbxProvincia.getSelectedItem().toString();
					
				}
				
				if(cbxLocalidad.getSelectedIndex() != 0) {
					
					localidad = cbxLocalidad.getSelectedItem().toString();
					
				}
				
				if(cbxBarrio.getSelectedIndex() != 0) {
					
					barrio = cbxBarrio.getSelectedItem().toString();
					
				}
				
				if(cbxTipoInmueble.getSelectedIndex() != 0) {
					
					tipoInmueble = cbxTipoInmueble.getSelectedItem().toString();
					
				}
				
				if(!txtDormitorios.getText().isEmpty()) {
					
					dormitorios = Integer.parseInt(txtDormitorios.getText().toString());
					
				}
				
				if(this.gestorInmueble.buscarTodosConFiltros(provincia, localidad, barrio, tipoInmueble, dormitorios).size() > 0)
				{
					this.listaInmuebles = this.gestorInmueble.buscarTodosConFiltros(provincia, localidad, barrio, tipoInmueble, dormitorios);
					modeloTabla.fireTableDataChanged();
				}
				else
				{
					this.mostrarMensajeAdvertencia(pantallaPrincipal, "Filtros", "No se encontro ningun inmueble con los filtros establecidos");
					this.setVisible(false);
					JPanel refrescar = new Interfaz_Consultar_Inmuebles(pantallaPrincipal);
					pantallaPrincipal.setContentPane(refrescar);
					pantallaPrincipal.setTitle("Lista de Inmuebles");
				}
				
			});
		add(btnFiltrar);
		
		JButton btnLimpiarFiltro = new JButton("Limpiar Filtros");
		btnLimpiarFiltro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiarFiltro.setBounds(834, 198, 180, 40);
		btnLimpiarFiltro.addActionListener(e->
		{
			
			cbxProvincia.setSelectedIndex(0);
			cbxLocalidad.setSelectedIndex(0);
			cbxBarrio.setSelectedIndex(0);
			cbxTipoInmueble.setSelectedIndex(0);
			txtDormitorios.setText("");
			
			orden.setRowFilter(RowFilter.regexFilter("",0));
			
		});
		add(btnLimpiarFiltro);
		
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
		
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerDetalles.setBounds(10, 675, 141, 40);
		add(btnVerDetalles);
		
		JButton btnGenerarCatalogo = new JButton("Generar Catalogo");
		btnGenerarCatalogo.addActionListener(e-> {
			if(table.getRowCount()==0) {
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun inmueble.", "Debe seleccionar al menos un inmueble");
			}
			else {
				
				List<String> idsInmuebles = new ArrayList<String>();
				for(int i=0; i<table.getRowCount();i++) {
					idsInmuebles.add(modeloTabla.obtenerIdInmueble(i).toString());
				}
				try {
					gestorCatalogo.generarCatalogo(1, idsInmuebles);
					this.mostrarMensajeAdvertencia(pantallaPrincipal, "Generar catalogo", "Se ha creado el catalogo con exito!");
				} catch (BaseDeDatosException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGenerarCatalogo.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGenerarCatalogo.setBounds(161, 675, 185, 40);
		add(btnGenerarCatalogo);

	}
	
	public void mostrarMensajeAdvertencia(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostrarMensajeExito(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
}
