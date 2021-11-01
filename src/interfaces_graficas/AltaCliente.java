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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

public class AltaCliente extends JFrame{

	private JFrame frmAadirCliente;
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

	public AltaCliente() {
		
		super();
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAltaCliente = new JPanel();
		getContentPane().add(panelAltaCliente, BorderLayout.CENTER);
		panelAltaCliente.setLayout(null);	
		
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(298, 41, 130, 25);
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidoCliente = new JLabel("Apellido");
		lblApellidoCliente.setBounds(298, 81, 130, 25);
		lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTelefonoCliente = new JLabel("Telefono");
		lblTelefonoCliente.setBounds(298, 121, 130, 25);
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelAltaCliente.setLayout(null);
		panelAltaCliente.add(lblNombreCliente);
		panelAltaCliente.add(lblApellidoCliente);
		panelAltaCliente.add(lblTelefonoCliente);
		
		JPanel panelDatosInmueble = new JPanel();
		panelDatosInmueble.setBorder(new TitledBorder(null, "Datos del inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosInmueble.setBounds(278, 173, 416, 193);
		panelAltaCliente.add(panelDatosInmueble);
		panelDatosInmueble.setLayout(null);
		
		JLabel lblTipoDeInmueble = new JLabel("Tipo de Inmueble");
		lblTipoDeInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeInmueble.setBounds(20, 20, 130, 25);
		panelDatosInmueble.add(lblTipoDeInmueble);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocalidad.setBounds(20, 60, 130, 25);
		panelDatosInmueble.add(lblLocalidad);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarrio.setBounds(20, 100, 130, 25);
		panelDatosInmueble.add(lblBarrio);
		
		JLabel lblMonto = new JLabel("Monto Disponible");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonto.setBounds(20, 140, 130, 25);
		panelDatosInmueble.add(lblMonto);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(190, 60, 200, 25);
		panelDatosInmueble.add(textFieldLocalidad);
		
		textFieldBarrio = new JTextField();
		textFieldBarrio.setColumns(10);
		textFieldBarrio.setBounds(190, 100, 200, 25);
		panelDatosInmueble.add(textFieldBarrio);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(190, 140, 200, 25);
		panelDatosInmueble.add(textFieldMonto);
		
		String[] aux = new String[8];
		aux[1]= "Local";
		aux[2]= "Casa";
		aux[3]= "Departamento";
		aux[4]= "Terreno";
		aux[5]= "Quinta";
		aux[6]= "Galpon";
		aux[7]= "Oficina";
		
		
		comboBoxTipoInmueble = new JComboBox(aux);
		comboBoxTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTipoInmueble.setBounds(190, 20, 200, 25);
		panelDatosInmueble.add(comboBoxTipoInmueble);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(468, 43, 200, 25);
		panelAltaCliente.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(468, 81, 200, 25);
		panelAltaCliente.add(textFieldApellido);
		
		textFieldTelefono = new JTextField();
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
		panelAltaCliente.add(textFieldTelefono);
		
		JButton btnAñadirCliente = new JButton("A\u00F1adir");
		btnAñadirCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadirCliente.setBounds(298, 669, 140, 30);
		panelAltaCliente.add(btnAñadirCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(537, 669, 140, 30);
		panelAltaCliente.add(btnCancelar);
		
		JPanel panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Caracteristicas del Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCaracteristicas.setBounds(104, 374, 808, 270);
		panelAltaCliente.add(panelCaracteristicas);
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
		
		textFieldFrente = new JTextField();
		textFieldFrente.setColumns(10);
		textFieldFrente.setBounds(141, 30, 116, 25);
		panelCaracteristicas.add(textFieldFrente);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad");
		lblAntiguedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAntiguedad.setBounds(21, 150, 130, 25);
		panelCaracteristicas.add(lblAntiguedad);
		
		JLabel lblBaos = new JLabel("Ba\u00F1os");
		lblBaos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBaos.setBounds(21, 190, 130, 25);
		panelCaracteristicas.add(lblBaos);
		
		textFieldFondo = new JTextField();
		textFieldFondo.setColumns(10);
		textFieldFondo.setBounds(141, 70, 116, 25);
		panelCaracteristicas.add(textFieldFondo);
		
		textFieldSuperficie = new JTextField();
		textFieldSuperficie.setColumns(10);
		textFieldSuperficie.setBounds(141, 110, 116, 25);
		panelCaracteristicas.add(textFieldSuperficie);
		
		textFieldAntiguedad = new JTextField();
		textFieldAntiguedad.setColumns(10);
		textFieldAntiguedad.setBounds(141, 150, 116, 25);
		panelCaracteristicas.add(textFieldAntiguedad);
		
		textFieldBaños = new JTextField();
		textFieldBaños.setColumns(10);
		textFieldBaños.setBounds(141, 190, 116, 25);
		panelCaracteristicas.add(textFieldBaños);
		
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
		aux1[1]= "Norte";
		aux1[2]= "Sur";
		aux1[3]= "Este";
		aux1[4]= "Oeste";
		aux1[5]= "Noreste";
		aux1[6]= "Noroeste";
		aux1[7]= "Sureste";
		aux1[8]= "Suroeste";
		
		JComboBox comboBoxOrientacion = new JComboBox(aux1);
		comboBoxOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxOrientacion.setBounds(141, 230, 116, 25);
		panelCaracteristicas.add(comboBoxOrientacion);
		
		JCheckBox chckbxHorizontal = new JCheckBox("Si / No");
		chckbxHorizontal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHorizontal.setBounds(440, 30, 95, 21);
		panelCaracteristicas.add(chckbxHorizontal);
		
		JCheckBox chckbxGarage = new JCheckBox("Si / No");
		chckbxGarage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGarage.setBounds(440, 70, 93, 21);
		panelCaracteristicas.add(chckbxGarage);
		
		JCheckBox chckbxPatio = new JCheckBox("Si / No");
		chckbxPatio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPatio.setBounds(440, 110, 93, 21);
		panelCaracteristicas.add(chckbxPatio);
		
		JCheckBox chckbxAguaCorriente = new JCheckBox("Si / No");
		chckbxAguaCorriente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAguaCorriente.setBounds(440, 150, 93, 21);
		panelCaracteristicas.add(chckbxAguaCorriente);
		
		JCheckBox chckbxCloacas = new JCheckBox("Si / No");
		chckbxCloacas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCloacas.setBounds(440, 190, 93, 21);
		panelCaracteristicas.add(chckbxCloacas);
		
		JCheckBox chckbxGas = new JCheckBox("Si / No");
		chckbxGas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGas.setBounds(676, 30, 93, 21);
		panelCaracteristicas.add(chckbxGas);
		
		JCheckBox chckbxAguaCaliente = new JCheckBox("Si / No");
		chckbxAguaCaliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAguaCaliente.setBounds(676, 70, 93, 21);
		panelCaracteristicas.add(chckbxAguaCaliente);
		
		JCheckBox chckbxTelefono = new JCheckBox("Si / No");
		chckbxTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTelefono.setBounds(676, 110, 93, 21);
		panelCaracteristicas.add(chckbxTelefono);
		
		JCheckBox chckbxLavadero = new JCheckBox("Si / No");
		chckbxLavadero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxLavadero.setBounds(676, 150, 93, 21);
		panelCaracteristicas.add(chckbxLavadero);
		
		JCheckBox chckbxPavimento = new JCheckBox("Si / No");
		chckbxPavimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPavimento.setBounds(676, 190, 93, 21);
		panelCaracteristicas.add(chckbxPavimento);
		
		JLabel lblErrorNombre = new JLabel("(!)");
		lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(275, 42, 13, 25);
		panelAltaCliente.add(lblErrorNombre);
		
		JLabel lblErrorApellido = new JLabel("(!)");
		lblErrorApellido.setForeground(Color.RED);
		lblErrorApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorApellido.setBounds(275, 81, 13, 25);
		panelAltaCliente.add(lblErrorApellido);
		
		JLabel lblErrorTelefono = new JLabel("(!)");
		lblErrorTelefono.setForeground(Color.RED);
		lblErrorTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorTelefono.setBounds(275, 121, 13, 25);
		panelAltaCliente.add(lblErrorTelefono);
		
		btnAñadirCliente.addActionListener(e-> {
			validarDatosVacios();
		  });
	}
 
	
	public boolean validarDatosVacios() {		
		
		System.out.println(this.comboBoxTipoInmueble.getSelectedItem() == null);
		
		if(		this.textFieldNombre.getText().isEmpty() ||
				this.textFieldApellido.getText().isEmpty() ||
				this.textFieldBarrio.getText().isEmpty() ||
				this.textFieldMonto.getText().isEmpty() ||
				this.textFieldLocalidad.getText().isEmpty() ||
				this.textFieldTelefono.getText().isEmpty() ||
				this.comboBoxTipoInmueble.getSelectedItem() == null)
				
		{
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		}
		
		return true;
	}
}
