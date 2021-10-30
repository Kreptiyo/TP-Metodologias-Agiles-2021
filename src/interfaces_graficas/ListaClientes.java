package interfaces_graficas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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


public class ListaClientes  extends JFrame{
	private JFrame frmAbmCliente;
	private JTable tablaClientes;
	private DefaultTableModel modelo;
	private JTextField textFieldFiltrarNombre;
	private JTextField textFieldFiltrarApellido;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaClientes window = new ListaClientes();
					window.frmAbmCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmCliente = new JFrame();
		frmAbmCliente.setTitle("Listar Cliente");
		frmAbmCliente.setBounds(100, 100, 1024, 768);
		frmAbmCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelClientes = new JPanel();
		frmAbmCliente.getContentPane().add(panelClientes, BorderLayout.CENTER);
		panelClientes.setLayout(null);
		
		JPanel panelTablaClientes = new JPanel();
		panelTablaClientes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTablaClientes.setBounds(114, 275, 800, 277);
		panelClientes.add(panelTablaClientes);
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
		gbc_scrollPanelTablaClientes.gridheight = 7;
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
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Tipo Inmueble");
		modelo.addColumn("Localidad");
		modelo.addColumn("Barrio");
		modelo.addColumn("Monto");
		tablaClientes.setModel(modelo);
		this.modelo.addRow(new Object[]{"AA","AA","AA","AA","AA","AA"});
		this.modelo.addRow(new Object[]{"BB","BB","BB","BB","BB","BB"});
		this.modelo.addRow(new Object[]{"CC","CC","CC","CC","CC","CC"});
		scrollPanelTablaClientes.setViewportView(tablaClientes);
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarCliente.setBounds(440, 600, 140, 30);
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.addActionListener(e->{	
					ModificarCliente mc = new ModificarCliente();
			  		mc.setVisible(true);
			  		
		});
		panelClientes.add(btnModificarCliente);
		
		JButton btnAñadirCliente = new JButton("A\u00F1adir");
		btnAñadirCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadirCliente.setBounds(114, 600, 140, 30);
		btnAñadirCliente.addActionListener(e-> {
			
			AltaCliente ac = new AltaCliente();
			ac.setVisible(true);
		
		});
		panelClientes.add(btnAñadirCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarCliente.setBounds(774, 600, 140, 30);
		btnEliminarCliente.setEnabled(false);
		panelClientes.add(btnEliminarCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCliente.setBounds(296, 74, 130, 25);
		panelClientes.add(lblNombreCliente);
		
		JLabel lblApellidoCliente = new JLabel("Apellido");
		lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidoCliente.setBounds(296, 114, 130, 25);
		panelClientes.add(lblApellidoCliente);
		
		textFieldFiltrarNombre = new JTextField();
		textFieldFiltrarNombre.setColumns(10);
		textFieldFiltrarNombre.setBounds(466, 76, 200, 25);
		panelClientes.add(textFieldFiltrarNombre);
		
		textFieldFiltrarApellido = new JTextField();
		textFieldFiltrarApellido.setColumns(10);
		textFieldFiltrarApellido.setBounds(466, 114, 200, 25);
		panelClientes.add(textFieldFiltrarApellido);
		
		JButton btnFlitrarCliente = new JButton("Filtrar");
		btnFlitrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFlitrarCliente.setBounds(501, 161, 140, 30);
		panelClientes.add(btnFlitrarCliente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(774, 675, 140, 30);
		panelClientes.add(btnVolver);
		
		tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	if(!tablaClientes.getSelectionModel().isSelectionEmpty()){
		    		btnEliminarCliente.setEnabled(true);
		    		btnModificarCliente.setEnabled(true);
		    	}
		    	
		        }
		});
		
		
		
		
	}

}
