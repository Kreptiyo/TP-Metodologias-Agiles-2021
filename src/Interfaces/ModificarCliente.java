package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ModificarCliente {

	private JFrame frmModificarCliente;
	private JTextField textFieldTelefono;
	private JTextField textFieldLocalidad;
	private JTextField textFieldBarrio;
	private JTextField textFieldCaracteriscticas;
	private JTextField textFieldMonto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente window = new ModificarCliente();
					window.frmModificarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarCliente = new JFrame();
		frmModificarCliente.setTitle("Modificar Cliente");
		frmModificarCliente.setBounds(100, 100, 1024, 768);
		frmModificarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelModificarCliente = new JPanel();
		frmModificarCliente.getContentPane().add(panelModificarCliente, BorderLayout.CENTER);
		panelModificarCliente.setLayout(null);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono");
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefonoCliente.setBounds(330, 216, 130, 25);
		panelModificarCliente.add(lblTelefonoCliente);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(500, 216, 200, 25);
		panelModificarCliente.add(textFieldTelefono);
		
		JPanel panelDatosInmueble = new JPanel();
		panelDatosInmueble.setLayout(null);
		panelDatosInmueble.setBorder(new TitledBorder(null, "Datos del inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosInmueble.setBounds(312, 255, 434, 230);
		panelModificarCliente.add(panelDatosInmueble);
		
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
		
		textFieldCaracteriscticas = new JTextField();
		textFieldCaracteriscticas.setColumns(10);
		textFieldCaracteriscticas.setBounds(190, 140, 200, 25);
		panelDatosInmueble.add(textFieldCaracteriscticas);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(190, 180, 200, 25);
		panelDatosInmueble.add(textFieldMonto);
		
		JComboBox comboBoxTipoInmueble = new JComboBox();
		comboBoxTipoInmueble.setBounds(190, 20, 200, 25);
		panelDatosInmueble.add(comboBoxTipoInmueble);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(334, 515, 140, 30);
		panelModificarCliente.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(584, 515, 140, 30);
		panelModificarCliente.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Cliente: RAMIRO GRIPPO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(413, 102, 230, 46);
		panelModificarCliente.add(lblNewLabel);
	}
}
