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

import dominio.Cliente;
import gestores.Gestor_Cliente;

public class Lista_Cliente extends JPanel {

	private JTable tablaClientes;
	private DefaultTableModel modelo;
	private JTextField textFieldFiltrarNombre;
	private JTextField textFieldFiltrarApellido;
	private List<Cliente> clientes;
	private Gestor_Cliente gestorClientes;
	
	public Lista_Cliente(JFrame pantallaPrincipal) {
		armarPanel(pantallaPrincipal);
	}

	
	public void armarPanel(JFrame pantallaPrincipal) {
		
		gestorClientes = new Gestor_Cliente();
		clientes = gestorClientes.listarTodos();
		
		
		setLayout(null);
		JPanel panelTablaClientes = new JPanel();
		panelTablaClientes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTablaClientes.setBounds(114, 275, 796, 289);
		add(panelTablaClientes);
		GridBagLayout gbl_panelTablaClientes = new GridBagLayout();
		gbl_panelTablaClientes.columnWidths = new int[]{0, 0};
		gbl_panelTablaClientes.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelTablaClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTablaClientes.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTablaClientes.setLayout(gbl_panelTablaClientes);
		
		JScrollPane scrollPanelTablaClientes = new JScrollPane();
		GridBagConstraints gbc_scrollPanelTablaClientes = new GridBagConstraints();
		gbc_scrollPanelTablaClientes.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPanelTablaClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPanelTablaClientes.gridx = 0;
		gbc_scrollPanelTablaClientes.gridy = 0;
		panelTablaClientes.add(scrollPanelTablaClientes, gbc_scrollPanelTablaClientes);
		
		tablaClientes = new JTable();
		
		
		this.modelo = new DefaultTableModel()
		{
		public boolean isCellEditable(int row, int column)
		       {
		         return false;//This causes all cells to be not editable
		       }
		};    
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Tipo Inmueble");
		modelo.addColumn("Localidad");
		modelo.addColumn("Barrio");
		modelo.addColumn("Monto");
		
		
		tablaClientes.setModel(modelo);
		tablaClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPanelTablaClientes.setViewportView(tablaClientes);
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarCliente.setBounds(440, 600, 140, 30);
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.addActionListener(e->{	
				
			
			String nombre = (String) modelo.getValueAt(tablaClientes.getSelectedRow(), 1);
			String apellido = (String) modelo.getValueAt(tablaClientes.getSelectedRow(), 2);
			String id = (String) modelo.getValueAt(tablaClientes.getSelectedRow(), 0);
			
			  		this.setVisible(false);
					JPanel panelModificarClientes = new Modificar_Cliente(pantallaPrincipal, nombre, apellido, id);
					panelModificarClientes.setVisible(true);
					pantallaPrincipal.setContentPane(panelModificarClientes);
					pantallaPrincipal.setTitle("Modificar Clientes");
			  		
		});
		add(btnModificarCliente);
		
		JButton btnAñadirCliente = new JButton("A\u00F1adir");
		btnAñadirCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadirCliente.setBounds(114, 600, 140, 30);
		btnAñadirCliente.addActionListener(e-> {
			
			
			this.setVisible(false);
			JPanel panelAltaClientes = new AltaCliente(pantallaPrincipal);
			panelAltaClientes.setVisible(true);
			pantallaPrincipal.setContentPane(panelAltaClientes);
			pantallaPrincipal.setTitle("Alta Clientes");
		
		});
		add(btnAñadirCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarCliente.setBounds(774, 600, 140, 30);
		btnEliminarCliente.setEnabled(false);
		btnEliminarCliente.addActionListener(e-> {
			
			String id = (String) modelo.getValueAt(tablaClientes.getSelectedRow(), 0);			
			this.gestorClientes.eliminarCliente(Integer.parseInt(id));
			clientes = gestorClientes.listarTodos();
			this.mostrarResultados(clientes);
		});
		add(btnEliminarCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCliente.setBounds(296, 74, 130, 25);
		add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("Apellido");
		lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidoCliente.setBounds(296, 114, 130, 25);
		add(lblApellidoCliente);
		
		textFieldFiltrarNombre = new JTextField();
		textFieldFiltrarNombre.setColumns(10);
		textFieldFiltrarNombre.setBounds(466, 76, 200, 25);
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
		textFieldFiltrarApellido.setBounds(466, 114, 200, 25);
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
		
		JButton btnFlitrarCliente = new JButton("Filtrar");
		btnFlitrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFlitrarCliente.setBounds(501, 161, 140, 30);
		btnFlitrarCliente.addActionListener(e-> {
              
              		
  			while (modelo.getRowCount() > 0) {
  				 modelo.removeRow(0);
  			}

              if(textFieldFiltrarNombre.getText().isEmpty() && textFieldFiltrarApellido.getText().isEmpty()) {
            	  JOptionPane.showMessageDialog(null, "Debe ingresar al menos un filtro");
            	  mostrarResultados(gestorClientes.listarTodos());
              }else {
            	  
                  mostrarResultados(gestorClientes.buscarPorNombreApellido(textFieldFiltrarNombre.getText(), textFieldFiltrarApellido.getText()));
              }

          }


      );
		add(btnFlitrarCliente);
		
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
		
		tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	if(!tablaClientes.getSelectionModel().isSelectionEmpty()){
		    		btnEliminarCliente.setEnabled(true);
		    		btnModificarCliente.setEnabled(true);
		    	}
		    	
		        }
		});
		
		this.mostrarResultados(clientes);
		
		
	}
	
	private void mostrarResultados(List<Cliente> clientes){
		
		while (modelo.getRowCount() > 0) {
			 modelo.removeRow(0);
		}
		
		for(Integer i = 0; i< this.clientes.size(); i++) {
			  String[] dato = new String[8];
			  dato[7]= clientes.get(i).getId().toString();
			  dato[0] = clientes.get(i).getNombre();
			  dato[1] = clientes.get(i).getApellido();
			  dato[2] = clientes.get(i).getTipoInmueble().name();
			  dato[3] =  clientes.get(i).getLocalidad();
			  dato[4] =  clientes.get(i).getBarrio();
			  dato[5] =  clientes.get(i).getMonto().toString();
			  this.modelo.addRow(new Object[]{dato[7],dato[0], dato[1],dato[2], dato[3],dato[4], dato[5]});
			    
		  }
	}
	
	
}
