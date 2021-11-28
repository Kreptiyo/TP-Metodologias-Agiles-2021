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

import dominio.Vendedor;
import dominio.Vendedor.Tipo_Documento;
import excepciones.BaseDeDatosException;
import gestores.Gestor_Cliente;
import gestores.Gestor_Vendedor;

public class Modificar_Vendedor extends JPanel {
		
		private JTextField textFieldNombre;
		private JTextField textFieldApellido;
		private JTextField textFieldFechaNacimientoDia;
		private JTextField textFieldLocalidad;
		private JTextField textFieldProvincia;
		private JTextField textFieldRepetirContrase�a;
		private JLabel textFieldTipoDocumento;
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
		private JLabel lblErrorContrase�a;
		private JTextField textFieldUsuario;
		private JTextField textFieldContrase�a;
		private JLabel lblnroDocumento;
		private JTextField textFieldNroDocumento;
		private JLabel lblErrorDocumento;
		private JTextField textFieldMes;
		private JTextField textFieldA�o;
		private Gestor_Vendedor gestVendedor;
		private Vendedor vend;
		
		public Modificar_Vendedor(JFrame pantallaPrincipal, String nombre, String apellido, String dni) {
			armarPanel(pantallaPrincipal, nombre, apellido ,dni);
		}

		public void armarPanel(JFrame pantallaPrincipal, String nombre, String apellido, String dni) {
	
				setBounds(100, 100, 1024, 768);
				setLayout(null);	
				
				gestVendedor = new Gestor_Vendedor();
				
				vend = new Vendedor();
				vend = gestVendedor.buscarPorNombreApellidoDNI(nombre, apellido, dni).get(0);
	
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
	
	
	textFieldNombre = new JTextField(vend.getNombre());
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
	textFieldApellido = new JTextField(vend.getApellido());
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
	
	textFieldFechaNacimientoDia = new JTextField(vend.getFechaNacimiento().substring(0, 2));
	textFieldFechaNacimientoDia.setEditable(false);
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
	
	JButton btnModificarVendedor = new JButton("Modificar");
	btnModificarVendedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnModificarVendedor.setBounds(298, 669, 140, 30);
	add(btnModificarVendedor);
	
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
	
	textFieldUsuario = new JTextField(vend.getUsuario());
	textFieldUsuario.setEditable(false);
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
	
	textFieldContrase�a = new JTextField(vend.getContrase�a());
	textFieldContrase�a.setColumns(10);
	textFieldContrase�a.setBounds(490, 382, 200, 25);
	textFieldContrase�a.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldContrase�a.getText().length()>20) 
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
	add(textFieldContrase�a);
	
	lblErrorUsuario = new JLabel("(!)");
	lblErrorUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorUsuario.setForeground(Color.RED);
	lblErrorUsuario.setBounds(330, 325, 23, 25);
	lblErrorUsuario.setVisible(false);
	add(lblErrorUsuario);
	
	lblErrorContrase�a = new JLabel("(!)");
	lblErrorContrase�a.setForeground(Color.RED);
	lblErrorContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblErrorContrase�a.setBounds(330, 381, 23, 25);
	lblErrorContrase�a.setVisible(false);
	add(lblErrorContrase�a);
	
	lblnroDocumento = new JLabel("Nro. Documento");
	lblnroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblnroDocumento.setBounds(520, 100, 130, 25);
	add(lblnroDocumento);
	
	textFieldNroDocumento = new JTextField(vend.getNrodocumento());
	textFieldNroDocumento.setEditable(false);
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
	
	textFieldTipoDocumento = new JLabel(vend.getTipodocumento().name());
	textFieldTipoDocumento.setBounds(260, 100, 200, 25);
	add(textFieldTipoDocumento);
	textFieldTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
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
	
	textFieldLocalidad = new JTextField(vend.getLocalidad());
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
	
	textFieldProvincia = new JTextField(vend.getProvincia());
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
	
