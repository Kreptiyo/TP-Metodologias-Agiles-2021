package interfaces_graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dominio.Inmueble;
import dominio.Propietario;
import gestores.Gestor_Inmueble;
import gestores.Gestor_Propietario;
import modelos_tablas.Modelo_Tabla_Inmuebles_Cliente;
import dominio.Propietario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Gestionar_Inmueble extends JPanel {

	private JTextField txtNumDocumento;
	private JTable table;
	private JLabel lblFiltroDeBusqueda;
	private JSeparator separator;
	private JLabel lblNumDocumento;
	private JButton btnBuscar;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnVolver;
	private Modelo_Tabla_Inmuebles_Cliente modeloTabla;
	private List<Inmueble> listaInmuebles;
	private JLabel lblInmueblesDelPropietario;
	private Propietario propietario;
	private Gestor_Propietario gestorPropietario;
	private JTextField txtPropietario;
	private JLabel lblPropietario;
	private Gestor_Inmueble gestorInmueble;
	

	public Interfaz_Gestionar_Inmueble(JFrame pantallaPrincipal) {
		gestorPropietario = new Gestor_Propietario();
		gestorInmueble = new Gestor_Inmueble();
		listaInmuebles = new ArrayList<Inmueble>();
		propietario = new Propietario();
		this.armarPanel(pantallaPrincipal);
	}
	
	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		lblFiltroDeBusqueda = new JLabel("Filtro de busqueda");
		lblFiltroDeBusqueda.setForeground(Color.BLACK);
		lblFiltroDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFiltroDeBusqueda.setBounds(10, 40, 196, 25);
		add(lblFiltroDeBusqueda);
		
		separator = new JSeparator();
		separator.setBounds(216, 53, 798, 20);
		add(separator);
		
		lblNumDocumento = new JLabel("N\u00FAmero de documento:");
		lblNumDocumento.setForeground(Color.BLACK);
		lblNumDocumento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumDocumento.setBounds(20, 111, 215, 25);
		add(lblNumDocumento);
		
		txtNumDocumento = new JTextField();
		txtNumDocumento.setColumns(10);
		txtNumDocumento.setBounds(245, 111, 200, 25);
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
		add(txtNumDocumento);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(e-> {
			if(!this.txtNumDocumento.getText().isEmpty()) {
				propietario = gestorPropietario.buscarPorNroDocumento(Integer.parseInt(txtNumDocumento.getText().toString()));
				if(propietario.getId()!=null){
					txtPropietario.setText(this.propietario.getNombre() + " " + propietario.getApellido());
					this.listaInmuebles.clear();
					this.listaInmuebles.addAll(gestorInmueble.buscarTodos(propietario.getNrodocumento()));
					if(!this.listaInmuebles.isEmpty())
					{
						this.modeloTabla.fireTableDataChanged();
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuscar.setBounds(465, 110, 185, 30);
		add(btnBuscar);
		
		
		modeloTabla = new Modelo_Tabla_Inmuebles_Cliente(listaInmuebles);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setFillsViewportHeight(true);
		table.setModel(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 276, 1004, 298);
		TableRowSorter<TableModel> orden =  new TableRowSorter<TableModel>(modeloTabla);
		table.setRowSorter(orden);
		add(scrollPane);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.addActionListener(e-> {
			
			if(propietario.getId()!=null) {
				this.setVisible(false);
				JPanel panelAltaInmueble = new Alta_Modificacion_Inmueble_Pagina_1(pantallaPrincipal, propietario.getNrodocumento(),-1);
				pantallaPrincipal.setContentPane(panelAltaInmueble);
			}
			else {
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun propietario.", "Debe buscar un propietario previo a añadir un inmueble.");
			}
			
		});
		btnAñadir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAñadir.setBounds(679, 585, 105, 40);
		add(btnAñadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBounds(909, 585, 105, 40);
		btnEliminar.addActionListener(e ->{
			if(table.getSelectedRow() != -1) 
			{
				int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el inmuueble del sistema?");
				if(resp==JOptionPane.YES_OPTION)
				{
					Integer id_Inmueble = modeloTabla.obtenerIdInmueble(table.getSelectedRow());
					gestorInmueble.eliminarInmueble(id_Inmueble);
					this.mostrarMensajeExito(pantallaPrincipal, "Eliminar inmueble", "Se elimino el inmueble correctamente");
					this.listaInmuebles.clear();
					this.listaInmuebles.addAll(gestorInmueble.buscarTodos(propietario.getNrodocumento()));
					this.modeloTabla.fireTableDataChanged();
				}
			}
			else 
			{
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun inmueble.", "Debe seleccionar un inmueble"+"\n"+"para eliminarlo.");
			}
	});
		add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(794, 585, 105, 40);
		btnModificar.addActionListener(e ->{
			if(table.getSelectedRow() != -1) 
			{
				this.setVisible(false);
				
				Inmueble i = gestorInmueble.buscarPorId(modeloTabla.obtenerIdInmueble(table.getSelectedRow()));
				JPanel panelAltaInmueble = new Alta_Modificacion_Inmueble_Pagina_1(pantallaPrincipal,propietario.getNrodocumento() , i.getId());
				
				pantallaPrincipal.setContentPane(panelAltaInmueble);
			}
			else 
			{
				this.mostrarMensajeAdvertencia(pantallaPrincipal, "No seleccionó ningun inmueble.", "Debe seleccionar un inmueble"+"\n"+"para modificarlo.");
			}
	});
		add(btnModificar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBounds(914, 717, 100, 40);
		add(btnVolver);
		
		lblInmueblesDelPropietario = new JLabel("Inmuebles asociados al propietario:");
		lblInmueblesDelPropietario.setForeground(Color.BLACK);
		lblInmueblesDelPropietario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInmueblesDelPropietario.setBounds(10, 240, 398, 25);
		add(lblInmueblesDelPropietario);
		
		lblPropietario = new JLabel("Propietario:");
		lblPropietario.setForeground(Color.BLACK);
		lblPropietario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPropietario.setBounds(20, 165, 215, 25);
		add(lblPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setColumns(10);
		txtPropietario.setBounds(245, 165, 200, 25);
		txtPropietario.setEditable(false);
		add(txtPropietario);

	}
	
	
	public void mostrarMensajeExito(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeAdvertencia(JFrame padre ,String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.WARNING_MESSAGE);
	}
}
