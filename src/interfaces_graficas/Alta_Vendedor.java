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

public class Alta_Vendedor extends JPanel {
		
		private JFrame frmModificarCliente;
		private JTextField textFieldNombre;
		private JTextField textFieldApellido;
		private JTextField textFieldFechaNacimientoDia;
		private JTextField textFieldLocalidad;
		private JTextField textFieldProvincia;
		private JTextField textFieldRepetirContraseña;
		private JComboBox comboBoxTipoDocumento;
		private JLabel lblErrorTipoDocumento;
		private JLabel lblErrorLocalidad;
		private JLabel lblErrorProvincia;
		private JLabel lblErrorRepetirContra;
		private JLabel lblErrorNombre;
		private JLabel lblErrorApellido;
		private JLabel lblErrorFechaNacimiento;
		private JLabel lblUsuario;
		private JLabel lblContrasea;
		private JLabel lblErrorUsuario;
		private JLabel lblErrorContraseña;
		private Gestor_Cliente gestorCliente;
		private JLabel lbldormitorios;
		private JLabel lblPiscina;
		private JTextField textFieldUsuario;
		private JTextField textFieldContraseña;
		private JLabel lblnroDocumento;
		private JTextField textFieldNroDocumento;
		private JLabel lblErrorDocumento;
		private JTextField textFieldMes;
		private JTextField textFieldAño;
		private Gestor_Vendedor gestVendedor;
		
		
		public Alta_Vendedor(JFrame pantallaPrincipal) {
			armarPanel(pantallaPrincipal);
		}

		public void armarPanel(JFrame pantallaPrincipal) {
	
				setBounds(100, 100, 1024, 768);
				setLayout(null);	
				
				gestVendedor = new Gestor_Vendedor();
	
	JLabel lblNombreCliente = new JLabel("Nombre");
	lblNombreCliente.setBounds(120, 50, 130, 25);
	lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	JLabel lblApellidoCliente = new JLabel("Apellido");
	lblApellidoCliente.setBounds(520, 50, 130, 25);
	lblApellidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento");
	lblFechaNacimiento.setBounds(201, 247, 130, 25);
	lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	setLayout(null);
	add(lblNombreCliente);
	add(lblApellidoCliente);
	add(lblFechaNacimiento);
	
	
	textFieldNombre = new JTextField();
	textFieldNombre.setBounds(260, 50, 200, 25);
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
	textFieldApellido = new JTextField();
	textFieldApellido.setColumns(10);
	textFieldApellido.setBounds(660, 50, 200, 25);
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
	
	textFieldFechaNacimientoDia = new JTextField();
	textFieldFechaNacimientoDia.setColumns(10);
	textFieldFechaNacimientoDia.setBounds(370, 249, 69, 25);
	textFieldFechaNacimientoDia.addKeyListener(new KeyAdapter() {
	      public void keyPressed(KeyEvent ke) {
	         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
	        	 textFieldFechaNacimientoDia.setEditable(true);
	         } else {
	        	 textFieldFechaNacimientoDia.setEditable(false);
	         }
	      }
	   });
	add(textFieldFechaNacimientoDia);
	
	JButton btnAñadirVendedor = new JButton("A\u00F1adir");
	btnAñadirVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnAñadirVendedor.setBounds(298, 669, 140, 30);
	add(btnAñadirVendedor);
	
	JButton btnVolver = new JButton("Volver");
	btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnVolver.setBounds(537, 669, 140, 30);
	btnVolver.addActionListener(e->
	{
		this.setVisible(false);
		JPanel panelListaDeVendedores = new Lista_Vendedor(pantallaPrincipal);
		panelListaDeVendedores.setVisible(true);
		pantallaPrincipal.setContentPane(panelListaDeVendedores);
		pantallaPrincipal.setTitle("Lista de Clientes");
	});
	add(btnVolver);

	lblErrorNombre = new JLabel("(!)");
	lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorNombre.setForeground(Color.RED);
	lblErrorNombre.setBounds(100, 50, 13, 25);
	lblErrorNombre.setVisible(false);
	add(lblErrorNombre);