	textFieldRepetirContrase�a = new JTextField(vend.getContrase�a());
	textFieldRepetirContrase�a.setBounds(490, 437, 200, 25);
	textFieldRepetirContrase�a.addKeyListener(new KeyAdapter() 
	{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			if(textFieldRepetirContrase�a.getText().length()>20) 
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
	add(textFieldRepetirContrase�a);
	textFieldRepetirContrase�a.setColumns(10);
	
	textFieldMes = new JTextField(vend.getFechaNacimiento().substring(3,5));
	textFieldMes.setEditable(false);
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
	
	textFieldA�o = new JTextField(vend.getFechaNacimiento().substring(6, 10));
	textFieldA�o.setEditable(false);
	textFieldA�o.setColumns(10);
	textFieldA�o.setBounds(590, 249, 69, 25);
	textFieldA�o.addKeyListener(new KeyAdapter() {
	      public void keyPressed(KeyEvent ke) {
	         if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == 8) {
	        	 textFieldA�o.setEditable(true);
	         } else {
	        	 textFieldA�o.setEditable(false);
	         }
	      }
	   });
	add(textFieldA�o);
	
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
	lblErrorContrase�a.setVisible(false);
	lblErrorRepetirContra.setVisible(false);
	lblErrorProvincia.setVisible(false);
	lblErrorLocalidad.setVisible(false);
	lblErrorFechaNacimiento.setVisible(false);
	lblErrorUsuario.setVisible(false);
	
	btnModificarVendedor.addActionListener(e-> {
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
			
			if(this.textFieldRepetirContrase�a.getText().isEmpty()) {
				this.lblErrorRepetirContra.setVisible(true);
				error = true;
			}else {
				this.lblErrorRepetirContra.setVisible(false);
			}
			
			if(this.textFieldContrase�a.getText().isEmpty()) {
				this.lblErrorContrase�a.setVisible(true);
				error = true;
			}else {
				this.lblErrorContrase�a.setVisible(false);
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
			
			if(!validarDatosVacios() && validarDatosContrase�a() && validarDatosFecha()) {
				
				String tipoDoc = this.textFieldTipoDocumento.getText();
				int tipodocumento = 0;
				
				String fecha;
				fecha = this.textFieldFechaNacimientoDia.getText() + "/" + this.textFieldMes.getText() + "/" + this.textFieldA�o.getText();
				
				switch (tipoDoc) 
				{
				case "DNI":
					tipodocumento = 1; 
					break;
				case "CI":
					tipodocumento = 2; 
					break;
				case "LC":
					tipodocumento = 3; 
					break;
				case "LE":
					tipodocumento = 4; 
					break;
				case "Pasaporte":
					tipodocumento = 5; 
					break;

				}
				
				this.gestVendedor.actualizarVendedor(
						this.vend.getId(),
						this.textFieldNombre.getText(), 
						this.textFieldApellido.getText(),
						this.textFieldLocalidad.getText(),
						this.textFieldProvincia.getText(),
						tipodocumento, 
						this.textFieldNroDocumento.getText(),
						fecha,
						this.textFieldContrase�a.getText(),
						this.textFieldUsuario.getText()
						);
			
				JOptionPane.showMessageDialog(null, "Vendedor creado");
			
			
			}
		}
		
		public boolean validarDatosContrase�a() {
			
			String c = this.textFieldContrase�a.getText();
			String rc = this.textFieldRepetirContrase�a.getText();
			
			
			if(c.equalsIgnoreCase(rc)) {
				this.lblErrorContrase�a.setVisible(false);
				this.lblErrorRepetirContra.setVisible(false);
				return true;
			}else {
				this.lblErrorContrase�a.setVisible(true);
				this.lblErrorRepetirContra.setVisible(true);
				JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");
				return false;
			}
			
		}
		
		public boolean validarDatosFecha() {
			
			if(Integer.parseInt(this.textFieldFechaNacimientoDia.getText()) > 31 || 
				Integer.parseInt(this.textFieldFechaNacimientoDia.getText()) < 1 ||
				Integer.parseInt(this.textFieldMes.getText()) < 1 ||
				Integer.parseInt(this.textFieldMes.getText()) > 12 ||
				Integer.parseInt(this.textFieldA�o.getText()) < 1900 ||
				Integer.parseInt(this.textFieldA�o.getText()) > 2021 ) {
				
				this.lblErrorFechaNacimiento.setVisible(true);
				JOptionPane.showMessageDialog(null, "La fecha esta mal escrita");
				return false;
			}else {
				this.lblErrorFechaNacimiento.setVisible(false);				
				return true;
			}
			
		}
		
}
