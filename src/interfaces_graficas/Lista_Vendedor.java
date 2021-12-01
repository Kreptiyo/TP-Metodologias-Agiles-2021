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
import gestores.Gestor_Vendedor;


public class Lista_Vendedor extends JPanel {

	private JTable tablaVendedor;
	private DefaultTableModel modelo;
	private JTextField textFieldFiltrarNombre;
	private JTextField textFieldFiltrarApellido;
	private List<Vendedor> vendedores;
	private Gestor_Vendedor gestorVendedores;
	private JTextField textFieldFiltrarDocumento;
	
	public Lista_Vendedor(JFrame pantallaPrincipal) {
		armarPanel(pantallaPrincipal);
	}

	
	public void armarPanel(JFrame pantallaPrincipal) {
		
		gestorVendedores = new Gestor_Vendedor();
		vendedores = gestorVendedores.listarTodos();
		
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
				
			
			String nombre = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 0);
			String apellido = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 1);
			String dni = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 3);
			
			  		this.setVisible(false);
					JPanel panelModificarvendedores = new Modificar_Vendedor(pantallaPrincipal, nombre, apellido, dni);
					panelModificarvendedores.setVisible(true);
					pantallaPrincipal.setContentPane(panelModificarvendedores);
					pantallaPrincipal.setTitle("Modificar vendedores");
			  		
		});
		add(btnModificarVendedor);
		
		JButton btnA�adirVendedor = new JButton("A\u00F1adir");
		btnA�adirVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnA�adirVendedor.setBounds(114, 600, 140, 30);
		btnA�adirVendedor.addActionListener(e-> {
			
			
			this.setVisible(false);
			JPanel panelAltavendedores = new Alta_Vendedor(pantallaPrincipal);
			panelAltavendedores.setVisible(true);
			pantallaPrincipal.setContentPane(panelAltavendedores);
			pantallaPrincipal.setTitle("Alta vendedores");
		
		});
		add(btnA�adirVendedor);
		
		JButton btnEliminarVendedor = new JButton("Eliminar");
		btnEliminarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarVendedor.setBounds(774, 600, 140, 30);
		btnEliminarVendedor.setEnabled(false);
		btnEliminarVendedor.addActionListener(e-> {
			
			String dni = (String) modelo.getValueAt(tablaVendedor.getSelectedRow(), 3);			
			this.gestorVendedores.eliminarVendedor(dni);
			 vendedores = gestorVendedores.listarTodos();
			 this.mostrarResultados(vendedores);
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
		btnFlitrarVendedor.addActionListener(e-> {
              
              		
  			while (modelo.getRowCount() > 0) {
  				 modelo.removeRow(0);
  			}

              if(textFieldFiltrarNombre.getText().isEmpty() && textFieldFiltrarApellido.getText().isEmpty() && textFieldFiltrarDocumento.getText().isEmpty()) {
            	  JOptionPane.showMessageDialog(null, "Debe ingresar al menos un filtro");
            	  mostrarResultados(gestorVendedores.listarTodos());
              }else {           	  
                  mostrarResultados(gestorVendedores.buscarPorNombreApellidoDNI(textFieldFiltrarNombre.getText(), textFieldFiltrarApellido.getText(),textFieldFiltrarDocumento.getText() ));
              }

          }


      );
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
		
		this.mostrarResultados(vendedores);
		
		
	}
	
	private void mostrarResultados(List<Vendedor> vendedores){
		
		while (modelo.getRowCount() > 0) {
			 modelo.removeRow(0);
		}
		
			
		for(Integer i = 0; i< this.vendedores.size(); i++) {
			  String[] dato = new String[7];
			  dato[0] = vendedores.get(i).getNombre();
			  dato[1] = vendedores.get(i).getApellido();
			  dato[2] = vendedores.get(i).getTipodocumento().name();
			  dato[3] =  vendedores.get(i).getNrodocumento();
			  dato[4] =  vendedores.get(i).getLocalidad();
			  dato[5] =  vendedores.get(i).getProvincia();
			  dato[6] =  vendedores.get(i).getFechaNacimiento();
			  this.modelo.addRow(new Object[]{dato[0], dato[1],dato[2], dato[3],dato[4], dato[5],dato[6]});
			    
		  }
	}
}
