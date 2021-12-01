package interfaces_graficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import excepciones.BaseDeDatosException;
import gestores.Gestor_Cliente;
import gestores.Gestor_Vendedor;

public class Venta_Inmueble extends JPanel {
		

		private JTextField textFieldNombre;
		private JTextField textFieldApellido;
		private JTextField textFieldLocalidad;
		private JTextField textFieldProvincia;
		private JTextField textFieldBarrio;
		private JLabel lblCalleNumero;
		private JTextField textFieldCalleNumero;
		private JLabel lblnroTelefono;
		private JTextField textFieldNroTelefono;
		private Gestor_Vendedor gestVendedor;
		private JPanel panel;
		private JTextField textFieldPrecioVenta;
		private JComboBox comboBoxTipoInmueble;
		private JButton btnConfirmarVenta;
		private JButton btnCancelar;
		
		
		public Venta_Inmueble(JFrame pantallaPrincipal) {
			armarPanel(pantallaPrincipal);
		}

		public void armarPanel(JFrame pantallaPrincipal) {
	
				setBounds(100, 100, 1024, 768);
				setLayout(null);	
				
				gestVendedor = new Gestor_Vendedor();
	setLayout(null);
	
	btnConfirmarVenta = new JButton("Confirmar Venta");
	btnConfirmarVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnConfirmarVenta.setBounds(302, 609, 140, 30);
	add(btnConfirmarVenta);
	
	btnCancelar = new JButton("Cancelar");
	btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnCancelar.setBounds(539, 609, 140, 30);
	btnCancelar.addActionListener(e->
	{
		this.setVisible(false);
		JPanel panelListaDereservas = new Interfaz_Grafica_Ver_Reservas(pantallaPrincipal);
		panelListaDereservas.setVisible(true);
		pantallaPrincipal.setContentPane(panelListaDereservas);
		pantallaPrincipal.setTitle("Lista de Reservas");
	});
	add(btnCancelar);
	
	
	JPanel panelCliente = new JPanel();
	panelCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelCliente.setBounds(72, 38, 881, 206);
	add(panelCliente);
	panelCliente.setLayout(null);
	
	JLabel lblApellidoCliente = new JLabel("Apellido");
	lblApellidoCliente.setBounds(280, 89, 85, 25);
	panelCliente.add(lblApellidoCliente);
	lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	lblnroTelefono = new JLabel("Telefono");
	lblnroTelefono.setBounds(280, 146, 92, 25);
	panelCliente.add(lblnroTelefono);
	lblnroTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	JLabel lblNombreCliente = new JLabel("Nombre");
	lblNombreCliente.setBounds(280, 31, 99, 25);
	panelCliente.add(lblNombreCliente);
	lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	
	textFieldNombre = new JTextField();
	textFieldNombre.setEditable(false);
	textFieldNombre.setBounds(398, 33, 200, 25);
	panelCliente.add(textFieldNombre);
	textFieldNombre.setColumns(10);
	
	textFieldNroTelefono = new JTextField();
	textFieldNroTelefono.setEditable(false);
	textFieldNroTelefono.setBounds(398, 148, 200, 25);
	panelCliente.add(textFieldNroTelefono);
	textFieldNroTelefono.setColumns(10);
	textFieldApellido = new JTextField();
	textFieldApellido.setEditable(false);
	textFieldApellido.setBounds(398, 91, 200, 25);
	panelCliente.add(textFieldApellido);
	textFieldApellido.setColumns(10);
	
	panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Inmueble", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(71, 273, 882, 265);
	add(panel);
	panel.setLayout(null);
	
	JLabel lblProvincia = new JLabel("Provincia");
	lblProvincia.setBounds(63, 41, 130, 25);
	panel.add(lblProvincia);
	lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	textFieldProvincia = new JTextField();
	textFieldProvincia.setEditable(false);
	textFieldProvincia.setBounds(203, 41, 200, 25);
	panel.add(textFieldProvincia);
	textFieldProvincia.setColumns(10);
	
	JLabel lblLocalidad = new JLabel("Localidad");
	lblLocalidad.setBounds(463, 41, 130, 25);
	panel.add(lblLocalidad);
	lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	textFieldLocalidad = new JTextField();
	textFieldLocalidad.setEditable(false);
	textFieldLocalidad.setBounds(603, 41, 200, 25);
	panel.add(textFieldLocalidad);
	textFieldLocalidad.setColumns(10);
	
	JLabel lblBarrio = new JLabel("Barrio");
	lblBarrio.setBounds(63, 88, 130, 25);
	panel.add(lblBarrio);
	lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	textFieldBarrio = new JTextField();
	textFieldBarrio.setEditable(false);
	textFieldBarrio.setBounds(203, 88, 200, 25);
	panel.add(textFieldBarrio);
	textFieldBarrio.setColumns(10);
	
	JLabel lblTipoDeInmueble = new JLabel("Tipo de Inmueble");
	lblTipoDeInmueble.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblTipoDeInmueble.setBounds(259, 143, 130, 25);
	panel.add(lblTipoDeInmueble);
	
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
	comboBoxTipoInmueble.setBounds(418, 143, 200, 25);
	panel.add(comboBoxTipoInmueble);
	
	lblCalleNumero = new JLabel("Calle/Numero");
	lblCalleNumero.setBounds(463, 88, 130, 25);
	panel.add(lblCalleNumero);
	lblCalleNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	textFieldCalleNumero = new JTextField();
	textFieldCalleNumero.setEditable(false);
	textFieldCalleNumero.setBounds(603, 90, 200, 25);
	panel.add(textFieldCalleNumero);
	textFieldCalleNumero.setColumns(10);
	
	JLabel lblPrecioVenta = new JLabel("Precio Venta");
	lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblPrecioVenta.setBounds(259, 196, 144, 38);
	panel.add(lblPrecioVenta);
	
	textFieldPrecioVenta = new JTextField();
	textFieldPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
	textFieldPrecioVenta.setColumns(10);
	textFieldPrecioVenta.setBounds(418, 196, 200, 40);
	panel.add(textFieldPrecioVenta);
	
	btnConfirmarVenta.addActionListener(e-> {
//		try {
//			//this.crearVendedor();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (BaseDeDatosException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
	  });
}
		
		public boolean validarDatosVacios() {		
			
			boolean error = false;
			
			
			
			if(this.textFieldPrecioVenta.getText().isEmpty()) {
				this.textFieldPrecioVenta.setVisible(true);
				error = true;
			}else {
				this.textFieldPrecioVenta.setVisible(false);
			}
			
			
			if(error == true)		
			{
				JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				return error;
			}
			return error;
		}
		
		
//		@SuppressWarnings("deprecation")
//		public void crearVendedor() throws SQLException, BaseDeDatosException {
//			
//			if(!validarDatosVacios()) {
//				
//				
//				int tipoDoc = this.comboBoxTipoDocumento.getSelectedIndex();
//
//				this.gestVendedor.actualizarVendedor(
//						this.textFieldNombre.getText(), 
//						this.textFieldApellido.getText(),
//						this.textFieldLocalidad.getText(),
//						this.textFieldProvincia.getText(),
//						tipoDoc, 
//						this.textFieldNroTelefono.getText(),
//						fecha,
//						this.textFieldCalleNumero.getText(),
//						this.textFieldUsuario.getText()
//						);
//			
//				JOptionPane.showMessageDialog(null, "Vendedor creado");
//			
//			
//			}
//		}
		
		
			
		
}
