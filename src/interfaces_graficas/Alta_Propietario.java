package interfaces_graficas;

import javax.swing.JPanel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Propietario;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

public class Alta_Propietario extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtNumDocumento;
	private JTextField txtNumTelefono;
	private JLabel lblNombrePropietario;
	private JLabel lblTitulo;
	private JLabel lblApellidoPropietario;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JLabel lblDatosPersonales;
	private JSeparator separator;
	private JLabel lblEmailPropietario;
	private JLabel lblTipoDNI;
	private JComboBox cbxTipoDocumento;
	private JLabel lblNumeroDocumento;
	private JLabel lblDatosDomicilio;
	private JSeparator separator_1;
	private JLabel lblNumeroTelefono;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblCaller;
	private JLabel lblNumeroCalle;
	private JLabel lblProvincia;
	private JLabel lblLocalidad;
	private JComboBox cbxProvincia;
	private JComboBox cbxLocalidad;
	private JLabel lblErrorNombre;
	private JLabel lblErrorTipoDoc;
	private JLabel lblErrorNumTel;
	private JLabel lblErrorApellido;
	private JLabel lblErrorNumDoc;
	private JLabel lblErrorEmail;
	private JLabel lblErrorCalle;
	private JLabel lblErrorProvincia;
	private JLabel lblErrorNumCalle;
	private JLabel lblErrorLocalidad;

	
	public Alta_Propietario(JFrame pantallaPrincipal) {
		setLayout(null);
		
		lblNombrePropietario = new JLabel("Nombre:");
		lblNombrePropietario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombrePropietario.setBounds(118, 150, 100, 25);
		add(lblNombrePropietario);
		
		
		lblTitulo = new JLabel("Ingrese los siguientes datos para a\u00F1adir un nuevo propietario: ");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(10, 45, 637, 25);
		add(lblTitulo);
		
		txtNombre = new JTextField(30);
		txtNombre.setBounds(315, 150, 150, 25);
		txtNombre.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtNombre.getText().length()>29) 
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
		add(txtNombre);
		
		lblApellidoPropietario = new JLabel("Apellido:");
		lblApellidoPropietario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellidoPropietario.setBounds(534, 150, 100, 25);
		add(lblApellidoPropietario);
		
		txtApellido = new JTextField(30);
		txtApellido.setColumns(10);
		txtApellido.setBounds(764, 150, 150, 25);
		txtApellido.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtApellido.getText().length()>29) 
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
		add(txtApellido);
		
		lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosPersonales.setBounds(10, 106, 150, 20);
		add(lblDatosPersonales);
		
		separator = new JSeparator();
		separator.setBounds(159, 119, 855, 20);
		add(separator);
		
		lblEmailPropietario = new JLabel("Email:");
		lblEmailPropietario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailPropietario.setBounds(534, 246, 100, 25);
		add(lblEmailPropietario);
		
		txtEmail = new JTextField(100);
		txtEmail.setBounds(764, 250, 150, 25);
		txtEmail.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtEmail.getText().length()>99) 
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
		add(txtEmail);
		
		lblTipoDNI = new JLabel("Tipo de Documento:");
		lblTipoDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDNI.setBounds(118, 200, 190, 25);
		add(lblTipoDNI);
		
		cbxTipoDocumento = new JComboBox<String>();
		cbxTipoDocumento.setBounds(315, 205, 150, 22);
		cbxTipoDocumento.addItem("SELECCIONAR");
		cbxTipoDocumento.addItem("DNI");
		cbxTipoDocumento.addItem("PASAPORTE");
		add(cbxTipoDocumento);
		
		lblNumeroDocumento = new JLabel("N\u00FAmero de Documento:");
		lblNumeroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroDocumento.setBounds(534, 200, 220, 25);
		add(lblNumeroDocumento);
		
		txtNumDocumento = new JTextField();
		txtNumDocumento.setBounds(764, 204, 150, 25);
		txtNumDocumento.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtNumDocumento.getText().length()>9) 
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
		add(txtNumDocumento);
		
		lblDatosDomicilio = new JLabel("Datos de Domicilio");
		lblDatosDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDatosDomicilio.setBounds(10, 318, 160, 20);
		add(lblDatosDomicilio);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(169, 334, 845, 20);
		add(separator_1);
		
		lblNumeroTelefono = new JLabel("N\u00FAmero de Telefono:");
		lblNumeroTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroTelefono.setBounds(118, 246, 196, 25);
		add(lblNumeroTelefono);
		
		txtNumTelefono = new JTextField();
		txtNumTelefono.setBounds(315, 250, 150, 25);
		txtNumTelefono.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtNumTelefono.getText().length()>10) 
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
		add(txtNumTelefono);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setBounds(804, 717, 100, 40);
		btnAceptar.addActionListener(e->
		{
			try {
				
				/*se colocan todos los datos que se van a pasar al gestor en variables*/
				
				String nombre = this.txtNombre.getText().toString();
				String apellido = this.txtApellido.getText().toString();
				String tipoDocumento = this.cbxTipoDocumento.getSelectedItem().toString();
				Integer numDocumento = null;
				if(!txtNumDocumento.getText().isEmpty()) {
					numDocumento = Integer.parseInt(this.txtNumDocumento.getText().toString());
				}
				Integer numTelefono = null;
				if(!txtNumTelefono.getText().isEmpty()) {
					numTelefono = Integer.parseInt(this.txtNumTelefono.getText().toString());
				}
				String email = this.txtEmail.getText().toString();
				String calle = this.txtCalle.getText().toString();
				Integer numCalle = null;
				if(!txtNumero.getText().isEmpty()) {
					numCalle = Integer.parseInt(this.txtNumero.getText().toString());
				}
				String provincia = this.cbxProvincia.getSelectedItem().toString();
				String localidad = this.cbxLocalidad.getSelectedItem().toString();
				
				Gestor_Propietario gestorPropietario = new Gestor_Propietario();
				gestorPropietario.crear_Propietario(nombre, apellido, tipoDocumento, numDocumento, numTelefono, email, calle, numCalle, provincia, localidad);
				this.accionMarcarCamposCorrectos();
				this.limpiarFormulario();
				this.mostrarMensajeInformacion(pantallaPrincipal,"Exito", "El propietario se ha creado exitosamente");
				
			} catch (Datos_Invalidos_Exception e2) {
				e2.printStackTrace();
				this.accionMarcarCamposCorrectos();
				this.mostrarError(e2.getCamposErroneos());
				this.mostrarMensajeError(pantallaPrincipal,"Error al dar de alta el propietario",e2.getMessage());
			}
			
		});
		add(btnAceptar);
		
		lblCaller = new JLabel("Calle:");
		lblCaller.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCaller.setBounds(118, 380, 100, 25);
		add(lblCaller);
		
		txtCalle = new JTextField(100);
		txtCalle.setBounds(315, 380, 150, 25);
		txtCalle.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtCalle.getText().length()>99) 
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
		lblNumeroCalle.setBounds(534, 380, 100, 25);
		add(lblNumeroCalle);
		
		txtNumero = new JTextField(5);
		txtNumero.setBounds(764, 380, 150, 25);
		txtNumero.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
					if(txtNumero.getText().length()>4) {
						e.consume();
					}
					
					char input = e.getKeyChar();
					if((input < '0' || input > '9') && input != '\b')
					{
						e.consume();
					}

			}
		});
		add(txtNumero);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(118, 441, 100, 25);
		add(lblProvincia);
		
		lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(534, 441, 100, 25);
		add(lblLocalidad);
		
		cbxProvincia = new JComboBox<String>();
		cbxProvincia.setBounds(315, 441, 150, 22);
		cbxProvincia.addItem("SELECCIONAR");
		cbxProvincia.addItem("SANTA FE");
		add(cbxProvincia);
		
		cbxLocalidad = new JComboBox<String>();
		cbxLocalidad.setBounds(764, 441, 150, 22);
		cbxLocalidad.addItem("SELECCIONAR");
		cbxLocalidad.addItem("SANTA FE");
		add(cbxLocalidad);
		
		lblErrorNombre = new JLabel("(!)");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorNombre.setBounds(88, 155, 20, 15);
		lblErrorNombre.setVisible(false);
		add(lblErrorNombre);
		
		lblErrorTipoDoc = new JLabel("(!)");
		lblErrorTipoDoc.setForeground(Color.RED);
		lblErrorTipoDoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorTipoDoc.setBounds(88, 205, 20, 15);
		lblErrorTipoDoc.setVisible(false);
		add(lblErrorTipoDoc);
		
		lblErrorNumTel = new JLabel("(!)");
		lblErrorNumTel.setForeground(Color.RED);
		lblErrorNumTel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorNumTel.setBounds(88, 251, 20, 15);
		lblErrorNumTel.setVisible(false);
		add(lblErrorNumTel);
		
		lblErrorApellido = new JLabel("(!)");
		lblErrorApellido.setForeground(Color.RED);
		lblErrorApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorApellido.setBounds(504, 155, 20, 15);
		lblErrorApellido.setVisible(false);
		add(lblErrorApellido);
		
		lblErrorNumDoc = new JLabel("(!)");
		lblErrorNumDoc.setForeground(Color.RED);
		lblErrorNumDoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorNumDoc.setBounds(504, 205, 20, 15);
		lblErrorNumDoc.setVisible(false);
		add(lblErrorNumDoc);
		
		lblErrorEmail = new JLabel("(!)");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorEmail.setBounds(504, 251, 20, 15);
		lblErrorEmail.setVisible(false);
		add(lblErrorEmail);
		
		lblErrorCalle = new JLabel("(!)");
		lblErrorCalle.setForeground(Color.RED);
		lblErrorCalle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorCalle.setBounds(88, 385, 20, 15);
		lblErrorCalle.setVisible(false);
		add(lblErrorCalle);
		
		lblErrorProvincia = new JLabel("(!)");
		lblErrorProvincia.setForeground(Color.RED);
		lblErrorProvincia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorProvincia.setBounds(88, 446, 20, 15);
		lblErrorProvincia.setVisible(false);
		add(lblErrorProvincia);
		
		lblErrorNumCalle = new JLabel("(!)");
		lblErrorNumCalle.setForeground(Color.RED);
		lblErrorNumCalle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorNumCalle.setBounds(504, 385, 20, 15);
		lblErrorNumCalle.setVisible(false);
		add(lblErrorNumCalle);
		
		lblErrorLocalidad = new JLabel("(!)");
		lblErrorLocalidad.setForeground(Color.RED);
		lblErrorLocalidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblErrorLocalidad.setBounds(504, 446, 20, 15);
		lblErrorLocalidad.setVisible(false);
		add(lblErrorLocalidad);

	}
	
	
	private void mostrarMensajeError(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void mostrarMensajeAdvertencia(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.WARNING_MESSAGE);
	}
	
	private void mostrarMensajeInformacion(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostrarError(List<String> listaErrores) {
		
		/*lo que hace esta funcion es que a partir de la lista de errores 
		 * por los cuales se dejaron campos no completados, hace visible un jlabel que es un "(!)" en color rojo
		 * junto a cada campo incompleto*/
		
		if(!listaErrores.isEmpty()) {
			for(String error: listaErrores) {
				switch (error.toLowerCase()) {
				
				case "nombre":
					
					this.lblErrorNombre.setVisible(true);
					
					break;
					
				case "apellido":
					
					this.lblErrorApellido.setVisible(true);
								
					break;
			
				case "tipo de documento":
					
					this.lblErrorTipoDoc.setVisible(true);
					
					break;
					
				case "telefono":
					
					this.lblErrorNumTel.setVisible(true);
					
					break;
					
				case "numero de documento":
					
					this.lblErrorNumDoc.setVisible(true);
					
					break;
					
				case "email":
					
					this.lblErrorEmail.setVisible(true);
					
					break;
					
				case "calle":
					
					this.lblErrorCalle.setVisible(true);
					
					break;
					
				case "numero de calle":
					
					this.lblErrorNumCalle.setVisible(true);
					
					break;
					
				case "provincia":
					
					this.lblErrorProvincia.setVisible(true);
					
					break;
					
				case "localidad":
					
					this.lblErrorLocalidad.setVisible(true);
					
					break;
					
				default:
					break;
				}
			}
		}
		
	}
	
	private void accionMarcarCamposCorrectos() {
		
		/*borra los simbolos que se muestran en pantlla junto a cada campo erroneo*/
		
		this.lblErrorApellido.setVisible(false);
		this.lblErrorNombre.setVisible(false);
		this.lblErrorCalle.setVisible(false);
		this.lblErrorEmail.setVisible(false);
		this.lblErrorLocalidad.setVisible(false);
		this.lblErrorNumCalle.setVisible(false);
		this.lblErrorNumDoc.setVisible(false);
		this.lblErrorNumTel.setVisible(false);
		this.lblErrorProvincia.setVisible(false);
		this.lblErrorLocalidad.setVisible(false);
		this.lblErrorTipoDoc.setVisible(false);
		
	}
	
	private void limpiarFormulario() {
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.cbxTipoDocumento.setSelectedIndex(0);
		this.txtNumDocumento.setText("");
		this.txtNumTelefono.setText("");
		this.txtEmail.setText("");
		this.txtCalle.setText("");
		this.txtNumero.setText("");
		this.cbxProvincia.setSelectedIndex(0);
		this.cbxLocalidad.setSelectedIndex(0);
	}
	
}

