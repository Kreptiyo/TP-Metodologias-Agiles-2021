package interfaces_graficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dominio.Cliente;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Cliente;
import interfaces_graficas.Lista_Cliente;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Modificar_Cliente extends JPanel {

	
	private JFrame frmModificarCliente;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalidad;
	private JTextField textFieldBarrio;
	private JTextField textFieldMonto;
	private JComboBox comboBoxTipoInmueble;
	private JComboBox comboBoxOrientacion;
	private JTextField textFieldFrente;
	private JTextField textFieldFondo;
	private JTextField textFieldSuperficie;
	private JTextField textFieldAntiguedad;
	private JTextField textFieldBaños;
	private JTextField textFieldDormitorios;
	private JCheckBox chckbxHorizontal;
	private JCheckBox chckbxGarage;
	private JCheckBox chckbxPatio;
	private JCheckBox chckbxAguaCorriente;
	private JCheckBox chckbxCloacas;
	private JCheckBox chckbxGas;
	private JCheckBox chckbxAguaCaliente;
	private JCheckBox chckbxTelefono;
	private JCheckBox chckbxLavadero;
	private JCheckBox chckbxPavimento;
	private JLabel lblErrorTipoInmueble;
	private JLabel lblErrorLocalidad;
	private JLabel lblErrorBarrio;
	private JLabel lblErrorMonto;
	private JLabel lblErrorNombre;
	private JLabel lblErrorApellido;
	private JLabel lblErrorTelefono;
	private  JLabel lblErrorCaractersiticas;
	private Gestor_Cliente gestorCliente;
	
	private JCheckBox chckbxPiscina;
	private JLabel lbldormitorios;
	private JLabel lblPiscina;
	private JLabel lblMail;
	private JTextField textFieldMail;
	private JTextField textFieldContrasea;
	private JLabel lblContrasea;
	private JTextField textFieldNroDocumento;
	private JLabel lblnroDocumento;
	private JLabel lblErrorMail;
	private JLabel lblErrorDocuemtno;
	private JLabel lblErrorContraseña;
	
	public Modificar_Cliente(JFrame pantallaPrincipal, String nombre, String apellido, String id) {
		armarPanel(pantallaPrincipal, nombre, apellido, id);
	}
	
	public void armarPanel(JFrame pantallaPrincipal, String nombre, String apellido, String id) {
		
		this.gestorCliente = new Gestor_Cliente();
		
		Cliente cliente = this.gestorCliente.buscarPorNombreApellido(nombre, apellido).get(0);
		
		setBounds(100, 100, 1024, 768);
		setLayout(null);	
		
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(140, 46, 130, 25);
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidoCliente = new JLabel("Apellido");
		lblApellidoCliente.setBounds(140, 86, 130, 25);
		lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTelefonoCliente = new JLabel("Telefono");
		lblTelefonoCliente.setBounds(140, 126, 130, 25);
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setLayout(null);
		add(lblNombreCliente);
		add(lblApellidoCliente);
		add(lblTelefonoCliente);
		
		JPanel panelDatosInmueble = new JPanel();
		panelDatosInmueble.setBorder(new TitledBorder(null, "Datos del inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosInmueble.setBounds(278, 173, 416, 193);
		add(panelDatosInmueble);
		panelDatosInmueble.setLayout(null);
		
		JLabel lblTipoDeInmueble = new JLabel("Tipo de Inmueble");
		lblTipoDeInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeInmueble.setBounds(30, 20, 130, 25);
		panelDatosInmueble.add(lblTipoDeInmueble);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalidad.setBounds(30, 60, 130, 25);
		panelDatosInmueble.add(lblLocalidad);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarrio.setBounds(30, 100, 130, 25);
		panelDatosInmueble.add(lblBarrio);
		
		JLabel lblMonto = new JLabel("Monto Disponible");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonto.setBounds(30, 140, 130, 25);
		panelDatosInmueble.add(lblMonto);
		
		textFieldLocalidad = new JTextField(cliente.getLocalidad());
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(190, 60, 200, 25);
		panelDatosInmueble.add(textFieldLocalidad);
		textFieldLocalidad.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldLocalidad.getText().length()>20) 
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
		
		textFieldBarrio = new JTextField(cliente.getBarrio());
		textFieldBarrio.setColumns(10);
		textFieldBarrio.setBounds(190, 100, 200, 25);
		panelDatosInmueble.add(textFieldBarrio);
		textFieldBarrio.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldBarrio.getText().length()>20) 
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
		
		textFieldMonto = new JTextField(cliente.getMonto().toString());
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(190, 140, 200, 25);
		panelDatosInmueble.add(textFieldMonto);
		textFieldMonto.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldMonto.setEditable(true);
		         } else {
		        	 textFieldMonto.setEditable(false);
		         }
		      }
		   });
		
		String[] aux = new String[7];
		aux[0]="";
		aux[1]= "LOCAL U OFICINA";
		aux[2]= "CASA";
		aux[3]= "DEPARTAMENTO";
		aux[4]= "TERRENO";
		aux[5]= "QUINTA";
		aux[6]= "GALPON";
		
		
		comboBoxTipoInmueble = new JComboBox(aux);
		comboBoxTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTipoInmueble.setBounds(190, 20, 200, 25);
		panelDatosInmueble.add(comboBoxTipoInmueble);
		
		lblErrorTipoInmueble = new JLabel("(!)");
		lblErrorTipoInmueble.setForeground(Color.RED);
		lblErrorTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorTipoInmueble.setBounds(10, 20, 13, 25);
		lblErrorTipoInmueble.setVisible(false);
		panelDatosInmueble.add(lblErrorTipoInmueble);
		
		lblErrorLocalidad = new JLabel("(!)");
		lblErrorLocalidad.setForeground(Color.RED);
		lblErrorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorLocalidad.setBounds(10, 60, 13, 25);
		lblErrorLocalidad.setVisible(false);
		panelDatosInmueble.add(lblErrorLocalidad);
		
		lblErrorBarrio = new JLabel("(!)");
		lblErrorBarrio.setForeground(Color.RED);
		lblErrorBarrio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorBarrio.setBounds(10, 100, 13, 25);
		lblErrorBarrio.setVisible(false);
		panelDatosInmueble.add(lblErrorBarrio);
		
		lblErrorMonto = new JLabel("(!)");
		lblErrorMonto.setForeground(Color.RED);
		lblErrorMonto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMonto.setBounds(10, 140, 13, 25);
		lblErrorMonto.setVisible(false);
		panelDatosInmueble.add(lblErrorMonto);
		
		textFieldNombre = new JTextField(cliente.getNombre());
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(274, 46, 200, 25);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldNombre.getText().length()>30) 
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
		textFieldApellido = new JTextField(cliente.getApellido());
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(274, 84, 200, 25);
		add(textFieldApellido);
		textFieldApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldApellido.getText().length()>30) 
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
		
		textFieldTelefono = new JTextField(String.valueOf(cliente.getTelefono()));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(468, 121, 200, 25);
		textFieldTelefono.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldTelefono.setEditable(true);
		         } else {
		        	 textFieldTelefono.setEditable(false);
		         }
		      }
		   });
		add(textFieldTelefono);

		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarCliente.setBounds(298, 669, 140, 30);
		add(btnModificarCliente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(537, 669, 140, 30);
		btnVolver.addActionListener(e->
		{
			this.setVisible(false);
			JPanel panelListaDeClientes = new Lista_Cliente(pantallaPrincipal);
			panelListaDeClientes.setVisible(true);
			pantallaPrincipal.setContentPane(panelListaDeClientes);
			pantallaPrincipal.setTitle("Lista de Clientes");
		});
		add(btnVolver);
		
		JPanel panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Caracteristicas del Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCaracteristicas.setBounds(104, 374, 808, 270);
		add(panelCaracteristicas);
		panelCaracteristicas.setLayout(null);
		
		JLabel lblFrente = new JLabel("Frente");
		lblFrente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrente.setBounds(21, 30, 130, 25);
		panelCaracteristicas.add(lblFrente);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setBounds(21, 70, 130, 25);
		panelCaracteristicas.add(lblFondo);
		
		JLabel lblSuperficie = new JLabel("Superficie");
		lblSuperficie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSuperficie.setBounds(21, 110, 130, 25);
		panelCaracteristicas.add(lblSuperficie);
		
		textFieldFrente = new JTextField(cliente.getFrente().toString());
		textFieldFrente.setColumns(10);
		textFieldFrente.setBounds(141, 30, 116, 25);
		panelCaracteristicas.add(textFieldFrente);
		textFieldFrente.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldFrente.setEditable(true);
		         } else {
		        	 textFieldFrente.setEditable(false);
		         }
		      }
		   });
		
		JLabel lblAntiguedad = new JLabel("Antiguedad");
		lblAntiguedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAntiguedad.setBounds(21, 150, 130, 25);
		panelCaracteristicas.add(lblAntiguedad);
		
		JLabel lblBaos = new JLabel("Ba\u00F1os");
		lblBaos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBaos.setBounds(21, 190, 130, 25);
		panelCaracteristicas.add(lblBaos);
		
		textFieldFondo = new JTextField(cliente.getFondo().toString());
		textFieldFondo.setColumns(10);
		textFieldFondo.setBounds(141, 70, 116, 25);
		panelCaracteristicas.add(textFieldFondo);
		textFieldFondo.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldFondo.setEditable(true);
		         } else {
		        	 textFieldFondo.setEditable(false);
		         }
		      }
		   });
		
		textFieldSuperficie = new JTextField(cliente.getSuperficie().toString());
		textFieldSuperficie.setColumns(10);
		textFieldSuperficie.setBounds(141, 110, 116, 25);
		panelCaracteristicas.add(textFieldSuperficie);
		textFieldSuperficie.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldSuperficie.setEditable(true);
		         } else {
		        	 textFieldSuperficie.setEditable(false);
		         }
		      }
		   });
		
		textFieldAntiguedad = new JTextField(cliente.getAntiguedad().toString());
		textFieldAntiguedad.setColumns(10);
		textFieldAntiguedad.setBounds(141, 150, 116, 25);
		panelCaracteristicas.add(textFieldAntiguedad);
		textFieldAntiguedad.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldAntiguedad.setEditable(true);
		         } else {
		        	 textFieldAntiguedad.setEditable(false);
		         }
		      }
		   });
		textFieldBaños = new JTextField(cliente.getBaños().toString());
		textFieldBaños.setColumns(10);
		textFieldBaños.setBounds(141, 190, 116, 25);
		panelCaracteristicas.add(textFieldBaños);
		textFieldBaños.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldBaños.setEditable(true);
		         } else {
		        	 textFieldBaños.setEditable(false);
		         }
		      }
		   });
		
		JLabel lbldormitorios = new JLabel("Dormitorios");
		lbldormitorios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldormitorios.setBounds(319, 230, 130, 25);
		panelCaracteristicas.add(lbldormitorios);
		
		textFieldDormitorios = new JTextField(cliente.getDormitorios().toString());
		textFieldDormitorios.setColumns(10);
		textFieldDormitorios.setBounds(439, 230, 82, 25);
		textFieldDormitorios.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldDormitorios.setEditable(true);
		         } else {
		        	 textFieldDormitorios.setEditable(false);
		         }
		      }
		   });
		panelCaracteristicas.add(textFieldDormitorios);
		
		JLabel lblPiscina = new JLabel("Piscina");
		lblPiscina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPiscina.setBounds(555, 230, 130, 25);
		panelCaracteristicas.add(lblPiscina);
		
		chckbxPiscina = new JCheckBox("Si / No");
		chckbxPiscina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPiscina.setBounds(676, 230, 93, 21);
		panelCaracteristicas.add(chckbxPiscina);
		
		JLabel lblHorizontal = new JLabel("Horizontal");
		lblHorizontal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorizontal.setBounds(319, 30, 130, 25);
		panelCaracteristicas.add(lblHorizontal);
		
		JLabel lblGarage = new JLabel("Garage");
		lblGarage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGarage.setBounds(319, 70, 130, 25);
		panelCaracteristicas.add(lblGarage);
		
		JLabel lblPatio = new JLabel("Patio");
		lblPatio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatio.setBounds(319, 110, 130, 25);
		panelCaracteristicas.add(lblPatio);
		
		JLabel lblAguaCorriente = new JLabel("Agua Corriente");
		lblAguaCorriente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAguaCorriente.setBounds(319, 150, 130, 25);
		panelCaracteristicas.add(lblAguaCorriente);
		
		JLabel lblCloacas = new JLabel("Cloacas");
		lblCloacas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCloacas.setBounds(319, 190, 130, 25);
		panelCaracteristicas.add(lblCloacas);
		
		JLabel lblGasNatural = new JLabel("Gas Natural");
		lblGasNatural.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGasNatural.setBounds(555, 30, 130, 25);
		panelCaracteristicas.add(lblGasNatural);
		
		JLabel lblAguaCaliente = new JLabel("Agua Caliente");
		lblAguaCaliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAguaCaliente.setBounds(555, 70, 130, 25);
		panelCaracteristicas.add(lblAguaCaliente);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(555, 110, 130, 25);
		panelCaracteristicas.add(lblTelefono);
		
		JLabel lblLavadero = new JLabel("Lavadero");
		lblLavadero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLavadero.setBounds(555, 150, 130, 25);
		panelCaracteristicas.add(lblLavadero);
		
		JLabel lblPavimento = new JLabel("Pavimento");
		lblPavimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPavimento.setBounds(555, 190, 130, 25);
		panelCaracteristicas.add(lblPavimento);
		
		JLabel lblOrientacion = new JLabel("Orientacion");
		lblOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrientacion.setBounds(21, 230, 130, 25);
		panelCaracteristicas.add(lblOrientacion);
		
		String[] aux1 = new String[9];
		aux1[0]= "";
		aux1[1]= "NORTE";
		aux1[2]= "SUR";
		aux1[3]= "ESTE";
		aux1[4]= "OESTE";
		aux1[5]= "NORESTE";
		aux1[6]= "NOROESTE";
		aux1[7]= "SURESTE";
		aux1[8]= "SUROESTE";
		
		comboBoxOrientacion = new JComboBox(aux1);
		comboBoxOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxOrientacion.setBounds(141, 230, 116, 25);
		panelCaracteristicas.add(comboBoxOrientacion);
		
		 chckbxHorizontal = new JCheckBox("Si / No");
		chckbxHorizontal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHorizontal.setBounds(440, 30, 95, 21);
		panelCaracteristicas.add(chckbxHorizontal);
		
		 chckbxGarage = new JCheckBox("Si / No");
		chckbxGarage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGarage.setBounds(440, 70, 93, 21);
		panelCaracteristicas.add(chckbxGarage);
		
		 chckbxPatio = new JCheckBox("Si / No");
		chckbxPatio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPatio.setBounds(440, 110, 93, 21);
		panelCaracteristicas.add(chckbxPatio);
		
		 chckbxAguaCorriente = new JCheckBox("Si / No");
		chckbxAguaCorriente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAguaCorriente.setBounds(440, 150, 93, 21);
		panelCaracteristicas.add(chckbxAguaCorriente);
		
		 chckbxCloacas = new JCheckBox("Si / No");
		chckbxCloacas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCloacas.setBounds(440, 190, 93, 21);
		panelCaracteristicas.add(chckbxCloacas);
		
		 chckbxGas = new JCheckBox("Si / No");
		chckbxGas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGas.setBounds(676, 30, 93, 21);
		panelCaracteristicas.add(chckbxGas);
		
		 chckbxAguaCaliente = new JCheckBox("Si / No");
		chckbxAguaCaliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAguaCaliente.setBounds(676, 70, 93, 21);
		panelCaracteristicas.add(chckbxAguaCaliente);
		
		 chckbxTelefono = new JCheckBox("Si / No");
		chckbxTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTelefono.setBounds(676, 110, 93, 21);
		panelCaracteristicas.add(chckbxTelefono);
		
		 chckbxLavadero = new JCheckBox("Si / No");
		chckbxLavadero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLavadero.setBounds(676, 150, 93, 21);
		panelCaracteristicas.add(chckbxLavadero);
		
		 chckbxPavimento = new JCheckBox("Si / No");
		chckbxPavimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPavimento.setBounds(676, 190, 93, 21);
		panelCaracteristicas.add(chckbxPavimento);

		lblErrorNombre = new JLabel("(!)");
		lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(117, 47, 13, 25);
		lblErrorNombre.setVisible(false);
		add(lblErrorNombre);

		lblErrorApellido = new JLabel("(!)");
		lblErrorApellido.setForeground(Color.RED);
		lblErrorApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorApellido.setBounds(117, 86, 13, 25);
		lblErrorApellido.setVisible(false);
		add(lblErrorApellido);

		lblErrorTelefono = new JLabel("(!)");
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorTelefono.setBounds(117, 126, 13, 25);
		lblErrorTelefono.setVisible(false);
		add(lblErrorTelefono);

		lblErrorCaractersiticas = new JLabel("(!)");
		lblErrorCaractersiticas.setForeground(Color.RED);
		lblErrorCaractersiticas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErrorCaractersiticas.setBounds(81, 358, 23, 40);
		lblErrorCaractersiticas.setVisible(false);
		add(lblErrorCaractersiticas);
		
		lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail.setBounds(551, 46, 130, 25);
		add(lblMail);
		
		textFieldMail = new JTextField(cliente.getMail());
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(677, 49, 200, 25);
		textFieldMail.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldMail.getText().length()>20) 
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
		add(textFieldMail);
		
		textFieldContrasea = new JTextField(cliente.getContraseña());
		textFieldContrasea.setColumns(10);
		textFieldContrasea.setBounds(677, 87, 200, 25);
		textFieldContrasea.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(textFieldContrasea.getText().length()>20) 
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
		add(textFieldContrasea);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(551, 86, 130, 25);
		add(lblContrasea);
		
		textFieldNroDocumento = new JTextField(cliente.getNroDocumento());
		textFieldNroDocumento.setColumns(10);
		textFieldNroDocumento.setBounds(677, 128, 200, 25);
		textFieldNroDocumento.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldNroDocumento.setEditable(true);
		         } else {
		        	 textFieldNroDocumento.setEditable(false);
		         }
		      }
		   });
		add(textFieldNroDocumento);
		
		lblnroDocumento = new JLabel("Nro. Documento");
		lblnroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnroDocumento.setBounds(551, 126, 130, 25);
		add(lblnroDocumento);
		
		textFieldTelefono = new JTextField(cliente.getTelefono());
		textFieldTelefono.setBounds(274, 128, 200, 25);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		lblErrorMail = new JLabel("(!)");
		lblErrorMail.setForeground(Color.RED);
		lblErrorMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorMail.setBounds(518, 51, 23, 17);
		lblErrorMail.setVisible(false);
		add(lblErrorMail);
		
		lblErrorDocuemtno = new JLabel("(!)");
		lblErrorDocuemtno.setForeground(Color.RED);
		lblErrorDocuemtno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorDocuemtno.setBounds(518, 131, 23, 17);
		lblErrorDocuemtno.setVisible(false);
		add(lblErrorDocuemtno);
		
		lblErrorContraseña = new JLabel("(!)");
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorContraseña.setBounds(518, 91, 23, 17);
		lblErrorContraseña.setVisible(false);
		add(lblErrorContraseña);
		textFieldTelefono.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldTelefono.setEditable(true);
		         } else {
		        	 textFieldTelefono.setEditable(false);
		         }
		      }
		   });
		
		
		btnModificarCliente.addActionListener(e-> {
			try {
				this.crearCliente(id);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BaseDeDatosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		  });
	}
	
	public void crearCliente(String id) throws SQLException, BaseDeDatosException {
		
		if(!validarDatosVacios()) {
			
			this.gestorCliente.actualizarCliente(
					Integer.parseInt(id),
					this.textFieldNombre.getText(), 
					this.textFieldLocalidad.getText(),
					this.textFieldApellido.getText(),
					this.textFieldTelefono.getText(),
					this.textFieldBarrio.getText(),
					Integer.parseInt(this.textFieldMonto.getText()),
					this.textFieldMail.getText(),
					this.textFieldContrasea.getText(),
					this.textFieldNroDocumento.getText());
			
			Integer frente, fondo, superficie, antiguedad, dormitorios, baños;
			
			if(!this.textFieldFrente.getText().isEmpty()) {
				frente = Integer.parseInt(this.textFieldFrente.getText());
			}else {
				frente = 0;
			}
			
			if(!this.textFieldFondo.getText().isEmpty()) {
				fondo = Integer.parseInt(this.textFieldFondo.getText());
			}else {
				fondo = 0;
			}
			
			if(!this.textFieldSuperficie.getText().isEmpty()) {
				superficie = Integer.parseInt(this.textFieldSuperficie.getText());
			}else {
				superficie = 0;
			}
			
			if(!this.textFieldAntiguedad.getText().isEmpty()) {
				antiguedad = Integer.parseInt(this.textFieldAntiguedad.getText());
			}else {
				antiguedad = 0;
			}
			
			if(!this.textFieldDormitorios.getText().isEmpty()) {
				dormitorios = Integer.parseInt(this.textFieldDormitorios.getText());
			}else {
				dormitorios = 0;
			}
			
			if(!this.textFieldBaños.getText().isEmpty()) {
				baños = Integer.parseInt(this.textFieldBaños.getText());
			}else {
				baños = 0;
			}
			
			int orietacion = this.comboBoxOrientacion.getSelectedIndex();
			int tipoInmueble =  this.comboBoxTipoInmueble.getSelectedIndex();
			
			this.gestorCliente.actualizarModelo_Datos_Inmueble(
					orietacion,
					tipoInmueble,
					frente, fondo, superficie, 
					this.chckbxHorizontal.isSelected(), 
					antiguedad, dormitorios, baños, 
					this.chckbxGarage.isSelected(), 
					this.chckbxPatio.isSelected(), 
					this.chckbxPiscina.isSelected(), 
					this.chckbxAguaCorriente.isSelected(), 
					this.chckbxCloacas.isSelected(), 
					this.chckbxGas.isSelected(), 
					this.chckbxAguaCaliente.isSelected(), 
					this.chckbxTelefono.isSelected(), 
					this.chckbxLavadero.isSelected(), 
					this.chckbxPavimento.isSelected());
			
		}
	}
 
	
	public boolean validarDatosVacios() {		
		
		boolean error = false;
		
		if(this.textFieldNombre.getText().isEmpty()) {
			this.lblErrorNombre.setVisible(true);
			error = true;
		}else {
			this.lblErrorNombre.setVisible(false);
		}
		
		if(this.textFieldApellido.getText().isEmpty()) {
			this.lblErrorApellido.setVisible(true);
			error = true;
		}else {
			this.lblErrorApellido.setVisible(false);
		}
		
		if(this.textFieldBarrio.getText().isEmpty()) {
			this.lblErrorBarrio.setVisible(true);
			error = true;
		}else {
			this.lblErrorBarrio.setVisible(false);
		}
		
		if(this.textFieldMonto.getText().isEmpty()) {
			this.lblErrorMonto.setVisible(true);
			error = true;
		}else {
			this.lblErrorMonto.setVisible(false);
		}
		
		if(this.textFieldLocalidad.getText().isEmpty()) {
			this.lblErrorLocalidad.setVisible(true);
			error = true;
		}else {
			this.lblErrorLocalidad.setVisible(false);
		}
		
		if(this.textFieldTelefono.getText().isEmpty()) {
			this.lblErrorTelefono.setVisible(true);
			error = true;
		}else {
			this.lblErrorTelefono.setVisible(false);
		}
		if(this.textFieldMail.getText().isEmpty()) {
			this.lblErrorMail.setVisible(true);
			error = true;
		}else {
			this.lblErrorMail.setVisible(false);
		}
		
		if(this.textFieldContrasea.getText().isEmpty()) {
			this.lblErrorContraseña.setVisible(true);
			error = true;
		}else {
			this.lblErrorContraseña.setVisible(false);
		}
		if(this.textFieldNroDocumento.getText().isEmpty()) {
			this.lblnroDocumento.setVisible(true);
			error = true;
		}else {
			this.lblnroDocumento.setVisible(false);
		}
		
		
		if(this.comboBoxTipoInmueble.getSelectedItem() == "") {
			this.lblErrorTipoInmueble.setVisible(true);
			error = true;
		}else {
			this.lblErrorTipoInmueble.setVisible(false);
		}
		
		if(
		this.textFieldAntiguedad.getText().isEmpty() &&
		this.textFieldBaños.getText().isEmpty()&&
		this.textFieldFondo.getText().isEmpty()&&
		this.textFieldFrente.getText().isEmpty()&&
		this.textFieldSuperficie.getText().isEmpty()&&
		this.textFieldDormitorios.getText().isEmpty()
		) {
			this.lblErrorCaractersiticas.setVisible(true);
			error = true;
		}else {
			this.lblErrorCaractersiticas.setVisible(false);
		}
		
		
		if(error == true)		
		{
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return error;
		}else {
			JOptionPane.showMessageDialog(null, "Cliente creado");
		}
		
		return error;
	}
	
	private void limpiarFormulario() {
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.textFieldTelefono.setText("");
		this.comboBoxTipoInmueble.setSelectedIndex(0);
		this.textFieldLocalidad.setText("");
		this.textFieldBarrio.setText("");
		this.textFieldMonto.setText("");
		this.textFieldAntiguedad.setText("");
		this.textFieldBaños.setText("");
		this.textFieldFondo.setText("");
		this.textFieldFrente.setText("");
		this.textFieldSuperficie.setText("");
		this.textFieldDormitorios.setText("");
		this.comboBoxOrientacion.setSelectedIndex(0);
		this.chckbxAguaCaliente.setSelected(false);
		this.chckbxPiscina.setSelected(false);
		this.chckbxAguaCorriente.setSelected(false);
		this.chckbxCloacas.setSelected(false);
		this.chckbxGarage.setSelected(false);
		this.chckbxAguaCaliente.setSelected(false);
		this.chckbxHorizontal.setSelected(false);
		this.chckbxLavadero.setSelected(false);
		this.chckbxPatio.setSelected(false);
		this.chckbxPavimento.setSelected(false);
		this.chckbxTelefono.setSelected(false);
		this.chckbxGas.setSelected(false);
	}
	
		private void accionMarcarCamposCorrectos() {
		
		/*borra los simbolos que se muestran en pantlla junto a cada campo erroneo*/
		
		this.lblErrorBarrio.setVisible(false);
		this.lblErrorNombre.setVisible(false);
		this.lblErrorMonto.setVisible(false);
		this.lblErrorLocalidad.setVisible(false);
		this.lblErrorApellido.setVisible(false);
		this.lblErrorCaractersiticas.setVisible(false);
		this.lblErrorTelefono.setVisible(false);
		this.lblErrorTipoInmueble.setVisible(false);
		this.lblErrorMail.setVisible(false);
		this.lblErrorContraseña.setVisible(false);
		this.lblnroDocumento.setVisible(false);
	}		
		
	}


