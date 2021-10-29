package Interfaces;

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

public class AltaCliente {

	private JFrame frmAadirCliente;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalidad;
	private JTextField textFieldBarrio;
	private JTextField textFieldCaracteristicas;
	private JTextField textFieldMonto;
	private JComboBox comboBoxTipoInmueble;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCliente window = new AltaCliente();
					window.frmAadirCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAadirCliente = new JFrame();
		frmAadirCliente.setTitle("Alta Cliente");
		frmAadirCliente.setBounds(100, 100, 1024, 768);
		frmAadirCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAltaCliente = new JPanel();
		frmAadirCliente.getContentPane().add(panelAltaCliente, BorderLayout.CENTER);
		
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
		panelDatosInmueble.setBounds(280, 160, 434, 230);
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
		
		JLabel lblCaracteristicas = new JLabel("Caracteristicas");
		lblCaracteristicas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaracteristicas.setBounds(20, 140, 130, 25);
		panelDatosInmueble.add(lblCaracteristicas);
		
		JLabel lblTipoDeInmueble_4 = new JLabel("Monto Disponible");
		lblTipoDeInmueble_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeInmueble_4.setBounds(20, 180, 130, 25);
		panelDatosInmueble.add(lblTipoDeInmueble_4);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);
		textFieldLocalidad.setBounds(190, 60, 200, 25);
		panelDatosInmueble.add(textFieldLocalidad);
		
		textFieldBarrio = new JTextField();
		textFieldBarrio.setColumns(10);
		textFieldBarrio.setBounds(190, 100, 200, 25);
		panelDatosInmueble.add(textFieldBarrio);
		
		textFieldCaracteristicas = new JTextField();
		textFieldCaracteristicas.setColumns(10);
		textFieldCaracteristicas.setBounds(190, 140, 200, 25);
		panelDatosInmueble.add(textFieldCaracteristicas);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(190, 180, 200, 25);
		textFieldMonto.addKeyListener(new KeyAdapter() {
		      public void keyPressed(KeyEvent ke) {
		         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
		        	 textFieldMonto.setEditable(true);
		         } else {
		        	 textFieldMonto.setEditable(false);
		         }
		      }
		   });
		panelDatosInmueble.add(textFieldMonto);
		
		String[] aux = new String[2];
		aux[1]= "Hola";
		
		comboBoxTipoInmueble = new JComboBox(aux);
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
		btnAñadirCliente.setBounds(298, 411, 140, 30);
		panelAltaCliente.add(btnAñadirCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(548, 411, 140, 30);
		panelAltaCliente.add(btnCancelar);
		
		btnAñadirCliente.addActionListener(e-> {
			validarDatosVacios();
		  });
	}
	
	public boolean validarDatosVacios() {		
		
		System.out.println(this.comboBoxTipoInmueble.getSelectedItem() == null);
		
		if(		this.textFieldNombre.getText().isEmpty() ||
				this.textFieldApellido.getText().isEmpty() ||
				this.textFieldBarrio.getText().isEmpty() ||
				this.textFieldCaracteristicas.getText().isEmpty() ||
				this.textFieldLocalidad.getText().isEmpty() ||
				this.textFieldMonto.getText().isEmpty() ||
				this.textFieldTelefono.getText().isEmpty() ||
				this.comboBoxTipoInmueble.getSelectedItem() == null)
				
		{
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		}
		
		return true;
	}
	
}
