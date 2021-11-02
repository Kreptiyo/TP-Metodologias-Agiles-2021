package interfaces_graficas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta_Modificacion_Inmueble_Pagina_1 extends JPanel {
	private JTextField txtLocalidad;
	private JTextField txtCalle;
	private JTextField txtNumeroCalle;
	private JTextField txtPisoDepartamento;

	/**
	 * Create the panel.
	 */
	public Alta_Modificacion_Inmueble_Pagina_1(JFrame pantallaPrincipal) {
		setForeground(Color.GRAY);
		setLayout(null);
		
		JLabel lblDatosUbicacion = new JLabel("Datos de ubicaci\u00F3n");
		lblDatosUbicacion.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosUbicacion.setBounds(10, 40, 190, 20);
		add(lblDatosUbicacion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(210, 55, 804, 20);
		add(separator);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(115, 100, 100, 25);
		add(lblProvincia);
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(225, 105, 150, 22);
		add(cbxProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(412, 100, 100, 25);
		add(lblLocalidad);
		
		JComboBox cbxLocalidad = new JComboBox();
		cbxLocalidad.setBounds(522, 105, 150, 22);
		add(cbxLocalidad);
		
		JCheckBox chkOtra = new JCheckBox("Otra");
		chkOtra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkOtra.setBounds(697, 105, 65, 22);
		add(chkOtra);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(768, 104, 150, 25);
		add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalle.setBounds(115, 168, 100, 25);
		add(lblCalle);
		
		JComboBox cbxCalle = new JComboBox();
		cbxCalle.setBounds(225, 168, 150, 22);
		add(cbxCalle);
		
		JLabel lblIngreseLocalidad = new JLabel("Ingrese una localidad");
		lblIngreseLocalidad.setBounds(793, 86, 111, 14);
		add(lblIngreseLocalidad);
		
		JCheckBox chkOtraCalle = new JCheckBox("Otra");
		chkOtraCalle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkOtraCalle.setBounds(413, 168, 65, 22);
		add(chkOtraCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(522, 168, 150, 25);
		add(txtCalle);
		
		JLabel lblNumeroCalle = new JLabel("N\u00FAmero:");
		lblNumeroCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroCalle.setBounds(697, 168, 100, 25);
		add(lblNumeroCalle);
		
		txtNumeroCalle = new JTextField();
		txtNumeroCalle.setColumns(10);
		txtNumeroCalle.setBounds(826, 168, 93, 25);
		add(txtNumeroCalle);
		
		JButton btnUbicacion = new JButton("Ubicaci\u00F3n");
		btnUbicacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUbicacion.setBounds(697, 214, 221, 40);
		add(btnUbicacion);
		
		JLabel lblUbicacion = new JLabel("(Presione el bot\u00F3n ubicaci\u00F3n si desea ingresar una)");
		lblUbicacion.setBounds(683, 266, 296, 14);
		add(lblUbicacion);
		
		JLabel lblBarrio = new JLabel("Barrio: ");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarrio.setBounds(115, 229, 100, 25);
		add(lblBarrio);
		
		JComboBox cbxCalle_1 = new JComboBox();
		cbxCalle_1.setBounds(225, 232, 150, 22);
		add(cbxCalle_1);
		
		JCheckBox chkDepartamento = new JCheckBox("Departamento");
		chkDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkDepartamento.setBounds(115, 299, 119, 22);
		add(chkDepartamento);
		
		JLabel lblPisoDepartamento = new JLabel("Piso/Departamento:");
		lblPisoDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPisoDepartamento.setBounds(115, 338, 180, 25);
		add(lblPisoDepartamento);
		
		txtPisoDepartamento = new JTextField();
		txtPisoDepartamento.setColumns(10);
		txtPisoDepartamento.setBounds(305, 338, 70, 25);
		add(txtPisoDepartamento);
		
		JButton btnSiguiente = new JButton("Siguiente pagina");
		btnSiguiente.addActionListener(e-> 
		{
				this.setVisible(false);
				JPanel panelAltaInmueblePag2 = new Alta_Modificacion_Inmueble_Pagina_2(pantallaPrincipal);
				pantallaPrincipal.setContentPane(panelAltaInmueblePag2);
		});
		btnSiguiente.setForeground(Color.BLACK);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBounds(748, 415, 170, 25);
		add(btnSiguiente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);

	}

}
