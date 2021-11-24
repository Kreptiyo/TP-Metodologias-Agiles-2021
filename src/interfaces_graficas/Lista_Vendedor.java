package interfaces_graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dominio.Vendedor;


public class Lista_Vendedor extends JPanel {

	private JTable tablaVendedor;
	private DefaultTableModel modelo;
	private JTextField textFieldFiltrarNombre;
	private JTextField textFieldFiltrarApellido;
	private List<Vendedor> clientes;
	//private Gestor_Cliente gestorvendedores;
	private JTextField textFieldFiltrarDocumento;
	
	public Lista_Vendedor(JFrame pantallaPrincipal) {
		armarPanel(pantallaPrincipal);
	}

	
	public void armarPanel(JFrame pantallaPrincipal) {
		
		//gestorvendedores = new Gestor_Cliente();
		// vendedores = gestorvendedores.listarTodos();
		
		
		setLayout(null);
		JPanel paneltablaVendedor = new JPanel();
		paneltablaVendedor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Vendedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		paneltablaVendedor.setBounds(114, 275, 796, 289);
		add(paneltablaVendedor);
		GridBagLayout gbl_paneltablaVendedor = new GridBagLayout();
		gbl_paneltablaVendedor.columnWidths = new int[]{0, 0};
		gbl_paneltablaVendedor.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_paneltablaVendedor.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_paneltablaVendedor.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		paneltablaVendedor.setLayout(gbl_paneltablaVendedor);
		
		JScrollPane scrollPaneltablaVendedor = new JScrollPane();
		GridBagConstraints gbc_scrollPaneltablaVendedor = new GridBagConstraints();
		gbc_scrollPaneltablaVendedor.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneltablaVendedor.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneltablaVendedor.gridx = 0;
		gbc_scrollPaneltablaVendedor.gridy = 0;
		paneltablaVendedor.add(scrollPaneltablaVendedor, gbc_scrollPaneltablaVendedor);
		
		tablaVendedor = new JTable();
		
		
		this.modelo = new DefaultTableModel()
		{
		public boolean isCellEditable(int row, int column)
		       {
		         return false;//This causes all cells to be not editable
		       }
		};    
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Tipo Documento");
		modelo.addColumn("Nro. Documento");
		modelo.addColumn("Localidad");
		modelo.addColumn("Provincia");
		modelo.addColumn("Fecha de Nacimiento");
		
		tablaVendedor.setModel(modelo);
		scrollPaneltablaVendedor.setViewportView(tablaVendedor);
		
		JButton btnModificarVendedor = new JButton("Modificar");
		btnModificarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarVendedor.setBounds(440, 600, 140, 30);
		btnModificarVendedor.setEnabled(false);
		btnModificarVendedor.addActionListener(e->{	
				
			
//			String nombre = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 1);
//			String apellido = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 2);
//			String id = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 0);
//			
//			  		this.setVisible(false);
//					JPanel panelModificarvendedores = new Modificar_Cliente(pantallaPrincipal, nombre, apellido, id);
//					panelModificarvendedores.setVisible(true);
//					pantallaPrincipal.setContentPane(panelModificarvendedores);
//					pantallaPrincipal.setTitle("Modificar vendedores");
			  		
		});
		add(btnModificarVendedor);
		
		JButton btnAñadirVendedor = new JButton("A\u00F1adir");
		btnAñadirVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadirVendedor.setBounds(114, 600, 140, 30);
		btnAñadirVendedor.addActionListener(e-> {
			
			
//			this.setVisible(false);
//			JPanel panelAltavendedores = new AltaCliente(pantallaPrincipal);
//			panelAltavendedores.setVisible(true);
//			pantallaPrincipal.setContentPane(panelAltavendedores);
//			pantallaPrincipal.setTitle("Alta vendedores");
		
		});
		add(btnAñadirVendedor);
		
		JButton btnEliminarVendedor = new JButton("Eliminar");
		btnEliminarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarVendedor.setBounds(774, 600, 140, 30);
		btnEliminarVendedor.setEnabled(false);
		btnEliminarVendedor.addActionListener(e-> {
			
			//String id = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 0);			
			//this.gestorvendedores.eliminarCliente(Integer.parseInt(id));
			// vendedores = gestorvendedores.listarTodos();
			// this.mostrarResultados(vendedores);
		});
		add(btnEliminarVendedor);
		
		JLabel lblNombreVendedor = new JLabel("Nombre");
		lblNombreVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreVendedor.setBounds(296, 75, 130, 25);
		add(lblNombreVendedor);
		
		JLabel lblApellidoVendedor = new JLabel("Apellido");
		lblApellidoVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidoVendedor.setBounds(296, 115, 130, 25);
		add(lblApellidoVendedor);
		
		textFieldFiltrarNombre = new JTextField();
		textFieldFiltrarNombre.setColumns(10);
		textFieldFiltrarNombre.setBounds(466, 75, 200, 25);
		textFieldFiltrarNombre.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldFiltrarNombre.getText().length()>30) 
				{
					e.consume();
				}
				char c= e.getKeyChar();
				if(Character.isLowerCase(c)) 
				{
					String cad = (""+c).toUpperCase();
					c=cad.charAt(0);
					e.setKeyChar(c);
				}

			}
		});
		add(textFieldFiltrarNombre);
		
		textFieldFiltrarApellido = new JTextField();
		textFieldFiltrarApellido.setColumns(10);
		textFieldFiltrarApellido.setBounds(466, 115, 200, 25);
		textFieldFiltrarApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldFiltrarApellido.getText().length()>30) 
				{
					e.consume();
				}
				char c= e.getKeyChar();
				if(Character.isLowerCase(c)) 
				{
					String cad = (""+c).toUpperCase();
					c=cad.charAt(0);
					e.setKeyChar(c);
				}

			}
		});
		add(textFieldFiltrarApellido);
		
		JButton btnFlitrarVendedor = new JButton("Filtrar");
		btnFlitrarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFlitrarVendedor.setBounds(440, 206, 140, 30);
