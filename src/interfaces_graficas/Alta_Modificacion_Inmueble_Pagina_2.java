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

public class Alta_Modificacion_Inmueble_Pagina_2 extends JPanel {

	private JTextField txtPrecio;
	private JTextField txtMetrosFrente;
	private JTextField txtMetrosFondo;
	private JTextField txtSuperficieTerreno;
	private JTextField txtSuperficieEdificio;
	private JTextField txtAntiguedad;
	private JTextField txtDormitorios;
	private JTextField txtBaños;

	/**
	 * Create the panel.
	 */
	public Alta_Modificacion_Inmueble_Pagina_2(JFrame pantallaPrincipal) {
		setLayout(null);
		
		JLabel lblDatosInmueble = new JLabel("Datos de Inmueble");
		lblDatosInmueble.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosInmueble.setBounds(10, 40, 190, 20);
		add(lblDatosInmueble);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(210, 54, 804, 20);
		add(separator);
		
		JLabel lblTipoInmueble = new JLabel("Tipo de inmueble: ");
		lblTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoInmueble.setBounds(123, 89, 170, 25);
		add(lblTipoInmueble);
		
		JComboBox cbxTipoInmueble = new JComboBox();
		cbxTipoInmueble.setBounds(303, 94, 150, 22);
		add(cbxTipoInmueble);
		
		JLabel lblPrecio = new JLabel("Precio de venta:  $");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(555, 89, 170, 25);
		add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(735, 93, 150, 25);
		add(txtPrecio);
		
		JLabel lblOrientacion = new JLabel("Orientaci\u00F3n:");
		lblOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrientacion.setBounds(123, 154, 170, 25);
		add(lblOrientacion);
		
		JComboBox cbxOrientacion = new JComboBox();
		cbxOrientacion.setBounds(303, 157, 150, 22);
		add(cbxOrientacion);
		
		JLabel lblMetrosFrente = new JLabel("Metros de frente:");
		lblMetrosFrente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMetrosFrente.setBounds(123, 215, 170, 25);
		add(lblMetrosFrente);
		
		txtMetrosFrente = new JTextField();
		txtMetrosFrente.setColumns(10);
		txtMetrosFrente.setBounds(291, 215, 79, 25);
		add(txtMetrosFrente);
		
		JLabel lblMetrosFondo = new JLabel("Metros de fondo:");
		lblMetrosFondo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMetrosFondo.setBounds(414, 215, 170, 25);
		add(lblMetrosFondo);
		
		txtMetrosFondo = new JTextField();
		txtMetrosFondo.setColumns(10);
		txtMetrosFondo.setBounds(574, 215, 79, 25);
		add(txtMetrosFondo);
		
		JLabel lblSuperficie = new JLabel("Superficie:");
		lblSuperficie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSuperficie.setBounds(705, 215, 97, 25);
		add(lblSuperficie);
		
		txtSuperficieTerreno = new JTextField();
		txtSuperficieTerreno.setColumns(10);
		txtSuperficieTerreno.setBounds(806, 215, 79, 25);
		add(txtSuperficieTerreno);
		
		JLabel lblM2 = new JLabel("[m2]");
		lblM2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblM2.setBounds(735, 244, 34, 16);
		add(lblM2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(123, 331, 762, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(123, 599, 762, 20);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(123, 331, 1, 2);
		add(separator_3);
		
		JLabel lblDatosEdificio = new JLabel("Datos del Edificio");
		lblDatosEdificio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosEdificio.setBounds(432, 300, 180, 20);
		add(lblDatosEdificio);
		
		JCheckBox chkPropiedadHorizontal = new JCheckBox("Propiedad Horizonal");
		chkPropiedadHorizontal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPropiedadHorizontal.setBounds(123, 350, 170, 22);
		add(chkPropiedadHorizontal);
		
		JLabel lblSuperficieEdificio = new JLabel("Superficie:");
		lblSuperficieEdificio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuperficieEdificio.setBounds(435, 347, 97, 25);
		add(lblSuperficieEdificio);
		
		txtSuperficieEdificio = new JTextField();
		txtSuperficieEdificio.setColumns(10);
		txtSuperficieEdificio.setBounds(505, 349, 79, 25);
		add(txtSuperficieEdificio);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad:");
		lblAntiguedad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAntiguedad.setBounds(705, 349, 97, 25);
		add(lblAntiguedad);
		
		txtAntiguedad = new JTextField();
		txtAntiguedad.setColumns(10);
		txtAntiguedad.setBounds(806, 351, 79, 25);
		add(txtAntiguedad);
		
		JLabel lblDormitorios = new JLabel("Dormitorios:");
		lblDormitorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDormitorios.setBounds(126, 402, 97, 25);
		add(lblDormitorios);
		
		txtDormitorios = new JTextField();
		txtDormitorios.setColumns(10);
		txtDormitorios.setBounds(214, 404, 79, 25);
		add(txtDormitorios);
		
		JLabel lblBaños = new JLabel("Ba\u00F1os:");
		lblBaños.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBaños.setBounds(435, 400, 97, 25);
		add(lblBaños);
		
		txtBaños = new JTextField();
		txtBaños.setColumns(10);
		txtBaños.setBounds(505, 402, 79, 25);
		add(txtBaños);
		
		JCheckBox chkGarage = new JCheckBox("Garaje/Cochera");
		chkGarage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkGarage.setBounds(123, 450, 170, 22);
		add(chkGarage);
		
		JCheckBox chkPatio = new JCheckBox("Patio");
		chkPatio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPatio.setBounds(432, 450, 170, 22);
		add(chkPatio);
		
		JCheckBox chkPiscina = new JCheckBox("Piscina");
		chkPiscina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPiscina.setBounds(705, 450, 170, 22);
		add(chkPiscina);
		
		JCheckBox chkAguaCorriente = new JCheckBox("Agua Corriente");
		chkAguaCorriente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkAguaCorriente.setBounds(123, 487, 170, 22);
		add(chkAguaCorriente);
		
		JCheckBox chkCloacas = new JCheckBox("Cloacas");
		chkCloacas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkCloacas.setBounds(432, 487, 170, 22);
		add(chkCloacas);
		
		JCheckBox chkGasNatural = new JCheckBox("Gas Natural");
		chkGasNatural.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkGasNatural.setBounds(705, 489, 170, 22);
		add(chkGasNatural);
		
		JCheckBox chkAguaCaliente = new JCheckBox("Agua Caliente");
		chkAguaCaliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkAguaCaliente.setBounds(123, 524, 170, 22);
		add(chkAguaCaliente);
		
		JCheckBox chkTelefono = new JCheckBox("Tel\u00E9fono");
		chkTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkTelefono.setBounds(432, 524, 170, 22);
		add(chkTelefono);
		
		JCheckBox chkLavadero = new JCheckBox("Lavadero");
		chkLavadero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkLavadero.setBounds(705, 524, 170, 22);
		add(chkLavadero);
		
		JCheckBox chkPavimiento = new JCheckBox("Pavimento");
		chkPavimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chkPavimiento.setBounds(123, 561, 170, 22);
		add(chkPavimiento);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setForeground(Color.BLACK);
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnterior.setBounds(785, 630, 100, 25);
		add(btnAnterior);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		JButton btnSiguientePgina = new JButton("Siguiente p\u00E1gina");
		btnSiguientePgina.addActionListener(e ->
		{
			this.setVisible(false);
			JPanel panelAltaInmueblePag3 = new Alta_Modificacion_Inmueble_Pagina_3(pantallaPrincipal);
			pantallaPrincipal.setContentPane(panelAltaInmueblePag3);
		});
		btnSiguientePgina.setForeground(Color.BLACK);
		btnSiguientePgina.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguientePgina.setBounds(599, 630, 170, 25);
		add(btnSiguientePgina);

	}

}
