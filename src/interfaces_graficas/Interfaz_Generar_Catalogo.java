package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Generar_Catalogo extends JPanel {
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtTelefono;
	private JTextField txtEmailCliente;
	private JTextField txtCodigoInmueble;
	private JTextField txtProvincia;
	private JTextField txtLocalidad;
	private JTextField txtCalle;
	private JTextField txtBarrio;
	private JTextField txtTipoInmueble;
	private JTextField txtPrecio;
	private JTextField txtImporteReserva;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Interfaz_Generar_Catalogo() {
		setLayout(null);
		
		JLabel lblDatosCliente = new JLabel("Datos del cliente:");
		lblDatosCliente.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosCliente.setBounds(10, 40, 150, 20);
		add(lblDatosCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(169, 55, 845, 20);
		add(separator);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreCliente.setBounds(179, 86, 100, 25);
		add(lblNombreCliente);
		
		txtNombreCliente = new JTextField(30);
		txtNombreCliente.setBounds(296, 86, 150, 25);
		add(txtNombreCliente);
		
		JLabel lblApelllidoCliente = new JLabel("Apellido:");
		lblApelllidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApelllidoCliente.setBounds(584, 86, 100, 25);
		add(lblApelllidoCliente);
		
		txtApellidoCliente = new JTextField(30);
		txtApellidoCliente.setBounds(694, 86, 150, 25);
		add(txtApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono: ");
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoCliente.setBounds(179, 146, 100, 25);
		add(lblTelefonoCliente);
		
		txtTelefono = new JTextField(30);
		txtTelefono.setBounds(296, 146, 150, 25);
		add(txtTelefono);
		
		JLabel lblEmailCliente = new JLabel("Email:");
		lblEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailCliente.setBounds(584, 146, 100, 25);
		add(lblEmailCliente);
		
		txtEmailCliente = new JTextField(30);
		txtEmailCliente.setBounds(694, 146, 150, 25);
		add(txtEmailCliente);
		
		JLabel lblDatosInmueble = new JLabel("Datos del inmueble:");
		lblDatosInmueble.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosInmueble.setBounds(10, 190, 183, 20);
		add(lblDatosInmueble);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(179, 203, 835, 20);
		add(separator_1);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigo.setBounds(179, 234, 100, 25);
		add(lblCodigo);
		
		txtCodigoInmueble = new JTextField(30);
		txtCodigoInmueble.setBounds(296, 234, 150, 25);
		add(txtCodigoInmueble);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(584, 234, 100, 25);
		add(lblProvincia);
		
		txtProvincia = new JTextField(30);
		txtProvincia.setBounds(694, 234, 150, 25);
		add(txtProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(179, 294, 100, 25);
		add(lblLocalidad);
		
		txtLocalidad = new JTextField(30);
		txtLocalidad.setBounds(296, 294, 150, 25);
		add(txtLocalidad);
		
		JLabel lblCalleNumero = new JLabel("Calle/N\u00B0:");
		lblCalleNumero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalleNumero.setBounds(584, 294, 100, 25);
		add(lblCalleNumero);
		
		txtCalle = new JTextField(30);
		txtCalle.setBounds(694, 294, 150, 25);
		add(txtCalle);
		
		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarrio.setBounds(179, 349, 100, 25);
		add(lblBarrio);
		
		txtBarrio = new JTextField(30);
		txtBarrio.setBounds(296, 349, 150, 25);
		add(txtBarrio);
		
		JLabel lblTipoInmueble = new JLabel("T. Inmueble:");
		lblTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoInmueble.setBounds(179, 400, 115, 25);
		add(lblTipoInmueble);
		
		txtTipoInmueble = new JTextField(30);
		txtTipoInmueble.setBounds(296, 400, 150, 25);
		add(txtTipoInmueble);
		
		JLabel lblPrecioVenta = new JLabel("Precio:");
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioVenta.setBounds(584, 349, 100, 25);
		add(lblPrecioVenta);
		
		txtPrecio = new JTextField(30);
		txtPrecio.setBounds(694, 349, 150, 25);
		add(txtPrecio);
		
		JLabel lblReserva = new JLabel("Reserva:");
		lblReserva.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblReserva.setBounds(10, 451, 183, 20);
		add(lblReserva);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(87, 464, 927, 20);
		add(separator_1_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setBounds(804, 717, 100, 40);
		add(btnAceptar);
		
		JLabel lblImporteReserva = new JLabel("Importe de la reserva:");
		lblImporteReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImporteReserva.setBounds(87, 508, 207, 25);
		add(lblImporteReserva);
		
		txtImporteReserva = new JTextField(30);
		txtImporteReserva.setBounds(296, 508, 150, 25);
		add(txtImporteReserva);
		
		JLabel lblTiempoReserva = new JLabel(" Tiempo de vigencia [D\u00EDas]:");
		lblTiempoReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiempoReserva.setBounds(528, 508, 248, 25);
		add(lblTiempoReserva);
		
		textField = new JTextField(30);
		textField.setBounds(786, 508, 150, 25);
		add(textField);

	}
}