	lblErrorApellido = new JLabel("(!)");
	lblErrorApellido.setForeground(Color.RED);
	lblErrorApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorApellido.setBounds(500, 50, 13, 25);
	lblErrorApellido.setVisible(false);
	add(lblErrorApellido);

	lblErrorFechaNacimiento = new JLabel("(!)");
	lblErrorFechaNacimiento.setForeground(Color.RED);
	lblErrorFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorFechaNacimiento.setBounds(169, 248, 13, 25);
	lblErrorFechaNacimiento.setVisible(false);
	add(lblErrorFechaNacimiento);
	
	lblUsuario = new JLabel("Usuario");
	lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblUsuario.setBounds(350, 324, 83, 25);
	add(lblUsuario);
	
	lblContrasea = new JLabel("Contrase\u00F1a");
	lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblContrasea.setBounds(350, 380, 130, 25);
	add(lblContrasea);
	
	textFieldUsuario = new JTextField();
	textFieldUsuario.setColumns(10);
	textFieldUsuario.setBounds(490, 326, 200, 25);
	textFieldUsuario.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldUsuario.getText().length()>20) 
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
	add(textFieldUsuario);
	
	textFieldContraseña = new JTextField();
	textFieldContraseña.setColumns(10);
	textFieldContraseña.setBounds(490, 382, 200, 25);
	textFieldContraseña.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldContraseña.getText().length()>20) 
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
	add(textFieldContraseña);
	
	lblErrorUsuario = new JLabel("(!)");
	lblErrorUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorUsuario.setForeground(Color.RED);
	lblErrorUsuario.setBounds(330, 325, 23, 25);
	lblErrorUsuario.setVisible(false);
	add(lblErrorUsuario);
	
	lblErrorContraseña = new JLabel("(!)");
	lblErrorContraseña.setForeground(Color.RED);
	lblErrorContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorContraseña.setBounds(330, 381, 23, 25);
	lblErrorContraseña.setVisible(false);
	add(lblErrorContraseña);
	
	lblnroDocumento = new JLabel("Nro. Documento");
	lblnroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblnroDocumento.setBounds(520, 100, 130, 25);
	add(lblnroDocumento);
	
	textFieldNroDocumento = new JTextField();
	textFieldNroDocumento.setColumns(10);
	textFieldNroDocumento.setBounds(660, 100, 200, 25);
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
	
	lblErrorDocumento = new JLabel("(!)");
	lblErrorDocumento.setForeground(Color.RED);
	lblErrorDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorDocumento.setBounds(500, 105, 23, 17);
	lblErrorDocumento.setVisible(false);
	add(lblErrorDocumento);
	
	JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
	lblTipoDeDocumento.setBounds(120, 100, 130, 25);
	add(lblTipoDeDocumento);
	lblTipoDeDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	lblErrorTipoDocumento = new JLabel("(!)");
	lblErrorTipoDocumento.setBounds(100, 100, 13, 25);
	add(lblErrorTipoDocumento);
	lblErrorTipoDocumento.setForeground(Color.RED);
	lblErrorTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
	String[] aux = new String[6];
	aux[0]="";
	aux[1]= "DNI";
	aux[2]= "CI";
	aux[3]= "LC";
	aux[4]= "LE";
	aux[5]= "Pasaporte";
	
	comboBoxTipoDocumento = new JComboBox(aux);
	comboBoxTipoDocumento.setBounds(260, 100, 200, 25);
	add(comboBoxTipoDocumento);
	comboBoxTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	JLabel lblLocalidad = new JLabel("Localidad");
	lblLocalidad.setBounds(520, 150, 130, 25);
	add(lblLocalidad);
	lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	lblErrorLocalidad = new JLabel("(!)");
	lblErrorLocalidad.setBounds(500, 150, 13, 25);
	add(lblErrorLocalidad);
	lblErrorLocalidad.setForeground(Color.RED);
	lblErrorLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
	lblErrorProvincia = new JLabel("(!)");
	lblErrorProvincia.setBounds(100, 150, 13, 25);
	add(lblErrorProvincia);
	lblErrorProvincia.setForeground(Color.RED);
	lblErrorProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
	JLabel lblProvincia = new JLabel("Provincia");
	lblProvincia.setBounds(120, 150, 130, 25);
	add(lblProvincia);
	lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	JLabel lblRepetirContra = new JLabel("Repetir Contrase\u00F1a");
	lblRepetirContra.setBounds(350, 437, 130, 25);
	add(lblRepetirContra);
	lblRepetirContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
	lblErrorRepetirContra = new JLabel("(!)");
	lblErrorRepetirContra.setBounds(330, 437, 13, 25);
	add(lblErrorRepetirContra);
	lblErrorRepetirContra.setForeground(Color.RED);
	lblErrorRepetirContra.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
	textFieldLocalidad = new JTextField();
	textFieldLocalidad.setBounds(660, 150, 200, 25);
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
	add(textFieldLocalidad);
	textFieldLocalidad.setColumns(10);
	
	textFieldProvincia = new JTextField();
	textFieldProvincia.setBounds(260, 150, 200, 25);
	textFieldProvincia.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldProvincia.getText().length()>20) 
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
	add(textFieldProvincia);
	textFieldProvincia.setColumns(10);
	
	textFieldRepetirContraseña = new JTextField();
	textFieldRepetirContraseña.setBounds(490, 437, 200, 25);
	textFieldRepetirContraseña.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldRepetirContraseña.getText().length()>20) 
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
	add(textFieldRepetirContraseña);
	textFieldRepetirContraseña.setColumns(10);
	
	textFieldMes = new JTextField();
	textFieldMes.setColumns(10);
	textFieldMes.setBounds(480, 249, 69, 25);
	textFieldMes.addKeyListener(new KeyAdapter() {
	      public void keyPressed(KeyEvent ke) {
	         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
	        	 textFieldMes.setEditable(true);
	         } else {
	        	 textFieldMes.setEditable(false);
	         }
	      }
	   });
	add(textFieldMes);
	
	textFieldAño = new JTextField();
	textFieldAño.setColumns(10);
	textFieldAño.setBounds(590, 249, 69, 25);
	textFieldAño.addKeyListener(new KeyAdapter() {
	      public void keyPressed(KeyEvent ke) {
	         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
	        	 textFieldAño.setEditable(true);
	         } else {
	        	 textFieldAño.setEditable(false);
	         }
	      }
	   });
	add(textFieldAño);
	
	JLabel lblNewDia = new JLabel("Dia");
	lblNewDia.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblNewDia.setBounds(398, 222, 59, 17);
	add(lblNewDia);
	
	JLabel lblNewMes = new JLabel("Mes");
	lblNewMes.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblNewMes.setBounds(500, 222, 59, 17);
	add(lblNewMes);
	
	JLabel lblAno = new JLabel("A\u00F1o");
	lblAno.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblAno.setBounds(613, 222, 59, 17);
	add(lblAno);
	
	lblErrorNombre.setVisible(false);
	lblErrorApellido.setVisible(false);
	lblErrorDocumento.setVisible(false);
	lblErrorTipoDocumento.setVisible(false);
	lblErrorContraseña.setVisible(false);
	lblErrorRepetirContra.setVisible(false);
	lblErrorProvincia.setVisible(false);
	lblErrorLocalidad.setVisible(false);
	lblErrorFechaNacimiento.setVisible(false);
	lblErrorUsuario.setVisible(false);
	
	btnAñadirVendedor.addActionListener(e-> {
		try {
			this.crearVendedor();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BaseDeDatosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	  });
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
			
			if(this.textFieldNroDocumento.getText().isEmpty()) {
				this.lblErrorDocumento.setVisible(true);
				error = true;
			}else {
				this.lblErrorDocumento.setVisible(false);
			}
			
			if(this.textFieldProvincia.getText().isEmpty()) {
				this.lblErrorProvincia.setVisible(true);
				error = true;
			}else {
				this.lblErrorProvincia.setVisible(false);
			}
			
			if(this.textFieldLocalidad.getText().isEmpty()) {
				this.lblErrorLocalidad.setVisible(true);
				error = true;
			}else {
				this.lblErrorLocalidad.setVisible(false);
			}
			
			if(this.textFieldRepetirContraseña.getText().isEmpty()) {
				this.lblErrorRepetirContra.setVisible(true);
				error = true;
			}else {
				this.lblErrorRepetirContra.setVisible(false);
			}
			
			if(this.textFieldContraseña.getText().isEmpty()) {
				this.lblErrorContraseña.setVisible(true);
				error = true;
			}else {
				this.lblErrorContraseña.setVisible(false);
			}
			if(this.textFieldUsuario.getText().isEmpty()) {
				this.lblErrorUsuario.setVisible(true);
				error = true;
			}else {
				this.lblErrorUsuario.setVisible(false);
			}
			if(this.comboBoxTipoDocumento.getSelectedItem() == "") {
				this.lblErrorTipoDocumento.setVisible(true);
				error = true;
			}else {
				this.lblErrorTipoDocumento.setVisible(false);
			}
			
			if(
			this.textFieldFechaNacimientoDia.getText().isEmpty() ||
			this.textFieldMes.getText().isEmpty()||
			this.textFieldAño.getText().isEmpty()
			) {
				this.lblErrorFechaNacimiento.setVisible(true);
				error = true;
			}else {
				this.lblErrorTipoDocumento.setVisible(false);
			}
			
			
			if(error == true)		
			{
				JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
				return error;
			}
			return error;
		}
		
		@SuppressWarnings("deprecation")
		public void crearVendedor() throws SQLException, BaseDeDatosException {
			
			if(!validarDatosVacios() && validarDatosContraseña() && validarDatosFecha()) {
				
				System.out.println("Entra");
				
				int tipoDoc = this.comboBoxTipoDocumento.getSelectedIndex();
				
				Date fecha = new Date();
				fecha.setDate(Integer.parseInt(this.textFieldFechaNacimientoDia.getText()));
				fecha.setMonth(Integer.parseInt(this.textFieldMes.getText()));
				fecha.setYear(Integer.parseInt(this.textFieldAño.getText()));
				
				
				
				this.gestVendedor.actualizarVendedor(
						this.textFieldNombre.getText(), 
						this.textFieldApellido.getText(),
						this.textFieldLocalidad.getText(),
						this.textFieldProvincia.getText(),
						tipoDoc, 
						this.textFieldNroDocumento.getText(),
						fecha,
						this.textFieldContraseña.getText(),
						this.textFieldUsuario.getText()
						);
			
				JOptionPane.showMessageDialog(null, "Vendedor creado");
			
			
			}
		}
		
		public boolean validarDatosContraseña() {
			
			String c = this.textFieldContraseña.getText();
			String rc = this.textFieldRepetirContraseña.getText();
			
			
			if(c.equalsIgnoreCase(rc)) {
				this.lblErrorContraseña.setVisible(false);
				this.lblErrorRepetirContra.setVisible(false);
				return true;
			}else {
				this.lblErrorContraseña.setVisible(true);
				this.lblErrorRepetirContra.setVisible(true);
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				return false;
			}
			
		}
		
		public boolean validarDatosFecha() {
			
			if(Integer.parseInt(this.textFieldFechaNacimientoDia.getText()) > 31 || 
				Integer.parseInt(this.textFieldFechaNacimientoDia.getText()) < 1 ||
				Integer.parseInt(this.textFieldMes.getText()) < 1 ||
				Integer.parseInt(this.textFieldMes.getText()) > 12 ||
				Integer.parseInt(this.textFieldAño.getText()) < 1900 ||
				Integer.parseInt(this.textFieldAño.getText()) > 2021 ) {
				
				this.lblErrorFechaNacimiento.setVisible(true);
				JOptionPane.showMessageDialog(null, "La fecha esta mal escrita");
				return false;
			}else {
				this.lblErrorFechaNacimiento.setVisible(false);				
				return true;
			}
			
		}
		
}
