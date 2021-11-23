package interfaces_graficas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import dominio.Inmueble;
import dominio.Inmueble.Orientacion;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Inmueble;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Alta_Modificacion_Inmueble_Pagina_1 extends JPanel {
	
	private JTextField txtLocalidad;
	private JTextField txtCalle;
	private JTextField txtNumeroCalle;
	private JTextField txtPisoDepartamento;
	private JLabel lblDatosUbicacion;
	private JSeparator separator;
	private JLabel lblProvincia;
	private JComboBox cbxProvincia;
	private JLabel lblLocalidad;
	private JComboBox cbxLocalidad;
	private JCheckBox chkOtra;
	private JLabel lblCalle;
	private JComboBox cbxCalle;
	private JLabel lblIngreseLocalidad;
	private JCheckBox chkOtraCalle;
	private JLabel lblNumeroCalle;
	private JButton btnUbicacion;
	private JLabel lblUbicacion;
	private JLabel lblBarrio;
	private JComboBox cbxBarrio;
	private JCheckBox chkDepartamento;
	private JLabel lblPisoDepartamento;
	private JButton btnSiguiente;
	private JButton btnCancelar;	
	private Inmueble inmueble;
	
	
	/*Recibe el panel siguinte para poder moverse entre interfaces con la posibilidad de volver al anterior*/
	
	private Gestor_Inmueble gestorInmueble;
	/**
	 * @wbp.parser.constructor
	 */
	public Alta_Modificacion_Inmueble_Pagina_1(JFrame pantallaPrincipal, String nroDocumento, Integer idInmueble) {
		this.gestorInmueble = new Gestor_Inmueble();
		inmueble = new Inmueble();
		this.armarPanel(pantallaPrincipal, nroDocumento, idInmueble);
		if(idInmueble!=-1) {
			inmueble = gestorInmueble.buscarPorId(idInmueble);
			this.setearDatos(inmueble.getProvincia(), inmueble.getLocalidad(),  inmueble.getCalle(),  inmueble.getCalleNumero(),  inmueble.getPisoDepartamento(), inmueble.getBarrio());
		}
		
	}
	
	/*public Alta_Modificacion_Inmueble_Pagina_1(JFrame pantallaPrincipal, Integer nroDocumento, String provincia, String localidad, String calle, Integer numeroCalle, Integer numDepartamento,
		String barrio, 	String tipoInmueble, Integer precio, String orientacion, Integer metrosFrente, Integer metrosFondo, Integer superficie, Integer antiguedad,	
		boolean propHorizontal, Integer superficieEdificio, Integer cantDormitorios, Integer cantBaños, boolean garage, boolean patio, boolean piscina, boolean aguaCaliente, boolean aguaCorriente, boolean cloacas,
		boolean gasNatural, boolean telefono, boolean lavadero, boolean pavimento, String descripcion) {
		this.gestorInmueble = new Gestor_Inmueble();
		this.armarPanel(pantallaPrincipal, nroDocumento);
		this.setearDatos(provincia, localidad,  calle,  numeroCalle,  numDepartamento, barrio);
	}*/
	

	public void armarPanel(JFrame pantallaPrincipal, String nroDocumento, Integer idInmueble) {
		setForeground(Color.GRAY);
		setLayout(null);
		
		lblDatosUbicacion = new JLabel("Datos de ubicaci\u00F3n");
		lblDatosUbicacion.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosUbicacion.setBounds(10, 40, 190, 20);
		add(lblDatosUbicacion);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(210, 55, 804, 20);
		add(separator);
		
		lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(115, 100, 100, 25);
		add(lblProvincia);
		
		cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(225, 105, 150, 22);
		cbxProvincia.addItem("SELECCIONAR");
		cbxProvincia.addItem("SANTA FE");
		
		add(cbxProvincia);
		
		lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(412, 100, 100, 25);
		add(lblLocalidad);
		
		cbxLocalidad = new JComboBox();
		cbxLocalidad.setBounds(522, 105, 150, 22);
		cbxLocalidad.addItem("SELECCIONAR");
		cbxLocalidad.addItem("SANTA FE");
		add(cbxLocalidad);
		
		chkOtra = new JCheckBox("Otra");
		chkOtra.addActionListener(e-> {
			
			if(chkOtra.isSelected()) {
				txtLocalidad.setEditable(true);
				cbxLocalidad.setEnabled(false);
				cbxLocalidad.setSelectedIndex(0);
			}
			else {
				txtLocalidad.setEditable(false);
				txtLocalidad.setText("");
				cbxLocalidad.setEnabled(true);
				cbxLocalidad.setSelectedIndex(0);
			}
			
		
		});
		chkOtra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkOtra.setBounds(697, 105, 65, 22);
		
		add(chkOtra);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(768, 104, 150, 25);
		txtLocalidad.setEditable(false);
		txtLocalidad.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtLocalidad.getText().length()>29) 
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
		add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		lblCalle = new JLabel("Calle: ");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalle.setBounds(115, 168, 100, 25);
		add(lblCalle);
		
		cbxCalle = new JComboBox();
		cbxCalle.setBounds(225, 168, 150, 22);
		cbxCalle.addItem("SELECCIONAR");
		cbxCalle.addItem("ANGEL CASANELLO");
		add(cbxCalle);
		
		lblIngreseLocalidad = new JLabel("Ingrese una localidad");
		lblIngreseLocalidad.setBounds(768, 86, 159, 14);
		add(lblIngreseLocalidad);
		
		chkOtraCalle = new JCheckBox("Otra");
		chkOtraCalle.addActionListener(e ->{
			
			if(chkOtraCalle.isSelected()) {
				txtCalle.setEditable(true);
				cbxCalle.setEnabled(false);
				cbxCalle.setSelectedIndex(0);
			}
			else {
				txtCalle.setEditable(false);
				txtCalle.setText("");
				cbxCalle.setEnabled(true);
				cbxCalle.setSelectedIndex(0);
			}
			
		});
		chkOtraCalle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkOtraCalle.setBounds(413, 168, 65, 22);
		add(chkOtraCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(522, 168, 150, 25);
		txtCalle.setEditable(false);
		txtCalle.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtCalle.getText().length()>29) 
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
		add(txtCalle);
		
		lblNumeroCalle = new JLabel("N\u00FAmero:");
		lblNumeroCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroCalle.setBounds(697, 168, 100, 25);
		add(lblNumeroCalle);
		
		txtNumeroCalle = new JTextField();
		txtNumeroCalle.setColumns(10);
		txtNumeroCalle.setBounds(826, 168, 93, 25);
		txtNumeroCalle.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtNumeroCalle.getText().length()>3) 
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
		add(txtNumeroCalle);
		
		btnUbicacion = new JButton("Ubicaci\u00F3n");
		btnUbicacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUbicacion.setBounds(697, 214, 221, 40);
		add(btnUbicacion);
		
		lblUbicacion = new JLabel("(Presione si desea ingresar una)");
		lblUbicacion.setBounds(707, 265, 221, 14);
		add(lblUbicacion);
		
		lblBarrio = new JLabel("Barrio: ");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarrio.setBounds(115, 229, 100, 25);
		add(lblBarrio);
		
		cbxBarrio = new JComboBox();
		cbxBarrio.setBounds(225, 232, 150, 22);
		cbxBarrio.addItem("SELECCIONAR");
		cbxBarrio.addItem("UN BARRIO");
		add(cbxBarrio);
		
		chkDepartamento = new JCheckBox("Departamento");
		chkDepartamento.addActionListener(e-> {
			
			if(chkDepartamento.isSelected()) {
				txtPisoDepartamento.setEditable(true);
			}
			else {
				txtPisoDepartamento.setEditable(false);
				txtPisoDepartamento.setText("");
			}
		
		});
		chkDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkDepartamento.setBounds(115, 299, 119, 22);
		add(chkDepartamento);
		
		lblPisoDepartamento = new JLabel("Piso/Departamento:");
		lblPisoDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPisoDepartamento.setBounds(115, 338, 180, 25);
		add(lblPisoDepartamento);
		
		txtPisoDepartamento = new JTextField();
		txtPisoDepartamento.setColumns(10);
		txtPisoDepartamento.setBounds(305, 338, 70, 25);
		txtPisoDepartamento.setEditable(false);
		txtPisoDepartamento.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtPisoDepartamento.getText().length()>2) 
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
		add(txtPisoDepartamento);
		
		btnSiguiente = new JButton("Siguiente pagina");
		btnSiguiente.addActionListener(e->{
			
			try {
				
				String provincia = this.cbxProvincia.getSelectedItem().toString();
				
				String localidad;
				
				if(chkOtra.isSelected()) {
					localidad = txtLocalidad.getText();	
				}
				else {
					localidad = cbxLocalidad.getSelectedItem().toString();
				}
				
				String calle;
				if(chkOtraCalle.isSelected()) {
					calle = txtCalle.getText();
				}
				else {
					calle = cbxCalle.getSelectedItem().toString();
				}
				
				Integer numCalle;
				if(txtNumeroCalle.getText().isEmpty()) {
					numCalle = null;
				}
				else {
					numCalle = Integer.parseInt(this.txtNumeroCalle.getText().toString());
				}
				
				
				String barrio = cbxBarrio.getSelectedItem().toString();
				
				Integer numDepto;
				if(chkDepartamento.isSelected()) {
					
					if(txtPisoDepartamento.getText().isEmpty()){
						numDepto = null;
					}
					else {
						numDepto = Integer.parseInt(this.txtPisoDepartamento.getText().toString());
					}
				}
				
				else {
					numDepto = -1;
				}
				gestorInmueble.actualizarModelo_Propietario(nroDocumento);
				if(idInmueble!=-1) {
					gestorInmueble.actualizarModelo_IdInmueble(idInmueble);
				}
				gestorInmueble.validar_Datos_Ubicacion(provincia, localidad, calle, numCalle, barrio,numDepto);
				gestorInmueble.actualizarModelo_Ubicacion(provincia, localidad, calle, numCalle, barrio, numDepto);
				this.setVisible(false);
				Alta_Modificacion_Inmueble_Pagina_2 panelSiguiente = new Alta_Modificacion_Inmueble_Pagina_2(pantallaPrincipal, gestorInmueble, idInmueble);
				pantallaPrincipal.setContentPane(panelSiguiente);
				
				
			} catch (Datos_Invalidos_Exception e2) {
				e2.printStackTrace();
				this.mostrarMensajeError(pantallaPrincipal,"Error al ingresar datos",e2.getMessage());
			}
		});

		btnSiguiente.setForeground(Color.BLACK);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBounds(748, 415, 170, 25);
		add(btnSiguiente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e-> {
			this.setVisible(false);
			Interfaz_Gestionar_Inmueble cancelar = new Interfaz_Gestionar_Inmueble(pantallaPrincipal);
			pantallaPrincipal.setContentPane(cancelar);
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		JLabel lblIngreseUnaCalle = new JLabel("Ingrese una calle");
		lblIngreseUnaCalle.setBounds(522, 149, 159, 14);
		add(lblIngreseUnaCalle);

	}
	
	public void setearDatos(String provincia, String localidad, String calle, Integer numeroCalle, Integer numDepartamento,String barrio) 
	{
		this.cbxProvincia.setSelectedItem(provincia);
		
		boolean otraLocalidad = false;
		for(int i=0; i<cbxLocalidad.getItemCount(); i++) {
			
			if(cbxLocalidad.getItemAt(i).equals(localidad)) {
				otraLocalidad = true;
			}
			
		}
		
		if(otraLocalidad=true) {
			this.chkOtra.setSelected(true);
			txtLocalidad.setText(localidad);
		}
		else {
			cbxLocalidad.setSelectedItem(localidad);
		}
		
		
		boolean otraCalle = false;
		for(int i=0; i<cbxCalle.getItemCount(); i++) {
			
			if(cbxCalle.getItemAt(i).equals(localidad)) {
				otraCalle = true;
			}
			
		}
		
		if(otraCalle=true) {
			this.chkOtraCalle.setSelected(true);
			txtCalle.setText(calle);
		}
		else {
			cbxCalle.setSelectedItem(localidad);
		}
		
		this.txtNumeroCalle.setText(numeroCalle.toString());
		this.cbxBarrio.setSelectedItem(barrio);
		
		if(numDepartamento!=-1) {
			this.chkDepartamento.setSelected(true);
			this.txtPisoDepartamento.setText(numDepartamento.toString());
		}
		
	}
	
	private void mostrarMensajeError(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
}
