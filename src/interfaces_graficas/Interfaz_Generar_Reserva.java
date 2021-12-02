package interfaces_graficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import dominio.Cliente;
import dominio.Inmueble;
import dominio.Reserva;
import excepciones.BaseDeDatosException;
import excepciones.Datos_Invalidos_Exception;
import gestores.Gestor_Cliente;
import gestores.Gestor_Inmueble;
import gestores.Gestor_Reserva;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Interfaz_Generar_Reserva extends JPanel {
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtTelefono;
	private JTextField txtCodigoInmueble;
	private JTextField txtProvincia;
	private JTextField txtLocalidad;
	private JTextField txtCalle;
	private JTextField txtBarrio;
	private JTextField txtTipoInmueble;
	private JTextField txtPrecio;
	private JTextField txtImporteReserva;
	private JTextField txtTiempoVigencia;
	private Gestor_Inmueble gestorInmueble;
	private Gestor_Cliente gestorCliente;
	private Inmueble inmueble;
	private Cliente cliente;
	private JTextField txtEmail;
	


	public Interfaz_Generar_Reserva(JFrame pantallaPrincipal, Integer idCliente, Integer idInmueble) {
		this.gestorCliente = new Gestor_Cliente();
		this.gestorInmueble = new Gestor_Inmueble();
		this.armarPanel(pantallaPrincipal, idCliente, idInmueble);
		this.setearDatos(idCliente, idInmueble);
	}
	
	public void armarPanel(JFrame pantallaPrincipal,Integer idCliente, Integer idInmueble) {
		setLayout(null);
		
		JLabel lblDatosCliente = new JLabel("Datos del cliente:");
		lblDatosCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosCliente.setBounds(10, 40, 183, 20);
		add(lblDatosCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 55, 798, 20);
		add(separator);
		
		JLabel lblNombreCliente = new JLabel("Nombre:");
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreCliente.setBounds(179, 86, 100, 25);
		add(lblNombreCliente);
		
		txtNombreCliente = new JTextField(30);
		txtNombreCliente.setBounds(296, 86, 150, 25);
		txtNombreCliente.setEditable(false);
		add(txtNombreCliente);
		
		JLabel lblApelllidoCliente = new JLabel("Apellido:");
		lblApelllidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApelllidoCliente.setBounds(584, 86, 100, 25);
		add(lblApelllidoCliente);
		
		txtApellidoCliente = new JTextField(30);
		txtApellidoCliente.setBounds(694, 86, 150, 25);
		txtApellidoCliente.setEditable(false);
		add(txtApellidoCliente);
		
		JLabel lblTelefonoCliente = new JLabel("Telefono: ");
		lblTelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoCliente.setBounds(179, 146, 100, 25);
		add(lblTelefonoCliente);
		
		txtTelefono = new JTextField(30);
		txtTelefono.setBounds(296, 146, 150, 25);
		txtTelefono.setEditable(false);
		add(txtTelefono);
		
		JLabel lblDatosInmueble = new JLabel("Datos del inmueble:");
		lblDatosInmueble.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDatosInmueble.setBounds(10, 190, 242, 20);
		add(lblDatosInmueble);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(216, 203, 798, 20);
		add(separator_1);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigo.setBounds(179, 234, 100, 25);
		add(lblCodigo);
		
		txtCodigoInmueble = new JTextField(30);
		txtCodigoInmueble.setBounds(296, 234, 150, 25);
		txtCodigoInmueble.setEditable(false);
		add(txtCodigoInmueble);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProvincia.setBounds(584, 234, 100, 25);
		add(lblProvincia);
		
		txtProvincia = new JTextField(30);
		txtProvincia.setBounds(694, 234, 150, 25);
		txtProvincia.setEditable(false);
		add(txtProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocalidad.setBounds(179, 294, 100, 25);
		add(lblLocalidad);
		
		txtLocalidad = new JTextField(30);
		txtLocalidad.setBounds(296, 294, 150, 25);
		txtLocalidad.setEditable(false);
		add(txtLocalidad);
		
		JLabel lblCalleNumero = new JLabel("Calle/N\u00B0:");
		lblCalleNumero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalleNumero.setBounds(584, 294, 100, 25);
		add(lblCalleNumero);
		
		txtCalle = new JTextField(30);
		txtCalle.setBounds(694, 294, 150, 25);
		txtCalle.setEditable(false);
		add(txtCalle);
		
		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBarrio.setBounds(179, 349, 100, 25);
		add(lblBarrio);
		
		txtBarrio = new JTextField(30);
		txtBarrio.setBounds(296, 349, 150, 25);
		txtBarrio.setEditable(false);
		add(txtBarrio);
		
		JLabel lblTipoInmueble = new JLabel("T. Inmueble:");
		lblTipoInmueble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoInmueble.setBounds(179, 400, 115, 25);
		add(lblTipoInmueble);
		
		txtTipoInmueble = new JTextField(30);
		txtTipoInmueble.setBounds(296, 400, 150, 25);
		txtTipoInmueble.setEditable(false);
		add(txtTipoInmueble);
		
		JLabel lblPrecioVenta = new JLabel("Precio:");
		lblPrecioVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioVenta.setBounds(584, 349, 100, 25);
		add(lblPrecioVenta);
		
		txtPrecio = new JTextField(30);
		txtPrecio.setBounds(694, 349, 150, 25);
		txtPrecio.setEditable(false);
		add(txtPrecio);
		
		JLabel lblReserva = new JLabel("Reserva:");
		lblReserva.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblReserva.setBounds(10, 451, 183, 20);
		add(lblReserva);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(104, 464, 910, 20);
		add(separator_1_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e->
		{
				this.setVisible(false);
				JPanel volver = new Interfaz_Grafica_Ver_Catalogo(pantallaPrincipal);
				pantallaPrincipal.setContentPane(volver);
				pantallaPrincipal.setTitle("Catalogo");
				
			});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancelar.setBounds(914, 717, 100, 40);
		add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(e->
		{
			try {
				
				Integer importeReserva;
				
				if(!this.txtImporteReserva.getText().isEmpty()) {
					importeReserva = Integer.parseInt(this.txtImporteReserva.getText().toString());
				}else
				{
					importeReserva = -1;
				}
				
				Integer tiempoVigencia;
				
				if(!this.txtTiempoVigencia.getText().isEmpty()) {
					tiempoVigencia = Integer.parseInt(this.txtTiempoVigencia.getText().toString());
				}else
				{
					tiempoVigencia = -1;
				}
						
				Gestor_Reserva gestorReserva = new Gestor_Reserva();
				this.generarPDF(gestorReserva.crear_Reserva(idCliente, idInmueble, importeReserva, tiempoVigencia, this.txtEmail.getText().toString()));
				
				
				this.mostrarMensajeInformacion(pantallaPrincipal,"Exito", "Se ha reservado el inmueble exitosamente!");
				
				this.setVisible(false);
				JPanel volver = new Interfaz_Grafica_Ver_Catalogo(pantallaPrincipal);
				pantallaPrincipal.setContentPane(volver);
				pantallaPrincipal.setTitle("Catalogo");
				
			} catch (Datos_Invalidos_Exception e2) {
				e2.printStackTrace();
				this.mostrarMensajeError(pantallaPrincipal,"Error al generar la reserva",e2.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BaseDeDatosException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		txtImporteReserva.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtImporteReserva.getText().length()>10) 
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
		add(txtImporteReserva);
		
		JLabel lblTiempoReserva = new JLabel(" Tiempo de vigencia [D\u00EDas]:");
		lblTiempoReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiempoReserva.setBounds(528, 508, 248, 25);
		add(lblTiempoReserva);
		
		txtTiempoVigencia = new JTextField(30);
		txtTiempoVigencia.setBounds(786, 508, 150, 25);
		txtTiempoVigencia.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(txtTiempoVigencia.getText().length()>1) 
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
		add(txtTiempoVigencia);
		
		JLabel lblEmailContacto = new JLabel("Email de contacto:");
		lblEmailContacto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailContacto.setBounds(87, 566, 207, 25);
		add(lblEmailContacto);
		
		txtEmail = new JTextField(30);
		txtEmail.setBounds(296, 566, 150, 25);
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

	}
	
	private void mostrarMensajeError(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void mostrarMensajeInformacion(JFrame padre, String titulo,String detalle) 
	{
		JOptionPane.showMessageDialog(padre,
			    detalle,titulo,
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void setearDatos(Integer idCliente, Integer idInmueble){
		
		cliente = gestorCliente.buscarPorId(idCliente);
		inmueble = gestorInmueble.buscarPorId(idInmueble);
		
		/*setear campos del cliente*/
		this.txtNombreCliente.setText(cliente.getNombre().toString());
		this.txtApellidoCliente.setText(cliente.getApellido().toString());
		this.txtTelefono.setText(String.valueOf(cliente.getTelefono()));
		
		/*setear campos del inmueble*/
		this.txtCodigoInmueble.setText(inmueble.getId().toString());
		this.txtProvincia.setText(inmueble.getProvincia());
		this.txtLocalidad.setText(inmueble.getLocalidad());
		this.txtCalle.setText(inmueble.getCalle() + " " + inmueble.getCalleNumero().toString());
		this.txtBarrio.setText(inmueble.getBarrio());
		this.txtTipoInmueble.setText(inmueble.getTipoDeInmueble().name().toString());
		this.txtPrecio.setText(inmueble.getPrecioDeVenta().toString());
		
	}
	
	private void generarPDF(Reserva r) throws IOException {

		
		try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Comienzo
            contentStream.beginText();
           
          //Se pone la fuente de la letra  
            contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 24);               
            contentStream.setLeading(14.5f);  
          
            //Se setea la posicion donde se comienza a escribir
            contentStream.newLineAtOffset(25, 700);  
          
	// Se escribe los textos que van a aparecer y se los agrega

                  String text = "";  
                  String Line1 = "Reserva";  
                  String Line2 = "Cliente: n°: " + r.getIdCliente();
                  String Line3 = "Usted ha realizado la reserva del inmueble n°: " + r.getIdInmueble();
                  String Line4 = "El costo de la misma es de: " + r.getImporteReserva();
                  String Line5 = "y tiene una duracion de " + r.getTiempoVigencia() + " dias";
           
            contentStream.showText(Line1);  
            contentStream.newLine();   
            contentStream.showText(text);  
            contentStream.newLine();  
            contentStream.showText(Line2);  
            contentStream.newLine();   
            contentStream.showText(text);  
            contentStream.newLine();  
            contentStream.showText(text);  
            contentStream.newLine();   
            contentStream.showText(Line3);  
            contentStream.newLine();  
            contentStream.showText(text);  
            contentStream.newLine();   
            contentStream.showText(Line4);  
            contentStream.newLine();  
            contentStream.showText(text);  
            contentStream.newLine();   
            contentStream.showText(Line5); 
              
            //Finaliza  
            contentStream.endText();  
          
            //Se cierra y se guarda
            contentStream.close();  
            document.save("reserva.pdf");
        }
		
	}

}