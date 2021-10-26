package interfaces_graficas;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dominio.Propietario;
import gestores.Gestor_Propietario;
import modelos_tablas.Modelo_Tabla_Listar_Propietarios;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;

public class Interfaz_Grafica_Listar_Propietarios extends JPanel {
	private JTextField txtNumDocumento;
	private JTextField txtApellido;
	private JTable table;
	private JLabel lblFiltroDeBusqueda;
	private JSeparator separator;
	private JLabel lblTipoDni;
	private JLabel lblNumDocumento;
	private JComboBox cbxTipoDocumento;
	private JLabel lblApellido;
	private JButton btnFiltrar;
	private JButton btnVolver;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAñadirInmueble;
	
	/*modelo tabla es un modelo de tabla personalizado cuyas columnas son los datos del propietario*/
	
	private Modelo_Tabla_Listar_Propietarios modeloTabla;
	private Gestor_Propietario gestorPropietario;
	
	public Interfaz_Grafica_Listar_Propietarios(JFrame pantallaPrincipal) {
		super();
		this.gestorPropietario = new Gestor_Propietario();
		this.armarPanel(pantallaPrincipal);
	}
	
	/*funcion para armar todo el panel con los componentes*/
	private void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		lblFiltroDeBusqueda = new JLabel("Filtro de busqueda");
		lblFiltroDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiltroDeBusqueda.setForeground(new Color(0, 0, 0));
		lblFiltroDeBusqueda.setBounds(10, 45, 196, 25);
		add(lblFiltroDeBusqueda);
		
		separator = new JSeparator();
		separator.setBounds(207, 59, 807, 20);
		add(separator);
		
		lblTipoDni = new JLabel("Tipo de documento: ");
		lblTipoDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDni.setBounds(111, 90, 185, 25);
		add(lblTipoDni);
		
		txtNumDocumento = new JTextField();
		txtNumDocumento.setBounds(763, 94, 150, 25);
		add(txtNumDocumento);
		txtNumDocumento.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtNumDocumento.getText().length()>9) 
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
		txtNumDocumento.setColumns(10);
		
		lblNumDocumento = new JLabel("N\u00FAmero de documento:");
		lblNumDocumento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumDocumento.setForeground(new Color(0, 0, 0));
		lblNumDocumento.setBounds(538, 94, 215, 25);
		add(lblNumDocumento);
		
		cbxTipoDocumento = new JComboBox();
		cbxTipoDocumento.setBounds(306, 94, 150, 25);
		add(cbxTipoDocumento);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellido.setBounds(111, 154, 185, 25);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(306, 154, 150, 25);
		txtApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtApellido.getText().length()>29) 
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
		add(txtApellido);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFiltrar.setBounds(538, 148, 375, 40);
		add(btnFiltrar);
		
		
		
		modeloTabla = new Modelo_Tabla_Listar_Propietarios(gestorPropietario.listarTodas());
		table = new JTable();
		table.setBounds(10, 245, 899, 445);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 245, 899, 445);
		TableRowSorter<TableModel> orden =  new TableRowSorter<TableModel>(modeloTabla);
		table.setRowSorter(orden);
		add(scrollPane);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(914, 717, 100, 40);
		add(btnVolver);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelAñadirPropietario = new Alta_Propietario(pantallaPrincipal);
			pantallaPrincipal.setContentPane(panelAñadirPropietario);
			pantallaPrincipal.setTitle("DAR DE ALTA NUEVA COMPETENCIA");
		});
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAñadir.setBounds(914, 245, 105, 40);
		add(btnAñadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(914, 296, 105, 40);
		add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(e ->{
			if(table.getSelectedRow() != -1) 
			{
				int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el propietario del sistema?");
				if(resp==JOptionPane.YES_OPTION)
				{
					Integer id_Propietario = modeloTabla.obtenerIdPropietario(table.getSelectedRow());
					gestorPropietario.eliminarPropietario(id_Propietario);
					this.mostrarMensajeExito(pantallaPrincipal, "Eliminar Propietario", "Se elimino el propietario correctamente");
					this.setVisible(false);
					Interfaz_Grafica_Listar_Propietarios recarga = new Interfaz_Grafica_Listar_Propietarios(pantallaPrincipal);
					pantallaPrincipal.setContentPane(recarga);
				}
			}
			else 
			{
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun propietario.", "Debe seleccionar un propietario"+"\n"+"para eliminarlo.");
			}
	});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(914, 438, 105, 40);
		add(btnEliminar);
		
		btnAñadirInmueble = new JButton();
		btnAñadirInmueble.setText("<html><center><p>Añadir<p>Inmueble<p><html>");
		btnAñadirInmueble.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAñadirInmueble.setBounds(914, 347, 105, 80);
		add(btnAñadirInmueble);

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