//		btnFlitrarVendedor.addActionListener(e-> {
//              
//              		
//  			while (modelo.getRowCount() > 0) {
//  				 modelo.removeRow(0);
//  			}
//
//              if(textFieldFiltrarNombre.getText().isEmpty() && textFieldFiltrarApellido.getText().isEmpty()) {
//            	  JOptionPane.showMessageDialog(null, "Debe ingresar al menos un filtro");
//            	  mostrarResultados(gestorvendedores.listarTodos());
//              }else {
//            	  
//                  mostrarResultados(gestorvendedores.buscarPorNombreApellido(textFieldFiltrarNombre.getText(), textFieldFiltrarApellido.getText()));
//              }
//
//          }
//
//
//      );
		add(btnFlitrarVendedor);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(774, 675, 140, 30);
		btnVolver.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelMenu = new Menu_Principal(pantallaPrincipal);
			panelMenu.setVisible(true);
			pantallaPrincipal.setContentPane(panelMenu);
			pantallaPrincipal.setTitle("Menu Principal");
		});
		add(btnVolver);
		
		JLabel lblNroDocumento = new JLabel("Nro. documento");
		lblNroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNroDocumento.setBounds(296, 155, 130, 25);
		add(lblNroDocumento);
		
		textFieldFiltrarDocumento = new JTextField();
		textFieldFiltrarDocumento.setColumns(10);
		textFieldFiltrarDocumento.setBounds(466, 155, 200, 25);
		add(textFieldFiltrarDocumento);
		
		tablaVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	if(!tablaVendedor.getSelectionModel().isSelectionEmpty()){
		    		btnEliminarVendedor.setEnabled(true);
		    		btnModificarVendedor.setEnabled(true);
		    	}
		    	
		        }
		});
		
		//this.mostrarResultados(vendedores);
		
		
	}
	
	private void mostrarResultados(List<Vendedor> vendedores){
		
		while (modelo.getRowCount() > 0) {
			 modelo.removeRow(0);
		}
		
//		for(Integer i = 0; i< this.vendedores.size(); i++) {
//			  String[] dato = new String[8];
//			  dato[7]= vendedores.get(i).getId().toString();
//			  dato[0] = vendedores.get(i).getNombre();
//			  dato[1] = vendedores.get(i).getApellido();
//			  dato[2] = vendedores.get(i).getTipoInmueble().name();
//			  dato[3] =  vendedores.get(i).getLocalidad();
//			  dato[4] =  vendedores.get(i).getBarrio();
//			  dato[5] =  vendedores.get(i).getMonto().toString();
//			  this.modelo.addRow(new Object[]{dato[7],dato[0], dato[1],dato[2], dato[3],dato[4], dato[5]});
//			    
//		  }
	}
}
