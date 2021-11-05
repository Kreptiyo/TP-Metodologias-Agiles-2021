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

import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Inmueble;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Alta_Modificacion_Inmueble_Pagina_2 extends JPanel {

	private JTextField txtPrecio;
	private JTextField txtMetrosFrente;
	private JTextField txtMetrosFondo;
	private JTextField txtSuperficieTerreno;
	private JTextField txtSuperficieEdificio;
	private JTextField txtAntiguedad;
	private JTextField txtDormitorios;
	private JTextField txtBaños;
	private JLabel lblDatosInmueble;
	private JSeparator separator;
	private JLabel lblTipoInmueble;
	private JComboBox cbxTipoInmueble;
	private JLabel lblPrecio;
	private JLabel lblOrientacion;
	private JComboBox cbxOrientacion;
	private JLabel lblMetrosFrente;
	private JLabel lblMetrosFondo;
	private JLabel lblSuperficie;
	private JLabel lblM2;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblDatosEdificio;
	private JCheckBox chkPropiedadHorizontal;
	private JLabel lblSuperficieEdificio;
	private JLabel lblAntiguedad;
	private JLabel lblBaños;
	private JLabel lblDormitorios;
	private JCheckBox chkGarage;
	private JCheckBox chkPiscina;
	private JCheckBox chkPatio;
	private JCheckBox chkAguaCorriente;
	private JCheckBox chkCloacas;
	private JCheckBox chkGasNatural;
	private JCheckBox chkAguaCaliente;
	private JCheckBox chkTelefono;
	private JCheckBox chkLavadero;
	private JCheckBox chkPavimiento;
	private JButton btnCancelar;
	private JButton btnSiguientePagina;
	
	/*CONSTRUCTOR PARA PANTALLA ALTA*/
	public Alta_Modificacion_Inmueble_Pagina_2(JFrame pantallaPrincipal) {
		this.armarPanel(pantallaPrincipal);
	}
	
	
	/*CONSTRUCTOR PARA PANTALLA MODIFICAR*/
	public Alta_Modificacion_Inmueble_Pagina_2(JFrame pantallaPrincipal, String tipoInmueble, Integer precio, String orientacion,
			Integer metrosFrente, Integer metrosFondo, Integer superficie, Integer antiguedad,	boolean propHorizontal,
			Integer superficieEdificio, Integer cantDormitorios, Integer cantBaños, boolean garage, boolean patio, boolean piscina,
			boolean aguaCaliente, boolean aguaCorriente, boolean cloacas,
			boolean gasNatural, boolean telefono, boolean lavadero, boolean pavimento, String descripcion) 
	{
		this.armarPanel(pantallaPrincipal);
		this.setearDatos(tipoInmueble, precio, orientacion, metrosFrente, metrosFondo, superficie, antiguedad,
			 superficieEdificio, cantDormitorios, cantBaños, propHorizontal, garage, patio, piscina,
			 aguaCaliente, aguaCorriente, cloacas, gasNatural, telefono, lavadero, pavimento);
	}
	
	public void armarPanel(JFrame pantallaPrincipal) {
		setLayout(null);
		
		lblDatosInmueble = new JLabel("Datos de Inmueble");
		lblDatosInmueble.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosInmueble.setBounds(10, 40, 190, 20);
		add(lblDatosInmueble);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(210, 54, 804, 20);
		add(separator);
		
		lblTipoInmueble = new JLabel("Tipo de inmueble: ");
		lblTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoInmueble.setBounds(123, 89, 170, 25);
		add(lblTipoInmueble);
		
		cbxTipoInmueble = new JComboBox();
		cbxTipoInmueble.setBounds(303, 94, 150, 22);
		cbxTipoInmueble.addItem("SELECCIONAR");
		cbxTipoInmueble.addItem("L / LOCAL U OFICINA");
		cbxTipoInmueble.addItem("C / CASA");
		cbxTipoInmueble.addItem("D / DEPARTAMENTO");
		cbxTipoInmueble.addItem("T / TERRENO");
		cbxTipoInmueble.addItem("Q / QUINTA");
		cbxTipoInmueble.addItem("G / GALPÓN");
		add(cbxTipoInmueble);
		
		lblPrecio = new JLabel("Precio de venta:  $");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(555, 89, 170, 25);
		add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(735, 93, 150, 25);
		txtPrecio.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtPrecio.getText().length()>9) 
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
		add(txtPrecio);
		
		lblOrientacion = new JLabel("Orientaci\u00F3n:");
		lblOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrientacion.setBounds(123, 154, 170, 25);
		add(lblOrientacion);
		
		cbxOrientacion = new JComboBox();
		cbxOrientacion.setBounds(303, 157, 150, 22);
		cbxOrientacion.addItem("SELECCIONAR");
		cbxOrientacion.addItem("NORTE");
		cbxOrientacion.addItem("SUR");
		cbxOrientacion.addItem("ESTE");
		cbxOrientacion.addItem("OESTE");
		cbxOrientacion.addItem("NORESTE");
		cbxOrientacion.addItem("NOROESTE");
		cbxOrientacion.addItem("SURESTE");
		cbxOrientacion.addItem("SUROESTE");
		add(cbxOrientacion);
		
		lblMetrosFrente = new JLabel("Metros de frente:");
		lblMetrosFrente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMetrosFrente.setBounds(123, 215, 170, 25);
		add(lblMetrosFrente);
		
		txtMetrosFrente = new JTextField();
		txtMetrosFrente.setColumns(10);
		txtMetrosFrente.setBounds(291, 215, 79, 25);
		txtMetrosFrente.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtMetrosFrente.getText().length()>3) 
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
		add(txtMetrosFrente);
		
		lblMetrosFondo = new JLabel("Metros de fondo:");
		lblMetrosFondo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMetrosFondo.setBounds(414, 215, 170, 25);
		add(lblMetrosFondo);
		
		txtMetrosFondo = new JTextField();
		txtMetrosFondo.setColumns(10);
		txtMetrosFondo.setBounds(574, 215, 79, 25);
		txtMetrosFondo.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtMetrosFondo.getText().length()>3) 
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
		add(txtMetrosFondo);
		
		lblSuperficie = new JLabel("Superficie:");
		lblSuperficie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSuperficie.setBounds(705, 215, 97, 25);
		add(lblSuperficie);
		
		txtSuperficieTerreno = new JTextField();
		txtSuperficieTerreno.setColumns(10);
		txtSuperficieTerreno.setBounds(806, 215, 79, 25);
		txtSuperficieTerreno.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtSuperficieTerreno.getText().length()>6) 
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
		add(txtSuperficieTerreno);
		
		lblM2 = new JLabel("[m2]");
		lblM2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblM2.setBounds(735, 244, 34, 16);
		add(lblM2);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(123, 331, 762, 2);
		add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(123, 599, 762, 20);
		add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(123, 331, 1, 2);
		add(separator_3);
		
		lblDatosEdificio = new JLabel("Datos del Edificio");
		lblDatosEdificio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosEdificio.setBounds(432, 300, 180, 20);
		add(lblDatosEdificio);
		
		chkPropiedadHorizontal = new JCheckBox("Propiedad Horizonal");
		chkPropiedadHorizontal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPropiedadHorizontal.setBounds(123, 350, 170, 22);
		add(chkPropiedadHorizontal);
		
		lblSuperficieEdificio = new JLabel("Superficie:");
		lblSuperficieEdificio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuperficieEdificio.setBounds(435, 347, 97, 25);
		add(lblSuperficieEdificio);
		
		txtSuperficieEdificio = new JTextField();
		txtSuperficieEdificio.setColumns(10);
		txtSuperficieEdificio.setBounds(505, 349, 79, 25);
		txtSuperficieEdificio.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtSuperficieEdificio.getText().length()>6) 
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
		add(txtSuperficieEdificio);
		
		lblAntiguedad = new JLabel("Antiguedad:");
		lblAntiguedad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAntiguedad.setBounds(705, 349, 97, 25);
		add(lblAntiguedad);
		
		txtAntiguedad = new JTextField();
		txtAntiguedad.setColumns(10);
		txtAntiguedad.setBounds(806, 351, 79, 25);
		txtAntiguedad.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtAntiguedad.getText().length()>3) 
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
		add(txtAntiguedad);
		
		lblDormitorios = new JLabel("Dormitorios:");
		lblDormitorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDormitorios.setBounds(126, 402, 97, 25);
		add(lblDormitorios);
		
		txtDormitorios = new JTextField();
		txtDormitorios.setColumns(10);
		txtDormitorios.setBounds(214, 404, 79, 25);
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
		
		lblBaños = new JLabel("Ba\u00F1os:");
		lblBaños.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBaños.setBounds(435, 400, 97, 25);
		add(lblBaños);
		
		txtBaños = new JTextField();
		txtBaños.setColumns(10);
		txtBaños.setBounds(505, 402, 79, 25);
		txtBaños.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtBaños.getText().length()>2) 
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
		add(txtBaños);
		
		chkGarage = new JCheckBox("Garaje/Cochera");
		chkGarage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkGarage.setBounds(123, 450, 170, 22);
		add(chkGarage);
		
		chkPatio = new JCheckBox("Patio");
		chkPatio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPatio.setBounds(432, 450, 170, 22);
		add(chkPatio);
		
		chkPiscina = new JCheckBox("Piscina");
		chkPiscina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPiscina.setBounds(705, 450, 170, 22);
		add(chkPiscina);
		
		chkAguaCorriente = new JCheckBox("Agua Corriente");
		chkAguaCorriente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkAguaCorriente.setBounds(123, 487, 170, 22);
		add(chkAguaCorriente);
		
		chkCloacas = new JCheckBox("Cloacas");
		chkCloacas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkCloacas.setBounds(432, 487, 170, 22);
		add(chkCloacas);
		
		chkGasNatural = new JCheckBox("Gas Natural");
		chkGasNatural.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkGasNatural.setBounds(705, 489, 170, 22);
		add(chkGasNatural);
		
		chkAguaCaliente = new JCheckBox("Agua Caliente");
		chkAguaCaliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkAguaCaliente.setBounds(123, 524, 170, 22);
		add(chkAguaCaliente);
		
		chkTelefono = new JCheckBox("Tel\u00E9fono");
		chkTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkTelefono.setBounds(432, 524, 170, 22);
		add(chkTelefono);	
		
		chkLavadero = new JCheckBox("Lavadero");
		chkLavadero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkLavadero.setBounds(705, 524, 170, 22);
		add(chkLavadero);
		
		chkPavimiento = new JCheckBox("Pavimento");
		chkPavimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPavimiento.setBounds(123, 561, 170, 22);
		add(chkPavimiento);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		btnSiguientePagina = new JButton("Siguiente p\u00E1gina");
		btnSiguientePagina.addActionListener(e ->
		{
			try {
				
				String tipoInmueble = cbxTipoInmueble.getSelectedItem().toString();
				Integer precioInmueble;
				if(txtPrecio.getText().isEmpty()) {
					precioInmueble = null;
				}
				else {
					precioInmueble = Integer.parseInt(txtPrecio.getText().toString());
				}
				String orientacion = cbxOrientacion.getSelectedItem().toString();
				Integer metrosFondo;
				if(txtMetrosFondo.getText().isEmpty()) {
					metrosFondo = null;
				}
				else {
					metrosFondo = Integer.parseInt(txtMetrosFondo.getText().toString());
				}
				Integer metrosFrente;
				if(txtMetrosFrente.getText().isEmpty()) {
					metrosFrente = null;
				}
				else {
					metrosFrente = Integer.parseInt(txtMetrosFrente.getText().toString());
				}
				Integer superficieTerreno;
				if(txtSuperficieTerreno.getText().isEmpty()) {
					superficieTerreno = null;
				}
				else {
					superficieTerreno = Integer.parseInt(txtSuperficieTerreno.getText().toString());
				}
				
				
				Gestor_Inmueble gestorInmueble = new Gestor_Inmueble();
				gestorInmueble.validar_Datos_Inmueble(tipoInmueble, precioInmueble, orientacion, metrosFondo, metrosFrente, superficieTerreno);
				
				Integer superficieEdificio;
				if(txtSuperficieEdificio.getText().isEmpty()) {
					superficieEdificio = null;
				}
				else {
					superficieEdificio = Integer.parseInt(txtSuperficieEdificio.getText().toString());
				}
				
				Integer antiguedad;
				if(txtAntiguedad.getText().isEmpty()) {
					antiguedad = null;
				}
				else {
					antiguedad = Integer.parseInt(txtAntiguedad.getText().toString());
				}
				
				Integer cantDormitorios;
				if(txtDormitorios.getText().isEmpty()) {
					cantDormitorios = null;
				}
				else {
					cantDormitorios = Integer.parseInt(txtDormitorios.getText().toString());
				}
				
				Integer cantBaños;
				if(txtBaños.getText().isEmpty()) {
					cantBaños = null;
				}
				else {
					cantBaños = Integer.parseInt(txtBaños.getText().toString());
				}
				
				
				gestorInmueble.actualizarModelo_Datos_Inmueble(tipoInmueble, precioInmueble, orientacion, metrosFrente, metrosFondo, superficieTerreno,
						this.chkPropiedadHorizontal.isSelected(), superficieEdificio, 
						antiguedad, cantDormitorios, cantBaños, this.chkGarage.isSelected(), this.chkPatio.isSelected(),
						this.chkPiscina.isSelected(), this.chkAguaCorriente.isSelected(), this.chkCloacas.isSelected(), this.chkGasNatural.isSelected(),
						this.chkAguaCaliente.isSelected(), this.chkTelefono.isSelected(), this.chkLavadero.isSelected(), this.chkPavimiento.isSelected());
				this.setVisible(false);
				Alta_Modificacion_Inmueble_Pagina_3 panelSiguiente = new Alta_Modificacion_Inmueble_Pagina_3(pantallaPrincipal);
				pantallaPrincipal.setContentPane(panelSiguiente);
				
			} catch (Datos_Invalidos_Exception e2) {
				e2.printStackTrace();
				this.mostrarMensajeError(pantallaPrincipal,"Error al ingresar datos",e2.getMessage());
			}

		});
		btnSiguientePagina.setForeground(Color.BLACK);
		btnSiguientePagina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguientePagina.setBounds(715, 630, 170, 25);
		add(btnSiguientePagina);

	}
	
	private void mostrarMensajeError(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void setearDatos(String tipoInmueble, Integer precio, String orientacion, Integer metrosFrente, Integer metrosFondo, Integer superficie, Integer antiguedad,
			Integer superficieEdificio, Integer cantDormitorios, Integer cantBaños, boolean propHorizontal, boolean garage, boolean patio, boolean piscina,
			boolean aguaCaliente, boolean aguaCorriente, boolean cloacas, boolean gasNatural, boolean telefono, boolean lavadero, boolean pavimento) {
		
		this.cbxTipoInmueble.setSelectedItem(tipoInmueble);
		this.txtPrecio.setText(precio.toString());
		this.cbxOrientacion.setSelectedItem(orientacion);
		this.txtMetrosFrente.setText(metrosFrente.toString());
		this.txtMetrosFondo.setText(metrosFondo.toString());
		this.txtSuperficieTerreno.setText(superficie.toString());
		this.txtAntiguedad.setText(antiguedad.toString());
		this.txtSuperficieEdificio.setText(superficieEdificio.toString());
		this.txtDormitorios.setText(cantDormitorios.toString());
		this.txtBaños.setText(cantBaños.toString());
		
		if(propHorizontal == true) {
			this.chkPropiedadHorizontal.setSelected(true);
		}
		else {
			this.chkPropiedadHorizontal.setSelected(false);
		}
		
		if(garage == true) {
			this.chkGarage.setSelected(true);
		}
		else {
			this.chkGarage.setSelected(false);
		}
		
		if(patio == true) {
			this.chkPatio.setSelected(true);
		}
		else {
			this.chkPatio.setSelected(false);
		}
		
		if(piscina == true) {
			this.chkPiscina.setSelected(true);
		}
		else {
			this.chkPiscina.setSelected(false);
		}
		
		if(aguaCaliente == true) {
			this.chkAguaCaliente.setSelected(true);
		}
		else {
			this.chkAguaCaliente.setSelected(false);
		}
		
		if(aguaCorriente == true) {
			this.chkAguaCorriente.setSelected(true);
		}
		else {
			this.chkAguaCorriente.setSelected(false);
		}
		
		if(cloacas == true) {
			this.chkCloacas.setSelected(true);
		}
		else {
			this.chkCloacas.setSelected(false);
		}
		
		if(gasNatural == true) {
			this.chkGasNatural.setSelected(true);
		}
		else {
			this.chkGasNatural.setSelected(false);
		}
		
		if(telefono == true) {
			this.chkTelefono.setSelected(true);
		}
		else {
			this.chkTelefono.setSelected(false);
		}
		
		if(lavadero == true) {
			this.chkLavadero.setSelected(true);
		}
		else {
			this.chkLavadero.setSelected(false);
		}
		
		if(pavimento == true) {
			this.chkPavimiento.setSelected(true);
		}
		else {
			this.chkPavimiento.setSelected(false);
		}
		
	}

}